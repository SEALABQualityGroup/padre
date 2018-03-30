package actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EVL_Tree_Root;
import model.EVL_Tree_FixStatement;

public class Add_Fix_to_EVL extends Action{

	TreeViewer EVLtree;
	EVL_Tree_Container containerSelected;
	
	public Add_Fix_to_EVL(TreeViewer tree, EVL_Tree_Container s) {
		this.EVLtree = tree;
		this.containerSelected = s;
	}

	public void run() {
		
		EVL_Tree_FixStatement fixNew = new EVL_Tree_FixStatement(containerSelected.getContext());
		List<EVL_Tree_FixStatement> fixList = containerSelected.getFixList();
		fixList.add(fixNew);

		for (EVL_Tree_Context_Item c : ((EVL_Tree_Root)EVLtree.getInput()).getContextList()) {
			if (c.getName().equals(containerSelected.getContext())) {
				for (EVL_Tree_Container container : c.getContainers()) {
					if (container.equals(containerSelected)) {
						container.setFixList(fixList);
					}
				}
			}
		}

		Object[] ex = EVLtree.getExpandedElements();
		EVLtree.refresh();
		EVLtree.setExpandedElements(ex);
	}
}
