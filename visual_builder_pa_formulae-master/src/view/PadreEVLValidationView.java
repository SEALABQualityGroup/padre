package view;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.dt.util.ListContentProvider;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.epsilon.evl.dt.views.ValidationView;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
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
import org.osgi.framework.Bundle;

import analysis.performance.jmt.jmva.UmlJmvaController;
import launching.launchers.PadreLaunchConfigurationDelegate;
import launching.util.EvlStandaloneExample;

public class PadreEVLValidationView extends ValidationView {

	private static PadreEVLValidationView instance = null;

	private static final String PADRE_CORE = "it.univaq.disim.sealab.padre.core";
	private static final String PADRE_PERF_ANALYSIS = "it.univaq.disim.sealab.padre.performance.analysis";

	protected Action checkModelActionMode;
	private boolean checkModelOnDemand = false;

	protected Action checkModelAction;

	protected Action perfAnActionMode;
	private boolean perfAnOnDemand = false;

	protected Action perfAnAction;

	protected Action perfAnMethodAction;

	public boolean isCheckModelOnDemand() {
		return checkModelOnDemand;
	}

	public void setCheckModelOnDemand(boolean checkModelOnDemand) {
		this.checkModelOnDemand = checkModelOnDemand;
	}

	public boolean isPerfAnOnDemand() {
		return perfAnOnDemand;
	}

	public void setPerfAnOnDemand(boolean perfAnOnDemand) {
		this.perfAnOnDemand = perfAnOnDemand;
	}

	public static PadreEVLValidationView getInstance() {
		return instance;
	}

	class PadreFixActionHeader extends Action {
		public PadreFixActionHeader() {
			this.setText("Available refactoring actions");
			this.setEnabled(false);
		}

		@Override
		public void run() {

		}
	}

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

