package analysis.performance.jmt.jmva;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.osgi.framework.Bundle;

import analysis.performance.jmt.jmva.transformation.ETL_Domain_Transformation;
import analysis.performance.jmt.jmva.transformation.Uml2JmvaTransformation;
import analysis.performance.jmt.jmva.transformation.util.RegisterMetamodel;
import it.univaq.disim.sealab.padre.performance.analysis.launching.JmtModelGenerator;
import it.univaq.disim.sealab.padre.performance.analysis.launching.JmvaExecutor;
import it.univaq.disim.sealab.padre.performance.analysis.launching.JmvaFileGenerator;
import it.univaq.disim.sealab.padre.performance.analysis.launching.Launcher;
import it.univaq.disim.sealab.padre.performance.analysis.launching.UMLModelConformer;

public class UmlJmvaController {
	public static final String UML_EXTENSION = ".uml";
	public static final String JMVA_EXTENSION = ".jmva";
	public static final String DEFAULT_EXTENSION = ".xmi";

	// private static final String PROJECT_BASEPATH =
	// System.getProperty("user.dir").toString();
	public static String PROJECT_BASEPATH = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
			+ File.separator + "PADRE";// System.getProperty("user.dir").toString();
	// private static final String ETL_BASEPATH = PROJECT_BASEPATH +
	// "/resources/transformations/";
	// private static final String UML_JMT_FWD_ETL_COMPLETE_PATH = ETL_BASEPATH +
	// "UmlDeploymentDemands2Jmva.etl";
	// private static final String UML_JMT_BWD_ETL_COMPLETE_PATH = ETL_BASEPATH +
	// "Jmva2UmlDeploymentDemands.etl";
	private static final String MM_BASEPATH = PROJECT_BASEPATH + "/resources/metamodels/";
	private static final String JMT_MM_COMPLETE_PATH = MM_BASEPATH + "JMT/JMTModel.ecore";
	private static final String TRACE_MM_COMPLETE_PATH = MM_BASEPATH + "Tracing/Trace.ecore";
	private static final String ANT_BUILDS_BASEPATH = PROJECT_BASEPATH + "/resources/transformations/antlaunch/";
	private static final String UML_JMT_FWD_ANT_BUILD_COMPLETE_PATH = ANT_BUILDS_BASEPATH + "forward/fwd.xml";
	private static final String UML_JMT_BWD_ANT_BUILD_COMPLETE_PATH = ANT_BUILDS_BASEPATH + "backward/bwd.xml";
	public static final int UML_JAVA_FWD_TRANSFORMATION = 0;
	public static final int UML_JAVA_BWD_TRANSFORMATION = 1;

	private String in_umlModelFilePath;
	private String in_umlModelFileName;
	private String jmtModelPath;
	private String jmtModelName;
	private String traceModelPath;
	private String traceModelName;
	private String out_umlModelFilePath;
	private String out_umlModelFileName;

