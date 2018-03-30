package actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;

import dialogs.MyTitleAreaDialogCCName;
import model.EVL_Tree_Constraint;
import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EVL_Tree_Root;

public class Add_Constraint_to_EVL extends Action {

	TreeViewer EVLtree;
	EVL_Tree_Context_Item contextSelected;

	public Add_Constraint_to_EVL(TreeViewer tree, EVL_Tree_Context_Item s) {
		this.EVLtree = tree;
		this.contextSelected = s;
	}

	public void run() {
		String constraintName = "";
		MyTitleAreaDialogCCName dialog2 = new MyTitleAreaDialogCCName(EVLtree.getControl().getShell());
		dialog2.create();
		if (dialog2.open() == Window.OK) {
			constraintName = dialog2.getName();

		} else {
			return;
		}

		EVL_Tree_Container cont2add = null;
		cont2add = new EVL_Tree_Constraint(contextSelected.getName(), constraintName);

		for (EVL_Tree_Context_Item c : ((EVL_Tree_Root) EVLtree.getInput()).getContextList()) {
			if (c.equals(contextSelected)) {
				List<EVL_Tree_Container> tempContainerList = c.getContainers();
				tempContainerList.add(cont2add);
				c.setContainer(tempContainerList);
			}
		}

		Object[] ex = EVLtree.getExpandedElements();
		EVLtree.refresh();
		EVLtree.setExpandedElements(ex);
		EVLtree.setExpandedState(contextSelected, true);
	}
}
