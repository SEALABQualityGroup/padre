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
package org.eclipse.epsilon.eol.execute.introspection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ExtendedPropertyGetter extends AbstractPropertyGetter {
	
	public ExtendedPropertyGetter(IEolContext context) {
		this.context = context;
	}
	
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		return context.getExtendedProperties().getPropertyValue(object, property.substring(1));
	}

}
