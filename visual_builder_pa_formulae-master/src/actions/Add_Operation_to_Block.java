package actions;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

import model.EOL_Library_F_Operation;
import model.EVL_Tree_CheckBlock;
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
public class Add_Operation_to_Block extends Action {

	TreeViewer evltree;
	private EVL_Tree_Root evl;
	IStructuredSelection selection;
	private EVL_Tree_CheckBlock block;
	private int comb;

	/**
	 * @param evltree The EVL TreeViewer
	 * @param iSelection The tree item selected
	 * @param check The Check statement to which the Operation will be added
	 * @param comb The boolean operator to use
	 */
	public Add_Operation_to_Block(TreeViewer evltree, ISelection iSelection, EVL_Tree_CheckBlock block, int comb) {
		super();
		this.evltree = evltree;
		this.evl = (EVL_Tree_Root)evltree.getInput();
		this.selection = (IStructuredSelection)iSelection;
		this.block = block;
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

			block.getBlocks_and_Operations().add(operation);

			String absolutePath = f.getEol_file();
			IPath filePath = Path.fromOSString(absolutePath);
			
			String[] segments = filePath.segments();
			String importString = segments[segments.length - 2] + "/" + segments[segments.length - 1];

			List<EVL_Tree_ImportStatement> iList = evl.getImportList();

			if (iList.isEmpty()) {
				EVL_Tree_ImportStatement newImp = new EVL_Tree_ImportStatement(importString);
				iList.add(newImp);
				evl.setImportList(iList);
			} else {
				boolean flag = false;

				for (Object i : iList.toArray()) {
					EVL_Tree_ImportStatement oldImp = (EVL_Tree_ImportStatement) i;
					if (oldImp.getText().equals(importString)) {
						flag = true;
						break;
					} else {
						flag = false;
						continue;
					}
				}

				if (!flag) {
					EVL_Tree_ImportStatement newImp = new EVL_Tree_ImportStatement(importString);
					iList.add(newImp);
					evl.setImportList(iList);
				}

			}

			Object[] o = evltree.getExpandedElements();
			evltree.setInput(evl);
			evltree.setExpandedElements(o);
			evltree.setExpandedState(block, true);
		}

	}
}
