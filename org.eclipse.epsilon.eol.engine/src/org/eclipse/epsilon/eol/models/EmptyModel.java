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
package org.eclipse.epsilon.eol.models;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;

public class EmptyModel extends Model{


	public void load() throws EolModelLoadingException {
		
	}

	public String getMetaModel() {
		return "";
	}

	public Object getEnumerationValue(String enumeration, String label) {
		return null;
	}

	public Collection<?> getAllOfType(String metaClass) throws EolModelElementTypeNotFoundException {
		return Collections.emptyList();
	}
 
	public Collection<?> getAllOfKind(String metaClass) throws EolModelElementTypeNotFoundException {
		return Collections.emptyList();
	}

	public Collection<?> getAllSupertypes(String metaClass) throws EolModelElementTypeNotFoundException {
		return Collections.emptyList();
	}

	public Collection<?> getAllSubtypes(String metaClass) throws EolModelElementTypeNotFoundException {
		return Collections.emptyList();
	}

	public Collection<?> getAllClasses(boolean onlyConcrete) {
		return Collections.emptyList();
	}

	public Object getTypeOf(Object instance) {
		return null;
	}
	
	public String getTypeNameOf(Object instance) {
		throw new UnsupportedOperationException("An empty model contains no elements.");
	}
	
	public Collection<String> getPropertiesOf(String type) {		
		return Collections.emptyList();
	}

	public Object createInstance(String metaClass) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		return null;
	}

	public Object getElementById(String id) {
		return null;
	}

	public String getElementId(Object instance) {
		return null;
	}
	
	public void setElementId(Object instance, String newId) {
		// do nothing
	}

	public void deleteElement(Object instance) {
		
	}

	public String getClassOf(Object instance) {
		return null;
	}

	public boolean owns(Object instance) {
		return false;
	}

	public boolean store(String fileName) {
		return false;
	}

	public boolean store() {
		return false;
	}

	@Override
	public void dispose() {
		
	}

	public Collection<?> allContents() {
		return Collections.emptyList();
	}

	public boolean isInstantiable(String metaClass) {
		return false;
	}

	public boolean hasType(String metaClass) {
		return true;
	}

	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		
	}

	public boolean isModelElement(Object instance) {
		return false;
	}

}
