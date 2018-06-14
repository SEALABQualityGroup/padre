package launching.launchers;

import java.io.File;

//import org.apache.tools.ant.DefaultLogger;
//import org.apache.tools.ant.Project;
//import org.apache.tools.ant.ProjectHelper;
//import org.eclipse.ant.core.AntCorePlugin;
//import org.eclipse.ant.core.AntRunner;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
//import org.eclipse.uml2.uml.UMLPackage;
//import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

//import launching.util.AntExecutor;

public class PadreEvlFrwdTransLauncher {

	public static void runBuild() throws CoreException {
		String dir = "/Users/davide/eclipse/eclipse-PADRE/local-workspace/PADRE-local-11032018/padre-master/visual_builder_pa_formulae-master/resources/transformations/antlaunch/forward/";
		String completePath = dir + "build.xml";
		
//		AntRunner runner = new AntRunner();
//		String antHome = "/Users/davide/eclipse/eclipse-PADRE/local-workspace/PADRE-local-11032018/padre-master/visual_builder_pa_formulae-master/lib/apache-ant-1.10.3 2/";
//		runner.setAntHome(antHome);
//		runner.setBuildFileLocation(completePath);
//		runner.addBuildLogger("org.apache.tools.ant.DefaultLogger");
//		runner.setArguments("-Dmessage=Building -verbose");
//		runner.run(new NullProgressMonitor());
//		ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
		
		ResourceSet rset = new ResourceSetImpl();
		rset.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap()
		       .put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		       .put("uml", UMLResource.Factory.INSTANCE);
		
		//maybe JMTModel.ecore and Trace.ecore must be registered
		
		File buildFile = new File(completePath);
//		Project p = new Project();
//		p.setUserProperty("ant.file", buildFile.getAbsolutePath());
//		p.init();
//		//ProjectHelper.configureProject(p, buildFile);
//		ProjectHelper helper = ProjectHelper.getProjectHelper();
//		p.addReference("ant.projectHelper", helper);
//		helper.parse(p, buildFile);
//		p.executeTarget(p.getDefaultTarget());
		
		launching.util.AntExecutor.executeAntTask(buildFile.getAbsolutePath(), "targetModels");
		
//		AntRunner antrunner = new AntRunner();
//		DefaultLogger logger = new DefaultLogger();
//        logger.setErrorPrintStream(System.err);
//        logger.setOutputPrintStream(System.err);
//        logger.setMessageOutputLevel(Project.MSG_INFO);
//		antrunner.addBuildListener(logger.getClass().getName());
//		
//		String antHome = "/Users/davide/eclipse/eclipse-PADRE/local-workspace/PADRE-local-11032018/padre-master/visual_builder_pa_formulae-master/lib/apache-ant-1.10.3 2/";
//		antrunner.setAntHome(antHome);
//		antrunner.setArguments(new String[] {"-Dmessage=Building -verbose",
//											"-logfile /Users/davide/eclipse/eclipse-PADRE/local-workspace/PADRE-local-11032018/padre-master/visual_builder_pa_formulae-master/doc/PADREantLog.log"});
//		antrunner.setBuildFileLocation(completePath);
//		//antrunner.setCustomClasspath(null);
//		//antrunner.setExecutionTargets(executionTargets);
//		//antrunner.setInputHandler(className);
//		//antrunner.setPropertyFiles(propertyFiles);
//		//IProgressMonitor monitor = (IProgressMonitor) getProject().getReferences().get(AntCorePlugin.ECLIPSE_PROGRESS_MONITOR);
////		try {
////			System.out.println("--->" + antrunner.getAvailableTargets());
////		} catch (CoreException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
//		antrunner.run(new NullProgressMonitor());
	}
	
	/**
     * Main method to test code
     * 
     * @param args
     */
//    public static void main(String[] args) {
//    		String dir = "/Users/davide/eclipse/eclipse-PADRE/local-workspace/PADRE-local-11032018/padre-master/visual_builder_pa_formulae-master/resources/transformations/antlaunch/forward/";
//		String completePath = dir + "build.xml";
//        // Running default target of ant script
//        //AntExecutor.executeAntTask(completePath);
//        System.out.println("-----------------------------");
//        // Running specified target of ant script
//        //AntExecutor.executeAntTask(completePath, "loadModels");
//        //AntExecutor.executeAntTask(completePath, "targetModels");
//        try {
//			runBuild();
//        } catch (CoreException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }

}
