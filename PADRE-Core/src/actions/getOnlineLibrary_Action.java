package actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;

import dialogs.DBcredentialsDialog;
import model.Db;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_F_Operation;
import plugin.Activator;

/**
 * It saves the online library of EOL files as local library in the folder
 * selected.
 *
 */
public class getOnlineLibrary_Action extends Action {

	private TableViewer operations;
	private int type;
	private List<Integer> id_list;

	/**
	 * @param operations The table listing operations
	 * @param type The type of operations (F, DO, TH).
	 */
	public getOnlineLibrary_Action(TableViewer operations, int type, List<Integer> id_list) {
		super();
		this.operations = operations;
		this.type = type;
		this.id_list = id_list;
	}

	public void run() {
		
		if (Db.getDB_URL() == null || Db.getUSER() == null || Db.getPASS() == null) {
				
				IDialogSettings settings = Activator.getDefault().getDialogSettings();
			    IDialogSettings section = settings.getSection("DBcredential");
			    
			    if (section == null) {

					saveCredentials(settings);
			    } else {
			    	Db.setDB_URL(section.get("url"));
			    	Db.setUSER(section.get("user"));
			    	Db.setPASS(section.get("pass"));
			    }
			}
		
			try {
				Db.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				DialogSettings settings = (DialogSettings) Activator.getDefault().getDialogSettings();
				settings.removeSection("DBcredential");
				Db.setDB_URL(null);
				Db.setUSER(null);
				Db.setPASS(null);
				saveCredentials(settings);
			}
			
			
			id_list.clear();
			List<String[]> items = new ArrayList<String[]>();

			try {
				
				switch (type) {
				case 1: {
					
					List<Integer> f_id_list = Db.getall_F_id();					
					
					for (Integer id : f_id_list) {
						EOL_Library_F_Operation f = Db.get_F_description_byId(id);
						items.add(new String[] { f.getName(), f.getContext() });

						id_list.add(id);
					}
					break;
				}
				case 2: {
					List<Integer> do_id_list = Db.getall_Do_id();

					for (Integer id : do_id_list) {
						EOL_Library_DO_Operation redo = Db.get_Do_description_byId(id);
						items.add(new String[] { redo.getName(), redo.getContext() });

						id_list.add(id);
					}
					break;
				}
				case 3: {
					List<Integer> th_id_list = Db.getall_Th_id();

					for (Integer id : th_id_list) {
						String th = Db.get_Th_name_byId(id);
						items.add(new String[] { th });

						id_list.add(id);
					}
					break;
				}
				default:
					break;
				}
				
				operations.setInput(items);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			

			

	}

	/**
	 * @param settings
	 */
	private void saveCredentials(IDialogSettings settings) {
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
	}

}
