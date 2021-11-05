package actions;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IStorageEditorInput;
//import editors.Local_EOL_Editor;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_F_Operation;
import model.EOL_Library_Th_Operation;

/**
 * It opens a new editor part to work the operation selected
 * @author Stefano
 *
 */
public class DoubleClick_EOL_operation_Action extends Action {

	private IStructuredSelection itemSelected;
	IStorage storage;
	IStorageEditorInput input;

	/**
	 * Costructor
	 * 
	 * @param itemSelected The operation double-clicked from the library tree
	 */
	public DoubleClick_EOL_operation_Action(ISelection itemSelected) {
		super();
		this.itemSelected = (IStructuredSelection) itemSelected;
	}

	public void run() {

		Object selected = itemSelected.getFirstElement();

		if (selected instanceof EOL_Library_F_Operation) {

			EOL_Library_F_Operation f = (EOL_Library_F_Operation) selected;
			String method = f.getMethod();
			storage = new helpers.StringStorage(method);
			input = new helpers.StringInput(storage);

		} else {
			if (selected instanceof EOL_Library_DO_Operation) {

				EOL_Library_DO_Operation redo = (EOL_Library_DO_Operation) selected;
				String method = redo.getMethod();
				storage = new helpers.StringStorage(method);
				input = new helpers.StringInput(storage);
				
			} else {
				if (selected instanceof EOL_Library_Th_Operation) {

					EOL_Library_Th_Operation th = (EOL_Library_Th_Operation) selected;
					String method = th.getMethod();
					storage = new helpers.StringStorage(method);
					input = new helpers.StringInput(storage);
					
				} else 
					return;
			}
				
		}		
		
		/*
		if (input != null) {
			IWorkbenchPage page1 = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			
			if (page1 != null) {
				try {
					Local_EOL_Editor eoledit = (Local_EOL_Editor) page1.openEditor(input, "editors.Local_EOL_Editor");
					eoledit.setItemSelected((EOL_Library_Operation_Superclass) selected);
				} catch (PartInitException e1) {
					e1.printStackTrace();
				}
			}
				
		}
		*/
	}
}
