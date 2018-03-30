package actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;

import dialogs.MyTitleAreaDialogMessage;
import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EVL_Tree_Root;
import model.EVL_Tree_Message;

public class Add_Message_to_EVL extends Action{

	TreeViewer EVLtree;
	EVL_Tree_Container containerSelected;
	
	public Add_Message_to_EVL(TreeViewer tree, EVL_Tree_Container s) {
		this.EVLtree = tree;
		this.containerSelected = s;
	}

	public void run() {

		String txtMsg = "";
		MyTitleAreaDialogMessage dialogMessage = new MyTitleAreaDialogMessage(EVLtree.getControl().getShell());
		dialogMessage.create();
		if (dialogMessage.open() == Window.OK) {
			txtMsg = dialogMessage.getName();

		} else {
			return;
		}

		EVL_Tree_Message msg = new EVL_Tree_Message(txtMsg);
		for (EVL_Tree_Context_Item c : ((EVL_Tree_Root)EVLtree.getInput()).getContextList()) {
			if (c.getName().equals(containerSelected.getContext())) {
				for (EVL_Tree_Container container : c.getContainers()) {
					if (container.equals(containerSelected)) {
						container.setMessage(msg);
					}
				}
			}
		}
		
		Object[] ex = EVLtree.getExpandedElements();
		EVLtree.refresh();
		EVLtree.setExpandedElements(ex);
		EVLtree.setExpandedState(containerSelected, true);
	}
}
