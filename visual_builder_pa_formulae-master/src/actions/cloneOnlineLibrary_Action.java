package actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import model.Db;

/**
 * It saves the online library of EOL files as local library in the folder
 * selected.
 *
 */
public class cloneOnlineLibrary_Action extends Action {

	private TableViewer operations;
	private String content;
	private int type;

	/**
	 * @param operations The table listing operations
	 * @param type The type of operations (F, DO, TH).
	 */
	public cloneOnlineLibrary_Action(TableViewer operations, int type) {
		super();
		this.operations = operations;
		this.type = type;
	}

	public void run() {

		FileDialog dialog = new FileDialog(operations.getControl().getShell(), SWT.SAVE);
		dialog.setFilterNames(new String[] { "EOL Files (*.*eol)" });
		dialog.setFilterExtensions(new String[] { "*.eol" });
		dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
		dialog.setFileName("");
		String dir = dialog.open();

		List<Integer> id_list;
		try {

			switch (type) {
			case 1: {
				id_list = Db.getall_F_id();

				content = "";

				for (Integer id : id_list) {
					content += Db.get_F_method_byId(id) + "\n";
				}
				break;
			}
			case 2: {
				id_list = Db.getall_Do_id();

				content = "";

				for (Integer id : id_list) {
					content += Db.get_Do_method_byId(id) + "\n";
				}
				break;
			}
			case 3: {
				id_list = Db.getall_Th_id();

				content = "";

				for (Integer id : id_list) {
					content += Db.get_Th_method_byId(id) + "\n";
				}
				break;
			}
			default:
				break;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		File file;
		file = new File(dir);

		try {

			FileWriter fw;
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.flush();
			bw.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
