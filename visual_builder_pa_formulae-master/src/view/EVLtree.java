package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import dialogs.MyTitleAreaDialogCrit;
import dialogs.MyTitleAreaDialogCCName;
import dialogs.MyTitleAreaDialogFixTitle;
import dialogs.MyTitleAreaDialogMessage;
import helpers.fillTreeModel;
import it.spe.disim.univaq.porting.evl2exl.Evl2Epl;
import it.spe.disim.univaq.porting.evl2exl.Evl2Ewl;
import it.spe.disim.univaq.porting.util.PortingUtil;
import listeners.dropListener;
import model.Check;
import model.Constraint;
import model.Container;
import model.Context;
import model.Critique;
import model.Db;
import model.Do;
import model.Evl;
import model.F_operation;
import model.Fix;
import model.GuardOperator;
import model.Message;
import model.Operation;
import model.Title;
import plugin.handlers.ProjectManagment;

public class EVLtree extends ViewPart {

	public Evl evl;
	public TreeViewer tree;
	Tree rawtree;
	private Action addCritiqueAction, addConstraintAction, setCheck, addMessage, addFix, setFixTitle, chooseFoperations, chooseDOoperations, saveEVL, saveEPL, saveEWL, saveXMLaction, importXMLaction;
	URL fullPathString;
	IActionBars bars;

	public EVLtree() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Bundle bundle = Platform.getBundle("it.spe.disim.univaq.it.plugin");
		bars = getViewSite().getActionBars();

		// tree for representing the evl file hierarchy
		rawtree = new Tree(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);

		// evl object
		evl = new Evl();
		rawtree.setData(evl);

		tree = new TreeViewer(rawtree);
		

