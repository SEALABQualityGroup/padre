package actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import model.EVL_Tree_CheckOperation;
import model.EVL_Tree_CheckStatement;

/**
 * This action filters the library by F-type operations of the context passed
 * as argument and activates context menu on these operations.
 * 
 * @author Stefano Di Francesco
 *
 */
public class Hook_TH_operation_Context_Menu extends Action {

	TreeViewer EVLtree;
	EVL_Tree_CheckOperation FoperationSelected;

	public Hook_TH_operation_Context_Menu(TreeViewer tree, EVL_Tree_CheckOperation s) {
		this.EVLtree = tree;
		this.FoperationSelected = s;
	}

	public void run() {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		views.EOL_Library_Tree EOL_tree_view = (views.EOL_Library_Tree) page.findView("views.EOL_Library_Tree");

		EVL_Tree_CheckOperation checkOperation = (EVL_Tree_CheckOperation) FoperationSelected;

		EOL_tree_view.getTreeFilter().setSearchText(".*");
		EOL_tree_view.getTreeFilter().setOperationType("Th");
		EOL_tree_view.eoltree.refresh();

		EOL_tree_view.hookContextMenu(checkOperation);
	}
}
