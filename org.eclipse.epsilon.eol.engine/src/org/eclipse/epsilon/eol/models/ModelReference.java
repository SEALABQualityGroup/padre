/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - implemented IComparableModel and IAdaptableModel
 ******************************************************************************/
package org.eclipse.epsilon.eol.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.compile.m3.Metamodel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.IWrapper;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;

public class ModelReference implements IAdaptableModel, IWrapper, IOperationContributorProvider {

	protected IModel target;
	protected String name;
	protected List<String> aliases = new ArrayList<String>();
	
	public ModelReference(IModel target) {
		this.target = target;
		this.name = target.getName();
		this.aliases.addAll(target.getAliases());
	}
	
	public IModel getTarget() {
		return target;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAliases() {
		return aliases;
	}
	
	public Collection<?> allContents() {
		return target.allContents();
	}

	public Object createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		return target.createInstance(type);
	}

	public void deleteElement(Object instance) throws EolRuntimeException {
		target.deleteElement(instance);
	}

	public void dispose() {
		target.dispose();
	}

	public Collection<?> getAllOfKind(String type) throws EolModelElementTypeNotFoundException {
		return target.getAllOfKind(type);
	}

	public Collection<?> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
		return target.getAllOfType(type);
	}

	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		return target.getEnumerationValue(enumeration, label);
	}

	public Object getElementById(String id) {
		return target.getElementById(id);
	}

	public String getElementId(Object instance) {
		return target.getElementId(instance);
	}
	
	public void setElementId(Object instance, String newId) {
		target.setElementId(instance, newId);
	}

	public IPropertyGetter getPropertyGetter() {
		return target.getPropertyGetter();
	}

	public IPropertySetter getPropertySetter() {
		return target.getPropertySetter();
	}

	public Object getTypeOf(Object instance) {
		return target.getTypeOf(instance);
	}
	
	public String getTypeNameOf(Object instance) {
		return target.getTypeNameOf(instance);
	}
	
	public String getFullyQualifiedTypeNameOf(Object instance) {
		return target.getFullyQualifiedTypeNameOf(instance);
	}

	public boolean hasType(String type) {
		return target.hasType(type);
	}

	public boolean isInstantiable(String type) {
		return target.isInstantiable(type);
	}

	public boolean isModelElement(Object instance) {
		return target.isModelElement(instance);
	}

	public boolean isOfKind(Object instance, String type) throws EolModelElementTypeNotFoundException {
		return target.isOfKind(instance,type);
	}

	public boolean isOfType(Object instance, String type) throws EolModelElementTypeNotFoundException {
		return target.isOfType(instance, type);
	}

	public boolean isReadOnLoad() {
		return target.isReadOnLoad();
	}

	public boolean isStoredOnDisposal() {
		return target.isStoredOnDisposal();
	}

	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		target.load(properties, resolver);
	}

	public void load() throws EolModelLoadingException {
		target.load();
	}

	public boolean owns(Object instance) {
		return target.owns(instance);
	}

	public void setReadOnLoad(boolean readOnLoad) {
		target.setReadOnLoad(readOnLoad);
	}

	public void setStoredOnDisposal(boolean storedOnDisposal) {
		target.setStoredOnDisposal(storedOnDisposal);
	}

	public boolean store(String fileName) {
		return target.store(fileName);
	}

	public boolean store() {
		return target.store();
	}

	public IModelTransactionSupport getTransactionSupport() {
		return target.getTransactionSupport();
	}

	public boolean knowsAboutProperty(Object instance, String property) {
		return target.knowsAboutProperty(instance, property);
	}

	public Object createInstance(String type, Collection<Object> parameters)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return target.createInstance(type, parameters);
	}

	public Object getWrapped() {
		return target;
	}

	public <T> T adaptTo(Class<T> modelType) {
		if (modelType.isInstance(target)) {
			return modelType.cast(target);
		}
		else {
			return null;
		}
	}

	@Override
	public OperationContributor getOperationContributor() {
		if (target instanceof IOperationContributorProvider) {
			return ((IOperationContributorProvider) target).getOperationContributor();
		}
		else return null;
	}

	@Override
	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		target.load(properties, basePath);
	}
	
	@Override
	public void load(StringProperties properties)
			throws EolModelLoadingException {
		target.load(properties);
	}

	@Override
	public Metamodel getMetamodel(StringProperties properties, IRelativePathResolver resolver) {
		return target.getMetamodel(properties, resolver);
	}

}
