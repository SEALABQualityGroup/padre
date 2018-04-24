package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It represent the <code>Check</code> construct
 * 
 * @author Davide Di Gironimo
 */
@XmlRootElement
public class EVL_Tree_CheckStatement {

	private String context;
	private EVL_Tree_CheckBlock block;

	

	/**
	 * Constructor of the class. It initialize the
	 * <code>EVL_Tree_CheckOperation</code> list.
	 * 
	 * @param context
	 *            The context to which this Check belongs
	 * @param operations
	 *            operations List of {@link EVL_Tree_CheckOperation}
	 */
	public EVL_Tree_CheckStatement(String context, EVL_Tree_CheckBlock block) {
		this.context = context;
		this.block = block;
	}

	/**
	 * @param context
	 *            The context to which this Check belongs
	 */
	public EVL_Tree_CheckStatement(String context) {
		this.context = context;
	}

	/**
	 * No arguments constructor necessary for XML
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
	
	@XmlElement
	public EVL_Tree_CheckBlock getBlock() {
		return block;
	}

	public void setBlock(EVL_Tree_CheckBlock block) {
		this.block = block;
	}

	public String toString() {
		String res = "\t\tcheck:";
		res += this.getBlock().toString();
		res += "\n\t\t\t\n";

		return res;

	}

}
