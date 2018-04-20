package actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import model.EVL_Tree_CheckStatement;

/**
 * This action filters the library by F-type operations of the context passed
 * as argument and activates context menu on these operations.
 * 
 * @author Stefano
 *
 */
public class Hook_F_operation_Context_Menu extends Action {

	TreeViewer EVLtree;
	EVL_Tree_CheckStatement checkSelected;

	public Hook_F_operation_Context_Menu(TreeViewer tree, EVL_Tree_CheckStatement s) {
		this.EVLtree = tree;
		this.checkSelected = s;
	}

	public void run() {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		views.EOL_Library_Tree EOL_tree_view = (views.EOL_Library_Tree) page.findView("views.EOL_Library_Tree");

		EVL_Tree_CheckStatement checkItem = (EVL_Tree_CheckStatement) checkSelected;

		EOL_tree_view.getTreeFilter().setSearchText(checkItem.getContext());
		EOL_tree_view.getTreeFilter().setOperationType("F");
		EOL_tree_view.eoltree.refresh();

		EOL_tree_view.hookContextMenu(checkItem, EVLtree);
	}
}
