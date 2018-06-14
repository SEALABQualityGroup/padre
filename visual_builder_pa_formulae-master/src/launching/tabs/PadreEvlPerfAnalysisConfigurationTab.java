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
package launching.tabs;

import java.util.Arrays;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab.SelectSourceListener;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.epsilon.evl.dt.launching.tabs.EvlSourceConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class PadreEvlPerfAnalysisConfigurationTab 
	extends AbstractLaunchConfigurationTab implements ModifyListener{

//	@Override
//	public EpsilonPlugin getPlugin() {
//		return EvlPlugin.getDefault();
//	}
//
//	@Override
//	public String getImagePath() {
//		return "icons/evl.gif";
//	}
//
//	@Override
//	public String getFileExtension() {
//		return "evl";
//	}
//
//	@Override
//	public String getSelectionTitle() {
//		return "Select an EVL Validation";
//	}
//
//	@Override
//	public String getSelectionSubtitle() {
//		return "EVL Validations in Workspace";
//	}
	
	protected Label solverLabel;
	protected Combo solverCombo;
	
	public void createControl(Composite parent) {
		
		FillLayout parentLayout = new FillLayout();
		parent.setLayout(parentLayout);

		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		
		GridLayout controlLayout = new GridLayout(2, false);
		control.setLayout(controlLayout);
		
		solverLabel = new Label(control, SWT.NONE);
		solverLabel.setText("Select the performance analysis: ");

		solverCombo = new Combo(control, SWT.NULL);
	    String[] perfan = new String[]{"QN-based (JMVA)", "LQN-based (LQNX)"};
	    //Arrays.sort(perfan);
	    for(int i=0; i<perfan.length; i++)
	    		solverCombo.add(perfan[i]);
	    solverCombo.addSelectionListener(new SelectionListener() {
	      public void widgetSelected(SelectionEvent e) {
	        System.out.println("Selected index: " + solverCombo.getSelectionIndex() + ", selected item: " + solverCombo.getItem(solverCombo.getSelectionIndex()) + ", text content in the text field: " + solverCombo.getText());
	      }
	      public void widgetDefaultSelected(SelectionEvent e) {
	        System.out.println("Default selected index: " + solverCombo.getSelectionIndex() + ", selected item: " + (solverCombo.getSelectionIndex() == -1 ? "<null>" : solverCombo.getItem(solverCombo.getSelectionIndex())) + ", text content in the text field: " + solverCombo.getText());
	        String text = solverCombo.getText();
	        if(solverCombo.indexOf(text) < 0) { // Not in the list yet. 
	        	solverCombo.add(text);
	          // Re-sort
	          String[] items = solverCombo.getItems();
	          Arrays.sort(items);
	          solverCombo.setItems(items);
	        }
	      }
	    });

		control.setBounds(0, 0, 300, 300);
		control.layout();
		control.pack();
		
		canSave();
		
	}

	public String getLaunchConfigurationKey() {
		return "SOURCE.EVL";
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		try {
			solverCombo.select(configuration.getAttribute(getSolverAttributeName(),0));
			//canSave();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
		PlatformUI.getWorkbench();
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			solverCombo.select(configuration.getAttribute(getSolverAttributeName(),0));
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//canSave();
		//updateLaunchConfigurationDialog();
	}
	
	
	
	@Override
	public boolean canSave(){
		return true;
	}
	
	

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(getSolverAttributeName(), solverCombo.getSelectionIndex());
		
//		// create a dialog with ok and cancel buttons and a question icon
//		MessageBox dialog =
//		    new MessageBox(this.getShell(), SWT.ICON_INFORMATION | SWT.OK);
//		dialog.setText("Selected performance analysis");
//		dialog.setMessage(solverCombo.getSelectionIndex() + " - " + solverCombo.getText());
//
//		// open dialog and await user selection
//		int returnCode = dialog.open();
	}

	@Override
	public String getName() {
		return getTitle();
	}
	
	public String getTitle() {
		return "Performance Analysis";
	}

	@Override
	public void modifyText(ModifyEvent e) {
		canSave();
		updateLaunchConfigurationDialog();
	}
	
	public String getSolverLabel() {
		return "Select the performance analysis: ";
	}
	
	public String getSolverAttributeName() {
		return "solver";
	}

	//public String getTitle() {
	//	return "EVL Source";
	//}

}