		private String getFilePath(String path) {
			Bundle bundle = Platform.getBundle(PADRE_PERF_ANALYSIS);
			URL fileURL = bundle.getResource(path);
			String finalPath = "";
			try {
				finalPath = FileLocator.resolve(fileURL).getFile();
				return java.nio.file.Paths.get(finalPath).normalize().toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return finalPath;
		}

		@Override
		public void run() {
			try {
				AbstractEmfModel model = (AbstractEmfModel) module.getContext().getModelRepository().getModels().get(0);
				String relative_path = "modelChecking";
				URI newURI = null;
				newURI = _store_current_model(model,
						StringEscapeUtils.escapeXml(relative_path.replace('<', ' ').replace('>', ' ')), true);

//				if (module.getSourceUri().getPath().contains("checkModel")
//
//						|| module.getSourceUri().getPath().contains("checkmodel")) {
//					PadreEVLValidationView.getInstance().setPartName("PADRE - Model Checking");
//// BEGIN old code - working (annotated for possible rollbacks)
//					fixInstance.perform();
//					unsatisfiedConstraint.setFixed(true);
//					setDone(!existUnsatisfiedConstraintsToFix());
//					List<UnsatisfiedConstraint> ucs = module.getContext().getUnsatisfiedConstraints();
////					int counter = 0;
////					for (UnsatisfiedConstraint uc : ucs) {
////						if (uc.isFixed()) {
////							counter++;
////						}
////					}
////					relative_path = "Step_" + counter;// + "---" + unsatisfiedConstraint.getMessage().trim() + "---" + fixInstance.getTitle().trim();
//					// Save the one-fix model
//					model = (AbstractEmfModel) module.getContext().getModelRepository().getModels().get(0);
//					// relative_path = "modelChecking";
//					newURI = _store_current_model(model,
//							StringEscapeUtils.escapeXml(relative_path.replace('<', ' ').replace('>', ' ')), true);
//// END old code - working (annotated for possible rollbacks)
//
////					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
////						public void run() {
//					try {
//						EvlStandaloneExample evlEx = new EvlStandaloneExample();
//						module.setUnsatisfiedConstraintFixer(new PadreEVLValidationViewFixer());
//						Collection<UnsatisfiedConstraint> unsatisfieds = evlEx.execute(module.getSourceUri().getPath(),
//								module.getContext().getModelRepository().getModels());
//						module.getContext().getUnsatisfiedConstraints().clear();
//						module.getContext().getUnsatisfiedConstraints().addAll(unsatisfieds);
//						viewer.setInput(module.getContext().getUnsatisfiedConstraints());
//						setDone(!existUnsatisfiedConstraintsToFix());
//					} catch (EolRuntimeException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}

				if (module.getContext().getUnsatisfiedConstraints().isEmpty()) {

					((EmfModel) model).dispose();

					// PERF AN CHECK
					if (!isPerfAnOnDemand()) {
						System.out.println("PERFORMANCE ANALYSIS...");
						UmlJmvaController controller = new UmlJmvaController();
						controller.roundtripMVA(newURI);
						System.out.println("Performance analysed!");
						try {

							String file_extension = newURI.fileExtension();
							newURI = newURI.trimFileExtension();
							String filename = newURI.segment(newURI.segmentCount() - 1);
							newURI = newURI.trimSegments(1);
							newURI = newURI.appendSegment("performanceAnalysis");
							newURI = newURI.appendSegment(filename);
							newURI = newURI.appendFileExtension(file_extension);

							((EmfModel) model).setModelFileUri(newURI);
							((EmfModel) model).loadModelFromUri();

							PadreEVLValidationView.getInstance()
									.setPartName("PADRE - Performance Antipattern Detection and Refactoring");
							EvlStandaloneExample evlEx = new EvlStandaloneExample();
							module.setUnsatisfiedConstraintFixer(new PadreEVLValidationViewFixer());
							IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
									new Path(PadreLaunchConfigurationDelegate.getInstance().getApsEvlFilePath()));
							String fileName = file.getRawLocation().toOSString();
							Collection<UnsatisfiedConstraint> unsatisfieds = evlEx.execute(fileName,
									module.getContext().getModelRepository().getModels());
							module.getContext().getUnsatisfiedConstraints().clear();
							module.getContext().getUnsatisfiedConstraints().addAll(unsatisfieds);
							viewer.setInput(module.getContext().getUnsatisfiedConstraints());
							setDone(!existUnsatisfiedConstraintsToFix());
							if (module.getContext().getUnsatisfiedConstraints().isEmpty()) {
								System.out.println("NO PERFORMANCE ANTIPATTERNS DETECTED");
							}
						} catch (EolRuntimeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("Performance will not be analysed! They will be analysed on-demand!");
					}
				}

			} catch (Exception e) {
				module.getContext().getErrorStream().println(e.toString());
			}
		}
	}

	protected boolean hasFinished() {
		if (isDone())
			return true;
		for (UnsatisfiedConstraint constraint : module.getContext().getUnsatisfiedConstraints()) {
			if (constraint.isFixed()) {
				return true;
			}
		}
		return false;
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
		instance = this;
	}

