package views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import actions.cloneOnlineLibrary_Action;
import dialogs.DBcredentialsDialog;
import dialogs.MessageDialogFixTitle;
import model.Db;
import model.EOL_Library_F_Operation;
import plugin.Activator;

public class F_OperationsOnDB extends ViewPart {

	private List<Integer> DBMetricFunctions;
	private Action getOnlineLibrary, cloneOnlineLibrary;
	private Action doubleClickAction;
//	private ContextFilter_not_used contextFilter;
	private TableViewer tableViewer;
	public int selectedOpID;

	public F_OperationsOnDB() {
	}

	@Override
	public void createPartControl(Composite parent) {

		DBMetricFunctions = new ArrayList<Integer>();

		tableViewer = new TableViewer(parent, SWT.BORDER);
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.setContentProvider(new ArrayContentProvider());

		TableColumn column = new TableColumn(tableViewer.getTable(), SWT.NONE);
		column.setText("Operation name");
		column.setWidth(200);
		TableViewerColumn nameColumn = new TableViewerColumn(tableViewer, column);

		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((String[]) element)[0];
			}
		});

		column = new TableColumn(tableViewer.getTable(), SWT.NONE);
		column.setText("Context");
		column.setWidth(80);
		TableViewerColumn contextColumn = new TableViewerColumn(tableViewer, column);

		contextColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((String[]) element)[1];
			}
		});

//		contextFilter = new ContextFilter_not_used();
//		tableViewer.addFilter(contextFilter);
		
		getOnlineLibrary = new Action() {
			public void run() {

				try {
					
					if (Db.getDB_URL() == null || Db.getUSER() == null || Db.getPASS() == null) {
						
						IDialogSettings settings = Activator.getDefault().getDialogSettings();
					    IDialogSettings section = settings.getSection("DBcredential");
					    
					    if (section == null) {

							DBcredentialsDialog dbDialog = new DBcredentialsDialog(tableViewer.getControl().getShell());
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
					
					
					
					DBMetricFunctions.clear();
					List<Integer> f_id_list = Db.getall_F_id();

					List<String[]> items = new ArrayList<String[]>();

					for (Integer id : f_id_list) {

						EOL_Library_F_Operation f = Db.get_F_description_byId(id);

						items.add(new String[] { f.getName(), f.getContext() });

						DBMetricFunctions.add(id);

					}

//					contextFilter.setSearchText(".*");
//					contextFilter.set_indexing(null);
					tableViewer.setInput(items);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					DialogSettings settings = (DialogSettings) Activator.getDefault().getDialogSettings();
					settings.removeSection("DBcredential");
					Db.setDB_URL(null);
					Db.setUSER(null);
					Db.setPASS(null);
					e.printStackTrace();
				}

			}
		};
		getOnlineLibrary.setText("Refresh");
		getOnlineLibrary.setToolTipText("Get library");
		getOnlineLibrary.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
		
		cloneOnlineLibrary = new cloneOnlineLibrary_Action(tableViewer, 1);
		cloneOnlineLibrary.setText("Clone");
		cloneOnlineLibrary.setToolTipText("Clone library");
		cloneOnlineLibrary.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));

		
		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(getOnlineLibrary);
		bars.getToolBarManager().add(cloneOnlineLibrary);

		doubleClickAction = new Action() {
			public void run() {

				int index = tableViewer.getTable().getSelectionIndex();

				int operation_id = DBMetricFunctions.get(index);
				selectedOpID = operation_id;

				String f_method = null;
				try {
					f_method = Db.get_F_method_byId(operation_id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				IStorage storage = new helpers.StringStorage(f_method);
				IStorageEditorInput input = new helpers.StringInput(storage);
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				if (page != null)
					try {
						page.openEditor(input, "editors.EolEditorForDB");
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		};

		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

}
