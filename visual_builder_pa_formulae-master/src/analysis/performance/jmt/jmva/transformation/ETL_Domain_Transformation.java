package analysis.performance.jmt.jmva.transformation;

import java.util.ArrayList;
import java.util.List;


public class ETL_Domain_Transformation {

	protected int id;
	protected String modules;
	protected String model_in;
	protected List<String> metamodel_in = new ArrayList<String>();
	protected List<String> metamodel_out = new ArrayList<String>();

	protected String sourceName;
	protected String targetName;
	protected String targetPath;

	protected String transformation;

	/* GETTERS */
	public int getId() {
		return id;
	}

	public String getModules() {
		return modules;
	}

	public String getModel_in() {
		return model_in;
	}

	public List<String> getSourceMetamodels() {
		return metamodel_in;
	}

	public List<String> getTargetMetamodels() {
		return metamodel_out;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getTargetName() {
		return targetName;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public String getTransformation() {
		return transformation;
	}

	/* SETTERS */

	public void setModules(String modules) {
		this.modules = modules;
	}

	public void setModel_in(String model_in) {
		this.model_in = model_in;
	}

	public void setMetamodel_in(String metamodel_in) {
		this.metamodel_in.add(metamodel_in);
	}

	public void setMetamodel_out(String metamodel_out) {
		this.metamodel_out.add(metamodel_out);
	}

	public void setSourceName(String inTag) {
		this.sourceName = inTag;
	}

	public void setTargetName(String outTag) {
		this.targetName = outTag;
	}

	public void setTargetPath(String outPath) {
		this.targetPath = outPath;
	}

	public void setTransformation(String transformation) {
		this.transformation = transformation;
	}

}
