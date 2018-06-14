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

import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.epsilon.common.dt.launching.tabs.EpsilonLaunchConfigurationTabGroup;
import org.eclipse.epsilon.evl.dt.launching.EvlLaunchConfigurationTabGroup;

import launching.tabs.PadreEvlPerfAnalysisConfigurationTab;
import launching.tabs.PadreEvlSourceConfigurationTab;

public class PadreEvlLaunchConfigurationTabGroup extends EvlLaunchConfigurationTabGroup{

	@Override
	public ILaunchConfigurationTab getSourceConfigurationTab() {
		return new PadreEvlSourceConfigurationTab();
	}
	
	@Override
	public ILaunchConfigurationTab[] getOtherConfigurationTabs() {
		PadreEvlPerfAnalysisConfigurationTab[] tabs = { new PadreEvlPerfAnalysisConfigurationTab() };
		//PadreEvlSourceConfigurationTab[] tabs = { new PadreEvlSourceConfigurationTab() };
		return tabs;
	}

}
