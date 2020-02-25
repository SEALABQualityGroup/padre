package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It represents an operation of the Check guard.
 * 
 */
@XmlRootElement
public class EVL_Tree_CheckOperation extends EVL_Tree_CheckChild {

	/**
	 * Single "Predicate" in the guard
	 * 
	 */
	private UnaryPredicate predicate;

	public EVL_Tree_CheckOperation(BooleanOperators op, UnaryPredicate predicate) {
		super(op);
		this.predicate = predicate;
	}
	
	/**
	 * Constructor with no arguments for XML
	 */
	public EVL_Tree_CheckOperation() {
		
	}

	@XmlElement
	public UnaryPredicate getPredicate() {
		return predicate;
	}

	public void setPredicate(UnaryPredicate predicate) {
		this.predicate = predicate;
	}

	public void setThreshold(String threshold) {
		this.predicate.setThreshold(threshold);
	}

	public String toString() {
		return " " + super.getOp().toString() + predicate.toString() + " ";
	}

}
