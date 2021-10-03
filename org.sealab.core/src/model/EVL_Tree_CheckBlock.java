package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * It represent a block of operations inside a check construct
 * 
 * @author Stefano Di Francesco
 */
@XmlRootElement
public class EVL_Tree_CheckBlock extends EVL_Tree_CheckChild {

	private List<EVL_Tree_CheckChild> blocks_and_operations;

	public EVL_Tree_CheckBlock(BooleanOperators op) {
		super(op);
		this.blocks_and_operations = new ArrayList<EVL_Tree_CheckChild>();
	}
	
	/**
	 * No arguments constructor necessary for XML
	 */
	public EVL_Tree_CheckBlock() {
	}

	/**
	 * @return List of {@link EVL_Tree_CheckChild} of the block
	 * 
	 */
	@XmlElementWrapper(name = "blocks_and_operations")
	@XmlElement(name = "blocks_and_operations")
	public List<EVL_Tree_CheckChild> getBlocks_and_Operations() {
		return blocks_and_operations;
	}

	public void setBlocks_and_Operations(List<EVL_Tree_CheckChild> blocks_and_operations) {
		this.blocks_and_operations = blocks_and_operations;
	}

	public String toString() {
		String result = "\n\t\t\t\t" + super.getOp().toString() + " (";
		
		for (EVL_Tree_CheckChild b : this.blocks_and_operations) {
			result += b.toString();			
		}
		
		result += ") ";

		return result;

	}

}
