package actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.jface.action.Action;

import view.PadreEVLValidationView;

// This class was called PadrePerformFixAction in the previous version
public class ApplyFix extends Action {
	private SimpleDateFormat sdf1;
    private Date date;
    private Timestamp timestamp;
    
	private FixInstance fixInstance;	
	private EmfModel model;
	private IEvlModule module;
	
    public ApplyFix(IEvlModule module, FixInstance fixInstance) {
		// Sets the graphical interface showing the refactoring actions
		loadTab(fixInstance);
		
    	this.sdf1 = new SimpleDateFormat("MMddHHmmss");
		this.date = new Date();
		this.module = module;

		// code to load models from Padre Configuration Evl;
		List<IModel> models = module.getContext()
				.getModelRepository()
				.getModels();

		if(models.size() != 1 | models == null)
			throw new IllegalStateException(
					"Padre Configuration should include a single UmlModel");
		
		this.model = (EmfModel) models.get(0);;
		
		/*if(!(this.model instanceof UmlModel))
			throw new IllegalArgumentException(
					"A UmlModel should be specified in the Padre Configuration. " +
					"The current model has class " + this.model.getClass());*/
	}
			
	public void loadTab(FixInstance fixInstance) {
		this.fixInstance = fixInstance;
		this.setImageDescriptor(EvlPlugin.getDefault().getImageDescriptor("icons/fix.gif"));

		try {
			this.setText(fixInstance.getTitle());
		} catch (EolRuntimeException e) {
			module.getContext().getErrorStream().println(e.toString());
			this.setText("An exception occured while evaluating the title of the fix");
		}
	}
	
	private Path getModelAbsolutePath(EmfModel model) {
		// Gets absolute path of the model
		URI modelFileUri = model.getModelFileUri();
		URI resolvedUri = CommonPlugin.resolve(modelFileUri);
		String absolutePath = resolvedUri.path();
		
		return Paths.get(absolutePath);
	}
	
	private Path createOutputDirectory(EmfModel model) {
		// Gets the current time. Needed to create a unique directory
		this.timestamp = new Timestamp(date.getTime());
		Path modelPath = this.getModelAbsolutePath(model);
		// Creates the directory containing the results
		Path newDir = Paths.get(modelPath.getParent() + "/refactoring_" + sdf1.format(timestamp));
		try {
			/*
			 *  This check seems redundant. The name of the output directory 
			 *  ensures it's unicity
			 */
			if(!Files.exists(newDir))
				Files.createDirectory(newDir);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return newDir;
	}

	public void run() {
		Transformation uml2lqn = new Transformation();
		// Returns the absolute path of a directory
		Path outputDir = this.createOutputDirectory(model);
		Path modelPath  = this.getModelAbsolutePath(model);
		// the refactored model will be copied into the output directory
		Path currentModelPath = Paths.get(outputDir + "/" + modelPath.getFileName());
		URI currentModelUri = URI.createFileURI(currentModelPath.toString());
		// Applies a refactoring action
		try {
			this.fixInstance.perform();
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		}		
		// Sets the uri of the new file
		this.model.getResource().setURI(currentModelUri);
		this.model.setModelFileUri(currentModelUri);
		try {
			// Saves the model in the output directory
			this.model.getResource().save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		uml2lqn.run(this.model, outputDir);
		// Updates the GUI with the new refactored model
		PadreEVLValidationView.instance.updateView();
	}
}

