package view;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import filters.EOLLibraryContextFilter;
import listeners.dropListener2;
import listeners.workspaceChangeListener;
import model.Check;
import model.Context;
import model.Context2;
import model.Db;
import model.Do;
import model.Do_operation;
import model.F_operation;
import model.GuardOperator;
import model.ImportStatement;
import model.LibraryRoot;
import model.Operation;
import model.Predicate;
import model.Th_list;
import model.Th_operation;
import model.UnaryOperator;
import model.UnaryPredicate;

public class EOL_Library_Tree extends ViewPart {

	AST eolAST;
	public TreeViewer treeViewer;
	EOLLibraryContextFilter treeFilter;

	private Action newOperation, saveOperationsOnDB, doubleClickAction;
	private File eol_file;

	List<Context2> contexts;
	List<Th_operation> thresholds;
	List<Th_list> ths;

	List<LibraryRoot> listOfLibraries;

	IFolder folder = null;
	public String path;

	public EOL_Library_Tree() {
		contexts = new ArrayList<Context2>();
		thresholds = new ArrayList<Th_operation>();
	}

	@Override
	public void createPartControl(Composite parent) {

		treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(new EOLLibraryContentProvider());
		treeViewer.setLabelProvider(new EOLLibraryLabelProvider());

		treeFilter = new EOLLibraryContextFilter();
		treeFilter.setSearchText(".*");

		treeViewer.addFilter(treeFilter);

		TreeItem nullRoot = new TreeItem(treeViewer.getTree(), SWT.NONE);
		nullRoot.setText("Drag and drop EOL library root directory to view operations tree");

		newOperation = new Action() {
			public void run() {

				IStorage storage = new helpers.StringStorage("operation");
				IStorageEditorInput input = new helpers.StringInput(storage);
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

				if (page != null)
					try {
						page.openEditor(input, "editors.LocalEolEditor");

					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		};
		newOperation.setText("Add");
		newOperation.setToolTipText("Add new operation");
		newOperation.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));

		saveOperationsOnDB = new Action() {
			public void run() {

				try {
					EolModule eolM = new EolModule();

					eolM.parse(eol_file);

					eolAST = eolM.getAst();

					for (AST operation : AstUtil.getChildren(eolAST, 28)) {

						next_operation1:
						// if the operation is a threshold functions
						if (operation.getFirstChild().getText().startsWith("th_")) {

							List<Integer> th_id_list = Db.getall_Th_id();

							// check occurrences in the DB list of metric functions
							for (Integer id : th_id_list) {

								String th_name = Db.get_Th_name_byId(id);

								if (th_name.equals(operation.getFirstChild().getText())) {

									// if the name is the same
									String th_body = Db.get_Th_method_byId(id);
									eolM.parse(th_body);
									AST dbEOLast = eolM.getAst();

									AST dbOperation = AstUtil.getChild(dbEOLast, 28);

									// check that the signature is the same too
									if (compare(operation, dbOperation)) {

										// if the method has been changed, update it on DB
										if (!(th_body.equals(operation.rewrite()))) {
											Db.set_Th_method_byId(id, operation.rewrite());
											break next_operation1;
										} else {
											break next_operation1; // otherwise go on with the next operation in the eol
																	// file
										}

									}
									// if not go on inserting the new operation in the list

								}
							}

							// if 0 occurrences found insert the new operation in the list
							Db.insert_Threshold_function(operation.getFirstChild().getText(), operation.rewrite());

						}

						next_operation2:
						// if the operation is a metric functions
						if (operation.getSecondChild().getText().startsWith("F_")) {

							List<Integer> f_id_list = Db.getall_F_id();

							// check occurrences in the DB list of metric functions
							for (Integer id : f_id_list) {

								F_operation f = Db.get_F_description_byId(id);

								if (f.getName().equals(operation.getSecondChild().getText())) {

									// if the name is the same
									eolM.parse(f.getMethod());
									AST dbEOLast = eolM.getAst();

									AST dbOperation = AstUtil.getChild(dbEOLast, 28);

									// check that the signature is the same too
									if (compare(operation, dbOperation)) {

										// if the method has been changed, update it on DB
										if (!(f.getMethod().equals(operation.rewrite()))) {
											Db.set_F_method_byId(id, operation.rewrite());
											break next_operation2;
										} else {
											break next_operation2; // otherwise go on with the next operation in the eol
																	// file
										}

									}
									// if not go on inserting the new operation in the list

								}
							}

							// if 0 occurrences found insert the new operation in the list
							int return_bool = 0;

							if (operation.getThirdChild().getType() == EolParser.PARAMLIST) {
								// metodo con parametri
								if (operation.getFourthChild().getText().equals("Boolean"))
									return_bool = 1;

							} else {
								// semza parametri
								if (operation.getThirdChild().getText().equals("Boolean"))
									return_bool = 1;

							}

							Db.insert_Metric_function(operation.getFirstChild().getText(),
									operation.getSecondChild().getText(), operation.rewrite(), return_bool);

						}

						// if you are here the operation is a do_function
						List<Integer> Do_id_list = Db.getall_Do_id();

						next_operation3:
						// check occurrences in the DB list of metric functions
						for (Integer id : Do_id_list) {

							Do_operation redo = Db.get_Do_description_byId(id);

							if (redo.getName().equals(operation.getFirstChild().getText())) {

								// if the name is the same
								eolM.parse(redo.getMethod());
								AST dbEOLast = eolM.getAst();

								AST dbOperation = AstUtil.getChild(dbEOLast, 28);

								// check that the signature is the same too
								if (compare(operation, dbOperation)) {

									// if the method has been changed, update it on DB
									if (!(redo.getMethod().equals(operation.rewrite()))) {
										Db.set_Do_method_byId(id, operation.rewrite());
										break next_operation3;
									} else {
										break next_operation3; // otherwise go on with the next operation in the eol
																// file
									}

								}
								// if not go on inserting the new operation in the list

							}
						}

						Db.insert_Do_function(operation.getSecondChild().getText(), operation.getFirstChild().getText(),
								operation.rewrite());

					}
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
		saveOperationsOnDB.setText("Save");
		saveOperationsOnDB.setToolTipText("Save all operation in DB");
		saveOperationsOnDB.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEALL_EDIT));

		// IActionBars bars = getViewSite().getActionBars();
		// bars.getToolBarManager().add(newOperation);
		// bars.getToolBarManager().add(saveOperationsOnDB);

		// getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(listener);

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});

