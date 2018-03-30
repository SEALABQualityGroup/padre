package listeners;

import java.io.File;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import it.spe.disim.univaq.porting.evl2exl.Evl2Epl;
import it.spe.disim.univaq.porting.evl2exl.Evl2Ewl;
import it.spe.disim.univaq.porting.util.PortingUtil;

import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import model.EVL_Tree_Root;

public class port2ewlListener implements SelectionListener {
	
	private Text console;
	private Shell shell;
	File evl_file,ewl_file;
	
	AST ewlASTGen, evlAST;
	
	public port2ewlListener(Text console, Shell s) {
		
		this.console=console;
		this.shell = s;
	}
	
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		
		
		FileDialog dialog = new FileDialog(shell);
		dialog.setText("Load EVL code...");
		dialog.setFilterPath("c:\\");
		dialog.setFilterNames(new String[] { "All Files (*.evl)" });
		dialog.setFilterExtensions(new String[] { "*.evl" });
		String dir = dialog.open();
		if (dir != null)
		{
			evl_file = new File(dir);
		}
		else
		{
			return;
		}
		
		
		dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setFilterNames(new String[] { "All Files (*.ewl)" });
		dialog.setText("Save EWL code...");
		dialog.setFilterExtensions(new String[] { "*.ewl" }); 
		dialog.setFilterPath("c:\\");
		dialog.setFileName("");
		dir = dialog.open();
		if (dir != null)
		{
			ewl_file = new File(dir);
		}
		else
		{
			return;
		}
		
		
		try {
			
			EvlModule evlM = new EvlModule();
			evlM.parse(evl_file.toURI());
			evlAST = evlM.getAst();
			ewlASTGen = Evl2Ewl.evl2ewl(evlAST);
			PortingUtil.ast2file(ewlASTGen, ewl_file);
			console.append("\n Save ewl file complete ");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			console.append("\n" + e1.getMessage() );
		}
		
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
