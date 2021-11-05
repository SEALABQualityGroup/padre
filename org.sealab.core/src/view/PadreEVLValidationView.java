package view;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.common.dt.util.ListContentProvider;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.epsilon.evl.dt.views.ValidationView;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;

import actions.ApplyFix;
import actions.FixHeader;
import launching.util.EvlStandaloneExample;

public class PadreEVLValidationView extends ValidationView {
	public static PadreEVLValidationView instance;

	public PadreEVLValidationView() {
		super();
		PadreEVLValidationView.instance = this;
	}
	
	public IEvlModule getModule() {
		return this.module;
	}
	
	class UnsatisfiedConstraintLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return ((UnsatisfiedConstraint) obj).getMessage();
		}

		public Image getColumnImage(Object obj, int index) {
			UnsatisfiedConstraint unsatisfiedConstraint = (UnsatisfiedConstraint) obj;
			if (unsatisfiedConstraint.isFixed()) {
				return EvlPlugin.getDefault().createImage("icons/fix.gif");
			} else if (unsatisfiedConstraint.getConstraint().isInfo()) {
				return EvlPlugin.getDefault().createImage("icons/info.gif");
			} else if (unsatisfiedConstraint.getConstraint().isCritique()) {
				return EvlPlugin.getDefault().createImage("icons/critique.gif");
			} else {
				return EvlPlugin.getDefault().createImage("icons/error.gif");
			}
		}
	}

	public void fix(final IEvlModule module, PadreEVLValidationViewFixer fixer) {
		if(this.fixer != null) {
			//setDone(true);
		}

		this.fixer = new PadreEVLValidationViewFixer();
		this.module = module;
		
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				//PadreEVLValidationView.instance.setPartName("Padre - Refactoring");
				// Needs to be a list, otherwise validation view won't get populated!
				viewer.setInput(new ArrayList<>(module.getContext().getUnsatisfiedConstraints()));
				setDone(!existUnsatisfiedConstraintsToFix());				
			}
		});
	}
	
	public void updateView() {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				EvlStandaloneExample evlEx = new EvlStandaloneExample();
				module.setUnsatisfiedConstraintFixer(new PadreEVLValidationViewFixer());
				try {
					Collection<UnsatisfiedConstraint> unsatisfieds = evlEx.execute(
							module.getSourceUri().getPath(),
							module.getContext().getModelRepository().getModels()
					);
					module.getContext().getUnsatisfiedConstraints().clear();
					module.getContext().getUnsatisfiedConstraints().addAll(unsatisfieds);				
				} catch (EolRuntimeException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				viewer.setInput(new ArrayList<>(module.getContext().getUnsatisfiedConstraints()));
				setDone(!existUnsatisfiedConstraintsToFix());
			}
		});
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ListContentProvider());
		viewer.setLabelProvider(new UnsatisfiedConstraintLabelProvider());

		makeActions();
		hookContextMenu();
		contributeToActionBars();
	}

	private void makeActions() {
		stopAction = new Action() {
			@Override
			public void run() {
				viewer.setInput(null);
				setDone(true);
			}
		};

		stopAction.setText("Stop");
		stopAction.setToolTipText("Click to stop the refactoring session");
		stopAction.setImageDescriptor(EvlPlugin.getDefault().getImageDescriptor("icons/stop.gif"));
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				PadreEVLValidationView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager menu = bars.getMenuManager();
		IToolBarManager toolbar = bars.getToolBarManager();

		menu.add(stopAction);
		toolbar.add(stopAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		
		UnsatisfiedConstraint unsatisfiedConstraint = (UnsatisfiedConstraint) ((StructuredSelection) viewer
				.getSelection()).getFirstElement();
		if (unsatisfiedConstraint == null)
			return;

		manager.add(new FixHeader());
		manager.add(new Separator(IWorkbenchActionConstants.SEP));

		for (FixInstance fixInstance : unsatisfiedConstraint.getFixes()) {
			manager.add(new ApplyFix(this.module, fixInstance));
		}

		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
}
