package helpers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import model.Check;
import model.Container;
import model.Context;
import model.Evl;
import model.Fix;
import model.GuardOperator;
import model.ImportStatement;
import model.Message;
import model.Operation;
import model.Title;

public class fillTreeModel {

	private Tree tree;
	private Evl evl;

	public fillTreeModel(Tree tree, Evl evl) {
		this.tree = tree;
		this.evl = evl;
	}

	public void fill() {
		tree.setRedraw(false);

		TreeItem importRoot = new TreeItem(tree, SWT.NONE);
		importRoot.setText("import list");

		for (ImportStatement i : evl.getImportList()) {
			TreeItem importItem = new TreeItem(importRoot, SWT.NONE);
			importItem.setText(i.toString());
			importItem.setData(i);
		}

		for (Context c : evl.getContextList()) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText("context " + c.getName());
			item.setData(c);
			for (Container cont : c.getContainers()) {
				TreeItem contItem = new TreeItem(item, SWT.NONE);
				contItem.setText(cont.getType() + " " + cont.getName());
				contItem.setData(cont);

				Check check = cont.getCheck();
				if (check != null) {
					TreeItem checkItem = new TreeItem(contItem, SWT.NONE);
					checkItem.setText("check :");
					checkItem.setData(check);
					checkItem.setExpanded(true);

					TreeItem notCheckItem = new TreeItem(checkItem, SWT.NONE);
					notCheckItem.setText("not");

					for (Operation op : check.getOperations()) {
						if (op.getOp() != GuardOperator.EMPTY) {
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
				Message message = cont.getMessage();
				if (message != null) {
					TreeItem messageItem = new TreeItem(contItem, SWT.NONE);
					messageItem.setText("message : " + message.getText());
					messageItem.setData(message);
				}

				for (Fix fix : cont.getFixList()) {
					TreeItem fixItem = new TreeItem(contItem, SWT.NONE);
					fixItem.setText("fix");
					fixItem.setData(fix);

					Title title = fix.getTitle();
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