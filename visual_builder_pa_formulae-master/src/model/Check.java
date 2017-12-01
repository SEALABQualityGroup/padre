package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/** *
 *It represent the <code>Check</code> construct 
 *@author Davide Di Gironimo
 */
@XmlRootElement
public class Check {
	
	/**
	  * This is the list of comparisons in the guard
	  * 
	  */
	private List<Operation> operations;
	
	
	/**
	   * Constructor of the class.
	   * It initialize the <code>Operation</code> list.
	   * 
	   * @param operations List of {@link Operation}
	   * 
	   */
	public Check(List<Operation> operations) {
		super();
		this.operations=operations;
	}
	public Check(){
		this.operations=new ArrayList<Operation>();
		
	}
	@XmlElementWrapper(name="operations")
	@XmlElement(name="operation")
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public String toString(){
		String res = "\t\tcheck:\n";
		res+="\t\t\t\t"+UnaryOperator.NOT.toString()+"(";
		//res+="\t\t\t\t";
		for(Operation op : this.getOperations()){
			res+=op.toString();
		}
		res+=")";
		res+="\n\t\t\t\n";
		
		return res;
		
	}

	
}
