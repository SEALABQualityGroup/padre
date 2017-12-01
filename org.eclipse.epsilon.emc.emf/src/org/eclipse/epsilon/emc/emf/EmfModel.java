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
package org.eclipse.epsilon.emc.emf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.compile.m3.Metamodel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotAnEnumerationValueException;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.models.IReflectiveModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public class EmfModel extends AbstractEmfModel implements IReflectiveModel {
	
	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * When paired with "true", external references will be resolved during loading.
	 * Otherwise, external references are not resolved.
	 * 
	 * Paired with "true" by default.
	 */
	public static final String PROPERTY_EXPAND = "expand";

	/**
	 * @deprecated {@link #PROPERTY_METAMODEL_URI} and {@link #PROPERTY_FILE_BASED_METAMODEL_URI} are now
	 * interpreted as comma-separated lists of 0+ metamodel locations, and it is allowed to mix both types
	 * of metamodels now. This property is no longer used.
	 */
	@Deprecated
	public static final String PROPERTY_IS_METAMODEL_FILE_BASED = "isMetamodelFileBased";

	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * This key is a comma-separated list of zero or more namespaces URI of some of the metamodels to which
	 * this model conforms. Users may combine this key with {@link #PROPERTY_FILE_BASED_METAMODEL_URI} to load
	 * both file-based and URI-based metamodels at the same time.
	 */
	public static final String PROPERTY_METAMODEL_URI = "metamodelUri";

	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * This key is a comma-separated list of zero or more {@link URI}s that can be used to locate some of the
	 * metamodels to which this model conforms. Users may combine this key with {@link #PROPERTY_METAMODEL_URI}
	 * to load both file-based and URI-based metamodels at the same time.
	 */
	public static final String PROPERTY_FILE_BASED_METAMODEL_URI = "fileBasedMetamodelUri";

	/**
	 * @deprecated Replaced by
	 *             {@link #PROPERTY_FILE_BASED_METAMODEL_URI}.
	 *              This property will be removed in a future release of Epsilon.
	 */
	@Deprecated
	public static final String PROPERTY_METAMODEL_FILE = "metamodelFile";
	
	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * This key is paired with a {@link URI} that can be used to locate this model.
	 * This key must always be paired with a value.
	 */
	public static final String PROPERTY_MODEL_URI = "modelUri";

	/**
	 * @deprecated  Replaced by
	 *              {@link #PROPERTY_MODEL_URI}.
	 *              This property will be removed in a future release of Epsilon.
	 */
	@Deprecated
	public static final String PROPERTY_MODEL_FILE = "modelFile";

	/**
	 * One of the keys used to construct the first argument to
	 * {@link EmfModel#load(StringProperties, String)}.
	 *
	 * This key is a Boolean value that if set to <code>true</code> (the
	 * default), tries to reuse previously registered file-based EPackages that
	 * have not been modified since the last time they were registered.
	 */
	public static final String PROPERTY_REUSE_UNMODIFIED_FILE_BASED_METAMODELS = "reuseUnmodifiedFileBasedMetamodels";

	protected List<URI> metamodelUris = new ArrayList<URI>();
	protected List<EPackage> packages;
	protected boolean isMetamodelFileBased;
	protected URI modelUri = null;
	protected List<URI> metamodelFileUris = new ArrayList<URI>();
	protected boolean useExtendedMetadata = false;

	protected boolean reuseUnmodifiedFileBasedMetamodels = true;
	protected static Map<String, List<EPackage>> fileBasedMetamodels = new HashMap<String, List<EPackage>>();
	protected static Map<String, Long> fileBasedMetamodelTimestamps = new HashMap<String, Long>();


	public Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException {
		final Collection<String> properties = new LinkedList<String>();
		
		for (EStructuralFeature feature : featuresForType(type)) {
			properties.add(feature.getName());
		}
		
		return properties;
	}

	public boolean preventLoadingOfExternalModelElements() {
		if (isExpand()) {
			setExpand(false);
			return true;
			
		} else {
			return false;
		}
	}
	
	/**
	 * Load the model using the set of properties specified by the first argument.
	 * 
	 * @see #PROPERTY_MODEL_URI
	 * @see #PROPERTY_IS_METAMODEL_FILE_BASED
	 * @see #PROPERTY_EXPAND
	 * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=341481">Rationale for deprecating the FILE properties</a>.
	 */
	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		PropertyMigrator.migrateDeprecatedProperties(properties);	
		
		super.load(properties, resolver);
		this.modelUri = URI.createURI(properties.getProperty(PROPERTY_MODEL_URI));
		this.expand = properties.getBooleanProperty(PROPERTY_EXPAND, true);
		this.isMetamodelFileBased = properties.getBooleanProperty(PROPERTY_IS_METAMODEL_FILE_BASED, false);

		this.metamodelUris = toURIList(properties.getProperty(PROPERTY_METAMODEL_URI));
		this.metamodelFileUris = toURIList(properties.getProperty(PROPERTY_FILE_BASED_METAMODEL_URI));
		this.reuseUnmodifiedFileBasedMetamodels = properties.getBooleanProperty(PROPERTY_REUSE_UNMODIFIED_FILE_BASED_METAMODELS, true);
		
		load();
	}

	protected void loadModel() throws EolModelLoadingException {
		loadModelFromUri();
		setupContainmentChangeListeners();
	}

	/**
	 * Used for backwards-compatibility with existing Eclipse launch configurations.
	 * 
	 * See #341481
	 */
	static class PropertyMigrator {
		public static void migrateDeprecatedProperties(StringProperties properties) {
			migrateModelFileProperty(properties);
			migrateMetamodelFileProperty(properties);
		}
		
		private static void migrateModelFileProperty(StringProperties properties) {
			migrateUriValue(properties, PROPERTY_MODEL_FILE, PROPERTY_MODEL_URI);
		}
		
		private static void migrateMetamodelFileProperty(StringProperties properties) {
			migrateUriValue(properties, PROPERTY_METAMODEL_FILE, PROPERTY_FILE_BASED_METAMODEL_URI);
		}

		private static void migrateUriValue(StringProperties properties, String oldProperty, String newProperty) {
			if (properties.hasProperty(oldProperty) && !properties.hasProperty(newProperty)) {
				final String oldValue = properties.getProperty(oldProperty);

				final File oldFile = new File(oldValue);
				if (oldFile.canRead() || oldFile.getParentFile() != null && oldFile.getParentFile().canRead()) {
					// This is a regular path to a readable file (to be read) or in a readable directory (to be saved)
					properties.put(newProperty, EmfUtil.createFileBasedURI(oldValue));
				}
				else {
					// It's not a regular file path: treat it as a platform:/resource/ URI
					properties.put(newProperty, EmfUtil.createPlatformResourceURI(oldValue));
				}
			}
		}
	}
	
	
	public void setupContainmentChangeListeners() {
		// Add a notification adapter to all objects in the model
		// so that they get moved when their containment changes
		
		if (modelImpl != null) {
			for (EObject eObject : allContents()) {
				boolean isAdapted = false;
				for (Adapter adapter : eObject.eAdapters()) {
					if (adapter instanceof ContainmentChangeAdapter) {
						isAdapted = true;
					}
				}
				if (!isAdapted){
					eObject.eAdapters().add(new ContainmentChangeAdapter(eObject, eObject.eResource()));
				}
			}
		}
	}
	
	protected ResourceSet createResourceSet() {
		return new CachedResourceSet();
	}
	
	public void loadModelFromUri() throws EolModelLoadingException {
		ResourceSet resourceSet = createResourceSet();
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("model", new DefaultXMIResource.Factory());
		
        // Check if global package registry contains the EcorePackage
		if (EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) == null) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		determinePackagesFrom(resourceSet);
		
		// Note that AbstractEmfModel#getPackageRegistry() is not usable yet, as modelImpl is not set
		for (EPackage ep : packages) {
			String nsUri = ep.getNsURI();
			if (nsUri == null || nsUri.trim().length() == 0) {
				nsUri = ep.getName();
			}
			resourceSet.getPackageRegistry().put(nsUri, ep);
		}
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		Resource model = resourceSet.createResource(modelUri);
		if (this.readOnLoad) {
			try {
				model.load(null);
				if (expand) {
					EcoreUtil.resolveAll(model);
				}
			} catch (IOException e) {
				throw new EolModelLoadingException(e, this);
			}
		}
		modelImpl = model;
	}

	public List<String> getMetamodelFiles() {
		final List<String> files = new ArrayList<String>(metamodelFileUris.size());
		for (URI metamodelFileUri : this.metamodelFileUris) {
			files.add(EmfUtil.getFile(metamodelFileUri));
		}
		return files;
	}

	/**
	 * @deprecated This value is no longer used to load models: it is only
	 * kept for backwards compatibility, and it now simply indicates whether
	 * a file metamodel was loaded at all, or not.
	 */
	@Deprecated
	public boolean isMetamodelFileBased() {
		return isMetamodelFileBased;
	}

	/**
	 * @deprecated This value is no longer honored anymore. Please populate the
	 *             lists in {@link #getMetamodelUris()} (URI-based metamodels)
	 *             and {@link #getMetamodelFileUris()} (file-based metamodels)
	 *             appropriately instead.
	 */
	@Deprecated
	public void setMetamodelFileBased(boolean isMetamodelFileBased) {
		this.isMetamodelFileBased = isMetamodelFileBased;
	}

	public List<String> getMetamodelUris() {
		final List<String> uris = new ArrayList<String>(metamodelUris.size());
		for (URI metamodelUri : this.metamodelUris) {
			uris.add(metamodelUri.toString());
		}
		return uris;
	}

	public String getModelFile() {
		return EmfUtil.getFile(modelUri);
	}

	public URI getModelFileUri() {
		return modelUri;
	}

	public void setModelFileUri(URI modelFileUri) {
		this.modelUri = modelFileUri;
	}

	public List<URI> getMetamodelFileUris() {
		return metamodelFileUris;
	}

	public void setMetamodelFileUris(List<URI> fileUris) {
		this.metamodelFileUris = new ArrayList<URI>(fileUris);
	}

	public void setMetamodelFileUri(URI uri) {
		metamodelFileUris = Arrays.asList(uri);
	}

	public void setMetamodelUris(List<String> uris) {
		this.metamodelUris.clear();
		for (String sURI : uris) {
			this.metamodelUris.add(URI.createURI(sURI));
		}
	}

	public void setMetamodelUri(String uri) {
		metamodelUris = Arrays.asList(URI.createURI(uri));
	}

	public void setMetamodelFiles(List<String> paths) {
		this.metamodelFileUris.clear();
		for (String sPath : paths) {
			this.metamodelFileUris.add(URI.createFileURI(sPath));
		}
	}

	public void setMetamodelFile(String path) {
		setMetamodelFileUri(URI.createFileURI(path));
	}

	public void setModelFile(String path) {
		this.modelUri = URI.createFileURI(path);
	}

	public boolean isReuseUnmodifiedFileBasedMetamodels() {
		return reuseUnmodifiedFileBasedMetamodels;
	}

	public void setReuseUnmodifiedFileBasedMetamodels(boolean reuseUnmodifiedFileBasedMetamodels) {
		this.reuseUnmodifiedFileBasedMetamodels = reuseUnmodifiedFileBasedMetamodels;
	}

	@Override
	public IReflectivePropertySetter getPropertySetter() {
		return new EmfPropertySetter();
	}

	public boolean hasProperty(String type, String property) throws EolModelElementTypeNotFoundException {
		return getPropertiesOf(type).contains(property);
	}
	
	public boolean isEnumerationValue(Object object) {
		return object instanceof Enumerator;
	}

	public String getEnumerationTypeOf(Object literal) throws EolNotAnEnumerationValueException {
		if (!isEnumerationValue(literal))
			throw new EolNotAnEnumerationValueException(literal);
		
		if (literal instanceof EEnumLiteral) {
			return ((EEnumLiteral)literal).getEEnum().getName();
		} else {
			return ((Enumerator)literal).getClass().getSimpleName();
		}		
	}

	public String getEnumerationLabelOf(Object literal) throws EolNotAnEnumerationValueException {
		if (!isEnumerationValue(literal))
			throw new EolNotAnEnumerationValueException(literal);
			
		return ((Enumerator)literal).getName();
	}

	@Override
	public String toString() {
		return "EmfModel [name=" + getName() + "]";
	}

	protected void determinePackagesFrom(ResourceSet resourceSet) throws EolModelLoadingException {
		packages = new ArrayList<EPackage>();

		for (URI metamodelFileUri : this.metamodelFileUris) {
			List<EPackage> metamodelPackages = null;
			try {
				metamodelPackages = attemptFileBasedMetamodelReuse(metamodelFileUri);
				if (metamodelPackages == null) {
					metamodelPackages = EmfUtil.register(metamodelFileUri, resourceSet.getPackageRegistry());
					saveFileBasedMetamodelForReuse(metamodelFileUri, metamodelPackages);
				}
			} catch (Exception e) {
				throw new EolModelLoadingException(e,this);
			}
			for (EPackage metamodelPackage : metamodelPackages) {
				packages.add(metamodelPackage);
				EmfUtil.collectDependencies(metamodelPackage, packages);
			}
		}
	
		for (URI metamodelUri : this.metamodelUris) {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(metamodelUri.toString());
			if (ePackage == null) {
				throw new EolModelLoadingException(new IllegalArgumentException("Could not locate a metamodel with the URI '" + metamodelUri + "'. Please ensure that this metamodel has been registered with Epsilon."), this);
			}
			packages.add(ePackage);
			EmfUtil.collectDependencies(ePackage, packages);
		}
	}

	private List<EPackage> attemptFileBasedMetamodelReuse(URI uri) {
		if (!reuseUnmodifiedFileBasedMetamodels || !uri.isFile()) {
			// Reuse has been disabled, or the URI is not for a file: do nothing
			return null;
		}

		final String path = uri.toFileString();
		final File metamodelFile = new File(path);
		final Long lastTimestamp = fileBasedMetamodelTimestamps.get(path);
		if (lastTimestamp == null || metamodelFile.lastModified() != lastTimestamp) {
			// We don't have this URI in our cache yet, or the file
			// has been modified since the last time we read it
			return null;
		}

		return fileBasedMetamodels.get(path);
	}

	private void saveFileBasedMetamodelForReuse(URI uri, List<EPackage> packages) {
		// We always save the previously loaded metamodels, as we might want to force
		// a reload first in one EmfModel and then reuse the metamodel in the next
		// EmfModel.
		if (!uri.isFile()) {
			// The URI is not for a file: do nothing
			return;
		}

		final String path = uri.toFileString();
		final File metamodelFile = new File(path);
		final Long timestamp = metamodelFile.lastModified();
		fileBasedMetamodels.put(path, packages);
		fileBasedMetamodelTimestamps.put(path, timestamp);
	}

	public boolean hasPackage(String packageName) {
		return packageForName(packageName) != null;
	}
	
	private EPackage packageForName(String name) {
		final String[] parts = name.split("::");
		
		int partIndex = 0;
		EPackage current = null;
		Collection<EPackage> next = getTopLevelPackages();
		
		do {
			current = packageForName(parts[partIndex++], next);
			if (current != null) next = current.getESubpackages();
		
		} while(current!=null && partIndex < parts.length);
		
		return current;
	}

	private Collection<EPackage> getTopLevelPackages() {
		final Collection<EPackage> packages = new LinkedList<EPackage>();
		for (Object pkg : getPackageRegistry().values()) {
			if (pkg instanceof EPackage) {
				packages.add((EPackage)pkg);
			}
		}
		return packages;
	}
	
	private EPackage packageForName(String name, Collection<EPackage> packages) {
		for (EPackage p : packages) {
			if (name.equals(p.getName())) {
				return p;
			}
		}
		return null;
	}
	

	private EList<EStructuralFeature> featuresForType(String type) throws EolModelElementTypeNotFoundException {
		return classForName(type).getEAllStructuralFeatures();
	}

	private List<URI> toURIList(final String commaSeparatedList) {
		final List<URI> list = new ArrayList<URI>();
		for (String s : commaSeparatedList.trim().split("\\s*,\\s*")) {
			if (s.length() > 0) {
				list.add(URI.createURI(s));
			}
		}
		return list;
	}
	
	@Override
	public Metamodel getMetamodel(StringProperties properties,
			IRelativePathResolver resolver) {
		return new EmfModelMetamodel(properties, resolver);
	}
}
