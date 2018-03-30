package helpers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import model.EVL_Tree_CheckStatement;
import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EVL_Tree_Root;
import model.EVL_Tree_FixStatement;
import model.BooleanOperators;
import model.EVL_Tree_ImportStatement;
import model.EVL_Tree_Message;
import model.EVL_Tree_CheckOperation;
import model.EVL_Tree_FixTitle;

public class fillTreeModel {

	private Tree tree;
	private EVL_Tree_Root evl;

	public fillTreeModel(Tree tree, EVL_Tree_Root evl) {
		this.tree = tree;
		this.evl = evl;
	}

	public void fill() {
		tree.setRedraw(false);

		TreeItem importRoot = new TreeItem(tree, SWT.NONE);
		importRoot.setText("import list");

		for (EVL_Tree_ImportStatement i : evl.getImportList()) {
			TreeItem importItem = new TreeItem(importRoot, SWT.NONE);
			importItem.setText(i.toString());
			importItem.setData(i);
		}

		for (EVL_Tree_Context_Item c : evl.getContextList()) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText("context " + c.getName());
			item.setData(c);
			for (EVL_Tree_Container cont : c.getContainers()) {
				TreeItem contItem = new TreeItem(item, SWT.NONE);
				contItem.setText(cont.getType() + " " + cont.getName());
				contItem.setData(cont);

				EVL_Tree_CheckStatement check = cont.getCheck();
				if (check != null) {
					TreeItem checkItem = new TreeItem(contItem, SWT.NONE);
					checkItem.setText("check :");
					checkItem.setData(check);
					checkItem.setExpanded(true);

					TreeItem notCheckItem = new TreeItem(checkItem, SWT.NONE);
					notCheckItem.setText("not");

					for (EVL_Tree_CheckOperation op : check.getOperations()) {
						if (op.getOp() != BooleanOperators.EMPTY) {
							TreeItem checkChild2 = new TreeItem(notCheckItem, SWT.NONE);
							checkChild2.setText(op.getOp().toString());
							checkChild2.setData(op);

						}
						TreeItem checkChild1 = new TreeItem(notCheckItem, SWT.NONE);
						checkChild1.setText(op.getPredicate().toString());
						checkChild1.setData(op);

						// checkChild1.setExpanded(true);
					}
					notCheckItem.setExpanded(true);
					checkItem.setExpanded(true);
				}
				EVL_Tree_Message message = cont.getMessage();
				if (message != null) {
					TreeItem messageItem = new TreeItem(contItem, SWT.NONE);
					messageItem.setText("message : " + message.getText());
					messageItem.setData(message);
				}

				for (EVL_Tree_FixStatement fix : cont.getFixList()) {
					TreeItem fixItem = new TreeItem(contItem, SWT.NONE);
					fixItem.setText("fix");
					fixItem.setData(fix);

					EVL_Tree_FixTitle title = fix.getTitle();
					if (title != null) {
						TreeItem titleItem = new TreeItem(fixItem, SWT.NONE);
						titleItem.setText("title : " + title.getText());
						titleItem.setData(fix.getTitle());

					}
					TreeItem doItem = new TreeItem(fixItem, SWT.NONE);
					doItem.setText("do");
					doItem.setData(fix.getDoList());

					for (String doFun : fix.getDoList().getFunctions()) {
						TreeItem doChildItem = new TreeItem(doItem, SWT.NONE);
						doChildItem.setText(doFun);
						doChildItem.setData(doFun);
						// doChildItem.setExpanded(true);
						doItem.setExpanded(true);
					}
					fixItem.setExpanded(true);
				}
				contItem.setExpanded(true);
			}

			item.setExpanded(true);

		}
		

		importRoot.setExpanded(true);
		tree.setRedraw(true);
	}

}