	public void fix(final IEvlModule module, PadreEVLValidationViewFixer fixer) {

		if (this.fixer != null) {
			setDone(true);
		}

		this.fixer = new PadreEVLValidationViewFixer();// fixer;
		this.module = module;
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				// Model backup
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
				AbstractEmfModel model = (AbstractEmfModel) module.getContext().getModelRepository().getModels().get(0);
				setSession(sdf.format(calendar.getTime()));
				// model.setSession(session);
				String relative_path = model.getName() + "_initial";
				_store_current_model(model, relative_path, false);

//				if(module.getSourceUri().getPath().contains("checkModel")) {
				PadreEVLValidationView.getInstance().setPartName("PADRE - Model Checking");
//				} else {
//					PadreEVLValidationView.getInstance().setPartName("PADRE - Performance Antipattern Detection and Refactoring");
//				}

				// Viewer filling
				viewer.setInput(module.getContext().getUnsatisfiedConstraints());
				setDone(!existUnsatisfiedConstraintsToFix());

			}
		});
	}

	// it saves the model as UML file in a sub-directory named 'reason'
	// if overwriteMode, then the refactored model becames the actual model in the
	// next session step
	public URI _store_current_model(AbstractEmfModel model, String reason, boolean overwriteMode) {

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
		if (reason.toLowerCase().contains("initial"))// || !overwriteMode)
			newUri = newUri.appendSegment(session);
		// 'reason' string will be the name of the sub-directory containing the fix
		if (!newUri.toString().endsWith(reason))
			newUri = newUri.appendSegment(reason);
		else if (!overwriteMode)
			newUri = newUri.appendSegment(reason);
		// the name of the fixed model is the same as the original one
		newUri = newUri.appendSegment(filename);
		newUri = newUri.appendFileExtension(file_extension);

		try {
			// set new uri
			// module.getContext().getModelRepository().getTransactionSupport().startTransaction();
			// IModelTransactionSupport ts = model.getTransactionSupport();
			// ((EmfModel)model).setModelFileUri(newUri);
			model.getResource().setURI(newUri);
			model.getResource().save(null);
			// model.getResource().unload();
			// ((EmfModel)model).dispose();
			// ((EmfModel)model).loadModelFromUri();
			// model.clearCache();
			// module.getContext().getModelRepository().getTransactionSupport().commitTransaction();

			// InMemoryEmfModel newModel = new InMemoryEmfModel(model.getResource());
			// newModel.setName(model.getName());
			// newModel.getResource().setURI(newUri);
			// newModel.getResource().save(null);
			// newModel.getResource().save(module.getContext().getOutputStream(), null);

			// module.getContext().getModelRepository().removeModel(model);
			// module.getContext().getModelRepository().addModel(newModel);
			// model.getResource().unload();
			// model.getResource().load(null);
			// model.getResource().load(null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
//			if(!overwriteMode) {
//				// reset old uri
//				model.getResource().setURI(oldUri);
//			}
		}

		return newUri;
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
		clearAction.setToolTipText("Clear PADRE validation view");
		clearAction.setImageDescriptor(EvlPlugin.getDefault().getImageDescriptor("icons/clear.gif"));

		stopAction.setEnabled(false);

		checkModelActionMode = new Action("On-demand modelling assumptions check", IAction.AS_CHECK_BOX) {
			@Override
			public void run() {
				setDone(true);
			}
		};
		checkModelActionMode.setText("On-demand modelling assumptions check");
		checkModelActionMode.setToolTipText("Click to enable/disable on-demand modelling assumptions check");
		Bundle bundle = Platform.getBundle(PADRE_CORE);
		URL checkModelModeIconPath = bundle.getEntry("icons/on-demand-checkModel-icon.png");
		checkModelActionMode.setImageDescriptor(ImageDescriptor.createFromURL(checkModelModeIconPath));
		checkModelActionMode.setEnabled(true);
		checkModelActionMode.addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				if (checkModelActionMode.isChecked()) {
					setCheckModelOnDemand(true);
					checkModelAction.setEnabled(true);
				} else {
					setCheckModelOnDemand(false);
					checkModelAction.setEnabled(false);
				}
			}
		});

		checkModelAction = new Action("Check modelling assumptions!", IAction.AS_PUSH_BUTTON) {
			@Override
			public void run() {
				setDone(true);
			}
		};
		checkModelAction.setText("Check modelling assumptions!");
		checkModelAction.setToolTipText("Click to check modelling assumptions!");
		URL checkModelIconPath = bundle.getEntry("icons/checkModel.png");
		checkModelAction.setImageDescriptor(ImageDescriptor.createFromURL(checkModelIconPath));
		checkModelAction.setEnabled(false);
		checkModelAction.addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				if (checkModelActionMode.isChecked())
					checkModelAction.setEnabled(true);
				else
					checkModelAction.setEnabled(false);
			}
		});

