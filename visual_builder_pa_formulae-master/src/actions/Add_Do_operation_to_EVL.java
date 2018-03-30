package actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import model.EVL_Tree_FixOperations;
import model.EOL_Library_DO_Operation;
import model.EVL_Tree_ImportStatement;

/**
 * This action adds operation of refactoring to EVL
 *
 */
public class Add_Do_operation_to_EVL extends Action{
	
	IStructuredSelection selection;
	private EVL_Tree_FixOperations d;

	public Add_Do_operation_to_EVL(ISelection iSelection, EVL_Tree_FixOperations redo) {
		super();
		this.selection = (IStructuredSelection)iSelection;
		this.d = redo;
	}

	public void run() {

		IWorkbenchPage page1 = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		views.EVL_Tree evlview = (views.EVL_Tree) page1.findView("views.EVL_Tree");

		Object selected = selection.getFirstElement();

		if (selected instanceof EOL_Library_DO_Operation) {
			EOL_Library_DO_Operation redo;

			redo = (EOL_Library_DO_Operation) selected;

			List<String> list = d.getFunctions();

			list.add(redo.getName());
			d.setFunctions(list);

			String importFile = redo.getEol_file();

			List<EVL_Tree_ImportStatement> iList = evlview.evl.getImportList();

			if (iList.isEmpty()) {
				EVL_Tree_ImportStatement newImp = new EVL_Tree_ImportStatement(importFile);
				iList.add(newImp);
				evlview.evl.setImportList(iList);
			} else {
				boolean flag = false;

				for (Object i : iList.toArray()) {
					EVL_Tree_ImportStatement oldImp = (EVL_Tree_ImportStatement) i;
					if (oldImp.getText().equals(importFile)) {
						flag = true;
						break;
					} else {
						continue;
					}

				}

				if (!flag) {
					EVL_Tree_ImportStatement newImp = new EVL_Tree_ImportStatement(importFile);
					iList.add(newImp);
					evlview.evl.setImportList(iList);
				}

			}

			Object[] o = evlview.tree.getExpandedElements();
			evlview.tree.setInput(evlview.evl);
			evlview.tree.setExpandedElements(o);
			evlview.tree.setExpandedState(d, true);
		}

	}
}
