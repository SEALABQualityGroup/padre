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

import actions.cloneOnlineLibrary_Action;
import filters.ContextFilter_Depr;
import helpers.EOL_Utils;
import model.Db;
import model.EOL_Library_DO_Operation;

public class Do_OperationsOnDB extends ViewPart {

	private List<Integer> DBDoFunctions;
	private Action getLocalLibrary, getOnlineLibrary, cloneOnlineLibrary;
	private Action doubleClickAction;
	public int selectedOpID;
	private ContextFilter_Depr contextFilter;
	private TableViewer tableViewer;

	public Do_OperationsOnDB() {
	}

	@Override
	public void createPartControl(Composite parent) {

		DBDoFunctions = new ArrayList<Integer>();

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

		contextFilter = new ContextFilter_Depr();
		tableViewer.addFilter(contextFilter);

		Action putOnline = new Action() {
			public void run() {

				TableItem[] selects;
				TableItem itemSelected;

				selects = tableViewer.getTable().getSelection();
				itemSelected = selects[0];

				itemSelected.getText(0);

				int index = tableViewer.getTable().getSelectionIndex();

				int operation_id = DBDoFunctions.get(index);

				EOL_Library_DO_Operation redo;

				try {
					redo = Db.get_Do_description_byId(operation_id);

					Db.insert_Do_functionOnline(redo.getName(), redo.getContext(), Db.get_Do_method_byId(operation_id));

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
					DBDoFunctions.clear();
					List<Integer> do_id_list = Db.getall_Do_id();

					List<String[]> items = new ArrayList<String[]>();

					for (Integer id : do_id_list) {

						EOL_Library_DO_Operation redo = Db.get_Do_description_byId(id);

						items.add(new String[] { redo.getName(), redo.getContext() });

						DBDoFunctions.add(id);

					}

					contextFilter.setSearchText(".*");
					contextFilter.set_indexing(null);

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
					DBDoFunctions.clear();
					List<Integer> do_id_list_Online = Db.getall_Do_id_Online();
					List<Integer> do_id_list = Db.getall_Do_id();

					List<String[]> items = new ArrayList<String[]>();
					boolean flag = false;

					for (Integer Onlineid : do_id_list_Online) {

						flag = false;
						for (Integer local_id : do_id_list) {

							EOL_Library_DO_Operation redoOnline = Db.get_Do_description_byId_Online(Onlineid);
							EOL_Library_DO_Operation redo = Db.get_Do_description_byId(local_id);

							if (redo.getName().equals(redoOnline.getName())) {

								// if the name is the same
								EolModule eolM = new EolModule();
								eolM.parse(redoOnline.getMethod());
								AST OnlineEOLast = eolM.getAst();

								AST OnlineOperation = AstUtil.getChild(OnlineEOLast, 28);

								eolM.parse(redo.getMethod());
								AST localEOLast = eolM.getAst();

								AST LocalOperation = AstUtil.getChild(localEOLast, 28);

								// check that the signature is the same too
								if (EOL_Utils.compare(LocalOperation, OnlineOperation)) {

									// if the method has been changed, update it on DB
									if (!(Db.get_Do_method_byId(local_id)
											.equals(Db.get_Do_method_byId_Online(Onlineid)))) {
										Db.set_Do_method_byId(local_id, OnlineOperation.rewrite());
										flag = true;
										items.add(new String[] { Db.get_Do_description_byId(local_id).getName(), Db.get_Do_description_byId(local_id).getContext() });
										DBDoFunctions.add(local_id);
										break;
									} else {
										flag = true;
										items.add(new String[] { Db.get_Do_description_byId(local_id).getName(), Db.get_Do_description_byId(local_id).getContext() });
										DBDoFunctions.add(local_id);
										break; // otherwise go on with the next operation from online db
									}
								}
							}
						}

						// if no occurrences found go on inserting the new operation in the local DB

						if (flag) {
							
						} else {
							EOL_Library_DO_Operation redoOnline = Db.get_Do_description_byId_Online(Onlineid);

							items.add(new String[] { redoOnline.getName(), redoOnline.getContext() });

							int do_id = Db.insert_Do_function(redoOnline.getName(), redoOnline.getContext(),
									Db.get_Do_method_byId_Online(Onlineid));
							DBDoFunctions.add(do_id);
						}
						
					}

					contextFilter.setSearchText(".*");
					contextFilter.set_indexing(null);

					tableViewer.setInput(items);
					
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					views.EVL_Tree evlview = (views.EVL_Tree) page.findView("view.EVLtree");
					
//					evlview.setcontexts();

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
		
		cloneOnlineLibrary = new cloneOnlineLibrary_Action(tableViewer, 2);
		cloneOnlineLibrary.setText("Clone");
		cloneOnlineLibrary.setToolTipText("Clone library");
		cloneOnlineLibrary.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));

		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(getLocalLibrary);
		bars.getToolBarManager().add(cloneOnlineLibrary);

		doubleClickAction = new Action() {
			public void run() {

				int index = tableViewer.getTable().getSelectionIndex();

				int operation_id = DBDoFunctions.get(index);
				selectedOpID = operation_id;

				String do_method = null;
				try {
					do_method = Db.get_Do_method_byId(operation_id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				IStorage storage = new helpers.StringStorage(do_method);
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
