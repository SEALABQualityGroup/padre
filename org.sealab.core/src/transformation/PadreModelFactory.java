package transformation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;

public class PadreModelFactory {
	
	public EmfModel createEmfModel(
			String name,
			URI uri, 
			boolean readOnLoad, 
			boolean storedOnDisposal
	) {
		EmfModel model = new EmfModel();
		model.setName(name);
		model.setModelFileUri(uri);
		model.setReadOnLoad(readOnLoad);
		model.setStoredOnDisposal(storedOnDisposal);
		
		return model;
	}	
	public PlainXmlModel createXmlModel(
			String name,
			File file,
			boolean readOnLoad, 
			boolean storedOnDisposal
	) {
		PlainXmlModel model = new PlainXmlModel();
		model.setName(name);
		model.setFile(file);
		model.setReadOnLoad(readOnLoad);
		model.setStoredOnDisposal(storedOnDisposal);

		return model;
	}

	public void loadModel(Model model) {
		try {
			model.load();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		}
	}
	
	public void loadUmlMarte(EmfModel model) {
		Collection<EPackage> marte = 
				org.eclipse.papyrus.MARTE.MARTEPackage.eINSTANCE
				.getESubpackages();

		loadMetamodel(model, marte);
	}
	
	public void loadUml(EmfModel model) {
		Collection<EPackage> metamodel = Arrays.asList(
				UMLPackage.eINSTANCE,
				StandardPackage.eINSTANCE, 
				EcorePackage.eINSTANCE
		);
		
		loadMetamodel(model, metamodel);
	}
	
	public void loadXSD(EmfModel model, String xsdPath) {
		XSDEcoreBuilder xsdEcoreBuilder = new XSDEcoreBuilder();
		URI xsdURI = URI.createFileURI(xsdPath);

		Collection<EPackage> xsdPackages = new ArrayList<EPackage>();
		Collection<EObject> xsdObjects = xsdEcoreBuilder.generate(xsdURI);
		
		xsdObjects.forEach(element -> xsdPackages.add((EPackage) element));

		loadMetamodel(model, xsdPackages);
	}

	public void loadMetamodel(EmfModel model, Collection<EPackage> ePackages) {
		Resource resource = model.getResource();
		ResourceSet set = new ResourceSetImpl();
		
		if(resource == null)
			resource = set.createResource(model.getModelFileUri());
		else
			set = resource.getResourceSet();
		
		model.setResource(resource);
		
		List<String> uris = new ArrayList<String>();
		for(EPackage ePackage: ePackages) {
			// Stores the metamodel in the local registry of the ResourceSet
			set.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
			// Puts the metamodel in the global registry
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
			uris.add(ePackage.getNsURI());
		}
		/* 
		 * References the metamodel inside the model object
		 * addMetamodelUri didn't work for the purpose
		 */
		model.setMetamodelUris(uris);
	}
}
