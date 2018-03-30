package actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import model.EVL_Tree_Root;

public class Save_EVL_file_Action extends Action {

	private TreeViewer evltree;
	private EVL_Tree_Root evl;

	public Save_EVL_file_Action(TreeViewer evltree, EVL_Tree_Root evl) {
		super();
		this.evltree = evltree;
		this.evl = evl;
	}
	
	public void run() {
		
		FileDialog dialog = new FileDialog(evltree.getControl().getShell(), SWT.SAVE);
		dialog.setText("Save EVL code...");
		dialog.setFilterNames(new String[] { "All Files (*.evl)" });
		dialog.setFilterExtensions(new String[] { "*.evl" });
		dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
		dialog.setFileName("");
		String dir = dialog.open();
		File file;
		if (dir != null) {
			file = new File(dir);
		} else {
			return;
		}

		try {

			FileWriter fw;
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(evl.toString());
			bw.flush();
			bw.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