	public UmlJmvaController(String modelName) {
		// this.in_umlModelFilePath =
		// getClass().getResource("examples"+File.separator+"BGCS"+File.separator).toString();
		try {
			this.in_umlModelFilePath = new File(".").getCanonicalPath() + File.separator;
			PROJECT_BASEPATH = this.in_umlModelFilePath;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // PROJECT_BASEPATH + in_umlModelFilePath;

		// this.in_umlModelFileName -> resources/examples/BGCS/
		this.in_umlModelFileName = modelName;
		// this.jmtModelPath -> resources/examples/BGCS/performanceAnalysis/jmva
		this.jmtModelPath = this.in_umlModelFilePath + "performanceAnalysis/jmva/";
		this.jmtModelName = this.in_umlModelFileName;
		// this.traceModelPath -> resources/examples/BGCS/performanceAnalysis/traces
		this.traceModelPath = this.in_umlModelFilePath + "performanceAnalysis/traces/";
		this.traceModelName = this.in_umlModelFileName;
		// this.out_umlModelFileName -> resources/examples/BGCS/
		this.out_umlModelFilePath = this.in_umlModelFilePath;
		// BGCS-analysed
		this.out_umlModelFileName = this.in_umlModelFileName + "-analysed";
	}

	public void roundtripMVA() throws CoreException {
		// String in_umlModelAbsFilePath = this.in_umlModelFilePath +
		// this.in_umlModelFileName + UML_EXTENSION;
		// String jmtModelAbsFilePath = this.jmtModelPath + this.jmtModelName +
		// DEFAULT_EXTENSION;
		// String jmvaAbsFilePath = this.jmtModelPath + this.jmtModelName +
		// JMVA_EXTENSION;
		// String traceModelAbsFilePath = this.traceModelPath + this.traceModelName +
		// DEFAULT_EXTENSION;
		// String out_umlModelAbsFilePath = this.out_umlModelFilePath +
		// this.out_umlModelFileName + UML_EXTENSION;

		// resources/examples/BGCS/BGCS.uml
		String in_umlModelAbsFilePath = getFilePath("examples/BGCS/BGCS.uml");
		// getBundle().getResource("examples/BGCS/BGCS.uml").getPath();

		// resources/examples/BGCS/performanceAnalysis/jmva/BGCS.xmi
		String jmtModelAbsFilePath = getFilePath("examples/BGCS/performanceAnalysis/jmva/BGCS.xmi");

		String jmvaAbsFilePath = getFilePath("examples/BGCS/performanceAnalysis/jmva/BGCS.jmva");

		String traceModelAbsFilePath = getFilePath(
				getBundle().getResource("examples/BGCS/performanceAnalysis/traces/").getPath()).concat("BGCS.xmi");

		String out_umlModelAbsFilePath = getFilePath(getBundle().getResource("examples/BGCS/").getPath())
				.concat("BGCS-analysed.uml");

		String out_traceModelAbsFilePath = getFilePath(getBundle().getResource("metamodels/Tracing/").getPath())
				.concat("Trace.xml");

		String out_jmtModelAbsFilePath = getFilePath(
				getBundle().getResource("examples/BGCS/performanceAnalysis/jmva").getPath()).concat("BGCS-JMVA.xmi");

		String jmtMetamodelFilePath = getFilePath("metamodels/JMT/JMTModel.ecore");
		String traceMetamodelFilePath = getFilePath("metamodels/Tracing/Trace.ecore");
		// String uml2jmtFwdAntBuild =
		// getFilePath("transformations/antlaunch/forward/fwd.xml");

		String uml2jmtEtlTransformation = getFilePath("transformations/UmlDeploymentDemands2Jmva.etl");

		// this.out_umlModelFilePath + this.out_umlModelFileName + UML_EXTENSION;

		// Launcher fwdLauncher = new Launcher(in_umlModelAbsFilePath,
		// jmtMetamodelFilePath, jmtModelAbsFilePath,
		// traceMetamodelFilePath, traceModelAbsFilePath, uml2jmtFwdAntBuild);
		// fwdLauncher.runAntScript();

		// ETL TRANSFORMATION BY JAVA CODE

		// ETL_Domain_Transformation uml2jmva = new
		// ETL_Domain_Transformation(traceMetamodelFilePath);

		Uml2JmvaTransformation uml2jmva = new Uml2JmvaTransformation(traceMetamodelFilePath, uml2jmtEtlTransformation,
				in_umlModelAbsFilePath, out_umlModelAbsFilePath);

		RegisterMetamodel.packageRegistering(Arrays.asList(new String[] { traceMetamodelFilePath }));

		EmfModel sourceModel = null;
		try {
			sourceModel = uml2jmva.createEmfModel("UML", in_umlModelAbsFilePath,
					Arrays.asList(new URI[] { URI.createURI("http://www.eclipse.org/uml2/5.0.0/UML"),
							URI.createURI("http://www.eclipse.org/papyrus/MARTE/1"),
							URI.createURI("http://www.eclipse.org/uml2/5.0.0/UML/Profile/Standard"),
							URI.createURI("http://www.eclipse.org/emf/2002/Ecore") }),
					true, false);
		} catch (EolModelLoadingException | EolModelElementTypeNotFoundException | URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		uml2jmva.addModel(sourceModel);

		// TODO error at resouce.getResources().get(0) TO BE CHECKED
		EmfModel traceModel = null;
		try {
			traceModel = uml2jmva.loadEmptyModel("Trace",
					Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(traceMetamodelFilePath)) }),
					out_traceModelAbsFilePath);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		uml2jmva.addModel(traceModel);

		EmfModel jmtModel = null;
		try {
			jmtModel = uml2jmva.loadEmptyModel("jmtmodel",
					Arrays.asList(new String[] { RegisterMetamodel.getNsURI(new File(jmtMetamodelFilePath)) }),
					out_jmtModelAbsFilePath);
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		uml2jmva.addModel(jmtModel);

		try {
			uml2jmva.run(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// // model in
		// uml2jmva.setSourceName("BGCS");
		// uml2jmva.setMetamodel_in("metamodels/Tree.ecore");
		// uml2jmva.setModel_in("models/tree.model");
		//
		// // model out
		// uml2jmva.setTargetName("Target");
		// uml2jmva.setMetamodel_out("metamodels/Graph.ecore");
		// uml2jmva.setTargetPath("resources/models/outcome/outcome.model");

		// transformation
		// uml2jmva.setTransformation("transformations/Tree2Graph.etl");

		// END $$$$ ETL TRANSFORMATION BY JAVA CODE $$$$$

		// Launcher fwdLauncher = new Launcher(in_umlModelAbsFilePath,
		// jmtModelAbsFilePath, traceModelAbsFilePath);
		// fwdLauncher.runAntScript(0);
		JmvaFileGenerator jmvaFileGen = new JmvaFileGenerator();
		jmvaFileGen.generate(jmtModelAbsFilePath);

		// JmvaExecutor.run(jmvaAbsFilePath);
		JmvaExecutor.run(jmvaAbsFilePath.substring(0, jmvaAbsFilePath.length() - 5) + "-JMVA-working.jmva");

		JmtModelGenerator jmtModelGen = new JmtModelGenerator();
		// jmtModelGen.generate(jmvaAbsFilePath);
		jmtModelGen.generate(jmvaAbsFilePath.substring(0, jmvaAbsFilePath.length() - 5) + "-JMVA-working.jmva");

		// Launcher bwdLauncher = new Launcher(in_umlModelAbsFilePath,
		// JMT_MM_COMPLETE_PATH, jmtModelAbsFilePath, TRACE_MM_COMPLETE_PATH,
		// traceModelAbsFilePath, UML_JMT_BWD_ANT_BUILD_COMPLETE_PATH);
		Launcher bwdLauncher = new Launcher(in_umlModelAbsFilePath, JMT_MM_COMPLETE_PATH,
				jmtModelAbsFilePath.substring(0, jmtModelAbsFilePath.length() - 4) + "-JMVA-working.xmi",
				TRACE_MM_COMPLETE_PATH, traceModelAbsFilePath, out_umlModelAbsFilePath,
				UML_JMT_BWD_ANT_BUILD_COMPLETE_PATH);
		bwdLauncher.runAntScript();
		// //Launcher bwdLauncher = new Launcher(in_umlModelAbsFilePath,
		// jmtModelAbsFilePath, traceModelAbsFilePath, out_umlModelAbsFilePath);
		// Launcher bwdLauncher = new Launcher(in_umlModelAbsFilePath,
		// jmtModelAbsFilePath.substring(0, jmtModelAbsFilePath.length() - 4) +
		// "-JMVA-working.xmi", traceModelAbsFilePath, out_umlModelAbsFilePath);
		// bwdLauncher.runAntScript(1);

		UMLModelConformer mc = new UMLModelConformer(UMLModelConformer.OVERWRITE_MODE);
		mc.conform(out_umlModelAbsFilePath);
	}

	private String getFilePath(String path) {
		Bundle bundle = getBundle();
		URL fileURL = bundle.getResource(path);
		String finalPath = "";
		try {
			finalPath = FileLocator.resolve(fileURL).getFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalPath;
	}

	private Bundle getBundle() {
		return Platform.getBundle("it.spe.disim.univaq.it.plugin.performanceanalysis");
	}

}
