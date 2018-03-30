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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.UIJob;

import filters.ContextFilter_Depr;
import helpers.ShowView;
import helpers.EOL_Utils;
import helpers.fillTreeModel;
import model.EVL_Tree_CheckStatement;
import model.EVL_Tree_Context_Item;
import model.Db;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_F_Operation;
import model.BooleanOperators;
import model.EVL_Tree_CheckOperation;
import model.UnaryOperator;
import model.UnaryPredicate;

public class F_OperationsOnDB extends ViewPart {

	private List<Integer> DBMetricFunctions;
	private Action getLocalLibrary, getOnlineLibrary;
	private Action doubleClickAction;
	private ContextFilter_Depr contextFilter;
	private TableViewer tableViewer;
	public int selectedOpID;

	public F_OperationsOnDB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub

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

				int operation_id = DBMetricFunctions.get(index);

				EOL_Library_F_Operation f;

				try {
					f = Db.get_F_description_byId(operation_id);

					Db.insert_Metric_functionOnline(f.getContext(), f.getName(), f.getMethod(), 1);

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
					DBMetricFunctions.clear();
					List<Integer> f_id_list = Db.getall_F_id();

					List<String[]> items = new ArrayList<String[]>();

					for (Integer id : f_id_list) {

						EOL_Library_F_Operation f = Db.get_F_description_byId(id);

						items.add(new String[] { f.getName(), f.getContext() });

						DBMetricFunctions.add(id);

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
					DBMetricFunctions.clear();
					List<Integer> f_id_list_Online = Db.getall_F_id_Online();
					List<Integer> f_id_list = Db.getall_F_id();

					List<String[]> items = new ArrayList<String[]>();
					boolean flag;
					for (Integer id : f_id_list_Online) {
						flag = false;

						for (Integer local_id : f_id_list) {

							EOL_Library_F_Operation fOnline = Db.get_F_description_byId_Online(id);
							EOL_Library_F_Operation f = Db.get_F_description_byId(local_id);

							if (f.getName().equals(fOnline.getName())) {

								// if the name is the same
								EolModule eolM = new EolModule();
								eolM.parse(fOnline.getMethod());
								AST OnlineEOLast = eolM.getAst();

								AST OnlineOperation = AstUtil.getChild(OnlineEOLast, 28);

								eolM.parse(f.getMethod());
								AST localEOLast = eolM.getAst();

								AST LocalOperation = AstUtil.getChild(localEOLast, 28);

								// check that the signature is the same too
								if (EOL_Utils.compare(LocalOperation, OnlineOperation)) {

									// if the method has been changed, update it on DB
									if (!(f.getMethod().equals(fOnline.getMethod()))) {
										Db.set_F_method_byId(local_id, OnlineOperation.rewrite());
										items.add(new String[] { f.getName(), f.getContext() });
										DBMetricFunctions.add(local_id);
										flag = true;
										break;
									} else {
										flag = true;
										items.add(new String[] { f.getName(), f.getContext() });
										DBMetricFunctions.add(local_id);
										break; // otherwise go on with the next operation from online db
									}

								}
							}
						}

						if (flag) {

						} else {
							// if no occurrences found go on inserting the new operation in the local DB

							EOL_Library_F_Operation fOnline = Db.get_F_description_byId_Online(id);

							items.add(new String[] { fOnline.getName(), fOnline.getContext() });

//							int f_id = Db.insert_Metric_function(fOnline.getContext(), fOnline.getName(),
//									fOnline.getMethod(), 1);
							int f_id = Db.insert_Metric_function(fOnline.getContext(), fOnline.getName(),
									fOnline.getMethod());
							DBMetricFunctions.add(f_id);
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

		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(getLocalLibrary);
		bars.getToolBarManager().add(getOnlineLibrary);

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

		// getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(listener);

	}

	// private ISelectionListener listener = new ISelectionListener() {
	// public void selectionChanged(IWorkbenchPart sourcepart, ISelection selection)
	// {
	// // we ignore our own selections
	// if (sourcepart instanceof view.EVLtree) {
	// if (!selection.isEmpty()) {
	// try {
	// showSelection(sourcepart, selection);
	// } catch (PartInitException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	// }
	// };

	public void chooseF() {
		// public void showSelection(IWorkbenchPart sourcepart, ISelection selection)
		// throws PartInitException {
		//
		// if (selection instanceof IStructuredSelection) {
		// Object selected = ((IStructuredSelection) selection).getFirstElement();
		//
		UIJob myjob = new ShowView("view.F_OperationsOnDB", null);

		// if (selected instanceof Context) {
		//
		// Context c = (Context) selected;
		//
		// contextFilter.setSearchText(c.getName());
		// tableViewer.refresh();
		//
		// myjob.schedule();
		// }
		// if (selected instanceof Critique || selected instanceof
		// Constraint) {
		//
		// TreeItem[] selects;
		// TreeItem itemSelected;
		//
		// view.EVLtree evlview = (view.EVLtree) sourcepart;
		//
		// selects = evlview.tree.getTree().getSelection();
		// itemSelected = selects[0];
		//
		// TreeItem contextItem = itemSelected.getParentItem();
		// Context context = (Context) contextItem.getData();
		//
		// contextFilter.setSearchText(context.getName());
		// tableViewer.refresh();
		//
		// myjob.schedule();
		//
		// }
		// if (selected instanceof Check) {

		try {
			DBMetricFunctions.clear();
			List<Integer> f_id_list = Db.getall_F_id();

			List<String[]> items = new ArrayList<String[]>();

			for (Integer id : f_id_list) {

				EOL_Library_F_Operation f = Db.get_F_description_byId(id);

				items.add(new String[] { f.getName(), f.getContext() });

				DBMetricFunctions.add(id);

			}

			TreeItem[] selects;
			TreeItem itemSelected;

			// view.EVLtree evlview = (view.EVLtree) sourcepart;
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			views.EVL_Tree evlview = (views.EVL_Tree) page.findView("view.EVLtree");

			selects = evlview.tree.getTree().getSelection();
			itemSelected = selects[0];

			TreeItem invariantItem = itemSelected.getParentItem();
			TreeItem contextItem = invariantItem.getParentItem();
			EVL_Tree_Context_Item context = (EVL_Tree_Context_Item) contextItem.getData();

			contextFilter.setSearchText(context.getName());
			contextFilter.set_indexing(DBMetricFunctions);

			tableViewer.setInput(items);

			EVL_Tree_CheckStatement check = (EVL_Tree_CheckStatement) itemSelected.getData();

			hookContextMenu(evlview, check);

			myjob.schedule();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// }
		// }

	}

	private void hookContextMenu(views.EVL_Tree evlview, EVL_Tree_CheckStatement check) {

		Action set_First_Operation = new Action() {
			public void run() {

				generalAction(evlview, check, 0);

			}
		};
		set_First_Operation.setText("Add to EVL tree");
		set_First_Operation.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		Action set_Negated_First_Operation = new Action() {
			public void run() {

				generalAction(evlview, check, 1);

			}
		};
		set_Negated_First_Operation.setText("Add negated to EVL tree");
		set_Negated_First_Operation.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		Action set_AND = new Action() {
			public void run() {

				generalAction(evlview, check, 2);

			}
		};
		set_AND.setText("AND");
		set_AND.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		Action set_OR = new Action() {
			public void run() {

				generalAction(evlview, check, 3);

			}
		};
		set_OR.setText("OR");
		set_OR.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		Action set_XOR = new Action() {
			public void run() {

				generalAction(evlview, check, 4);

			}
		};
		set_XOR.setText("XOR");
		set_XOR.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		Action set_Negated_AND = new Action() {
			public void run() {

				generalAction(evlview, check, 5);

			}
		};
		set_Negated_AND.setText("NOT AND");
		set_Negated_AND.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		Action set_Negated_OR = new Action() {
			public void run() {

				generalAction(evlview, check, 6);

			}
		};
		set_Negated_OR.setText("NOT OR");
		set_Negated_OR.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		Action set_Negated_XOR = new Action() {
			public void run() {

				generalAction(evlview, check, 7);

			}
		};
		set_Negated_XOR.setText("NOT XOR");
		set_Negated_XOR.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				if (tableViewer.getSelection().isEmpty()) {
					return;
				}

				if (tableViewer.getSelection() instanceof IStructuredSelection) {

					if (check.getOperations().isEmpty()) {
						manager.add(set_First_Operation);
						manager.add(set_Negated_First_Operation);
					} else {
						manager.add(set_AND);
						manager.add(set_OR);
						manager.add(set_XOR);
						manager.add(set_Negated_AND);
						manager.add(set_Negated_OR);
						manager.add(set_Negated_XOR);
					}

				}
			}
		});
		Menu menu = menuMgr.createContextMenu(tableViewer.getControl());
		tableViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, tableViewer);
	}

