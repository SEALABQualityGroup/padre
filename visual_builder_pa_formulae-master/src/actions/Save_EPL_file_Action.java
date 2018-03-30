package actions;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import it.spe.disim.univaq.porting.evl2exl.Evl2Epl;
import it.spe.disim.univaq.porting.util.PortingUtil;
import model.EVL_Tree_Root;

public class Save_EPL_file_Action extends Action {

	private TreeViewer evltree;
	private EVL_Tree_Root evl;

	public Save_EPL_file_Action(TreeViewer evltree, EVL_Tree_Root evl) {
		super();
		this.evltree = evltree;
		this.evl = evl;
	}
	
	public void run() {
		
		File epl_file;

		FileDialog dialog = new FileDialog(evltree.getControl().getShell(), SWT.SAVE);
		dialog.setText("Save EPL code...");
		dialog.setFilterNames(new String[] { "All Files (*.epl)" });
		dialog.setFilterExtensions(new String[] { "*.epl" });
		dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
		dialog.setFileName("");
		String dir = dialog.open();
		if (dir != null) {
			epl_file = new File(dir);
		} else {
			return;
		}

		try {

			EvlModule evlM = new EvlModule();
			evlM.parse(evl.toString());
			AST evlAST = evlM.getAst();
			AST eplASTGen = Evl2Epl.evl2epl(evlAST);
			PortingUtil.ast2file(eplASTGen, epl_file);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
