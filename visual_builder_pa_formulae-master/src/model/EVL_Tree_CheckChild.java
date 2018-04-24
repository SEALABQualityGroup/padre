package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * It represent a block of operations inside a check construct
 * 
 * @author Stefano Di Francesco
 */
@XmlRootElement
@XmlSeeAlso({ EVL_Tree_CheckBlock.class, EVL_Tree_CheckOperation.class })
public class EVL_Tree_CheckChild {

	private String context;
	/**
	 * Comparison Operator between a single "Predicate" in the guard
	 * 
	 */
	private BooleanOperators op;

	public EVL_Tree_CheckChild(BooleanOperators op) {
		this.op = op;
	}

	/**
	 * No arguments constructor necessary for XML
	 */
	public EVL_Tree_CheckChild() {
	}

	@XmlElement
	public BooleanOperators getOp() {
		return op;
	}

	public void setOp(BooleanOperators op) {
		this.op = op;
	}
	
	/**
	 * @return Context instance to which this block belongs
	 */
	@XmlElement
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
