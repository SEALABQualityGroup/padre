package launching.util;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
 
/**
 * @author srccodes.com
 * @version 1.0
 */
public class AntExecutor {
    /**
     * To execute the default target specified in the Ant build.xml file
     * 
     * @param buildXmlFileFullPath
     */
    public static void executeAntTask(String buildXmlFileFullPath) {
        executeAntTask(buildXmlFileFullPath, null);
    }
     
    /**
     * To execute a target specified in the Ant build.xml file
     * 
     * @param buildXmlFileFullPath
     * @param target
     */
    public static void executeAntTask(String buildXmlFileFullPath, String target) {
        boolean success = false;
        DefaultLogger consoleLogger = getConsoleLogger();
 
        // Prepare Ant project
        Project project = new Project();
        File buildFile = new File(buildXmlFileFullPath);
        project.setUserProperty("ant.file", buildFile.getAbsolutePath());
        project.addBuildListener(consoleLogger);
 
        // Capture event for Ant script build start / stop / failure
        try {
            project.fireBuildStarted();
            project.init();
            ProjectHelper projectHelper = ProjectHelper.getProjectHelper();
            project.addReference("ant.projectHelper", projectHelper);
            projectHelper.parse(project, buildFile);
             
            // If no target specified then default target will be executed.
            String targetToExecute = (target != null && target.trim().length() > 0) ? target.trim() : project.getDefaultTarget();
            project.executeTarget(targetToExecute);
            project.fireBuildFinished(null);
            success = true;
        } catch (BuildException buildException) {
            project.fireBuildFinished(buildException);
            throw new RuntimeException("!!! Unable to restart the IEHS App !!!", buildException);
        }
        
//        File file = new File(buildXmlFileFullPath);
//        Project project = new Project();
//        project.init();
//        		
//        DefaultLogger logger = new DefaultLogger();
//        logger.setErrorPrintStream(System.err);
//        logger.setOutputPrintStream(System.err);
//        logger.setMessageOutputLevel(Project.MSG_INFO);
//        		
//        project.setProperty("ant.file", file.getAbsolutePath());
//        project.addBuildListener(logger);
//        project.fireBuildStarted();
//        		
//        ProjectHelper helper = ProjectHelper.getProjectHelper();
//        project.addReference("ant.projectHelper", helper);
//        helper.parse(project, file);
//        project.executeTarget(target);
         
        //return success;
    }
     
    /**
     * Logger to log output generated while executing ant script in console
     * 
     * @return
     */
    private static DefaultLogger getConsoleLogger() {
        DefaultLogger consoleLogger = new DefaultLogger();
        consoleLogger.setErrorPrintStream(System.err);
        consoleLogger.setOutputPrintStream(System.out);
        consoleLogger.setMessageOutputLevel(Project.MSG_INFO);
         
        return consoleLogger;
    }
 
}
