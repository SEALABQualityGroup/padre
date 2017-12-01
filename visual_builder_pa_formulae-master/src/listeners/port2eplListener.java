package listeners;

import java.io.File;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import it.spe.disim.univaq.porting.evl2exl.Evl2Epl;
import it.spe.disim.univaq.porting.util.PortingUtil;
import model.Evl;

import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class port2eplListener implements SelectionListener {
	
	private Text console;
	private File evl_file,epl_file;
	private Shell shell;
	
	AST eplASTGen, evlAST;
	
	public port2eplListener(Text console, Shell s) {
		
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
		dialog.setText("Save EPL code...");
		dialog.setFilterNames(new String[] { "All Files (*.epl)" });
		dialog.setFilterExtensions(new String[] { "*.epl" }); 
		dialog.setFilterPath("c:\\");
		dialog.setFileName("");
		dir = dialog.open();
		if (dir != null)
		{
			epl_file = new File(dir);
		}
		else
		{
			return;
		}
		
		try {
			
			EvlModule evlM = new EvlModule();
			evlM.parse(evl_file.toURI());
			evlAST = evlM.getAst();
			eplASTGen = Evl2Epl.evl2epl(evlAST);
			PortingUtil.ast2file(eplASTGen, epl_file);
			console.append("\n Save epl file complete ");
			
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
