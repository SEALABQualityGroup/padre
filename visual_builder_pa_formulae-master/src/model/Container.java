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
@XmlSeeAlso({ Critique.class, Constraint.class })
public class Container {

	private Context parent;
	/**
	 * Type of theinvariant : Critique or constraint;
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
	protected Check check;
	/**
	 * Invariant Message
	 * 
	 * 
	 */
	protected Message message;
	/**
	 * Fix List contained in the Invariant
	 * 
	 */
	private List<Fix> fixList;

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
	public Container(Context parent, String label, String name, Check check, List<Fix> fixList, Message message) {
		this.parent = parent;
		this.name = name;
		this.check = check;
		this.fixList = fixList;
		this.message = message;

	}

	public Container(Context parent, String critiqueName) {
		this.parent = parent;
		this.name = critiqueName;
		this.check = null;
		this.message = null;
		this.fixList = new ArrayList<Fix>();
	}

	public Container(Context parent) {
		this.parent = parent;
		this.fixList = new ArrayList<Fix>();
	}

	public Context getContext() {
		return parent;
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
	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	/**
	 * returns the message
	 * 
	 * @return message
	 */
	@XmlElement
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	/**
	 * returns list of fixies to apply when a model passes the checks
	 * 
	 * @return invariantList
	 */
	@XmlElementWrapper
	@XmlElement(name = "fix")
	public List<Fix> getFixList() {
		return fixList;
	}

	public void setFixList(List<Fix> fixList) {
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