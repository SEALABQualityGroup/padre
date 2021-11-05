package actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;

import transformation.PadreModelFactory;
import transformation.TransformationAgent;
import uml2lqn.PathProvider;

public class Transformation{
	private PadreModelFactory factory;
	private PathProvider paths;

	private File transformation;
	private File lqnXsd;
	private File backAnnotation;
	

 
	public Transformation() {
		super();
		/*
		 * PathProvider loads all the resources to execute the UML2LQN.
		 * The org.sealab.uml2lqn plugin is needed. 
		 */
		this.paths = new PathProvider();
		this.factory = new PadreModelFactory();
		
		this.transformation = this.paths.getTransformation();
		this.lqnXsd = this.paths.getLqnXsd();
		this.backAnnotation = this.paths.getBackAnnotation();
	}
	
	public void run(EmfModel model, Path outputDir) {
		// Set output resources
		String resultPath = outputDir + "/output.xml";
		String lqxo = outputDir + "/output.lqxo";

		//Creates the file containing the LQN
		File result = new File(resultPath);
		URI resultUri = URI.createFileURI(resultPath);
		try {
			result.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Creates the LQN model
		EmfModel lqn = factory.createEmfModel("LQN", resultUri, true);
		factory.loadXSD(lqn, lqnXsd.getPath());
		// Executes the UML2LQN ETL script
		TransformationAgent.run(transformation, Arrays.asList(model, lqn));
		// Output Formatting
		try {
			String xml = Files.readString(result.toPath());
			xml = xml.replaceAll("entryPhaseActivities", "entry-phase-activities")
					.replaceAll("hostDemandMean", "host-demand-mean")
					.replaceAll("callsMean", "calls-mean")
					.replaceAll("LqnCore:LqnModelType", "lqn-model")
					.replaceAll("synchCall", "synch-call")
					.replaceAll("(?m)^\s+<LqnCore:Activity.*", "")
					.replaceAll("(?m)^</?xmi:XMI.*", "");
			FileUtils.writeStringToFile(result, xml, "UTF-8");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// Calls the solver 
		ProcessBuilder builder = new ProcessBuilder("lqns", "-P", "cycles=yes", resultPath);
		// Sets the same I/O of the parent process
		builder.inheritIO();
		try {
			Process solver = builder.start();
			solver.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Solver Executed!!");

		PlainXmlModel lqxoModel = factory.createXmlModel("LQXO", new File(lqxo), true);
		factory.loadModel(lqxoModel);
		factory.loadUml(model);

		TransformationAgent.run(backAnnotation, Arrays.asList(model, lqxoModel));
		System.out.println("The performance estimation has been reported to the UML model!");
	}
}
