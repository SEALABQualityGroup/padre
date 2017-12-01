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
package org.eclipse.epsilon.eol.types;

import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolAnyType extends EolType{

	public static EolAnyType Instance = new EolAnyType();
	
	public EolAnyType() {
		super();
	}

	@Override
	public boolean isType(Object o) {
		return false;
	}

	@Override
	public boolean isKind(Object o) {
		return true;
	}

	@Override
	public Object createInstance() throws EolRuntimeException {
		return null;
	}
	
	@Override
	public String getName() {
		return "Any";
	}

	@Override
	public Object createInstance(List<Object> parameters)
			throws EolRuntimeException {
		throw new EolIllegalOperationParametersException("createInstance");
	}
	
	@Override
	public String toString() {
		return "Any";
	}
	
}
