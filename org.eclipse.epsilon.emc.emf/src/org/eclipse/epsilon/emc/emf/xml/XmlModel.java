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
package org.eclipse.epsilon.emc.emf.xml;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.CachedResourceSet;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;

public class XmlModel extends EmfModel implements IOperationContributorProvider {
	
	public static String PROPERTY_XSD_FILE = "xsdFile";
	protected MixedElementOperationContributor mixedElementOperationContributor = new MixedElementOperationContributor();
	
	protected String xsdFile = "";
	
	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		this.xsdFile = resolver.resolve(properties.getProperty(PROPERTY_XSD_FILE));
		super.load(properties, resolver);
	}
	
	@Override
	protected void determinePackagesFrom(ResourceSet resourceSet)
			throws EolModelLoadingException {
		super.determinePackagesFrom(resourceSet);
		
		if (xsdFile != null && xsdFile.endsWith("xsd")) {
			XSDEcoreBuilder xsdEcoreBuilder = new XSDEcoreBuilder();
			
		    Collection<EObject> ePackages = xsdEcoreBuilder.generate(URI.createFileURI(xsdFile));
		    
		    for (Iterator<EObject> iter = ePackages.iterator(); iter.hasNext();) {
		    	EPackage ePackage = (EPackage) iter.next();
		    	if (ePackage.getNsURI() == null || ePackage.getNsURI().length() == 0) {
		    		ePackage.setNsURI(ePackage.getName());
		    	}
		    	packages.add(ePackage);
		    }
		}
	}
	
	@Override
	protected ResourceSet createResourceSet() {
		return new CachedResourceSet() {
			@Override
			public Resource createNewResource(URI uri) {
				return new GenericXMLResourceFactoryImpl().createResource(uri);
			}
		};
	}
	
	@Override
	public XmlPropertySetter getPropertySetter() {
		return new XmlPropertySetter();
	}

	@Override
	public OperationContributor getOperationContributor() {
		return mixedElementOperationContributor;
	}
	
}
