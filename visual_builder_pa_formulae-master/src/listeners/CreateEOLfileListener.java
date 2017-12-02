package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;

import dialogs.DialogEOLfileName;

public class CreateEOLfileListener implements SelectionListener {
	
	private Shell shell;
	private org.eclipse.swt.widgets.List library;
	private String workspace, EOLfileName;
	
	public CreateEOLfileListener(Shell s, org.eclipse.swt.widgets.List library, String workspace) {
		
		this.shell = s;	
		this.library = library;
		this.workspace = workspace;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {	
		
		
		DialogEOLfileName dialog = new DialogEOLfileName(shell);
		dialog.create();
		
		if (dialog.open() == Window.OK) {
			
			EOLfileName = dialog.getName();			
			File eol_file = new File(workspace + "\\" + EOLfileName + ".eol");
			
			try {
				eol_file.createNewFile();
				
				
				library.removeAll();
				Collection<File> allEols = FileUtils.listFiles(new File(workspace), new String[]{"eol"}, true);
				
				if (allEols.isEmpty())
				{
					library.add("No files");
				} else {
					for(File f : allEols)
					{
						library.add(f.getName());
					}
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else {
			return;
		}

		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}
	
	

}
