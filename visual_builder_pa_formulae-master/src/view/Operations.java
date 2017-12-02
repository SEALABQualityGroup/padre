package view;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.jface.action.Action;
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
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.part.ViewPart;

import model.Db;
import model.Do_operation;
import model.F_operation;
import model.Th_operation;

public class Operations extends ViewPart {

	AST eolAST;
	public TableViewer tableViewer;
	public List<AST> ops;
	private Action newOperation, doubleClickAction, saveOperationsOnDB;
	private File eol_file;

	public Operations() {
		// TODO Auto-generated constructor stub

		ops = new ArrayList<AST>();
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub

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

							//check occurrences in the DB list of metric functions
							for (Integer id : th_id_list) {

								String th_name = Db.get_Th_name_byId(id);
								
								if (th_name.equals(operation.getFirstChild().getText())) {
									
									//if the name is the same
									String th_body = Db.get_Th_method_byId(id);
									eolM.parse(th_body);
									AST dbEOLast = eolM.getAst();
									
									AST dbOperation = AstUtil.getChild(dbEOLast, 28);
									
									//check that the signature is the same too
									if (compare(operation, dbOperation)) {
										
										//if the method has been changed, update it on DB
										if (!(th_body.equals(operation.rewrite()))) {
											Db.set_Th_method_byId(id, operation.rewrite());
											break next_operation1;
										} else {
											break next_operation1; //otherwise go on with the next operation in the eol file
										}
										
										
									}
									//if not go on inserting the new operation in the list
									
								}
							}
							
							//if 0 occurrences found insert the new operation in the list
							Db.insert_Threshold_function(operation.getFirstChild().getText(), operation.rewrite());

							
						}
						
						next_operation2:
						// if the operation is a metric functions
						if (operation.getSecondChild().getText().startsWith("F_")) {
							
							
							List<Integer> f_id_list = Db.getall_F_id();

							//check occurrences in the DB list of metric functions
							for (Integer id : f_id_list) {

								F_operation f = Db.get_F_description_byId(id);
								
								if (f.getName().equals(operation.getSecondChild().getText())) {
									
									//if the name is the same
									eolM.parse(f.getMethod());
									AST dbEOLast = eolM.getAst();
									
									AST dbOperation = AstUtil.getChild(dbEOLast, 28);
									
									//check that the signature is the same too
									if (compare(operation, dbOperation)) {
										
										//if the method has been changed, update it on DB
										if (!(f.getMethod().equals(operation.rewrite()))) {
											Db.set_F_method_byId(id, operation.rewrite());
											break next_operation2;
										} else {
											break next_operation2; //otherwise go on with the next operation in the eol file
										}
										
										
									}
									//if not go on inserting the new operation in the list
									
								}
							}
							
							//if 0 occurrences found insert the new operation in the list
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
						//check occurrences in the DB list of metric functions
						for (Integer id : Do_id_list) {

							Do_operation redo = Db.get_Do_description_byId(id);
							
							if (redo.getName().equals(operation.getFirstChild().getText())) {
								
								//if the name is the same
								eolM.parse(redo.getMethod());
								AST dbEOLast = eolM.getAst();
								
								AST dbOperation = AstUtil.getChild(dbEOLast, 28);
								
								//check that the signature is the same too
								if (compare(operation, dbOperation)) {
									
									//if the method has been changed, update it on DB
									if (!(redo.getMethod().equals(operation.rewrite()))) {
										Db.set_Do_method_byId(id, operation.rewrite());
										break next_operation3;
									} else {
										break next_operation3; //otherwise go on with the next operation in the eol file
									}
									
									
								}
								//if not go on inserting the new operation in the list
								
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

		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(newOperation);
		bars.getToolBarManager().add(saveOperationsOnDB);

		doubleClickAction = new Action() {
			public void run() {

				int index = tableViewer.getTable().getSelectionIndex();

				AST selected_op = ops.get(index);

				String f_method = null;

				f_method = selected_op.rewrite();

				IStorage storage = new helpers.StringStorage(f_method);
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

		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});

		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(listener);

	}

	private ISelectionListener listener = new ISelectionListener() {
		public void selectionChanged(IWorkbenchPart sourcepart, ISelection selection) {

			if (sourcepart instanceof ProjectExplorer) {
				showSelection(sourcepart, selection);
			}
		}
	};

	public void showSelection(IWorkbenchPart sourcepart, ISelection selection) {

		if (selection instanceof IStructuredSelection & !selection.isEmpty()) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();

			IFile file = (IFile) Platform.getAdapterManager().getAdapter(selected, IFile.class);

			if (file != null) {
				try {

					IPath location = file.getLocation();

					if (location.getFileExtension().equals("eol")) {
						eol_file = location.toFile();

						EolModule eolM = new EolModule();

						eolM.parse(eol_file);

						eolAST = eolM.getAst();

						tableViewer.setInput(null);
						ops.clear();

						List<String[]> items = new ArrayList<String[]>();

						for (AST operation : AstUtil.getChildren(eolAST, 28)) {

							if (operation.getFirstChild().getText().startsWith("th_")) {
								items.add(new String[] { operation.getFirstChild().getText(), "" });

								ops.add(operation);
							} else {
								items.add(new String[] { operation.getSecondChild().getText(),
										operation.getFirstChild().getText() });

								ops.add(operation);
							}

						}

						tableViewer.setInput(items);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					// eolcode.setText("No library selected");
				}
			}

		}

	}

	public File getSelectedEolfile() {
		return eol_file;
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