		Action action1 = new Action() {
			public void run() {

				setcontexts();

			}
		};
		action1.setText("Refresh");
		action1.setToolTipText("Refresh list");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
		bars.getMenuManager().add(action1);
		setcontexts();
		
		
		importXMLaction = new Action() {
			public void run() {
				FileDialog dlg = new FileDialog(tree.getControl().getShell());
				dlg.setText("Open Project...");
				dlg.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
				String[] filterExt = { "*.xml" };
				dlg.setFilterExtensions(filterExt);
				String dir = dlg.open();

				try {

					Evl imported = new Evl();
					imported = ProjectManagment.Open(dir);
					evl.setImportList(imported.getImportList());
					evl.setContextList(imported.getContextList());

				} catch (FileNotFoundException | JAXBException e1) {
					// TODO Auto-generated catch block
					 e1.printStackTrace();

				}

				rawtree.removeAll();
				new fillTreeModel(rawtree, evl).fill();
				
			}
		};
		importXMLaction.setText("Save");
		importXMLaction.setToolTipText("Import tree from XML");
		importXMLaction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_PROJECT));
		
		
		saveXMLaction = new Action() {
			public void run() {
				
				FileDialog dialog = new FileDialog(tree.getControl().getShell(), SWT.SAVE);
				dialog.setFilterNames(new String[] { "Xml Files (*.*xml)" });
				dialog.setFilterExtensions(new String[] { "*.xml" }); 
				dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
				dialog.setFileName("");
				String dir = dialog.open();
				try {
					File evl_file = new File(dir);
					ProjectManagment.Save(evl, evl_file);
				} catch (JAXBException e1) {
					// TODO Auto-generated catch block
					 e1.printStackTrace();

				}

			}
		};
		saveXMLaction.setText("Save");
		saveXMLaction.setToolTipText("Save tree as XML");
		saveXMLaction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));
		
		
		saveEVL = new Action() {
			public void run() {

				FileDialog dialog = new FileDialog(tree.getControl().getShell(), SWT.SAVE);
				dialog.setText("Save EVL code...");
				dialog.setFilterNames(new String[] { "All Files (*.evl)" });
				dialog.setFilterExtensions(new String[] { "*.evl" });
				dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
				dialog.setFileName("");
				String dir = dialog.open();
				File file;
				if (dir != null) {
					file = new File(dir);
				} else {
					return;
				}

				try {

					FileWriter fw;
					fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(evl.toString());
					bw.flush();
					bw.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					 e1.printStackTrace();
				}

			}
		};
		saveEVL.setText("Save");
		saveEVL.setToolTipText("Save EVL");
		saveEVL.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		
		saveEPL = new Action() {
			public void run() {
				
				File epl_file;
				
				FileDialog dialog = new FileDialog(tree.getControl().getShell(), SWT.SAVE);
				dialog.setText("Save EPL code...");
				dialog.setFilterNames(new String[] { "All Files (*.epl)" });
				dialog.setFilterExtensions(new String[] { "*.epl" }); 
				dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
				dialog.setFileName("");
				String dir = dialog.open();
				if (dir != null)
				{
					epl_file = new File(dir);
				}
				else
				{
					return;
				}
				
				try {
					
					EvlModule evlM = new EvlModule();
					evlM.parse(evl.toString());
					AST evlAST = evlM.getAst();
					AST eplASTGen = Evl2Epl.evl2epl(evlAST);
					PortingUtil.ast2file(eplASTGen, epl_file);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					 e1.printStackTrace();
				}
			}
		};
		saveEPL.setText("Save");
		saveEPL.setToolTipText("Save EPL");
		saveEPL.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));
		
		saveEWL = new Action() {
			public void run() {

				File ewl_file;
				
				FileDialog dialog = new FileDialog(tree.getControl().getShell(), SWT.SAVE);
				dialog.setText("Save EWL code...");
				dialog.setFilterNames(new String[] { "All Files (*.ewl)" });
				dialog.setFilterExtensions(new String[] { "*.ewl" }); 
				dialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
				dialog.setFileName("");
				String dir = dialog.open();
				if (dir != null)
				{
					ewl_file = new File(dir);
				}
				else
				{
					return;
				}
				
				try {
					
					EvlModule evlM = new EvlModule();
					evlM.parse(evl.toString());
					AST evlAST = evlM.getAst();
					AST ewlASTGen = Evl2Ewl.evl2ewl(evlAST);
					PortingUtil.ast2file(ewlASTGen, ewl_file);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					 e1.printStackTrace();
				}

			}
		};
		saveEWL.setText("Save");
		saveEWL.setToolTipText("Save EWL");
		saveEWL.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));

		IActionBars bars = getViewSite().getActionBars();
		bars.getToolBarManager().add(saveEVL);
		bars.getToolBarManager().add(saveEPL);
		bars.getToolBarManager().add(saveEWL);
		bars.getToolBarManager().add(saveXMLaction);
		bars.getToolBarManager().add(importXMLaction);
		
		chooseDOoperations = new Action() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				view.Do_OperationsOnDB Do_DB_view = (view.Do_OperationsOnDB) page.findView("view.Do_OperationsOnDB");
				Do_DB_view.chooseDo();
			}
		};
		chooseDOoperations.setText("Choose DO from DB");
		chooseDOoperations.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		chooseFoperations = new Action() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				view.F_OperationsOnDB F_DB_view = (view.F_OperationsOnDB) page.findView("view.F_OperationsOnDB");
				F_DB_view.chooseF();
			}
		};
		chooseFoperations.setText("Choose F from DB");
		chooseFoperations.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		setFixTitle = new Action() {
			public void run() {
				TreeItem[] selected = rawtree.getSelection();
				TreeItem temp = selected[0];

				Fix fixSelected = (Fix) temp.getData();
				String title = "";
				MyTitleAreaDialogFixTitle fixTitleDialog = new MyTitleAreaDialogFixTitle(tree.getControl().getShell());
				fixTitleDialog.create();
				if (fixTitleDialog.open() == Window.OK) {
					title = fixTitleDialog.getName();

				} else {
					return;
				}
				Title titleNew = new Title(title);
				fixSelected.setTitle(titleNew);

				rawtree.removeAll();
				rawtree.setData(evl);
				new fillTreeModel(rawtree, evl).fill();
			}
		};
		setFixTitle.setText("Set fix title");
		setFixTitle.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		setCheck = new Action() {
			public void run() {
				TreeItem[] selected = rawtree.getSelection();
				TreeItem temp = selected[0];
				TreeItem parent = temp.getParentItem();
				Context contParent = (Context) parent.getData();
				Container cSelected = (Container) temp.getData();

				Check checkNew = new Check();
				// cSelected.setCheck(checkNew);
				for (Context c : evl.getContextList()) {
					if (c.equals(contParent)) {
						for (Container container : c.getContainers()) {
							if (container.equals(cSelected)) {
								container.setCheck(checkNew);
							}
						}
					}
				}
				// evl.setCheckToContainer(cSelected.getParent(),
				// cSelected, checkNew);

				rawtree.removeAll();
				rawtree.setData(evl);
				new fillTreeModel(rawtree, evl).fill();
			}
		};
		setCheck.setText("Set check");
		setCheck.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		addMessage = new Action() {
			public void run() {
				TreeItem[] selected = rawtree.getSelection();
				TreeItem temp = selected[0];
				TreeItem parent = temp.getParentItem();
				Context contParent = (Context) parent.getData();
				Container cSelected = (Container) temp.getData();

				String txtMsg = "";
				MyTitleAreaDialogMessage dialogMessage = new MyTitleAreaDialogMessage(tree.getControl().getShell());
				dialogMessage.create();
				if (dialogMessage.open() == Window.OK) {
					txtMsg = dialogMessage.getName();

				} else {
					return;
				}

				Message msg = new Message(txtMsg);
				for (Context c : evl.getContextList()) {
					if (c.equals(contParent)) {
						for (Container container : c.getContainers()) {
							if (container.equals(cSelected)) {
								container.setMessage(msg);
							}
						}
					}
				}
				// evl.setCMessage(cSelected.getParent(), cSelected,
				// msg);

				rawtree.removeAll();
				rawtree.setData(evl);
				new fillTreeModel(rawtree, evl).fill();
			}
		};
		addMessage.setText("Add message");
		addMessage.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		addFix = new Action() {
			public void run() {
				TreeItem[] selected = rawtree.getSelection();
				TreeItem temp = selected[0];
				TreeItem parent = temp.getParentItem();
				Container cSelected = (Container) temp.getData();
				Context contextParent = (Context) parent.getData();
				Fix fixNew = new Fix();
				List<Fix> fixList = cSelected.getFixList();
				fixList.add(fixNew);
				// cSelected.setFixList(fixList);
				for (Context c : evl.getContextList()) {
					if (c.equals(contextParent)) {
						for (Container container : c.getContainers()) {
							if (container.equals(cSelected)) {
								container.setFixList(fixList);
							}
						}
					}
				}

				// evl.addFix2C(cSelected.getParent(), cSelected,
				// fixNew);

				rawtree.removeAll();
				rawtree.setData(evl);
				new fillTreeModel(rawtree, evl).fill();
			}
		};
		addFix.setText("Add fix");
		fullPathString = bundle.getEntry("icons/fix.gif");
		addFix.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

		addCritiqueAction = new Action() {
			public void run() {
				String critiqueName = "";
				MyTitleAreaDialogCCName dialog2 = new MyTitleAreaDialogCCName(tree.getControl().getShell());
				dialog2.create();
				if (dialog2.open() == Window.OK) {
					critiqueName = dialog2.getName();

				} else {
					return;
				}
				
				TreeItem[] selected = rawtree.getSelection();
				TreeItem temp = selected[0];
				Context contToAddParent = (Context) temp.getData();
				tree.getTree().removeAll();
				Container cont2add = null;
				cont2add = new Critique(critiqueName);

				for (Context c : evl.getContextList()) {
					if (c.equals(contToAddParent)) {
						List<Container> tempContainerList = c.getContainers();
						tempContainerList.add(cont2add);
						c.setContainer(tempContainerList);
					}
				}
				new fillTreeModel(rawtree, evl).fill();
			}
		};
		addCritiqueAction.setText("Add critique");
		fullPathString = bundle.getEntry("icons/critique.gif");
		addCritiqueAction.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));
		
		addConstraintAction = new Action() {
			public void run() {
				String constraintName = "";
				MyTitleAreaDialogCCName dialog2 = new MyTitleAreaDialogCCName(tree.getControl().getShell());
				dialog2.create();
				if (dialog2.open() == Window.OK) {
					constraintName = dialog2.getName();

				} else {
					return;
				}
				
				TreeItem[] selected = rawtree.getSelection();
				TreeItem temp = selected[0];
				Context contToAddParent = (Context) temp.getData();
				tree.getTree().removeAll();
				Container cont2add = null;
				cont2add = new Constraint(constraintName);

				for (Context c : evl.getContextList()) {
					if (c.equals(contToAddParent)) {
						List<Container> tempContainerList = c.getContainers();
						tempContainerList.add(cont2add);
						c.setContainer(tempContainerList);
					}
				}
				new fillTreeModel(rawtree, evl).fill();
			}
		};
		addConstraintAction.setText("Add constraint");
		fullPathString = bundle.getEntry("icons/constraint.gif");
		addConstraintAction.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

		
		
		hookContextMenu();
		
		getSite().setSelectionProvider(tree);
		
		//enable drag and drop of eol file
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		Transfer[] transferTypes = new Transfer[]{FileTransfer.getInstance()};
        tree.addDropSupport(operations, transferTypes, new dropListener(tree, evl));

	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				if (tree.getSelection().isEmpty()) {
					return;
				}

				if (tree.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) tree.getSelection();
					Object s = selection.getFirstElement();
					
					if (s instanceof Context) {
						manager.add(addConstraintAction);
						manager.add(addCritiqueAction);
					}
					
					if (s instanceof Constraint | s instanceof Critique) {
						manager.add(setCheck);
						manager.add(addMessage);
						manager.add(addFix);
					}
					
					if (s instanceof Fix) {
						manager.add(setFixTitle);
					}
					
					if (s instanceof Check) {
						manager.add(chooseFoperations);
					}
					
					if (s instanceof Do) {
						manager.add(chooseDOoperations);
					}
				}
			}
		});
		Menu menu = menuMgr.createContextMenu(tree.getControl());
		tree.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, tree);
	}

//	private void showMessage(String message) {
//		MessageDialog.openInformation(tree.getControl().getShell(), "Sample View", message);
//	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void setcontexts() {
		try { // Adding contexts to pull down menu
			for (String s : Db.getContexts()) {

				Action action1 = new Action() {
					public void run() {

						rawtree.removeAll();

						Context cNew = new Context(s);
						List<Context> cList = evl.getContextList();
						cList.add(cNew);
						evl.setContextList(cList);
						// evl.addContext(cNew);

						new fillTreeModel(rawtree, evl).fill();

					}
				};
				action1.setText(s);
				action1.setToolTipText("Add to tree");
				Bundle bundle = Platform.getBundle("it.spe.disim.univaq.it.plugin");
				fullPathString = bundle.getEntry("icons/context.gif");
				action1.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

				
				bars.getMenuManager().add(action1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
