package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** *
 *This is a predicate which provide an F with a real return value and it needs to be compared with a Threshold of another F 
 *
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class BinaryPredicate extends Predicate {
	
	private F left;
	private Threshold right;
	private BinaryPredicateOperator op;
	public BinaryPredicate(F left, Threshold right, BinaryPredicateOperator op){
		this.left = left;
		this.right = right;
		this.op=op;
	}
	public BinaryPredicate(){
		super();
	}
	
	@XmlElement
	public F getF() {
		return left;
	}
	public void setF(F f) {
		this.left = f;
	}
	
	@XmlElement
	public Threshold getRight() {
		return right;
	}
	public void setRight(Threshold right) {
		this.right = right;
	}
	@XmlElement
	public BinaryPredicateOperator getOp() {
		return op;
	}
	public void setOp(BinaryPredicateOperator op) {
		this.op = op;
	}
	public String toString(){
		return " "+left.toString()+op.toString()+right.toString()+" ";
	}	

}
