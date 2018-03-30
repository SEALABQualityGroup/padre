package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It represents the atomic operation (with its unary operator) in check statement
 *
 */
@XmlRootElement
public class UnaryPredicate {

	private EOL_Library_F_Operation f_op;
	private UnaryOperator op;
	
	public UnaryPredicate(UnaryOperator op , EOL_Library_F_Operation f){
		this.f_op = f;
		this.op=op;
	}

	public UnaryPredicate() {
		super();
	}
	
	@XmlElement
	public EOL_Library_F_Operation getF_op() {
		return f_op;
	}

	public void setF_op(EOL_Library_F_Operation f_op) {
		this.f_op = f_op;
	}
	
	@XmlElement
	public UnaryOperator getOp() {
		return op;
	}

	public void setOp(UnaryOperator op) {
		this.op = op;
	}

	public String toString() {
		if (this.op == UnaryOperator.EMPTY) {
			return " " + op.toString() + f_op.toString() + "() ";
		}
		return  " " + op.toString() + "( " + f_op.toString() + "()) ";
		
		//TODO add thresholds
	}

}
