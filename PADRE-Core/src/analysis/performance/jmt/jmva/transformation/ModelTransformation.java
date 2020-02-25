package analysis.performance.jmt.jmva.transformation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;

public class ModelTransformation{

	List<IModel> models = new ArrayList<IModel>();
	
	protected IModule module;

	private String transformationPath;

	private List<String> sourceMetamodels;
	private List<String> targetMetamodels;

	ETL_Domain_Transformation transformation;

	/**
	 * ePath is the ecore metamodel file path tPath is the transformation file path
	 * sModel is the source model file path tModel is the target model file path
	 * 
	 * @param ePath
	 * @param tPath
	 */
	public ModelTransformation(String tPath) {

		this.transformationPath = tPath;
		this.sourceMetamodels = new ArrayList<String>();
		this.targetMetamodels = new ArrayList<String>();
	}

	public void addSourceMetamodel(String metamodelFilePath) {
		this.sourceMetamodels.add(metamodelFilePath);
	}

	public void addAllSourceMetamodels(List<String> metamodelFilePaths) {
		this.sourceMetamodels.addAll(metamodelFilePaths);
	}

	public void addTargetMetamodel(String metamodelFilePath) {
		this.targetMetamodels.add(metamodelFilePath);
	}

	public void addAllTargetMetamodels(List<String> metamodelFilePaths) {
		this.targetMetamodels.addAll(metamodelFilePaths);
	}

	public void addModel(EmfModel m) {
		models.add(m);
	}

	/**
	 * 
	 * @param trasformazione
	 * @return IModel
	 * @throws Exception
	 */
	public void run() {

		// transformation = trans;
		// SOURCE METAMODEL
		// for(String path : transformation.getSourceMetamodels())
		// registerMetamodel(path);
		// //TARGET METAMODEL
		// for(String path : transformation.getTargetMetamodels())
		// registerMetamodel(path);

		module = new EtlModule();

		try {
			module.parse(new File(this.transformationPath));
			// to register the emf models into models repository
			for (IModel model : models) {
				// TODO there is an error here
				// IEtlContext etlContext = ((EtlModule) module).getContext();
				((EtlModule) module).getContext().getModelRepository().addModel(model);
			}

			//For loading Native tools
			((EtlModule) module).getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());

			// showPopUp();
			((EtlModule) module).execute();
			((EtlModule) module).getContext().getModelRepository().dispose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<URI> getMetamodelFileUris(EmfModel model) {
		return model.getMetamodelFileUris();
	}

	@SuppressWarnings("finally")
	public boolean isValid(EmfModel art) {
		Boolean turnback = false;
		try {
			// EcoreFactory factory = EcoreFactory.eINSTANCE;
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("model",
					new EcoreResourceFactoryImpl());
			// File temp = new File("models/"+ art.getModelFileUri() +".model");
			Resource resource = resourceSet.createResource(art.getModelFileUri());

			resource.load(null);

			EcoreUtil.resolveAll(resourceSet);
			EObject eo = resource.getContents().get(0);
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eo);
			if (diagnostic.getSeverity() != Diagnostic.ERROR)
				turnback = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return turnback;
		}
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
	
	public EmfModel createEmfModel(String name, URI model, List<String> metamodel, boolean readOnLoad,
			boolean storedOnDisposal){

		EmfModel emfModel = new EmfModel();
		emfModel.setName(name);
		emfModel.setMetamodelUris(metamodel);
		emfModel.setModelFileUri(model);
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
	
	public EmfModel loadEmptyModel(String name, List<String> metamodelPath, String outPath){

		EmfModel emfModel = new EmfModel();

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
	
	
	
}