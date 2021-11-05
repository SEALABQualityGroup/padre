package uml2lqn;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class PathProvider {
	private Bundle bundle; 
	/*
	 * This class finds and creates a file object for the resources of this bundle.
	 * It is necessary to use the classes provided by the org.osgi.framework plugin
	 * since this class is supposed to be executed within OSGi. Indeed, OSGi uses 
	 * the boundleresource: protocol to identify the files. It is not possible to load
	 * files referenced with the boundleresource: protocol using vanilla Java.
	 * https://www.eclipse.org/forums/index.php/t/174048/
	 */
	public PathProvider() {
		this.bundle = FrameworkUtil.getBundle(this.getClass());
	}
	
	private String getRealPath(URL bundleresource) {
		String path = "";
		try {
			path = FileLocator.toFileURL(bundleresource).getPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public File getBackAnnotation() {
		URL url = this.bundle.getEntry("src/epsilon/backAnnotation.eol");
		String realPath = this.getRealPath(url);
		return new File(realPath);
	}
	
	public File getTransformation() {
		URL url = this.bundle.getEntry("src/epsilon/uml2lqn.etl");
		String realPath = this.getRealPath(url);
		return new File(realPath);
	}

	public File getLqnXsd() {
		URL url = this.bundle.getEntry("src/lqnxsd/lqn.xsd");
		String realPath = this.getRealPath(url);
		return new File(realPath);
	}
	
	public String getResultPath() {
		URL url = this.bundle.getEntry("result/");	
		return this.getRealPath(url);
	}
}
