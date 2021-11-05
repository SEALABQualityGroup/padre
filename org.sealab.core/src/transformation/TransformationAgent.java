package transformation;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.etl.EtlModule;

public class TransformationAgent{
	public static void run(File scriptFile, List<Model> models) {
		String extension = FilenameUtils.getExtension(scriptFile.getPath());
		EolModule module = new EolModule();

		extension = extension.toLowerCase();
		extension = extension.trim();
		
		switch(extension) {
			case "etl":
				module = (EtlModule) new EtlModule();
				break;
			case "eol":
				break;
			default:
				throw new Error("Unknown file extension");
		}

		try {
			module.parse(scriptFile);
		} catch (Exception eParse) {
			eParse.printStackTrace();
		}
		
		module.getContext().getModelRepository().addModels(models);
		
		try {
			module.execute();

			ModelRepository repo = module.getContext().getModelRepository();
			for(IModel model : repo.getModels())
				model.store();
			
		} catch (EolRuntimeException eExecute) {
			eExecute.printStackTrace();
		}
	}
}