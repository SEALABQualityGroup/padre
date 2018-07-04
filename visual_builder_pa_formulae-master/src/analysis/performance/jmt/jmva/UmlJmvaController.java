package analysis.performance.jmt.jmva;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.osgi.framework.Bundle;

import analysis.performance.jmt.jmva.transformation.ModelTransformation;
import analysis.performance.jmt.jmva.transformation.util.RegisterMetamodel;
import it.univaq.disim.sealab.padre.performance.analysis.launching.JmtModelGenerator;
import it.univaq.disim.sealab.padre.performance.analysis.launching.JmvaExecutor;
import it.univaq.disim.sealab.padre.performance.analysis.launching.JmvaFileGenerator;
import it.univaq.disim.sealab.padre.performance.analysis.launching.UMLModelConformer;

public class UmlJmvaController {
	public static final String UML_EXTENSION = ".uml";
	public static final String JMVA_EXTENSION = ".jmva";
	public static final String DEFAULT_EXTENSION = ".xmi";

	public static final int UML_JAVA_FWD_TRANSFORMATION = 0;
	public static final int UML_JAVA_BWD_TRANSFORMATION = 1;
	private String jmtMetamodelFilePath;
	private String traceMetamodelFilePath;
	private String uml2jmtEtlTransformation;
	private String jmt2umlEtlTransformation;

	public UmlJmvaController() {
		jmtMetamodelFilePath = getFilePath(getBundle().getResource("metamodels/JMT/JMTModel.ecore").getPath());
		traceMetamodelFilePath = getFilePath(
				getBundle().getResource("metamodels/Tracing/Trace.ecore").getPath());
		uml2jmtEtlTransformation = getFilePath(
				getBundle().getResource("transformations/UmlDeploymentDemands2Jmva.etl").getPath());
		jmt2umlEtlTransformation = getFilePath(
				getBundle().getResource("transformations/Jmva2UmlDeploymentDemands.etl").getPath());
	}

	// public UmlJmvaController(URI modelUri) {// IPath path = new
	// Path(modelUri.toFileString()); //sourceModel}

