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
package org.eclipse.epsilon.epl.dt.wizards;

import org.eclipse.epsilon.common.dt.wizards.AbstractNewFileWizard2;

public class NewEplFileWizard extends AbstractNewFileWizard2 {

	@Override
	public String getTitle() {
		return "New EPL Program";
	}

	@Override
	public String getExtension() {
		return "epl";
	}

	@Override
	public String getDescription() {
		return "This wizard creates a new EPL program file with *.epl extension";
	}
	
	/*
	public ImageDescriptor getImageDescriptor() {
		return EtlPlugin.getImageDescriptor("icons/etl.gif");
	}
	*/
}
