package view;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.dt.util.ListContentProvider;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.epsilon.evl.dt.views.ValidationView;
import org.eclipse.epsilon.evl.dt.views.ValidationViewFixer;
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
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;

import analysis.performance.jmt.jmva.UmlJmvaController;

public class PadreEVLValidationView extends ValidationView {

	class PadrePerformFixAction extends Action {

		UnsatisfiedConstraint unsatisfiedConstraint = null;
		FixInstance fixInstance = null;

		public PadrePerformFixAction(UnsatisfiedConstraint unsatisfiedConstraint, FixInstance fixInstance) {
			this.unsatisfiedConstraint = unsatisfiedConstraint;
			this.fixInstance = fixInstance;
			this.setImageDescriptor(EvlPlugin.getDefault().getImageDescriptor("icons/fix.gif"));
			try {
				this.setText(fixInstance.getTitle());
			} catch (EolRuntimeException e) {
				module.getContext().getErrorStream().println(e.toString());
				this.setText("An exception occured while evaluating the title of the fix");
			}
		}

		@Override
		public void run() {
			try {
				fixInstance.perform();
				unsatisfiedConstraint.setFixed(true);
				setDone(!existUnsatisfiedConstraintsToFix());
				viewer.refresh();

				List<UnsatisfiedConstraint> UC = module.getContext().getUnsatisfiedConstraints();
				int counter = 0;
				for (UnsatisfiedConstraint uc : UC) {
					if (uc.isFixed()) {
						counter++;
					}
				}
				// Save the one-fix model
				AbstractEmfModel model = (AbstractEmfModel) module.getContext().getModelRepository().getModels().get(0);
				String relative_path = "Step_" + counter + "---" + unsatisfiedConstraint.getMessage() + "---"
						+ fixInstance.getTitle();
				_store_current_model(model,
						StringEscapeUtils.escapeXml(relative_path.replace('<', ' ').replace('>', ' ')));

				// POSSIBLE POINT FOR PERF AN
				boolean ans = module.getContext().getUserInput()
						.confirm("Would you like to analyse the performance of the refactored model?", true);
				if (ans) {
					UmlJmvaController controller = new UmlJmvaController(model.getName());
					controller.roundtripMVA();
					module.getContext().getUserInput().inform("Performance analysed!");
				} else {
					module.getContext().getUserInput().inform("Performance will not be analysed!");
				}
			} catch (Exception e) {
				module.getContext().getErrorStream().println(e.toString());
			}
		}
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

	class NameSorter extends ViewerSorter {
	}

	protected String session;

	/**
	 * The constructor.
	 */
	public PadreEVLValidationView() {
		super();

	}

	public void fix(final IEvlModule module, PadreEVLValidationViewFixer fixer) {

		if (this.fixer != null) {
			setDone(true);
		}

		this.fixer = new PadreEVLValidationViewFixer();// fixer;
		this.module = module;
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				viewer.setInput(module.getContext().getUnsatisfiedConstraints());
				setDone(!existUnsatisfiedConstraintsToFix());

				// Model backup
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
				AbstractEmfModel model = (AbstractEmfModel) module.getContext().getModelRepository().getModels().get(0);
				setSession(sdf.format(calendar.getTime()));
				// model.setSession(session);
				String relative_path = model.getName() + "_backup";
				_store_current_model(model, relative_path);
			}
		});
	}

	// it save the model as UML file in a sub-directory of name 'reason'
	public boolean _store_current_model(AbstractEmfModel model, String reason) {

		URI oldUri = model.getResource().getURI();

		// copy and modify the old uri
		String oldPath = oldUri.toPlatformString(false);

		URI newUri = URI.createPlatformResourceURI(oldPath, true);

		String file_extension = newUri.fileExtension();
		newUri = newUri.trimFileExtension();

		String filename = newUri.segment(newUri.segmentCount() - 1);
		newUri = newUri.trimSegments(1);

		// 'session' string will be the name of the directory containing the results of
		// the session
		newUri = newUri.appendSegment(session);
		// 'reason' string will be the name of the sub-directory containing the fix
		newUri = newUri.appendSegment(reason);
		// the name of the fixed model is the same as the original one
		newUri = newUri.appendSegment(filename);
		newUri = newUri.appendFileExtension(file_extension);

		try {
			// set new uri
			model.getResource().setURI(newUri);
			model.getResource().save(null);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			// reset old uri
			model.getResource().setURI(oldUri);
		}

		return true;
	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ListContentProvider());
		viewer.setLabelProvider(new UnsatisfiedConstraintLabelProvider());
		viewer.setSorter(new NameSorter());
		makeActions();
		hookContextMenu();
		contributeToActionBars();
	}

	private void makeActions() {
		stopAction = new Action() {
			@Override
			public void run() {
				setDone(true);
			}
		};
		stopAction.setText("Stop");
		stopAction.setToolTipText("Click to stop the refactoring session");
		stopAction.setImageDescriptor(EvlPlugin.getDefault().getImageDescriptor("icons/stop.gif"));

		clearAction = new Action() {
			@Override
			public void run() {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						setDone(true);
						viewer.setInput(Collections.emptyList());
					}

				});
			}
		};

		clearAction.setText("Clear");
		clearAction.setToolTipText("Clear the PADRE validation view");
		clearAction.setImageDescriptor(EvlPlugin.getDefault().getImageDescriptor("icons/clear.gif"));

		stopAction.setEnabled(false);
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
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(stopAction);
		manager.add(clearAction);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(stopAction);
		manager.add(clearAction);
	}

	private void fillContextMenu(IMenuManager manager) {

		UnsatisfiedConstraint unsatisfiedConstraint = (UnsatisfiedConstraint) ((StructuredSelection) viewer
				.getSelection()).getFirstElement();
		if (unsatisfiedConstraint == null)
			return;

		for (FixInstance fixInstance : unsatisfiedConstraint.getFixes()) {
			manager.add(new PadrePerformFixAction(unsatisfiedConstraint, fixInstance));
		}

		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	public void setSession(String timestamp) {
		session = "Refactoring__" + timestamp;
	}

	public String getSession() {
		return this.session;
	}
}
