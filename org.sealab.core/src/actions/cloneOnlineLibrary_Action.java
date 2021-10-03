package actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import dialogs.DBcredentialsDialog;
import model.Db;
import plugin.Activator;

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
		
		if (Db.getDB_URL() == null || Db.getUSER() == null || Db.getPASS() == null) {
			
			IDialogSettings settings = Activator.getDefault().getDialogSettings();
		    IDialogSettings section = settings.getSection("DBcredential");
		    
		    if (section == null) {

				DBcredentialsDialog dbDialog = new DBcredentialsDialog(operations.getControl().getShell());
				dbDialog.create();
				if (dbDialog.open() == Window.OK) {
					IDialogSettings section1 = settings.addNewSection("DBcredential");
					List<String> result = dbDialog.getCredentials();
					section1.put("url", result.get(0));
					section1.put("user", result.get(1));
					section1.put("pass", result.get(2));
					Db.setDB_URL(section1.get("url"));
			    	Db.setUSER(section1.get("user"));
			    	Db.setPASS(section1.get("pass"));
				} else {
					return;
				}
		    } else {
		    	Db.setDB_URL(section.get("url"));
		    	Db.setUSER(section.get("user"));
		    	Db.setPASS(section.get("pass"));
		    }
		}

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

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			DialogSettings settings = (DialogSettings) Activator.getDefault().getDialogSettings();
			settings.removeSection("DBcredential");
			Db.setDB_URL(null);
			Db.setUSER(null);
			Db.setPASS(null);
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
