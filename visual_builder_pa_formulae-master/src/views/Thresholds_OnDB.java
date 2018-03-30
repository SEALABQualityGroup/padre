package views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IStorage;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import helpers.EOL_Utils;
import model.Db;

public class Thresholds_OnDB extends ViewPart {

	private List<Integer> DBThresholdsFunctions;
	private Action getLocalLibrary, getOnlineLibrary;
	private Action doubleClickAction;
	public int selectedOpID;

	public Thresholds_OnDB() {
	}

	@Override
	public void createPartControl(Composite parent) {

		DBThresholdsFunctions = new ArrayList<Integer>();

		TableViewer tableViewer = new TableViewer(parent, SWT.BORDER);
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.setContentProvider(new ArrayContentProvider());

		TableColumn column = new TableColumn(tableViewer.getTable(), SWT.NONE);
		column.setText("Operation name");
		column.setWidth(170);
		TableViewerColumn nameColumn = new TableViewerColumn(tableViewer, column);

		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((String[]) element)[0];
			}
		});

		Action putOnline = new Action() {
			public void run() {

				TableItem[] selects;
				TableItem itemSelected;

				selects = tableViewer.getTable().getSelection();
				itemSelected = selects[0];

				itemSelected.getText(0);

				int index = tableViewer.getTable().getSelectionIndex();

				int operation_id = DBThresholdsFunctions.get(index);

				try {
					Db.insert_Threshold_functionOnline(Db.get_Th_name_byId(operation_id),
							Db.get_Th_method_byId(operation_id));

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		putOnline.setText("Put online");
		putOnline.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		getLocalLibrary = new Action() {
			public void run() {

				try {
					DBThresholdsFunctions.clear();
					List<Integer> th_id_list = Db.getall_Th_id();

					List<String[]> items = new ArrayList<String[]>();

					for (Integer id : th_id_list) {

						String th = Db.get_Th_name_byId(id);

						items.add(new String[] { th });

						DBThresholdsFunctions.add(id);

					}

					tableViewer.setInput(items);

					MenuManager menuMgr = new MenuManager("#PopupMenu");
					menuMgr.setRemoveAllWhenShown(true);
					menuMgr.addMenuListener(new IMenuListener() {
						public void menuAboutToShow(IMenuManager manager) {
							if (tableViewer.getSelection().isEmpty()) {
								return;
							}

							if (tableViewer.getSelection() instanceof IStructuredSelection) {

								manager.add(putOnline);

							}
						}
					});
					Menu menu = menuMgr.createContextMenu(tableViewer.getControl());
					tableViewer.getControl().setMenu(menu);
					getSite().registerContextMenu(menuMgr, tableViewer);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		getLocalLibrary.setText("Refresh");
		getLocalLibrary.setToolTipText("Get library");
		getLocalLibrary.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		getOnlineLibrary = new Action() {
			public void run() {

				try {
					DBThresholdsFunctions.clear();
					List<Integer> th_id_list_Online = Db.getall_Th_id_Online();
					List<Integer> th_id_list = Db.getall_Th_id();

					List<String[]> items = new ArrayList<String[]>();
					boolean flag;

					for (Integer id : th_id_list_Online) {
						flag = false;

						for (Integer local_id : th_id_list) {

							String th_name_Online = Db.get_Th_name_byId_Online(id);
							String th_name = Db.get_Th_name_byId(local_id);

							if (th_name_Online.equals(th_name)) {

								// if the name is the same
								String th_body_Online = Db.get_Th_method_byId_Online(id);
								String th_body = Db.get_Th_method_byId(local_id);

								EolModule eolM = new EolModule();
								eolM.parse(th_body_Online);
								AST OnlineEOLast = eolM.getAst();

								AST OnlineOperation = AstUtil.getChild(OnlineEOLast, 28);

								eolM.parse(th_body);
								AST localEOLast = eolM.getAst();

								AST LocalOperation = AstUtil.getChild(localEOLast, 28);

								// check that the signature is the same too
								if (EOL_Utils.compare(LocalOperation, OnlineOperation)) {

									// if the method has been changed, update it on DB
									if (!(th_body.equals(th_body_Online))) {
										Db.set_Th_method_byId(local_id, OnlineOperation.rewrite());
										flag = true;
										items.add(new String[] { Db.get_Th_name_byId(local_id) });
										DBThresholdsFunctions.add(local_id);
										break;
									} else {
										flag = true;
										items.add(new String[] { Db.get_Th_name_byId(local_id) });
										DBThresholdsFunctions.add(local_id);
										break; // otherwise go on with the next operation from online db
									}

								}
							}
						}

						if (flag) {

						} else {
							// if no occurrences found go on inserting the new operation in the local DB
							String th = Db.get_Th_name_byId_Online(id);
							int th_id = Db.insert_Threshold_function(th, Db.get_Th_method_byId_Online(id));

							items.add(new String[] { th });
							DBThresholdsFunctions.add(th_id);
						}

					}

					tableViewer.setInput(items);

					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					views.EVL_Tree evlview = (views.EVL_Tree) page.findView("view.EVLtree");

					// evlview.setcontexts();

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		getOnlineLibrary.setText("Refresh");
		getOnlineLibrary.setToolTipText("Get online library");
		getOnlineLibrary.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(getLocalLibrary);
		bars.getToolBarManager().add(getOnlineLibrary);

		doubleClickAction = new Action() {
			public void run() {

				int index = tableViewer.getTable().getSelectionIndex();

				int operation_id = DBThresholdsFunctions.get(index);
				selectedOpID = operation_id;

				String th_method = null;
				try {
					th_method = Db.get_Th_method_byId(operation_id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				IStorage storage = new helpers.StringStorage(th_method);
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
