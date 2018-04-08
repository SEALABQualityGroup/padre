package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It represent the <code>Check</code> construct
 * 
 * @author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_CheckStatement {

	private String context;
	private List<EVL_Tree_CheckOperation> operations;

	/**
	 * Constructor of the class. It initialize the
	 * <code>EVL_Tree_CheckOperation</code> list.
	 * 
	 * @param context
	 *            The context to which this Check belongs
	 * @param operations
	 *            operations List of {@link EVL_Tree_CheckOperation}
	 */
	public EVL_Tree_CheckStatement(String context, List<EVL_Tree_CheckOperation> operations) {
		this.context = context;
		this.operations = operations;
	}

	/**
	 * @param context
	 *            The context to which this Check belongs
	 */
	public EVL_Tree_CheckStatement(String context) {
		this.context = context;
		this.operations = new ArrayList<EVL_Tree_CheckOperation>();
	}

	/**
	 * No arguments constructor available for XML unmarshalling
	 */
	public EVL_Tree_CheckStatement() {
	}

	/**
	 * @return Context instance to which this Check belongs
	 */
	@XmlElement
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	/**
	 * @return List of {@link EVL_Tree_CheckOperation} of the Check
	 * 
	 */
	@XmlElementWrapper(name = "operations")
	@XmlElement(name = "operation")
	public List<EVL_Tree_CheckOperation> getOperations() {
		return operations;
	}

	/**
	 * @param operations
	 *            List of {@link EVL_Tree_CheckOperation} to add to the Check
	 * 
	 */
	public void setOperations(List<EVL_Tree_CheckOperation> operations) {
		this.operations = operations;
	}

	public String toString() {
		String res = "\t\tcheck:\n";
		res += "\t\t\t\tNOT(";
		for (EVL_Tree_CheckOperation op : this.getOperations()) {
			res += op.toString();
		}
		res += ")";
		res += "\n\t\t\t\n";

		return res;

	}

}
