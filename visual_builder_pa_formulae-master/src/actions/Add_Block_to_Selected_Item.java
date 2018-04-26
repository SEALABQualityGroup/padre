package actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import model.EVL_Tree_CheckBlock;
import model.EVL_Tree_Root;

/**
 * This action filters the library by F-type operations of the context passed
 * as argument and activates context menu on these operations.
 * 
 * @author Stefano
 *
 */
public class Add_Block_to_Selected_Item extends Action {

	TreeViewer evltree;
	private EVL_Tree_Root evl;
	EVL_Tree_CheckBlock blockSelected;
	EVL_Tree_CheckBlock blockToAdd;
	
	public Add_Block_to_Selected_Item(TreeViewer tree, EVL_Tree_CheckBlock b1, EVL_Tree_CheckBlock b2) {
		this.evltree = tree;
		this.evl = (EVL_Tree_Root)evltree.getInput();
		this.blockSelected = b1;
		this.blockToAdd = b2;
		this.blockToAdd.setContext(this.blockSelected.getContext());
	}

	public void run() {
		
		if (blockSelected != null) {
			EVL_Tree_CheckBlock blockItem = (EVL_Tree_CheckBlock) blockSelected;
			blockItem.getBlocks_and_Operations().add(blockToAdd);
			
			Object[] o = evltree.getExpandedElements();
			evltree.setInput(evl);
			evltree.setExpandedElements(o);
			evltree.setExpandedState(blockSelected, true);
		}
		
		
	}
}
