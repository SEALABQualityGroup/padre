//package actions;
//
//import org.eclipse.jface.action.Action;
//import org.eclipse.jface.viewers.TreeViewer;
//import org.eclipse.ui.IWorkbenchPage;
//import org.eclipse.ui.PlatformUI;
//
//import model.EVL_Tree_FixOperations;
//
///**
// * This action filters the library by Do-type operations of the context passed
// * as argument and activates context menu on these operations.
// * 
// * @author Stefano
// *
// */
//public class Hook_Do_operation_Context_Menu extends Action {
//
//	TreeViewer EVLtree;
//	EVL_Tree_FixOperations contextSelected;
//
//	/**
//	 * @param tree The EVL TreeViewer
//	 * @param s The list of DO
//	 */
//	public Hook_Do_operation_Context_Menu(TreeViewer tree, EVL_Tree_FixOperations s) {
//		this.EVLtree = tree;
//		this.contextSelected = s;
//	}
//
//	public void run() {
//
//		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//		views.EOL_Library_Tree EOL_tree_view = (views.EOL_Library_Tree) page.findView("views.EOL_Library_Tree");
//
//		EVL_Tree_FixOperations doItem = (EVL_Tree_FixOperations) contextSelected;
//
//		EOL_tree_view.getTreeFilter().setSearchText(doItem.getContext());
//		EOL_tree_view.getTreeFilter().setOperationType("Do");
//		EOL_tree_view.eoltree.refresh();
//
//		EOL_tree_view.hookContextMenu(doItem);
//	}
//}
