package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** *
 *It's the Check's guard.
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class Operation {
	
	/**
	  * Comparison Operator between a single "Predicate" in the guard
	  * 
	  */
	private GuardOperator op ; 
	/**
	  * Single "Predicate" in the guard
	  * 
	  */
	private Predicate predicate;
	
	public Operation(GuardOperator op, Predicate predicate ){
		this.op = op;
		this.predicate = predicate;
	}
	public Operation(){
		
	}
	@XmlElement
	public GuardOperator getOp() {
		return op;
	}
	public void setOp(GuardOperator op) {
		this.op = op;
	}
	@XmlElement
	public Predicate getPredicate() {
		return predicate;
	}
	public void setPredicate(Predicate predicate) {
		this.predicate = predicate;
	}
	public String toString(){
		return op.toString()+predicate.toString();
	}

}
