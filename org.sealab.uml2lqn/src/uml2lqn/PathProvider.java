package uml2lqn;

import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

public class PathProvider {
	String srcPath;
	
	public PathProvider() {
		this.srcPath = this.getSrc();
	}
		
	private String getSrc() {
		URL currentDir = this.getScriptPath("");
		
		/*
		System.out.println("ciao " + currentDir.toString());
		URI uri = URI.create(currentDir.toString());
		System.out.println(uri.toString());
		
		Path srcPath = Paths.get(uri);
		*/

		// return srcPath.getParent().toAbsolutePath().toString();
		return currentDir.toString();
	}
	
	private URL getScriptPath(String resourceName) {
		return this.getClass().getResource("../" + resourceName);
	}
	
	public String getBackAnnotation() {
		return this.srcPath + "/epsilon/backAnnotation.eol";
	}
	
	public String getTransformation() {
		return this.srcPath + "/epsilon/uml2lqn.etl";
	}
	
	public String getLqnXsd() {
		return this.srcPath + "/lqnxsd/lqn.xsd";
	}
	
	public String getResult() {
		return this.srcPath + "/result/output.xml";
	}
	
	/*
	public static void main(String[] args) {
		PathProvider path = new PathProvider();
		System.out.println(path.getSrc());
	}
	*/
}
