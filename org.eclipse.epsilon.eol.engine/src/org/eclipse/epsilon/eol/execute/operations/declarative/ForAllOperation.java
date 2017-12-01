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
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;

import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class ForAllOperation extends FirstOrderOperation {
	
	public boolean isReturnOnFirstMatch() {
		return false;
	}
	
	@Override
	public Object execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {
		
		Collection source = CollectionUtil.asCollection(target);
		
		FrameStack scope = context.getFrameStack();
		
		for (Object listItem : source) {	
			if (iterator.getType()==null || iterator.getType().isKind(listItem)){
				scope.enterLocal(FrameType.UNPROTECTED, expression);
				scope.put(Variable.createReadOnlyVariable(iterator.getName(),listItem));
				Object bodyResult = context.getExecutorFactory().executeAST(expression, context);
				if (bodyResult instanceof Boolean){
					if ((Boolean) bodyResult == false) return false;
				}
				scope.leaveLocal(expression);
			}
		}
		
		return true;

	}

}
