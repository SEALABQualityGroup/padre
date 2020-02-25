package actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import model.EVL_Tree_CheckBlock;

/**
 * This action filters the library by F-type operations of the context passed
 * as argument and activates context menu on these operations.
 * 
 * @author Stefano
 *
 */
public class Hook_F_operation_Context_Menu extends Action {

	TreeViewer EVLtree;
	EVL_Tree_CheckBlock blockSelected;

	public Hook_F_operation_Context_Menu(TreeViewer tree, EVL_Tree_CheckBlock b) {
		this.EVLtree = tree;
		this.blockSelected = b;
	}

	public void run() {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		views.EOL_Library_Tree EOL_tree_view = (views.EOL_Library_Tree) page.findView("views.EOL_Library_Tree");

		EVL_Tree_CheckBlock blockItem = (EVL_Tree_CheckBlock) blockSelected;

		EOL_tree_view.getTreeFilter().setSearchText(blockItem.getContext());
		EOL_tree_view.getTreeFilter().setOperationType("F");
		EOL_tree_view.eoltree.refresh();
		EOL_tree_view.eoltree.expandAll();

		EOL_tree_view.hookContextMenu(blockItem, EVLtree);
	}
}
