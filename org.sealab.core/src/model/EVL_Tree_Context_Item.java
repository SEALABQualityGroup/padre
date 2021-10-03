package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It represents the <code>context</code> in the <code>.evl</code> file
 *
 * @author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_Context_Item {
	
	private String name;
	
	/**
	 * the list of Invariant contained in the context
	 * 
	 */
	private List<EVL_Tree_Container> containers;

	/**
	 * Constructor of the class. It initialize the <code>invariantList</code> with
	 * the parameter, and set the name of the Context
	 * 
	 * @param name
	 *            Context name
	 * @param c
	 *            List of Invariant
	 * 
	 */
	public EVL_Tree_Context_Item(String name, List<EVL_Tree_Container> c) {
		super();
		this.name = name;
		this.containers = c;

	}

	public EVL_Tree_Context_Item(String contextName) {
		this.name = contextName;
		this.containers = new ArrayList<EVL_Tree_Container>();

	}

	public EVL_Tree_Context_Item() {
		this.containers = new ArrayList<EVL_Tree_Container>();
	}

	/**
	 * returns the context name
	 * 
	 * @return contextName
	 */
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns the invariant list
	 * 
	 * @return invariantList
	 */
	@XmlElementWrapper
	@XmlElement(name = "container")
	public List<EVL_Tree_Container> getContainers() {
		if (this.containers == null)
			return null;
		return this.containers;
	}

	public void setContainer(List<EVL_Tree_Container> c) {
		this.containers = c;

	}

	public String toString() {
		String res = "";
		res += "context " + this.getName() + "{\n";
		for (EVL_Tree_Container c : this.getContainers()) {
			if (containers != null) {
				res += "\t" + c.toString() + "\n";
			}
		}

		res += "}\n";
		return res;
	}
}
