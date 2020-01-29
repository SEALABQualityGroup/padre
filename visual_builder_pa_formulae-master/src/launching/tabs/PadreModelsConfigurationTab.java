package launching.tabs;

import java.util.List;

import org.eclipse.epsilon.common.dt.launching.tabs.ModelsConfigurationTab;

public class PadreModelsConfigurationTab extends ModelsConfigurationTab {

	
	public String getName() {
		return "Padre Models";
	}
	
	public List<String> getModels() {
		return models;
	}
}
