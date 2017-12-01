/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.dt.views;


import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.epsilon.common.dt.util.ListContentProvider;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.FixInstance;
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
import org.eclipse.ui.part.ViewPart;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ValidationView extends ViewPart {
	
	protected IEvlModule module = null;
	protected TableViewer viewer;
	protected Action stopAction;
	protected Action clearAction;
	protected ValidationViewFixer fixer;
	//private Action cancelAction;
	
	class UnsatisfiedConstraintLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return ((UnsatisfiedConstraint) obj).getMessage();
		}
		public Image getColumnImage(Object obj, int index) {
			UnsatisfiedConstraint unsatisfiedConstraint = (UnsatisfiedConstraint) obj;
			if (unsatisfiedConstraint.isFixed()) {
				return EvlPlugin.getDefault().createImage("icons/fix.gif");
			}
			else if (unsatisfiedConstraint.getConstraint().isInfo()) {
				return EvlPlugin.getDefault().createImage("icons/info.gif");
			}
			else if (unsatisfiedConstraint.getConstraint().isCritique()) {
				return EvlPlugin.getDefault().createImage("icons/critique.gif");
			}
			else {
				return EvlPlugin.getDefault().createImage("icons/error.gif");
			}
		}
	}
	
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public ValidationView() {
	
	}
	
	protected boolean existUnsatisfiedConstraintsToFix() {
		for (UnsatisfiedConstraint constraint : module.getContext().getUnsatisfiedConstraints()) {
			if (constraint.getFixes().size() > 0 && !constraint.isFixed()) {
				return true;
			}
		}
		return false;
	}
	
	public void fix(final IEvlModule module, ValidationViewFixer fixer) {
		
		if (this.fixer != null) {
			setDone(true);
		}
		
		this.fixer = fixer;
		this.module = module;
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				viewer.setInput(module.getContext().getUnsatisfiedConstraints());				
				setDone(!existUnsatisfiedConstraintsToFix());
				
				//Model backup 
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
				AbstractEmfModel model = (AbstractEmfModel)module.getContext().getModelRepository().getModels().get(0);
				model.setSession(sdf.format(calendar.getTime()));
				String relative_path = model.getName() + "_backup";
				model._store_current_model(relative_path);
			}
		});
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
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

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ValidationView.this.fillContextMenu(manager);
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

	private void fillContextMenu(IMenuManager manager) {
		
		UnsatisfiedConstraint unsatisfiedConstraint = (UnsatisfiedConstraint)((StructuredSelection) viewer.getSelection()).getFirstElement();
		if (unsatisfiedConstraint == null) return;
		
		for (FixInstance fixInstance : unsatisfiedConstraint.getFixes()) {
			manager.add(new PerformFixAction(unsatisfiedConstraint, fixInstance));
		}
		
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	class PerformFixAction extends Action {
		
		UnsatisfiedConstraint unsatisfiedConstraint = null;
		FixInstance fixInstance = null;
		
		public PerformFixAction(UnsatisfiedConstraint unsatisfiedConstraint, FixInstance fixInstance) {
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
			
			//PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			//	public void run() {
					try {
						fixInstance.perform();
						unsatisfiedConstraint.setFixed(true);
						setDone(!existUnsatisfiedConstraintsToFix());
						viewer.refresh();
						
						List<UnsatisfiedConstraint> UC = module.getContext().getUnsatisfiedConstraints();
						int counter = 0;
						for (UnsatisfiedConstraint uc : UC)
						{
							if (uc.isFixed())
							{
								counter++;
							}
						}
						
						//Save the one-fix model 						
						AbstractEmfModel model = (AbstractEmfModel)module.getContext().getModelRepository().getModels().get(0);
						String relative_path = "Step_" + counter + "---" + unsatisfiedConstraint.getMessage() + "---" + fixInstance.getTitle();
						model._store_current_model(StringEscapeUtils.escapeXml(relative_path.replace('<', ' ').replace('>', ' ')));
						
					} catch (Exception e) {
						module.getContext().getErrorStream().println(e.toString());
					}
			//}
				
			//});
			
		}
		
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(stopAction);
		manager.add(clearAction);
	}

	private void makeActions() {
		stopAction = new Action() {
			@Override
			public void run() {
				setDone(true);
			}
		};
		stopAction.setText("Stop");
		stopAction.setToolTipText("Finish with performing fixes and resume to the post section of the EVL specification");
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
		clearAction.setToolTipText("Clear the validation view");
		clearAction.setImageDescriptor(EvlPlugin.getDefault().getImageDescriptor("icons/clear.gif"));
		
		stopAction.setEnabled(false);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public boolean isDone() {
		if (fixer == null) return true;
		return fixer.isDone();
	}
	
	protected void setDone(boolean done) {
		stopAction.setEnabled(!done);
		if (fixer != null) fixer.setDone(done);;
	}
}
