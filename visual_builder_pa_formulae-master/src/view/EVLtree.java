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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
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
import model.Context2;
import model.Critique;
import model.Db;
import model.Do;
import model.Do_operation;
import model.Evl;
import model.F_operation;
import model.Fix;
import model.GuardOperator;
import model.ImportStatement;
import model.LibraryRoot;
import model.Message;
import model.Operation;
import model.Th_list;
import model.Th_operation;
import model.Title;
import plugin.handlers.ProjectManagment;
import view.EOL_Library_Tree.EOLLibraryContentProvider;
import view.EOL_Library_Tree.EOLLibraryLabelProvider;

public class EVLtree extends ViewPart {

	public Evl evl;
	public TreeViewer tree;
	private Action addCritiqueAction, addConstraintAction, setCheck, addMessage, addFix, setFixTitle, chooseFoperations,
			chooseDOoperations, saveEVL, saveEPL, saveEWL, saveXMLaction, importXMLaction;
	URL fullPathString;
	IActionBars bars;
	
	public TreeItem nullRoot;

	public EVLtree() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Bundle bundle = Platform.getBundle("it.spe.disim.univaq.it.plugin");
		bars = getViewSite().getActionBars();

//		nullRoot = new TreeItem(rawtree, SWT.NONE);
//		nullRoot.setText("Select EOL library root directory to start building EVL");

		evl = new Evl();

		tree = new TreeViewer(parent);
		tree.setContentProvider(new EVLContentProvider());
		tree.setLabelProvider(new EVLLabelProvider());
		
//		Action action1 = new Action() {
//			public void run() {
//
//				setcontexts();
//
//			}
//		};
//		action1.setText("Refresh");
//		action1.setToolTipText("Refresh list");
//		action1.setImageDescriptor(
//				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
//		bars.getMenuManager().add(action1);
//		setcontexts();

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

//				rawtree.removeAll();
//				new fillTreeModel(rawtree, evl).fill();
				
