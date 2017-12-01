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
package org.eclipse.epsilon.epl.execute;

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;

public class PatternMatchPropertySetter extends AbstractPropertySetter {

	@Override
	public void invoke(Object value) throws EolRuntimeException {
		//PatternMatch match = (PatternMatch) object;
		//Variable component = match.getComponent(property);
		//if (component != null) {
		//	component.setValueBruteForce(value);
		//}
		//else 
		throw new EolIllegalPropertyException(object, property, ast, context);
	}

}
