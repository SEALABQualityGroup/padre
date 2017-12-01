/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.eol.IEolExecutableModule;

public interface EpsilonLaunchConfigurationDelegateListener {
	
	public void aboutToParse(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEolExecutableModule module) throws CoreException;
	
	public void aboutToExecute(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEolExecutableModule module) throws Exception;
	
	public void executed(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEolExecutableModule module, Object result) throws Exception;
	
}
