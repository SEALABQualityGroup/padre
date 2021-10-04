package transformation;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.epsilon.etl.EtlModule;

public class TransformationAgent{

	// Factory to generate different kind of module
	public static EolModule createModule(String type) {
		String lowerCaseType = type.toLowerCase();
		
		switch(lowerCaseType) {
			case "etl":
				return new EtlModule();
			case "eol":
				return new EolModule();
			default:
				throw new Error("Module type not found!");
		}
	}

	public static void run(File scriptFile, List<Model> models) {
		String extension = FilenameUtils.getExtension(scriptFile.getPath());
		extension = extension.toLowerCase();
		
		EolModule module = createModule(extension);
		
		try {
			module.parse(scriptFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		module.getContext().getModelRepository().addModels(models);
		//module.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
	
		try {
			module.execute();
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		}
	
		//module.getContext().getModelRepository().dispose();
		
	}
}