	private void generalAction(views.EVL_Tree evlview, EVL_Tree_CheckStatement check, int comb) {
		TableItem[] selects;
		TableItem itemSelected;

		selects = tableViewer.getTable().getSelection();
		itemSelected = selects[0];

		itemSelected.getText(0);

		int index = tableViewer.getTable().getSelectionIndex();

		int operation_id = DBMetricFunctions.get(index);

		EOL_Library_F_Operation f;

		try {

			f = Db.get_F_description_byId(operation_id);

			UnaryPredicate pred;
			EVL_Tree_CheckOperation operation = null;

			switch (comb) {
			case 0:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);

				operation = new EVL_Tree_CheckOperation(BooleanOperators.EMPTY, pred);

				break;
			case 1:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);

				operation = new EVL_Tree_CheckOperation(BooleanOperators.EMPTY, pred);

				break;
			case 2:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);

				operation = new EVL_Tree_CheckOperation(BooleanOperators.AND, pred);

				break;
			case 3:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);

				operation = new EVL_Tree_CheckOperation(BooleanOperators.OR, pred);

				break;
			case 4:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);

				operation = new EVL_Tree_CheckOperation(BooleanOperators.XOR, pred);

				break;
			case 5:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);

				operation = new EVL_Tree_CheckOperation(BooleanOperators.AND, pred);

				break;
			case 6:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);

				operation = new EVL_Tree_CheckOperation(BooleanOperators.OR, pred);

				break;
			case 7:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);

				operation = new EVL_Tree_CheckOperation(BooleanOperators.XOR, pred);

				break;
			}

			check.getOperations().add(operation);
			evlview.tree.getTree().removeAll();

			new fillTreeModel(evlview.tree.getTree(), evlview.evl).fill();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
