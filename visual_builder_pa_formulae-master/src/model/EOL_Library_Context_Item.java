package model;

import java.util.ArrayList;
import java.util.List;

/**
 * It represents a context item of the tree of EOL library
 *
 * @author Stefano Di Francesco
 */
public class EOL_Library_Context_Item {

	private String name;

	private List<EOL_Library_F_Operation> list_of_functions;
	private List<EOL_Library_DO_Operation> list_of_refactorings;

	public EOL_Library_Context_Item() {
		this.list_of_functions = new ArrayList<EOL_Library_F_Operation>();
		this.list_of_refactorings = new ArrayList<EOL_Library_DO_Operation>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EOL_Library_F_Operation> geteffe() {
		if (this.list_of_functions == null)
			return null;
		return this.list_of_functions;
	}

	public void seteffe(List<EOL_Library_F_Operation> c) {
		this.list_of_functions = c;

	}

	public List<EOL_Library_DO_Operation> getdu() {
		if (this.list_of_refactorings == null)
			return null;
		return this.list_of_refactorings;
	}

	public void setdu(List<EOL_Library_DO_Operation> nuovodu) {
		this.list_of_refactorings = nuovodu;

	}
}
