package analysis.performance.jmt.jmva.transformation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.tools.ProfilerTool;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.execute.context.IEtlContext;

public class Uml2JmvaTransformation extends ETL_Transformation{


	List<IModel> models = new ArrayList<IModel>();
	
	private String ecorePath, transformationPath;
	
	private List<String> sourceMetamodels;
	private List<String> targetMetamodels;
	
	private String sourceModel, targetModel;
	
	ETL_Domain_Transformation transformation;
	
	/**
	 * ePath is the ecore metamodel file path
	 * tPath is the transformation file path
	 * sModel is the source model file path
	 * tModel is the target model file path
	 * 
	 * @param ePath
	 * @param tPath
	 */
	public Uml2JmvaTransformation(String ePath, String tPath, String sModel, String tModel) {
		this.ecorePath = ePath;
		this.transformationPath = tPath;
		this.sourceModel = sModel;
		this.targetModel = tModel;
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
	@Override
	public void run(ETL_Domain_Transformation trans) throws Exception {

//		transformation = trans;
		//SOURCE METAMODEL
//		for(String path : transformation.getSourceMetamodels())
//			registerMetamodel(path);
//		//TARGET METAMODEL
//		for(String path : transformation.getTargetMetamodels())
//			registerMetamodel(path);

		module = new EtlModule();
		
		module.parse(new File(this.transformationPath));

		//SOURCE MODEL
//		models.add(createEmfModel("BGCS",
//				sourceModel, sourceMetamodels,
//				true, false));

		//TARGET MODEL
//		models.add(loadEmptyModel("JMT Model",
//				targetMetamodels, targetModel));

		// to register the emf models into models repository
		for (IModel model : models) {
			// TODO there is an error here
//			IEtlContext etlContext = ((EtlModule) module).getContext();
			((EtlModule) module).getContext().getModelRepository().addModel(model);
		}

		//showPopUp();
/**		Internal error: java.lang.NullPointerException
 * 		at org.eclipse.epsilon.emc.emf.AbstractEmfModel.getPackageRegistry[AbstractEmfModel.java:118]
 */
		((EtlModule) module).execute();
		((EtlModule) module).getContext().getModelRepository().dispose();
	}

	// private URI getResourceEmfURI(String resourcePath) {
	// URI stringURI = URI.createURI(getClass()
	// .getResource("/" + resourcePath).toExternalForm());
	// return stringURI;
	// }

	@Override
	public List<URI> getMetamodelFileUris(EmfModel model) {
		return model.getMetamodelFileUris();
	}
	
	// TODO
	@SuppressWarnings("finally")
	@Override
	public boolean isValid(EmfModel art) {
		Boolean turnback = false;
		try {
			//EcoreFactory factory = EcoreFactory.eINSTANCE;
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put("model", new EcoreResourceFactoryImpl());
			// File temp = new File("models/"+ art.getModelFileUri() +".model");
			Resource resource = resourceSet.createResource(art
					.getModelFileUri());

			resource.load(null);
			
			EcoreUtil.resolveAll(resourceSet);
			EObject eo = resource.getContents().get(0);
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eo);
			if (diagnostic.getSeverity() != Diagnostic.ERROR)
				turnback = true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			return turnback;
		}
	}

	@Override
	public List<String> getMetamodelsURIs() {
		// TODO Auto-generated method stub
		return null;
	}
}