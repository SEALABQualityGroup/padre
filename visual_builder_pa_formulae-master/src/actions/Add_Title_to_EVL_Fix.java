package actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;

import dialogs.MyTitleAreaDialogFixTitle;
import model.EVL_Tree_FixStatement;
import model.EVL_Tree_FixTitle;

public class Add_Title_to_EVL_Fix extends Action{

	TreeViewer EVLtree;
	EVL_Tree_FixStatement fixSelected;
	
	public Add_Title_to_EVL_Fix(TreeViewer tree, EVL_Tree_FixStatement s) {
		this.EVLtree = tree;
		this.fixSelected = s;
	}

	public void run() {

		String title = "";
		MyTitleAreaDialogFixTitle fixTitleDialog = new MyTitleAreaDialogFixTitle(EVLtree.getControl().getShell());
		fixTitleDialog.create();
		if (fixTitleDialog.open() == Window.OK) {
			title = fixTitleDialog.getName();

		} else {
			return;
		}
		EVL_Tree_FixTitle titleNew = new EVL_Tree_FixTitle(title);
		fixSelected.setTitle(titleNew);

		Object[] ex = EVLtree.getExpandedElements();
		EVLtree.refresh();
		EVLtree.setExpandedElements(ex);
		EVLtree.setExpandedState(fixSelected, true);
	}
}
