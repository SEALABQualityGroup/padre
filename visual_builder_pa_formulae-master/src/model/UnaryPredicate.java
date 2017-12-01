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
	private UnaryOperator op;
	
	
	public UnaryPredicate(UnaryOperator op , F f){
		this.f = f;
		this.op=op;
		
	}
	public UnaryPredicate(){
		super();
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
		if (this.op == UnaryOperator.EMPTY) {
			return " "+op.toString()+f.toString()+" ";
		}
		return  " "+op.toString()+"( "+f.toString()+" ) ";
		
	}
	
}
