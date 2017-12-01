/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.types.EolCollectionType;

public class EmfPropertyGetter extends AbstractPropertyGetter{
	
	static {
		EolCollectionType.getCollectionTypeResolvers().add(new EmfCollectionTypeResolver());
	}
	
	public Object invoke(Object object, String property) throws EolRuntimeException {
		EObject eObject = (EObject) object;
		
		EStructuralFeature sf = EmfUtil.getEStructuralFeature(eObject.eClass(), property);
		
		if (sf != null) {	
			return eObject.eGet(sf);
		}
		else {
			throw new EolIllegalPropertyException(object, property, ast, context);
		}
	}
	
}
