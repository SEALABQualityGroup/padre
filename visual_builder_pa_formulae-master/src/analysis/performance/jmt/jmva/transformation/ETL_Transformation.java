package analysis.performance.jmt.jmva.transformation;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfMetaModel;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.dt.userinput.JFaceUserInput;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.eol.tools.EolSystem;
import org.eclipse.epsilon.etl.EtlModule;

public abstract class ETL_Transformation implements IXmiMetamodelsServices {

	protected List<IModel> models;
	protected IModule module;
	private ResourceSet resourceSet;

	/**
	 * 
	 * @param transformation
	 * @throws Exception
	 */
	public abstract void run(ETL_Domain_Transformation transformation) throws Exception;

	/**
	 * 
	 * From given input param, it creates a new emf model {@link EmfModel} which
	 * should have a real filesystem
	 * 
	 * @param name
	 * @param model
	 * @param metamodel
	 * @param readOnLoad
	 * @param storeOnDisposal
	 * @return the emf model from specified url
	 * @throws EolModelLoadingException
	 * @throws URISyntaxException
	 * @throws EolModelElementTypeNotFoundException
	 * @see EmfModel
	 */
	public EmfModel createEmfModel(String name, String model, String metamodel, boolean readOnLoad,
			boolean storeOnDisposal){

		EmfModel emfModel = new EmfModel();

		StringProperties properties = new StringProperties();

		properties.put(EmfModel.PROPERTY_NAME, name);

		try {
			properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, getFile(metamodel).toURI().toString());
			properties.put(EmfModel.PROPERTY_MODEL_URI, getFile(model).toURI().toString());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad + "");

		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, storeOnDisposal + "");

		try {
			emfModel.load(properties, (IRelativePathResolver) null);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emfModel;
	}

	public EmfModel createEmfModel(String name, String model, List<String> metamodel, boolean readOnLoad,
			boolean storedOnDisposal){

		EmfModel emfModel = new EmfModel();
		emfModel.setName(name);
		emfModel.setMetamodelUris(metamodel);
		emfModel.setModelFile(model);
		emfModel.setReadOnLoad(readOnLoad);
		emfModel.setStoredOnDisposal(storedOnDisposal);
		try {
			emfModel.loadModelFromUri();
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emfModel;
	}

	/**
	 * 
	 * From given input param, it creates a new instance of EmfModel which might
	 * have a real file in the filesystem
	 * 
	 * @param name
	 * @param metamodelPath
	 * @param outPath
	 * @return the emf model which might not link to a real filesystem
	 * @throws EolModelLoadingException
	 */
	public EmfModel loadEmptyModel(String name, String metamodelPath, String outPath)
			throws EolModelLoadingException {

		EmfModel model = new EmfModel();
		model.setName(name);
		model.setMetamodelFileUri(getResourceEmfURI(metamodelPath));
		model.setModelFileUri(URI.createFileURI(outPath));
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(true);
		model.load();

		return model;
	}

	/**
	 * 
	 * @param name
	 * @param metamodelPath
	 * @param outPath
	 * @return
	 * @throws URISyntaxException
	 */
	public EmfModel loadEmptyModel(String name, List<String> metamodelPath, String outPath){

		EmfModel emfModel = new EmfModel();

		// StringProperties properties = new StringProperties();
		// properties.put(EmfModel.PROPERTY_NAME, name);
		// properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,getFile(path).toURI().toString());
		// properties.put(EmfModel.PROPERTY_MODEL_URI, URI.createFileURI(new
		// File(outPath).getAbsolutePath()));
		// properties.put(EmfModel.PROPERTY_READONLOAD, false + "");
		// properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, true + "");
		// emfModel.load(properties, (IRelativePathResolver) null);

//		ArrayList<URI> metamodelFiles = new ArrayList<URI>();
//		for (URI path : metamodelPath) {
//			metamodelFiles.add(URI.createFileURI(path));
//		}
//		emfModel.setMetamodelFileUris(metamodelPath);
		emfModel.setMetamodelUris(metamodelPath);
		emfModel.setModelFileUri(URI.createFileURI(outPath));
		emfModel.setStoredOnDisposal(true);
		emfModel.setReadOnLoad(false);
		emfModel.setName(name);

		try {
			emfModel.load();
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emfModel;
	}

	/**
	 * 
	 * From given string fileName, it returns, through the given
	 * {@link ClassLoader}, the relative file in the filesystem
	 * 
	 * 
	 * @param fileName
	 * @return the file relatives to the fileName
	 * @throws URISyntaxException
	 */
	protected File getFile(String fileName) throws URISyntaxException {
		URL url = getClass().getResource("/" + fileName);
		return new File(url.toURI());
	}

	/**
	 * 
	 * It allows to register the metamodel in the {@link Registry}. It retrieves the
	 * metamodel starting from path, using the {@link ClassLoader}
	 * 
	 * @param path
	 * @throws URISyntaxException
	 */
	@Override
	public void registerMetamodel(String path) throws URISyntaxException {
//		File fileName = new File(getClass().getResource("/" + path).toURI());
//		URI uri = URI.createFileURI(fileName.getAbsolutePath());
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//
//		ResourceSet rs = new ResourceSetImpl();
//		// enable extended metadata
//		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(rs.getPackageRegistry());
//		rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
//
//		Resource r = rs.getResource(uri, true);
//		EObject eObject = r.getContents().get(0);
//		if (eObject instanceof EPackage) {
//			EPackage p = (EPackage) eObject;
//			EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
//		}
//		packageRegistering(path);
	}
	
	public ResourceSet getResourceSet() {
		if (resourceSet == null)
			resourceSet = new ResourceSetImpl();
		return resourceSet;
	}
	
	/**
	 * 
	 * @return the list of models which are contained in models
	 */
	protected List<IModel> getModels() {
		return models;
	}

	/**
	 * 
	 * It allows to add a model in the list of model
	 * 
	 * @param model
	 */
	protected void addModel(IModel model) {
		models.add(model);
	}

	/**
	 * 
	 * @param path
	 * @return the string of the full path
	 */
	protected String getFullPath(String path) {
		return FileUtil.getFile(path, this.getClass()).getAbsolutePath();
	}

	/**
	 * 
	 * From the string path of resource it returns the URI. It uses the
	 * {@link ClassLoader} to find the file in the file-system
	 * 
	 * @param resourcePath
	 * @return URI of the resource
	 */
	protected URI getResourceEmfURI(String resourcePath) {
		String uri = getClass().getResource("/" + resourcePath).toExternalForm();
		return URI.createURI(uri);
	}

	/**
	 * 
	 * @param name
	 * @param metamodelURI
	 * @return
	 */
	protected EmfMetaModel createEmfMetaModel(String name, String metamodelURI) {
		EmfMetaModel metamodel = new EmfMetaModel();

		metamodel.addMetamodelUri(metamodelURI);
		metamodel.setName(name);

		return metamodel;
	}

	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws URISyntaxException
	 */
	protected File getSource(String filePath) throws URISyntaxException {
		return new File(getClass().getResource("/" + filePath).toURI());
	}

	/**
	 * 
	 */
	protected void showPopUp() {
		EolSystem system = new EolSystem();
		system.setContext(((EtlModule) module).getContext());
		((EtlModule) module).getContext().getFrameStack().put(Variable.createReadOnlyVariable("System", system));
		((EtlModule) module).getContext().setUserInput(new JFaceUserInput(new PrettyPrinterManager()));
	}

	@Override
	public boolean isValid(EmfModel model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getMetamodelsURIs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<URI> getMetamodelFileUris(EmfModel model) {
		// TODO Auto-generated method stub
		return null;
	}
}
