package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** *
 *This is a predicate which F returns a Boolean value.
 *
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class UnaryPredicate extends Predicate {
	private F f;
	private F_operation f_op;
	private UnaryOperator op;
	
	
	public UnaryPredicate(UnaryOperator op , F f){
		this.f = f;
		this.op=op;
		
	}
	
	public UnaryPredicate(UnaryOperator op , F_operation f){
		this.f_op = f;
		this.op=op;
		
	}
	
	public UnaryPredicate(){
		super();
	}
	
	
	@XmlElement
	public F_operation getF_operation() {
		return f_op;
	}
	public void setF_operation(F_operation f) {
		this.f_op = f;
	}
	
	@XmlElement
	public F getF() {
		return f;
	}
	public void setF(F f) {
		this.f = f;
	}
	
	@XmlElement
	public UnaryOperator getOp() {
		return op;
	}
	public void setOp(UnaryOperator op) {
		this.op = op;
	}

	public String toString(){
		if (f != null) {
			if (this.op == UnaryOperator.EMPTY) {
				return " "+op.toString()+f.toString()+" ";
			}
			return  " "+op.toString()+"( "+f.toString()+" ) ";
		} else {
			if (this.op == UnaryOperator.EMPTY) {
				return " " + op.toString() + f_op.toString() + "() ";
			}
			return  " " + op.toString() + "( " + f_op.toString() + "()) ";
		}
		
		
	}
	
}
