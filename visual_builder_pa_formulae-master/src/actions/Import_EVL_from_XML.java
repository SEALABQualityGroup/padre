package actions;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.FileDialog;

import helpers.ProjectManagment;
import model.EVL_Tree_Root;

public class Import_EVL_from_XML extends Action {
	
	private TreeViewer evltree;
	private EVL_Tree_Root evl;

	public Import_EVL_from_XML(TreeViewer evltree, EVL_Tree_Root evl) {
		super();
		this.evltree = evltree;
		this.evl = evl;
	}

	public void run() {
		
		FileDialog dlg = new FileDialog(evltree.getControl().getShell());
		dlg.setText("Open Project...");
		dlg.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
		String[] filterExt = { "*.xml" };
		dlg.setFilterExtensions(filterExt);
		String dir = dlg.open();

		try {
			if (dir != null) {
				EVL_Tree_Root imported = new EVL_Tree_Root();
				imported = ProjectManagment.Open(dir);
				evl = imported;
				evltree.setInput(evl);
			}			

		} catch (FileNotFoundException | JAXBException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
