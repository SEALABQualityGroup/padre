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

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.IEvlFixer;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class ValidationViewFixer implements IEvlFixer {
	
	protected boolean done = false;
	
	public ValidationViewFixer() {
		super();
	}

	public void fix(IEvlModule module) throws EolRuntimeException {
		try {
			fixImpl(module);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void fixImpl(IEvlModule module) throws Exception {
		ValidationView validationView = getValidationView();
		validationView.fix(module, this);
		while (!isDone()){Thread.sleep(100);}
	}
	
	protected ValidationView getValidationView() {
		final ValidationViewWrapper validationViewWrapper = new ValidationViewWrapper();
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				try {
					validationViewWrapper.validationView = (ValidationView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.epsilon.evl.dt.views.ValidationView");
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
		return validationViewWrapper.validationView;
	}
	
	class ValidationViewWrapper {
		public ValidationView validationView;
	}
	
	public boolean isDone() {
		return done;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
}
