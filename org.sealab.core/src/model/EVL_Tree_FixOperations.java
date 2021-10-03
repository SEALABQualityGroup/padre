package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the list of <code>Do</code>
 * 
 * @author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_FixOperations {

	private String context;
	private List<String> functions;

	public EVL_Tree_FixOperations(String context) {
		this.context = context;
		functions = new ArrayList<String>();

	}

	public EVL_Tree_FixOperations() {
	}

	public String getContext() {
		return context;
	}

	@XmlElementWrapper
	@XmlElement
	public List<String> getFunctions() {
		return functions;
	}

	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}

	public String toString() {
		String res = "";
		for (String s : this.getFunctions()) {
			res += "\t\t\t\t\tself." + s + "();\n";
		}
		return res;
	}

}
