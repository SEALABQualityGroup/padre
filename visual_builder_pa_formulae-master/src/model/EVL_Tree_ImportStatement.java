package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Stefano
 *
 */
@XmlRootElement
public class EVL_Tree_ImportStatement {
	
	private String text;

	/**
	 * @return The path to the library imported
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            The path to the library to import
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Constructor
	 * 
	 * @param text
	 */
	public EVL_Tree_ImportStatement(String text) {
		this.text = text;
	}

	/**
	 * Constructor
	 */
	public EVL_Tree_ImportStatement() {
		this.text = null;
	}

	// @XmlElementWrapper
	// @XmlElement
	// public String getFunctions() {
	// return text;
	// }
	// public void setFunctions(String text) {
	// this.text = text;
	// }
	public String toString() {
		return "import " + this.text;
	}
}
