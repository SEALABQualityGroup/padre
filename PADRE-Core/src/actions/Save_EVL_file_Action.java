package actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;

import dialogs.MessageDialog_EXL_Name;
import model.EVL_Tree_Root;

/**
 * It saves the EVL tree as an EVL file code
 *
 */
public class Save_EVL_file_Action extends Action {

	private TreeViewer evltree;
	private EVL_Tree_Root evl;
	private String eol_library_path;

	public Save_EVL_file_Action(TreeViewer evltree, EVL_Tree_Root evl, String eol_library_path) {
		super();
		this.evltree = evltree;
		this.evl = evl;
		this.eol_library_path = eol_library_path;
	}
	
	public void run() {
		
		String evlfileName = "";
		MessageDialog_EXL_Name dialog2 = new MessageDialog_EXL_Name(evltree.getControl().getShell());
		dialog2.create();
		if (dialog2.open() == Window.OK) {
			evlfileName = dialog2.getName();

		} else {
			return;
		}

		String dir = Path.fromOSString(eol_library_path).removeLastSegments(1).toPortableString();
		dir = Path.fromPortableString(dir).append(evlfileName + ".evl").toPortableString();
		File file;
		file = new File(dir);

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
