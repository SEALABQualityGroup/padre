package actions;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import helpers.ProjectManagment;
import model.EVL_Tree_Root;

/**
 * It allows to export the EVL data structure as an XML file
 *
 */
public class Export_EVL_as_XML extends Action {

	private TreeViewer evltree;
	private EVL_Tree_Root evl;

	public Export_EVL_as_XML(TreeViewer evltree, EVL_Tree_Root evl) {
		super();
		this.evltree = evltree;
		this.evl = evl;
	}

	public void run() {

		FileDialog dialog = new FileDialog(evltree.getControl().getShell(), SWT.SAVE);
		dialog.setFilterNames(new String[] { "Xml Files (*.*xml)" });
		dialog.setFilterExtensions(new String[] { "*.xml" });
		dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
		dialog.setFileName("");
		String dir = dialog.open();

		try {
			if (dir != null) {
				File evl_file = new File(dir);
				ProjectManagment.Save(evl, evl_file);
			}

		} catch (JAXBException e1) {
			e1.printStackTrace();
		}

	}
}
