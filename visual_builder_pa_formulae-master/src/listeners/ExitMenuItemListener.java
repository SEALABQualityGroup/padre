package listeners;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
//import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class ExitMenuItemListener implements SelectionListener {
	private Shell shell;
	public ExitMenuItemListener(Shell shell){
		this.shell=shell;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		//MenuItem item = (MenuItem)e.getSource();
		//Shell shell = item.getDisplay().getActiveShell();
		shell.close();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		//MenuItem item = (MenuItem)e.getSource();
		//Shell shell = item.getDisplay().getActiveShell();
		shell.close();
		
	}

}
