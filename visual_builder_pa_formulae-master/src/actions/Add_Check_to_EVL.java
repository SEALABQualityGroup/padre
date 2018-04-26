package actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import model.BooleanOperators;
import model.EVL_Tree_CheckBlock;
import model.EVL_Tree_CheckStatement;
import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EVL_Tree_Root;

/**
 * It adds Check statement to EVL tree
 *
 */
public class Add_Check_to_EVL extends Action{

	TreeViewer EVLtree;
	EVL_Tree_Container containerSelected;
	
	/**
	 * @param tree The EVL TreeViewer
	 * @param s The tree item representing the Constraint or Critique to which the Check will be added
	 */
	public Add_Check_to_EVL(TreeViewer tree, EVL_Tree_Container s) {
		this.EVLtree = tree;
		this.containerSelected = s;
	}

	public void run() {

		EVL_Tree_CheckStatement checkNew = new EVL_Tree_CheckStatement(containerSelected.getContext());

		for (EVL_Tree_Context_Item c : ((EVL_Tree_Root)EVLtree.getInput()).getContextList()) {
			if (c.getName().equals(containerSelected.getContext())) {
				for (EVL_Tree_Container container : c.getContainers()) {
					if (container.equals(containerSelected)) {
						container.setCheck(checkNew);
						
						EVL_Tree_CheckBlock bl = new EVL_Tree_CheckBlock(BooleanOperators.NOT);
						bl.setContext(containerSelected.getContext());
						checkNew.setBlock(bl);
					}
				}
			}
		}

		Object[] ex = EVLtree.getExpandedElements();
		EVLtree.refresh();
		EVLtree.setExpandedElements(ex);
		EVLtree.setExpandedState(containerSelected, true);
		EVLtree.setExpandedState(checkNew, true);
	}
}
