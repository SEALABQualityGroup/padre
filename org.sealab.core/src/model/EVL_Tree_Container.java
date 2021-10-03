package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * It represents the Invariant contained in the context
 *
 * @author Davide Di Gironimo
 */
@XmlRootElement
@XmlSeeAlso({ EVL_Tree_Critique.class, EVL_Tree_Constraint.class })
public class EVL_Tree_Container {

	private String context;
	/**
	 * Type of the invariant : Critique or constraint;
	 * 
	 */
	protected String type;
	/**
	 * Name of the Invariant
	 * 
	 */
	protected String name;
	/**
	 * Check field of the Invariant
	 * 
	 * 
	 */
	protected EVL_Tree_CheckStatement check;
	/**
	 * Invariant Message
	 * 
	 * 
	 */
	protected EVL_Tree_Message message;
	/**
	 * Fix List contained in the Invariant
	 * 
	 */
	private List<EVL_Tree_FixStatement> fixList;

	/**
	 * Constructor of the class. It initialize all the field
	 * 
	 * @param label
	 *            Type of invariant
	 * @param name
	 *            Name of Invariant
	 * @param check
	 *            Check
	 * @param fixList
	 *            Fix List
	 * @param message
	 *            Message
	 * 
	 */
	public EVL_Tree_Container(String context, String label, String name, EVL_Tree_CheckStatement check, List<EVL_Tree_FixStatement> fixList, EVL_Tree_Message message) {
		this.context = context;
		this.name = name;
		this.check = check;
		this.fixList = fixList;
		this.message = message;

	}

	public EVL_Tree_Container(String context, String critiqueName) {
		this.context = context;
		this.name = critiqueName;
		this.check = null;
		this.message = null;
		this.fixList = new ArrayList<EVL_Tree_FixStatement>();
	}

	public EVL_Tree_Container(String context) {
		this.context = context;
		this.fixList = new ArrayList<EVL_Tree_FixStatement>();
	}

	public String getContext() {
		return context;
	}

	public EVL_Tree_Container() {
	}

	/**
	 * returns the invariant name
	 * 
	 * @return invariantName
	 */
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * returns Check
	 * 
	 * @return Check
	 */
	@XmlElement
	public EVL_Tree_CheckStatement getCheck() {
		return check;
	}

	public void setCheck(EVL_Tree_CheckStatement check) {
		this.check = check;
	}

	/**
	 * returns the message
	 * 
	 * @return message
	 */
	@XmlElement
	public EVL_Tree_Message getMessage() {
		return message;
	}

	public void setMessage(EVL_Tree_Message message) {
		this.message = message;
	}

	/**
	 * returns list of fixies to apply when a model passes the checks
	 * 
	 * @return invariantList
	 */
	@XmlElementWrapper
	@XmlElement(name = "fix")
	public List<EVL_Tree_FixStatement> getFixList() {
		return fixList;
	}

	public void setFixList(List<EVL_Tree_FixStatement> fixList) {
		this.fixList = fixList;
	}

	/**
	 * returns type of the invariant : constraint or critique
	 * 
	 * @return type of invariant
	 */
	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}