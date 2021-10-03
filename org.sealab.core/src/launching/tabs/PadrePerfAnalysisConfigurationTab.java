/*******************************************************************************
 * Copyright (c) 2018 The University of L'Aquilas
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Daniele Di Pompeo - dipompeodaniele@gmail.com
 ******************************************************************************/
package launching.tabs;

import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;

public class PadrePerfAnalysisConfigurationTab extends AbstractLaunchConfigurationTab implements ModifyListener {

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
		String[] perfan = new String[] { "QN-based (JMVA)", "LQN-based (LQNX)" };
		for (int i = 0; i < perfan.length; i++)
			solverCombo.add(perfan[i]);
		solverCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Selected index: " + solverCombo.getSelectionIndex() + ", selected item: "
						+ solverCombo.getItem(solverCombo.getSelectionIndex()) + ", text content in the text field: "
						+ solverCombo.getText());
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				System.out.println("Default selected index: " + solverCombo.getSelectionIndex() + ", selected item: "
						+ (solverCombo.getSelectionIndex() == -1 ? "<null>"
								: solverCombo.getItem(solverCombo.getSelectionIndex()))
						+ ", text content in the text field: " + solverCombo.getText());
				String text = solverCombo.getText();
				if (solverCombo.indexOf(text) < 0) { // Not in the list yet.
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
			solverCombo.select(configuration.getAttribute(getSolverAttributeName(), 0));
			// canSave();
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
			solverCombo.select(configuration.getAttribute(getSolverAttributeName(), 0));
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(getSolverAttributeName(), solverCombo.getSelectionIndex());
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
}
