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
package launching.launchers;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.ParametersConfigurationTab;

import launching.tabs.PadreModelsConfigurationTab;
import launching.tabs.PadrePerfAnalysisConfigurationTab;
import launching.tabs.PadreSourceConfigurationTab;

public class PadreLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	public ILaunchConfigurationTab[] getOtherConfigurationTabs() {
		AbstractLaunchConfigurationTab[] tabs = null;
		return tabs;
	}

	public ILaunchConfigurationTab[] getSourceConfigurationTabs() {
		return new ILaunchConfigurationTab[] { new PadreSourceConfigurationTab() };
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {

		ArrayList<ILaunchConfigurationTab> tabList = new ArrayList<ILaunchConfigurationTab>();
		for (ILaunchConfigurationTab tab : getSourceConfigurationTabs()) {
			tabList.add(tab);
		}

		tabList.add(new PadreModelsConfigurationTab()); // UAQ Padre model view
		tabList.add(new ParametersConfigurationTab());
		tabList.add(new PadrePerfAnalysisConfigurationTab());

		//IExtensionRegistry registry = Platform.getExtensionRegistry();
		//IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.eol.dt.launchConfigurationExtension");

		tabList.add(new CommonTab());
		setTabs(tabList);
	}

	public void setTabs(Collection<? extends ILaunchConfigurationTab> tabs) {
		setTabs(tabs.toArray(new ILaunchConfigurationTab[] {}));
	}

}
