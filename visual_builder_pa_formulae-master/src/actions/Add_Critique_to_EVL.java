package actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;

import dialogs.MessageDialogCCName;
import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EVL_Tree_Critique;
import model.EVL_Tree_Root;

/**
 * It adds a Critique to selected Context
 *
 */
public class Add_Critique_to_EVL extends Action {

	TreeViewer EVLtree;
	EVL_Tree_Context_Item contextSelected;

	/**
	 * @param tree The EVL TreeViewer
	 * @param s The tree item representing the Context to which the Critique will be added
	 */
	public Add_Critique_to_EVL(TreeViewer tree, EVL_Tree_Context_Item s) {
		this.EVLtree = tree;
		this.contextSelected = s;
	}

	public void run() {
		String critiqueName = "";
		MessageDialogCCName dialog2 = new MessageDialogCCName(EVLtree.getControl().getShell());
		dialog2.create();
		if (dialog2.open() == Window.OK) {
			critiqueName = dialog2.getName();

		} else {
			return;
		}

		EVL_Tree_Container cont2add = null;
		cont2add = new EVL_Tree_Critique(contextSelected.getName(), critiqueName);

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