//		perfAnMethodAction = new Action( "Performance analysis method", IAction.AS_DROP_DOWN_MENU ) {
//			@Override
//			public void run() {
//				setDone(true);
//			}
//		};
//		perfAnMethodAction.setText("Performance analysis method");
//		perfAnMethodAction.setToolTipText("Select the performance analysis method");
////		Bundle b = Platform.getBundle("it.univaq.disim.sealab.padre");
////		URL perfAnMethodActionPath = b.getEntry("icons/on-demand-icon.png");
////		perfAnMethodAction.setImageDescriptor(ImageDescriptor.createFromURL(perfAnMethodActionPath));
//		perfAnMethodAction.setEnabled(true);
////		ActionContributionItem item= new ActionContributionItem(perfAnMethodAction);
////		item.fill(, -1);
//		perfAnMethodAction.addPropertyChangeListener(new IPropertyChangeListener() {
//			@Override
//			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
//				// TODO Auto-generated method stub
//                if (perfAnActionMode.isChecked()) {
//                	perfAnMethodAction.setEnabled(true);
//                } else {
//                	perfAnMethodAction.setEnabled(false);
//                }
//			}
//		});

		perfAnActionMode = new Action("On-demand performance analysis", IAction.AS_CHECK_BOX) {
			@Override
			public void run() {
				setDone(true);
			}
		};
		perfAnActionMode.setText("On-demand performance analysis");
		perfAnActionMode.setToolTipText("Click to enable/disable on-demand performance analysis");
		// Bundle bundle = Platform.getBundle("it.univaq.disim.sealab.padre");
		URL perfAnModeIconPath = bundle.getEntry("icons/on-demand-icon.png");
		perfAnActionMode.setImageDescriptor(ImageDescriptor.createFromURL(perfAnModeIconPath));
		perfAnActionMode.setEnabled(true);
		perfAnActionMode.addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				if (perfAnActionMode.isChecked()) {
					setPerfAnOnDemand(true);
					perfAnAction.setEnabled(true);
				} else {
					setPerfAnOnDemand(false);
					perfAnAction.setEnabled(false);
				}
			}
		});

		perfAnAction = new Action("Analyse the performance!", IAction.AS_PUSH_BUTTON) {
			@Override
			public void run() {
				setDone(true);
			}
		};
		perfAnAction.setText("Analyse the performance!");
		perfAnAction.setToolTipText("Click to analyse the performance!");
		URL perfAnIconPath = bundle.getEntry("icons/perfAn.gif");
		perfAnAction.setImageDescriptor(ImageDescriptor.createFromURL(perfAnIconPath));
		perfAnAction.setEnabled(false);
		perfAnAction.addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				if (perfAnActionMode.isChecked())
					perfAnAction.setEnabled(true);
				else
					perfAnAction.setEnabled(false);
			}
		});
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
		manager.add(new Separator(IWorkbenchActionConstants.SEP));
		manager.add(checkModelActionMode);
		manager.add(checkModelAction);
		// manager.add(perfAnMethodAction);
		manager.add(perfAnActionMode);
		manager.add(perfAnAction);
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(stopAction);
		manager.add(clearAction);
		manager.add(new Separator(IWorkbenchActionConstants.SEP));
		manager.add(checkModelActionMode);
		manager.add(checkModelAction);
		// manager.add(perfAnMethodAction);
		manager.add(perfAnActionMode);
		manager.add(perfAnAction);
	}

	private void fillContextMenu(IMenuManager manager) {

		UnsatisfiedConstraint unsatisfiedConstraint = (UnsatisfiedConstraint) ((StructuredSelection) viewer
				.getSelection()).getFirstElement();
		if (unsatisfiedConstraint == null)
			return;

		manager.add(new PadreFixActionHeader());
		manager.add(new Separator(IWorkbenchActionConstants.SEP));

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
