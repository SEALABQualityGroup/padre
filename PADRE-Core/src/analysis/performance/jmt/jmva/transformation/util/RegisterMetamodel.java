package analysis.performance.jmt.jmva.transformation.util;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.MARTE.MARTEFactory;
import org.eclipse.papyrus.MARTE.MARTEPackage;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMFactory;
import org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import jmtmodel.JmtmodelPackage;

public class RegisterMetamodel {

	public static void registerMetamodel(final File file) {
		// Create a Resource Set
		ResourceSet rs = new ResourceSetImpl();

		// Get the EPackage element
		URI uri = URI.createURI(file.getPath());
		Resource mmResource;
		try {
			mmResource = rs.getResource(uri, true);
		} catch (Exception e) {
			uri = URI.createFileURI(uri.path());
			mmResource = rs.getResource(uri, true);
		}
		EObject mmPackage = mmResource.getContents().get(0);

		// Register the metamodel namespace URI
		if (mmPackage.eClass().getName().equals("EPackage")) {
			EPackage p = (EPackage) mmPackage;
			String nsURI = p.getNsURI();
			if (nsURI == null) {
				nsURI = p.getName();
				p.setNsURI(nsURI);
			}
			EPackage.Registry.INSTANCE.put(nsURI, p);
		}
	}

	public static String getNsURI(File file) {
		ResourceSet rs = new ResourceSetImpl();

		// Get the EPackage element
		URI uri = URI.createURI(file.getPath());
		Resource mmResource;
		try {
			mmResource = rs.getResource(uri, true);
		} catch (Exception e) {
			uri = URI.createFileURI(uri.path());
			mmResource = rs.getResource(uri, true);
		}
		EObject mmPackage = mmResource.getContents().get(0);

		// Register the metamodel namespace URI
		if (mmPackage.eClass().getName().equals("EPackage")) {
			EPackage p = (EPackage) mmPackage;
			String nsURI = p.getNsURI();
			if (nsURI == null) {
				nsURI = p.getName();
				p.setNsURI(nsURI);
			}
			return nsURI;
		}
		return "";
	}

	public static void packageRegistering(List<String> paths) {
		// setResourceSet(new ResourceSetImpl());
		ResourceSet rs = new ResourceSetImpl();
		
		rs.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		rs.getPackageRegistry().put(StandardPackage.eNS_URI, StandardPackage.eINSTANCE);
		
		rs.getPackageRegistry().put(org.eclipse.papyrus.MARTE.MARTEPackage.eNS_URI, MARTEPackage.eINSTANCE);
		rs.getPackageRegistry().put(org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eNS_URI,
				GQAMPackage.eINSTANCE);

		rs.getPackageRegistry().put(JmtmodelPackage.eINSTANCE.getNsURI(), JmtmodelPackage.eINSTANCE);

		for (String path : paths) {
			registerMetamodel(new File(path));
		}

		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				MARTEFactory.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				GQAMFactory.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);

	}
}
