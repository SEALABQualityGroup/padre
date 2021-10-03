package model;

import java.util.List;

/**
 * It represents the data structure root for the EOL library
 * 
 * @author Stefano Di Francesco
 */
public class EOL_Library_Root {
	/**
	 * the list of Invariant contained in the context
	 * 
	 */
	private String name;
	private String path;

	private List<EOL_Library_Context_Item> cs;
	private List<EOL_Library_Th_Operation> ths;

	/**
	 * Constructor of the class. It initialize the <code>invariantList</code> with
	 * the parameter, and set the name of the Context
	 * 
	 * @param cs
	 *            List of <code>EOL_Library_Context_Item</code>
	 * @param ths
	 *            List of <code>EOL_Library_Th_Operation</code>
	 * @param libraryName
	 *            It is the name of the root directory of the library
	 * 
	 */
	public EOL_Library_Root(List<EOL_Library_Context_Item> cs, List<EOL_Library_Th_Operation> ths, String libraryName) {
		this.cs = cs;
		this.ths = ths;
		this.setName(libraryName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<EOL_Library_Context_Item> getListContexts() {
		if (this.cs == null)
			return null;
		return this.cs;
	}

	public void setListContexts(List<EOL_Library_Context_Item> cs) {
		this.cs = cs;

	}

	public List<EOL_Library_Th_Operation> getths() {
		if (this.ths == null)
			return null;
		return this.ths;
	}

	public void setths(List<EOL_Library_Th_Operation> ths) {
		this.ths = ths;

	}

}