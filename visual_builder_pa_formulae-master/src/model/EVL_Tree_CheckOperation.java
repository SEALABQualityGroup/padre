package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It represents an operation of the Check guard.
 * 
 * @author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_CheckOperation {

	/**
	 * Comparison Operator between a single "Predicate" in the guard
	 * 
	 */
	private BooleanOperators op;	

	/**
	 * Single "Predicate" in the guard
	 * 
	 */
	private UnaryPredicate predicate;

	public EVL_Tree_CheckOperation(BooleanOperators op, UnaryPredicate predicate) {
		this.op = op;
		this.predicate = predicate;
	}

	public EVL_Tree_CheckOperation() {

	}

	@XmlElement
	public BooleanOperators getOp() {
		return op;
	}

	public void setOp(BooleanOperators op) {
		this.op = op;
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
		return " " + op.toString() + predicate.toString();
	}

}