				tree.setInput(evl);

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
				if (dir != null) {
					epl_file = new File(dir);
				} else {
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
				if (dir != null) {
					ewl_file = new File(dir);
				} else {
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
				view.EOL_Library_Tree Do_tree_view = (view.EOL_Library_Tree) page.findView("view.EOL_Library_Tree");
				Do_tree_view.chooseDo();
			}
		};
		chooseDOoperations.setText("Choose DO");
		chooseDOoperations.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		chooseFoperations = new Action() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				view.EOL_Library_Tree F_tree_view = (view.EOL_Library_Tree) page.findView("view.EOL_Library_Tree");
				F_tree_view.chooseF();
			}
		};
		chooseFoperations.setText("Choose F");
		chooseFoperations.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		setFixTitle = new Action() {
			public void run() {
				ISelection selected = tree.getSelection();
				Object selectedElement = ((IStructuredSelection) selected).getFirstElement();

				Fix fixSelected = (Fix) selectedElement;
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

				Object[] ex = tree.getExpandedElements();
				tree.setInput(evl);
				tree.setExpandedElements(ex);
				tree.setExpandedState(fixSelected, true);
			}
		};
		setFixTitle.setText("Set fix title");
		setFixTitle.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		setCheck = new Action() {
			public void run() {
				ISelection selected = tree.getSelection();
				Object selectedElement = ((IStructuredSelection) selected).getFirstElement();
				
				Container containerSelected = (Container) selectedElement;
				Context contParent = (Context) containerSelected.getContext();

				Check checkNew = new Check(contParent);

				for (Context c : evl.getContextList()) {
					if (c.equals(contParent)) {
						for (Container container : c.getContainers()) {
							if (container.equals(containerSelected)) {
								container.setCheck(checkNew);
							}
						}
					}
				}

				Object[] ex = tree.getExpandedElements();
				tree.setInput(evl);
				tree.setExpandedElements(ex);
				tree.setExpandedState(containerSelected, true);
			}
		};
		setCheck.setText("Set check");
		setCheck.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		addMessage = new Action() {
			public void run() {
				ISelection selected = tree.getSelection();
				Object selectedElement = ((IStructuredSelection) selected).getFirstElement();
				
				Container containerSelected = (Container) selectedElement;
				Context contParent = (Context) containerSelected.getContext();

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
							if (container.equals(containerSelected)) {
								container.setMessage(msg);
							}
						}
					}
				}
				
				Object[] ex = tree.getExpandedElements();
				tree.setInput(evl);
				tree.setExpandedElements(ex);
				tree.setExpandedState(containerSelected, true);
			}
		};
		addMessage.setText("Add message");
		addMessage.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		addFix = new Action() {
			public void run() {
				ISelection selected = tree.getSelection();
				Object selectedElement = ((IStructuredSelection) selected).getFirstElement();
				
				Container containerSelected = (Container) selectedElement;
				Context contextParent = (Context) containerSelected.getContext();
				
				Fix fixNew = new Fix(contextParent);
				List<Fix> fixList = containerSelected.getFixList();
				fixList.add(fixNew);

				for (Context c : evl.getContextList()) {
					if (c.equals(contextParent)) {
						for (Container container : c.getContainers()) {
							if (container.equals(containerSelected)) {
								container.setFixList(fixList);
							}
						}
					}
				}

				Object[] ex = tree.getExpandedElements();
				tree.setInput(evl);
				tree.setExpandedElements(ex);
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

				ISelection selected = tree.getSelection();
				Object selectedElement = ((IStructuredSelection) selected).getFirstElement();
				Context contToAddParent = (Context) selectedElement;

				Container cont2add = null;
				cont2add = new Critique(contToAddParent, critiqueName);

				for (Context c : evl.getContextList()) {
					if (c.equals(contToAddParent)) {
						List<Container> tempContainerList = c.getContainers();
						tempContainerList.add(cont2add);
						c.setContainer(tempContainerList);
					}
				}

				Object[] ex = tree.getExpandedElements();
				tree.setInput(evl);
				tree.setExpandedElements(ex);
				tree.setExpandedState(contToAddParent, true);
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

				ISelection selected = tree.getSelection();
				Object selectedElement = ((IStructuredSelection) selected).getFirstElement();
				Context contToAddParent = (Context) selectedElement;

				Container cont2add = null;
				cont2add = new Constraint(contToAddParent, constraintName);

				for (Context c : evl.getContextList()) {
					if (c.equals(contToAddParent)) {
						List<Container> tempContainerList = c.getContainers();
						tempContainerList.add(cont2add);
						c.setContainer(tempContainerList);
					}
				}
				
				Object[] ex = tree.getExpandedElements();
				tree.setInput(evl);
				tree.setExpandedElements(ex);
				tree.setExpandedState(contToAddParent, true);
			}
		};
		addConstraintAction.setText("Add constraint");
		fullPathString = bundle.getEntry("icons/constraint.gif");
		addConstraintAction.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

		//hookContextMenu();

		getSite().setSelectionProvider(tree);

		// enable drag and drop of eol file
