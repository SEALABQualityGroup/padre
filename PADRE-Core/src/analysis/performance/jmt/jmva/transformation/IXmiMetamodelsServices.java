package analysis.performance.jmt.jmva.transformation;

import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import org.eclipse.epsilon.emc.emf.EmfModel;

public interface IXmiMetamodelsServices {
	
	/**
	 * 
	 * returns either true whether the model is conformed to his metamodels or false otherwise
	 * 
	 * @param model it is an EmfModel
	 * @return true whether the model is conformed to his metamodels  
	 */
	public boolean isValid(EmfModel model);
	
	/**
	 * 
	 * @return
	 */
	public List<String> getMetamodelsURIs();
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	public List<URI> getMetamodelFileUris(EmfModel model);
	
	/**
	 * 
	 * @param metamodelPath
	 * @throws URISyntaxException
	 */
	public void registerMetamodel(String metamodelPath) throws URISyntaxException;

}


