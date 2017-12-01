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
package org.eclipse.epsilon.evl.execute.operations;

import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.exceptions.EvlConstraintNotFoundException;

public class SatisfiesOperation extends SimpleOperation {
	
	protected boolean all = true;
	
	public SatisfiesOperation(boolean all) {
		super();
		this.all = all;
	}
	
	
	public boolean isAll() {
		return all;
	}
	
	public void setAll(boolean all) {
		this.all = all;
	}

	@Override
	public Object execute(Object source, List<?> parameters,
			IEolContext context_, AST ast) throws EolRuntimeException {

		if (source == null) return false;
		
		IEvlContext context = (IEvlContext) context_;
		
		for (Object parameter : parameters) {
			String constraintName = context.getPrettyPrinterManager().toString(parameter);
			
			Constraint constraint = context.getModule().getConstraints().getConstraint(constraintName, source, context);
			
			if (constraint == null) {
				throw new EvlConstraintNotFoundException(constraintName,ast);
			}
			
			boolean valid = constraint.check(source,context);
			
			if (all) {
				if (!valid) return false;
			}
			else {
				if (valid) return true;
			}
		}
		
		return true;
	}
	
}