	private IFile getFile(URI uri) {
		String scheme = uri.scheme();
		if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) {
			StringBuffer platformResourcePath = new StringBuffer();
			for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
				platformResourcePath.append('/');
				platformResourcePath.append(uri.segment(j));
			}
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourcePath.toString()));
		}
		return null;
	}

	public void roundtripMVA(URI modelURI) {
		IFile modelFile = getFile(modelURI);
		IFolder containerFolder = (IFolder) modelFile.getParent();
		IFolder perfAnalysisOutputFolder = containerFolder.getFolder("performanceAnalysis");

		try {
			create(perfAnalysisOutputFolder);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IFolder jmvaOutputFolder = perfAnalysisOutputFolder.getFolder("jmva");
		IFolder tracesOutputFolder = perfAnalysisOutputFolder.getFolder("traces");
		try {
			jmvaOutputFolder.create(false, true, getMonitor());
			tracesOutputFolder.create(false, true, getMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String modelName = "BGCS.jmva";
		IFile jmvaFile = jmvaOutputFolder.getFile(modelName);
		IFile jmtFile = jmvaOutputFolder.getFile("BGCS.xmi");
		IFile tracesFile = tracesOutputFolder.getFile("trace.xml");
		IFile analysedModel = perfAnalysisOutputFolder.getFile("analysed."+modelFile.getFileExtension());
		
		uml2jmt(modelURI, tracesFile, jmtFile);
		
		jmvaGenerator(jmvaFile.getLocation(), jmtFile.getLocation());
				
		jmt2uml(modelURI, analysedModel, tracesFile, jmtFile);
		
		UMLModelConformer mc = new UMLModelConformer(UMLModelConformer.OVERWRITE_MODE);
		mc.conform(analysedModel.getLocation().toString());
	}
	
	private void jmvaGenerator(IPath jmvaPath, IPath jmtPath) {
		JmvaFileGenerator jmvaFileGen = new JmvaFileGenerator(jmvaPath.toString());
		jmvaFileGen.generate(jmtPath.toString());
		JmvaExecutor.run(jmvaPath.toString());
		JmtModelGenerator jmtModelGen = new JmtModelGenerator();
		jmtModelGen.generate(jmvaPath.toString(), jmtPath.toString());
	}
	
	private void jmt2uml(URI modelURI, IFile analysedModelFile, IFile tracesFile, IFile jmtFile) {
		ModelTransformation jmva2uml = new ModelTransformation(jmt2umlEtlTransformation);
		RegisterMetamodel.packageRegistering(Arrays.asList(new String[] { traceMetamodelFilePath }));

		jmva2uml.addModel(jmva2uml.createEmfModel("UML", modelURI,
				Arrays.asList(new String[] { UMLPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTEPackage.eNS_URI,
						StandardPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eNS_URI,
						EcorePackage.eNS_URI }),
				true, true));

		jmva2uml.addModel(jmva2uml.loadEmptyModel("UMLPerf",
				Arrays.asList(new String[] { UMLPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTEPackage.eNS_URI,
						StandardPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eNS_URI,
						EcorePackage.eNS_URI }),
				analysedModelFile.getLocation().toString()));

		jmva2uml.addModel(jmva2uml.createEmfModel("Trace", tracesFile.getLocation().toString(),
				Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(traceMetamodelFilePath)) }), true,
				false));

		jmva2uml.addModel(jmva2uml.createEmfModel("jmtmodel", jmtFile.getLocation().toString(),
				Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(jmtMetamodelFilePath)) }), true,
				false));

		jmva2uml.run();
	}
	
	private void uml2jmt(URI modelURI, IFile tracesFile, IFile jmtFile) {
		ModelTransformation uml2jmva = new ModelTransformation(uml2jmtEtlTransformation);
		RegisterMetamodel.packageRegistering(Arrays.asList(new String[] { traceMetamodelFilePath }));
		uml2jmva.addModel(uml2jmva.createEmfModel("UML", modelURI,
				Arrays.asList(new String[] { UMLPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTEPackage.eNS_URI,
						StandardPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eNS_URI,
						EcorePackage.eNS_URI }),
				true, false));
		uml2jmva.addModel(uml2jmva.loadEmptyModel("Trace",
				Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(traceMetamodelFilePath)) }),
				tracesFile.getLocation().toString()));
		uml2jmva.addModel(uml2jmva.loadEmptyModel("jmtmodel",
				Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(jmtMetamodelFilePath)) }),
				jmtFile.getLocation().toString()));
		uml2jmva.run();
	}

	public void roundtripMVA() {

		String in_umlModelAbsFilePath = getFilePath(
				getBundle().getResource("examples/BGCS/BGCS-Papyrus.uml").getPath());

		String jmvaAbsFilePath = getFilePath(
				getBundle().getResource("examples/BGCS/performanceAnalysis/jmva/").getPath()).concat("/BGCS.jmva");

		String out_umlModelAbsFilePath = getFilePath(getBundle().getResource("examples/BGCS/").getPath())
				.concat("/BGCS-analysed.uml");

		String out_traceModelAbsFilePath = getFilePath(
				getBundle().getResource("examples/BGCS/performanceAnalysis/traces/").getPath()).concat("/Trace.xml");

		String out_jmtModelAbsFilePath = getFilePath(
				getBundle().getResource("examples/BGCS/performanceAnalysis/jmva/").getPath()).concat("/BGCS.xmi");


		ModelTransformation uml2jmva = new ModelTransformation(uml2jmtEtlTransformation);
		RegisterMetamodel.packageRegistering(Arrays.asList(new String[] { traceMetamodelFilePath }));
		uml2jmva.addModel(uml2jmva.createEmfModel("UML", in_umlModelAbsFilePath,
				Arrays.asList(new String[] { UMLPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTEPackage.eNS_URI,
						StandardPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eNS_URI,
						EcorePackage.eNS_URI }),
				true, false));
		uml2jmva.addModel(uml2jmva.loadEmptyModel("Trace",
				Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(traceMetamodelFilePath)) }),
				out_traceModelAbsFilePath));
		uml2jmva.addModel(uml2jmva.loadEmptyModel("jmtmodel",
				Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(jmtMetamodelFilePath)) }),
				out_jmtModelAbsFilePath));

		uml2jmva.run();

		JmvaFileGenerator jmvaFileGen = new JmvaFileGenerator(jmvaAbsFilePath);
		jmvaFileGen.generate(out_jmtModelAbsFilePath);

		JmvaExecutor.run(jmvaAbsFilePath);

		JmtModelGenerator jmtModelGen = new JmtModelGenerator();
		jmtModelGen.generate(jmvaAbsFilePath, out_jmtModelAbsFilePath);

		/** INKOVING BWD TRANSFORMATION **/

		ModelTransformation jmva2uml = new ModelTransformation(jmt2umlEtlTransformation);
		RegisterMetamodel.packageRegistering(Arrays.asList(new String[] { traceMetamodelFilePath }));

		jmva2uml.addModel(uml2jmva.createEmfModel("UML", in_umlModelAbsFilePath,
				Arrays.asList(new String[] { UMLPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTEPackage.eNS_URI,
						StandardPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eNS_URI,
						EcorePackage.eNS_URI }),
				true, true));

		jmva2uml.addModel(uml2jmva.loadEmptyModel("UMLPerf",
				Arrays.asList(new String[] { UMLPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTEPackage.eNS_URI,
						StandardPackage.eNS_URI, org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eNS_URI,
						EcorePackage.eNS_URI }),
				out_umlModelAbsFilePath));

		jmva2uml.addModel(uml2jmva.createEmfModel("Trace", out_traceModelAbsFilePath,
				Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(traceMetamodelFilePath)) }), true,
				false));

		jmva2uml.addModel(uml2jmva.createEmfModel("jmtmodel", out_jmtModelAbsFilePath,
				Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(jmtMetamodelFilePath)) }), true,
				false));

		jmva2uml.run();

		UMLModelConformer mc = new UMLModelConformer(UMLModelConformer.OVERWRITE_MODE);
		mc.conform(out_umlModelAbsFilePath);
	}

	private String getFilePath(String path) {
		Bundle bundle = getBundle();
		URL fileURL = bundle.getResource(path);
		String finalPath = "";
		try {
			finalPath = FileLocator.resolve(fileURL).getFile();
			return java.nio.file.Paths.get(finalPath).normalize().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalPath;
	}

	private Bundle getBundle() {
		return Platform.getBundle("it.univaq.disim.sealab.padre.performanceanalysis");
		// return FrameworkUtil.getBundle(getClass());
	}

	private IProgressMonitor getMonitor() {
		return null;
	}

	private void create(final IResource resource) throws CoreException {
		if (resource == null || resource.exists())
			return;
		if (!resource.getParent().exists())
			create(resource.getParent());
		switch (resource.getType()) {
		case IResource.FILE:
			((IFile) resource).create(new ByteArrayInputStream(new byte[0]), true, getMonitor());
			break;
		case IResource.FOLDER:
			((IFolder) resource).create(IResource.NONE, true, getMonitor());
			break;
		case IResource.PROJECT:
			((IProject) resource).create(getMonitor());
			((IProject) resource).open(getMonitor());
			break;
		}
	}
}