		doubleClickAction = new Action() {
			public void run() {

				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
				Object selected = selection.getFirstElement();

				String method = null;

				if (selected instanceof F_operation) {

					F_operation f = (F_operation) selected;
					method = f.getMethod();

				}

				if (selected instanceof Do_operation) {

					Do_operation redo = (Do_operation) selected;
					method = redo.getMethod();

				}

				if (selected instanceof Th_operation) {

					Th_operation th = (Th_operation) selected;
					method = th.getMethod();

				}

				IStorage storage = new helpers.StringStorage(method);
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

		ResourcesPlugin.getWorkspace().addResourceChangeListener(new workspaceChangeListener());

		// enable drag and drop of eol file
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		Transfer[] transferTypes = new Transfer[] { FileTransfer.getInstance() };
		treeViewer.addDropSupport(operations, transferTypes, new dropListener2(treeViewer));
	}

	/**
	 * This class provides the content for the tree in FileTree
	 */

	class EOLLibraryContentProvider implements ITreeContentProvider {

		private final Object[] EMPTY_ARRAY = new Object[0];

		/**
		 * Gets the root element(s) of the tree
		 * 
		 * @param arg0
		 *            the input data
		 * @return Object[]
		 */
		public Object[] getElements(Object inputElement) {
			// These are the root elements of the tree
			// We don't care what arg0 is, because we just want all
			// the root nodes in the file system
			if (inputElement instanceof List)
				return ((List) inputElement).toArray();
			else
				return EMPTY_ARRAY;

		}

		/**
		 * Returns whether the passed object has children
		 * 
		 * @param arg0
		 *            the parent object
		 * @return boolean
		 */
		public boolean hasChildren(Object element) {
			// Get the children
			if (element instanceof LibraryRoot || element instanceof Context2 || element instanceof Th_list
					|| element instanceof List) {
				return true;
			}

			return false;
		}

		/**
		 * Gets the children of the specified object
		 * 
		 * @param arg0
		 *            the parent object
		 * @return Object[]
		 */
		public Object[] getChildren(Object parentElement) {
			// Return the files and subdirectories in this directory

			if (parentElement instanceof LibraryRoot) {
				LibraryRoot box = (LibraryRoot) parentElement;
				Object[] result = new Object[2];
				result[0] = box.getListContexts();
				result[1] = box.getths();
				return result;
			}

			if (parentElement instanceof List) {
				List box = (List) parentElement;
				if (!box.isEmpty()) {
					if (box.get(0) instanceof Context2) {
						return box.toArray();
					}
					if (box.get(0) instanceof Th_operation) {
						return box.toArray();
					}
					if (box.get(0) instanceof F_operation) {
						return box.toArray();
					}
					if (box.get(0) instanceof Do_operation) {
						return box.toArray();
					}
				}

			}

			if (parentElement instanceof Context2) {
				Context2 box = (Context2) parentElement;
				Object[] result = new Object[2];
				result[0] = box.geteffe();
				result[1] = box.getdu();
				return result;
			}

			return EMPTY_ARRAY;
		}

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

	}

	public class EOLLibraryLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof LibraryRoot) {
				return ((LibraryRoot) element).getName();
			}
			if (element instanceof Context2) {
				return ((Context2) element).getName();
			}

