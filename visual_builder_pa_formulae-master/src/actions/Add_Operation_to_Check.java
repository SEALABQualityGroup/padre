package actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

import model.EVL_Tree_CheckStatement;
import model.EOL_Library_F_Operation;
import model.BooleanOperators;
import model.EVL_Tree_ImportStatement;
import model.EVL_Tree_Root;
import model.EVL_Tree_CheckOperation;
import model.UnaryOperator;
import model.UnaryPredicate;

/**
 * It adds operations to EVL check
 *
 */
public class Add_Operation_to_Check extends Action {

	TreeViewer evltree;
	private EVL_Tree_Root evl;
	IStructuredSelection selection;
	private EVL_Tree_CheckStatement check;
	private int comb;

	public Add_Operation_to_Check(TreeViewer evltree, ISelection iSelection, EVL_Tree_CheckStatement check, int comb) {
		super();
		this.evltree = evltree;
		this.evl = (EVL_Tree_Root)evltree.getInput();
		this.selection = (IStructuredSelection)iSelection;
		this.check = check;
		this.comb = comb;
	}

	public void run() {

		Object selected = selection.getFirstElement();

		if (selected instanceof EOL_Library_F_Operation) {
			EOL_Library_F_Operation f;

			f = (EOL_Library_F_Operation) selected;

			UnaryPredicate pred;
			EVL_Tree_CheckOperation operation = null;
			
			switch (comb) {
			case 0:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);
				operation = new EVL_Tree_CheckOperation(BooleanOperators.EMPTY, pred);

				break;
			case 1:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);
				operation = new EVL_Tree_CheckOperation(BooleanOperators.EMPTY, pred);

				break;
			case 2:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);
				operation = new EVL_Tree_CheckOperation(BooleanOperators.AND, pred);

				break;
			case 3:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);
				operation = new EVL_Tree_CheckOperation(BooleanOperators.OR, pred);

				break;
			case 4:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);
				operation = new EVL_Tree_CheckOperation(BooleanOperators.XOR, pred);

				break;
			case 5:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);
				operation = new EVL_Tree_CheckOperation(BooleanOperators.AND, pred);

				break;
			case 6:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);
				operation = new EVL_Tree_CheckOperation(BooleanOperators.OR, pred);

				break;
			case 7:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);
				operation = new EVL_Tree_CheckOperation(BooleanOperators.XOR, pred);

				break;
			}

			check.getOperations().add(operation);

			String importFile = f.getEol_file();

			List<EVL_Tree_ImportStatement> iList = evl.getImportList();

			if (iList.isEmpty()) {
				EVL_Tree_ImportStatement newImp = new EVL_Tree_ImportStatement(importFile);
				iList.add(newImp);
				evl.setImportList(iList);
			} else {
				boolean flag = false;

				for (Object i : iList.toArray()) {
					EVL_Tree_ImportStatement oldImp = (EVL_Tree_ImportStatement) i;
					if (oldImp.getText().equals(importFile)) {
						flag = true;
						break;
					} else {
						flag = false;
						continue;
					}
				}

				if (!flag) {
					EVL_Tree_ImportStatement newImp = new EVL_Tree_ImportStatement(importFile);
					iList.add(newImp);
					evl.setImportList(iList);
				}

			}

			Object[] o = evltree.getExpandedElements();
			evltree.setInput(evl);
			evltree.setExpandedElements(o);
			evltree.setExpandedState(check, true);
		}

	}
}
