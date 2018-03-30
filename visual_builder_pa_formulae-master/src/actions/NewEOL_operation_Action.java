package actions;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class NewEOL_operation_Action extends Action{

	public void run() {

		IStorage storage = new helpers.StringStorage("operation");
		IStorageEditorInput input = new helpers.StringInput(storage);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		if (page != null)
			try {
				page.openEditor(input, "editors.LocalEolEditor");

			} catch (PartInitException e1) {
				e1.printStackTrace();
			}

	}
}