			if (element instanceof List) {
				List box = (List) element;
				if (!box.isEmpty()) {
					if (box.get(0) instanceof Context2) {
						return "Contexts list";
					}
					if (box.get(0) instanceof Th_operation) {
						return "Thresholds list";
					}
					if (box.get(0) instanceof F_operation) {
						return "F";
					}
					if (box.get(0) instanceof Do_operation) {
						return "Do";
					}
				}

				return "___";
			}
			if (element instanceof F_operation) {
				return ((F_operation) element).getName();
			}
			if (element instanceof Do_operation) {
				return ((Do_operation) element).getName();
			}
			if (element instanceof Th_operation) {
				return ((Th_operation) element).getName();
			}
			return null;
		}
	}

	// IResource resource = event.getResource();
	//
	// if(resource.getFileExtension().equals("eol"))
	// {
	//
	// if (delta.getKind() == IResourceDelta.ADDED) {
	//
	// IPath newPath = delta.getProjectRelativePath();
	//
	// }
	//
	// IFolder f = (IFolder) resource.getParent();
	//
	// if (f.equals(folder)) {
	// // populate();
	// }
	// }
	//
	// }};

	// private ISelectionListener listener = new ISelectionListener() {
	// public void selectionChanged(IWorkbenchPart sourcepart, ISelection selection)
	// {
	//
	// if (sourcepart instanceof ProjectExplorer) {
	// showSelection(sourcepart, selection);
	// }
	// }
	// };
	//
	// public void showSelection(IWorkbenchPart sourcepart, ISelection selection) {
	//
	// if (selection instanceof IStructuredSelection & !selection.isEmpty()) {
	// Object selected = ((IStructuredSelection) selection).getFirstElement();
	//
	// if (selected instanceof IFolder) {
	// folder = (IFolder) Platform.getAdapterManager().getAdapter(selected,
	// IFolder.class);
	//
	// populate();
	// }
	//
	//
	//
	// }
	//
	// }

	/**
	 * 
	 */

	public File getSelectedEolfile() {
		return eol_file;
	}

	public void chooseF() {

		ISelection selects;
		Object itemSelected;

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		view.EVLtree evlview = (view.EVLtree) page.findView("view.EVLtree");

		selects = evlview.tree.getSelection();
		itemSelected = ((IStructuredSelection) selects).getFirstElement();

		Check checkItem = (Check) itemSelected;
		// TreeItem contextItem = invariantItem.getParentItem();
		// Context context = (Context) contextItem.getData();

		treeFilter.setSearchText(checkItem.getContext().getName());
		treeFilter.setOperationType("F");

		treeViewer.setInput(listOfLibraries);
		treeViewer.expandAll();
		treeViewer.refresh(listOfLibraries, false);

		hookContextMenu(evlview, checkItem);

	}

	public void populate(String path) {

		this.path = path;
		AST eolAST;

//		if (changed.size() > 0) {
//			for (IResource r : changed) {
//
//				File eol_file = r.getFullPath().toFile();
//				EolModule eolM = new EolModule();
//
//				try {
//					eolM.parse(eol_file);
//
//					eolAST = eolM.getAst();
//					
//					Th_operation[] ths= (Th_operation[]) thresholds.toArray();
//					
//					for (AST operation : AstUtil.getChildren(eolAST, 28)) {
//						
//						for (Th_operation t : thresholds) {
//							if (t.getEol_file().equals(eol_file.getCanonicalPath())) {
//								
//							}
//						}
//						
//					}
//					
//
//					TreePath[] treePaths = treeViewer.getExpandedTreePaths();
//					treeViewer.refresh();
//					treeViewer.setExpandedTreePaths(treePaths);
//
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		} else {
			contexts.clear();
			thresholds.clear();
			try {

				Collection<File> allEols = FileUtils.listFiles(new File(path), new String[] { "eol" }, true);

				for (File eol_file : allEols) {
					EolModule eolM = new EolModule();

					eolM.parse(eol_file);

					eolAST = eolM.getAst();

					for (AST operation : AstUtil.getChildren(eolAST, 28)) {

						// threshold functions
						if (operation.getFirstChild().getText().startsWith("th_")) {

							thresholds.add(new Th_operation(operation.getFirstChild().getText(), operation.rewrite(),
									eol_file.getCanonicalPath()));
							continue;
						}

						// metric functions
						if (operation.getSecondChild().getText().startsWith("F_")) {

							boolean found = false;
							for (Context2 c : contexts) {
								if (operation.getFirstChild().getText().equals(c.getName())) {
									c.geteffe()
											.add(new F_operation(operation.getSecondChild().getText(),
													operation.getFirstChild().getText(), operation.rewrite(),
													eol_file.getCanonicalPath()));
									found = true;
								}
							}

							if (!found) {
								Context2 nuovo = new Context2();
								nuovo.setName(operation.getFirstChild().getText());
								List<F_operation> nuovoeffe = new ArrayList<F_operation>();
								nuovoeffe.add(new F_operation(operation.getSecondChild().getText(),
										operation.getFirstChild().getText(), operation.rewrite(),
										eol_file.getCanonicalPath()));
								nuovo.seteffe(nuovoeffe);
								contexts.add(nuovo);
							}

							continue;
						}

						// do_function
						boolean found = false;
						for (Context2 c : contexts) {
							if (operation.getFirstChild().getText().equals(c.getName())) {
								c.getdu()
										.add(new Do_operation(operation.getSecondChild().getText(),
												operation.getFirstChild().getText(), operation.rewrite(),
												eol_file.getCanonicalPath()));
								found = true;
							}
						}

						if (!found) {
							Context2 nuovo = new Context2();
							nuovo.setName(operation.getFirstChild().getText());
							List<Do_operation> nuovodu = new ArrayList<Do_operation>();
							nuovodu.add(new Do_operation(operation.getSecondChild().getText(),
									operation.getFirstChild().getText(), operation.rewrite(),
									eol_file.getCanonicalPath()));
							nuovo.setdu(nuovodu);
							contexts.add(nuovo);
						}

					}

				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				// eolcode.setText("No library selected");
			}

			listOfLibraries = new ArrayList<LibraryRoot>();
			LibraryRoot root = new LibraryRoot(contexts, thresholds, "library 1");
			listOfLibraries.add(root);

			treeFilter.setSearchText(".*");
			treeFilter.setOperationType(".*");
			
			treeViewer.setInput(listOfLibraries);

			treeViewer.setExpandedState(listOfLibraries, true);
			treeViewer.setExpandedState(root, true);

			// tree.setFilters(contextFilter);

			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			view.EVLtree evlview = (view.EVLtree) page.findView("view.EVLtree");

			evlview.setcontexts();

			// evlview.nullRoot.setText("To start building EVL choose a context from the
			// arrow menu");
			// }
		}

//	}

	public void chooseDo() {

		ISelection selects;
		Object itemSelected;

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		view.EVLtree evlview = (view.EVLtree) page.findView("view.EVLtree");

		selects = evlview.tree.getSelection();
		itemSelected = ((IStructuredSelection) selects).getFirstElement();

		Do doItem = (Do) itemSelected;
		// TreeItem invariant = fixItem.getParentItem();
		// TreeItem context = invariant.getParentItem();
		// Context cont = (Context) context.getData();

		Context cont = doItem.getContext();

		treeFilter.setSearchText(cont.getName());
		treeFilter.setOperationType("Do");

		treeViewer.setInput(listOfLibraries);
		treeViewer.expandAll();
		treeViewer.refresh(listOfLibraries, false);

		hookContextMenu(evlview, doItem);

	}

	private void hookContextMenu(view.EVLtree evlview, Check check) {

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
				if (treeViewer.getSelection().isEmpty()) {
					return;
				}

				if (treeViewer.getSelection() instanceof IStructuredSelection) {

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
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, treeViewer);
	}

	private void generalAction(view.EVLtree evlview, Check check, int comb) {

		IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
		Object selected = selection.getFirstElement();

		if (selected instanceof F_operation) {
			F_operation f;

			f = (F_operation) selected;

			Predicate pred;
			Operation operation = null;

			switch (comb) {
			case 0:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);

				operation = new Operation(GuardOperator.EMPTY, pred);

				break;
			case 1:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);

				operation = new Operation(GuardOperator.EMPTY, pred);

				break;
			case 2:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);

				operation = new Operation(GuardOperator.AND, pred);

				break;
			case 3:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);

				operation = new Operation(GuardOperator.OR, pred);

				break;
			case 4:
				pred = new UnaryPredicate(UnaryOperator.EMPTY, f);

				operation = new Operation(GuardOperator.XOR, pred);

				break;
			case 5:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);

				operation = new Operation(GuardOperator.AND, pred);

				break;
			case 6:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);

				operation = new Operation(GuardOperator.OR, pred);

				break;
			case 7:
				pred = new UnaryPredicate(UnaryOperator.NOT, f);

				operation = new Operation(GuardOperator.XOR, pred);

				break;
			}

			check.getOperations().add(operation);

			String importFile = f.getEol_file();

			List<ImportStatement> iList = evlview.evl.getImportList();

			if (iList.isEmpty()) {
				ImportStatement newImp = new ImportStatement(importFile);
				iList.add(newImp);
				evlview.evl.setImportList(iList);
			} else {
				boolean flag = false;

				for (Object i : iList.toArray()) {
					ImportStatement oldImp = (ImportStatement) i;
					if (oldImp.getText().equals(importFile)) {
						flag = true;
						break;
					} else {
						flag = false;
						continue;
					}
				}

				if (!flag) {
					ImportStatement newImp = new ImportStatement(importFile);
					iList.add(newImp);
					evlview.evl.setImportList(iList);
				}

			}

			// evlview.tree.getTree().removeAll();
			//
			// new fillTreeModel(evlview.tree.getTree(), evlview.evl).fill();
			Object[] o = evlview.tree.getExpandedElements();
			evlview.tree.setInput(evlview.evl);
			evlview.tree.setExpandedElements(o);
			evlview.tree.setExpandedState(check, true);
		}

	}

	private void hookContextMenu(view.EVLtree evlview, Do d) {

		Action set_Redo_Operation = new Action() {
			public void run() {

				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
				Object selected = selection.getFirstElement();

				if (selected instanceof Do_operation) {
					Do_operation redo;

					redo = (Do_operation) selected;

					List<String> list = d.getFunctions();

					list.add(redo.getName());
					d.setFunctions(list);

					String importFile = redo.getEol_file();

					List<ImportStatement> iList = evlview.evl.getImportList();

					if (iList.isEmpty()) {
						ImportStatement newImp = new ImportStatement(importFile);
						iList.add(newImp);
						evlview.evl.setImportList(iList);
					} else {
						boolean flag = false;

						for (Object i : iList.toArray()) {
							ImportStatement oldImp = (ImportStatement) i;
							if (oldImp.getText().equals(importFile)) {
								flag = true;
								break;
							} else {
								continue;
							}

						}

						if (!flag) {
							ImportStatement newImp = new ImportStatement(importFile);
							iList.add(newImp);
							evlview.evl.setImportList(iList);
						}

					}

					// evlview.tree.getTree().removeAll();
					//
					// new fillTreeModel(evlview.tree.getTree(), evlview.evl).fill();

					Object[] o = evlview.tree.getExpandedElements();
					evlview.tree.setInput(evlview.evl);
					evlview.tree.setExpandedElements(o);
					evlview.tree.setExpandedState(d, true);
				}

			}
		};
		set_Redo_Operation.setText("Add to EVL tree");
		set_Redo_Operation.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				if (treeViewer.getSelection().isEmpty()) {
					return;
				}

				if (treeViewer.getSelection() instanceof IStructuredSelection) {

					manager.add(set_Redo_Operation);

				}
			}
		});
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, treeViewer);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public boolean compare(AST oldOp, AST newOp) {

		String firstold = oldOp.getFirstChild().getText();
		String firstnew = newOp.getFirstChild().getText();
		String secondold = oldOp.getSecondChild().getText();
		String secondnew = newOp.getSecondChild().getText();
		String thirdold = oldOp.getThirdChild().getText();
		String thirdnew = newOp.getThirdChild().getText();

		if (oldOp.getFourthChild() != null && newOp.getFourthChild() != null) {
			String fourold = oldOp.getFourthChild().getText();
			String fournew = newOp.getFourthChild().getText();

			if (firstold.equals(firstnew) && secondold.equals(secondnew) && thirdold.equals(thirdnew)
					&& fourold.equals(fournew))
				return true;
			else
				return false;
		}

		if (oldOp.getFourthChild() == null && newOp.getFourthChild() == null) {
			if (firstold.equals(firstnew) && secondold.equals(secondnew) && thirdold.equals(thirdnew))
				return true;
			else
				return false;
		}

		return false;
	}

}