//		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
//		Transfer[] transferTypes = new Transfer[] { FileTransfer.getInstance() };
//		tree.addDropSupport(operations, transferTypes, new dropListener(tree, evl));

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

	class EVLContentProvider implements ITreeContentProvider {

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
			if (inputElement instanceof Evl) {
				Evl box = (Evl) inputElement;
				
				Object[] result = new Object[1 + box.getContextList().size()];
				result[0] = box.getImportList();
				System.arraycopy(box.getContextList().toArray(), 0, result, 1, box.getContextList().size());
				
				return result;
			}
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
			if (element instanceof Evl) {
				return true;
			}
			if (element instanceof List) {
				List l = (List)element;
				if (l.size() > 0)
					return true;
				else
					return false;
			}
			if (element instanceof Context) {
				Context c = (Context)element;
				if (c.getContainers().size() > 0)
					return true;
				else 
					return false;
			}
			if (element instanceof Container) {
				Container c = (Container)element;
				if (c.getCheck() != null || c.getMessage() != null || c.getFixList().size() > 0)
					return true;
				else 
					return false;
			}
			if (element instanceof Check) {
				Check c = (Check)element;
				if (c.getOperations().size() > 0)
					return true;
				else 
					return false;
			}
			if (element instanceof Fix) {
				Fix f = (Fix)element;
				if (f.getTitle() != null || f.getDoList() != null)
					return true;
				else 
					return false;
			}
			if (element instanceof Do) {
				Do d = (Do)element;
				if (d.getFunctions().size() > 0)
					return true;
				else 
					return false;
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

			if (parentElement instanceof Context) {
				Context box = (Context) parentElement;
				return box.getContainers().toArray();
			}
			
			if (parentElement instanceof Container) {
				Container box = (Container) parentElement;
				List<Object> children = new ArrayList<Object>();
				if (box.getCheck() != null)
					children.add(box.getCheck());
				if (box.getMessage() != null)
					children.add(box.getMessage());
				if (box.getFixList().size() > 0)
					children.add(box.getFixList());
				return children.toArray();
			}
			
			if (parentElement instanceof Check) {
				Check box = (Check) parentElement;
				return box.getOperations().toArray();
			}
			
			if (parentElement instanceof Fix) {
				Fix box = (Fix) parentElement;
				List<Object> children = new ArrayList<Object>();
				if (box.getTitle() != null)
					children.add(box.getTitle());
				if (box.getDoList() != null)
					children.add(box.getDoList());
				return children.toArray();
			}
			
			if (parentElement instanceof Do) {
				Do box = (Do) parentElement;
				return box.getFunctions().toArray();
			}

			if (parentElement instanceof List) {
				List box = (List) parentElement;
				if (!box.isEmpty()) {
					if (box.get(0) instanceof ImportStatement) {
						return box.toArray();
					}
					if (box.get(0) instanceof Context) {
						return box.toArray();
					}
					if (box.get(0) instanceof Operation) {
						return box.toArray();
					}
					if (box.get(0) instanceof Fix) {
						return box.toArray();
					}
				}
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

	public class EVLLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof List) {
				List box = (List) element;
				if (!box.isEmpty()) {
					if (box.get(0) instanceof ImportStatement) {
						return "Import list";
					}
					if (box.get(0) instanceof Fix) {
						return "Fix list";
					}
				} else return "Import list";
			}

			if (element instanceof ImportStatement) {
				return ((ImportStatement) element).toString();
			}
			
			if (element instanceof Context) {
				return ("context " + ((Context) element).getName());
			}
			
			if (element instanceof Container) {
				return ((Container) element).getType() + " " + ((Container) element).getName();
			}
			
			if (element instanceof Check) {
				return "check: NOT";
			}
			
			if (element instanceof Operation) {
				Operation op = (Operation) element;
				String result = "";
				if (op.getOp() != GuardOperator.EMPTY) {
					result += op.getOp().toString();
				}
				return result + " " + op.getPredicate().toString();
			}
			
			if (element instanceof Message) {
				Message m = (Message) element;
				return "message : " + m.getText();
			}
			
			if (element instanceof Fix) {
				Fix m = (Fix) element;
				return "fix:";
			}
			
			if (element instanceof Title) {
				Title t = (Title) element;
				return "title: " + t.getText();
			}
			
			if (element instanceof Do) {
				Do m = (Do) element;
				return "Do";
			}
			
			if (element instanceof String) {
				String m = (String) element;
				return m;
			}
			
			return null;
		}
	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void setcontexts() {
		// Adding contexts to pull down menu

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		view.EOL_Library_Tree EOLLibraryTree = (view.EOL_Library_Tree) page.findView("view.EOL_Library_Tree");

		for (Context2 s : EOLLibraryTree.contexts) {

			Action addContext = new Action() {
				public void run() {

//					rawtree.removeAll();

					Context cNew = new Context(s.getName());
					List<Context> cList = evl.getContextList();
					cList.add(cNew);
					evl.setContextList(cList);
					// evl.addContext(cNew);

//					new fillTreeModel(rawtree, evl).fill();
					
					Object[] ex = tree.getExpandedElements();
					tree.setInput(evl);
					tree.setExpandedElements(ex);
				}
			};
			addContext.setText(s.getName());
			addContext.setToolTipText("Add to tree");
			Bundle bundle = Platform.getBundle("it.spe.disim.univaq.it.plugin");
			fullPathString = bundle.getEntry("icons/context.gif");
			addContext.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

			bars.getMenuManager().add(addContext);
		}
	}

}
