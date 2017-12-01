package plugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import view.Gui;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ProvaHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	Button get;
	Button set;
	public ProvaHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		Shell shell = window.getShell();
		/*MessageDialog.openInformation(
				shell,
				"Plugin",
				"Hello, Eclipse world");*/
		Shell dialog = new Shell(shell);
		
		dialog.setText("Plugin");
		
		Gui g = new Gui();
		g.createGui(dialog);
		dialog.open();

		return null;
	}
	

}
