package views;

import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import actions.Add_Check_to_EVL;
import actions.Add_Constraint_to_EVL;
import actions.Add_Critique_to_EVL;
import actions.Add_Fix_to_EVL;
import actions.Add_Message_to_EVL;
import actions.Add_Title_to_EVL_Fix;
import actions.Export_EVL_as_XML;
import actions.Hook_Do_operation_Context_Menu;
import actions.Hook_F_operation_Context_Menu;
import actions.Import_EVL_from_XML;
import actions.Save_EPL_file_Action;
import actions.Save_EVL_file_Action;
import actions.Save_EWL_file_Action;
import contentProviders.EVL_Tree_ContentProvider;
import contentProviders.EVL_Tree_LabelProvider;
import model.EVL_Tree_CheckStatement;
import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EOL_Library_Context_Item;
import model.EVL_Tree_FixOperations;
import model.EVL_Tree_Root;
import model.EVL_Tree_FixStatement;

/**
 * It is the view that contains the EVL TreeViewer
 *
 */
public class EVL_Tree extends ViewPart {

	public EVL_Tree_Root evl;
	public TreeViewer tree;
	String eol_library_path;
	private Action saveEVL, saveEPL, saveEWL, saveXMLaction, importXMLaction;

	private TreeItem emptyTree_Placeholder;
	
	public EVL_Tree() {
	}
	
	public String getEol_library_path() {
		return eol_library_path;
	}

	public void setEol_library_path(String eol_library_path) {
		this.eol_library_path = eol_library_path;
	}

	@Override
	public void createPartControl(Composite parent) {

		evl = new EVL_Tree_Root();

		tree = new TreeViewer(parent);
		tree.setContentProvider(new EVL_Tree_ContentProvider());
		tree.setLabelProvider(new EVL_Tree_LabelProvider());
		
		emptyTree_Placeholder = new TreeItem(tree.getTree(), SWT.NONE);
		emptyTree_Placeholder.setText("No EOL library available");

		hookContextMenu();

		getSite().setSelectionProvider(tree);

	}

	/**
	 * It sets all actions for toolbar elements
	 * 
	 */
	public void setActions() {
		
		importXMLaction = new Import_EVL_from_XML(tree, evl);
		importXMLaction.setText("Save");
		importXMLaction.setToolTipText("Import tree from XML");
		importXMLaction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT));

		saveXMLaction = new Export_EVL_as_XML(tree, evl);
		saveXMLaction.setText("Save");
		saveXMLaction.setToolTipText("Save tree as XML");
		saveXMLaction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));

		saveEVL = new Save_EVL_file_Action(tree, evl, eol_library_path);
		saveEVL.setText("Save");
		saveEVL.setToolTipText("Save EVL");
		saveEVL.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));

		saveEPL = new Save_EPL_file_Action(tree, evl, eol_library_path);
		saveEPL.setText("Save");
		saveEPL.setToolTipText("Save EPL");
		saveEPL.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));

		saveEWL = new Save_EWL_file_Action(tree, evl, eol_library_path);
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
		bars.updateActionBars();
	}
	/**
	 * It adds list of context to pull down menu of the view
	 * 
	 * @param cts The list of context available in EOL library 
	 */
	public void setContexts(List<EOL_Library_Context_Item> cts) {

		Bundle bundle = Platform.getBundle("it.spe.disim.univaq.it.plugin");
		URL fullPathString = bundle.getEntry("icons/context.gif");
		
		IActionBars bars = getViewSite().getActionBars();
		IMenuManager dropdown_menu = bars.getMenuManager();
		dropdown_menu.removeAll();
		
		for (EOL_Library_Context_Item s : cts) {

			Action addContext_Action = new Action() {
				public void run() {

					EVL_Tree_Context_Item cNew = new EVL_Tree_Context_Item(s.getName());
					List<EVL_Tree_Context_Item> cList = evl.getContextList();
					cList.add(cNew);
					evl.setContextList(cList);

					Object[] ex = tree.getExpandedElements();
					tree.setInput(evl);
					tree.setExpandedElements(ex);
				}
			};
			addContext_Action.setText(s.getName());
			addContext_Action.setToolTipText("Add to tree");			
			addContext_Action.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

			dropdown_menu.add(addContext_Action);
			bars.updateActionBars();
		}
		
		tree.setInput(null);
		emptyTree_Placeholder = new TreeItem(tree.getTree(), SWT.NONE);
		emptyTree_Placeholder.setText("To start building EVL choose a context from the arrow menu");
	}

	/**
	 * It adds context menu to tree item
	 */
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
					
					Bundle bundle = Platform.getBundle("it.spe.disim.univaq.it.plugin");

					if (s instanceof EVL_Tree_Context_Item) {

						Action addConstraintAction = new Add_Constraint_to_EVL(tree, (EVL_Tree_Context_Item) s);
						addConstraintAction.setText("Add constraint");
						URL fullPathString = bundle.getEntry("icons/constraint.gif");
						addConstraintAction.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

						Action addCritiqueAction = new Add_Critique_to_EVL(tree, (EVL_Tree_Context_Item) s);
						addCritiqueAction.setText("Add critique");
						fullPathString = bundle.getEntry("icons/critique.gif");
						addCritiqueAction.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

						manager.add(addConstraintAction);
						manager.add(addCritiqueAction);
					}

					if (s instanceof EVL_Tree_Container) {

						Action setCheck = new Add_Check_to_EVL(tree, (EVL_Tree_Container) s);
						setCheck.setText("Set check");
						setCheck.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

						Action addMessage = new Add_Message_to_EVL(tree, (EVL_Tree_Container) s);
						addMessage.setText("Add message");
						addMessage.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

						Action addFix = new Add_Fix_to_EVL(tree, (EVL_Tree_Container) s);
						addFix.setText("Add fix");
						URL fullPathString = bundle.getEntry("icons/fix.gif");
						addFix.setImageDescriptor(ImageDescriptor.createFromURL(fullPathString));

						manager.add(setCheck);
						manager.add(addMessage);
						manager.add(addFix);
					}

					if (s instanceof EVL_Tree_FixStatement) {
						Action setFixTitle = new Add_Title_to_EVL_Fix(tree, (EVL_Tree_FixStatement) s);
						setFixTitle.setText("Set fix title");
						setFixTitle.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
						manager.add(setFixTitle);
					}

					if (s instanceof EVL_Tree_CheckStatement) {

						Action chooseFoperations = new Hook_F_operation_Context_Menu(tree, (EVL_Tree_CheckStatement) s);
						chooseFoperations.setText("Choose F");
						chooseFoperations.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

						manager.add(chooseFoperations);
					}

					if (s instanceof EVL_Tree_FixOperations) {

						Action chooseDOoperations = new Hook_Do_operation_Context_Menu(tree, (EVL_Tree_FixOperations) s);
						chooseDOoperations.setText("Choose DO");
						chooseDOoperations.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

						manager.add(chooseDOoperations);
					}
				}
			}
		});
		Menu menu = menuMgr.createContextMenu(tree.getControl());
		tree.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, tree);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
