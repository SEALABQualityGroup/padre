package views;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import actions.Add_Do_operation_to_EVL;
import actions.Add_Operation_to_Block;
import actions.Add_TH_operation_to_EVL;
import actions.DoubleClick_EOL_operation_Action;
import contentProviders.EOLLibraryContentProvider;
import contentProviders.EOLLibraryLabelProvider;
import filters.EOLLibraryContextFilter;
import listeners.DropListener_for_EOL_Library_Tree;
import model.EVL_Tree_CheckBlock;
import model.EVL_Tree_CheckOperation;
import model.EVL_Tree_FixOperations;

/**
 * It is the view that contains the TreeViewer for the EOL library
 *
 */
public class EOL_Library_Tree extends ViewPart {

	AST eolAST;

	public TreeViewer eoltree;
	private EOLLibraryContextFilter treeFilter;

	public EOL_Library_Tree() {
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.
	 * Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {

		eoltree = new TreeViewer(parent);
		eoltree.setContentProvider(new EOLLibraryContentProvider());
		eoltree.setLabelProvider(new EOLLibraryLabelProvider());

		setTreeFilter(new EOLLibraryContextFilter());
		getTreeFilter().setSearchText(".*");

		eoltree.addFilter(getTreeFilter());

		TreeItem nullRoot = new TreeItem(eoltree.getTree(), SWT.NONE);
		nullRoot.setText("Drag and drop here the EOL library root directory");

//		Action newOperation = new NewEOL_operation_Action();
//		newOperation.setText("Add");
//		newOperation.setToolTipText("Add new operation");
//		newOperation.setImageDescriptor(
//				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
//
//		Action saveOperationsOnDB = new Save_operation_OnDB_Action();
//		saveOperationsOnDB.setText("Save");
//		saveOperationsOnDB.setToolTipText("Save all operation in DB");
//		saveOperationsOnDB.setImageDescriptor(
//				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEALL_EDIT));

//		IActionBars bars = getViewSite().getActionBars();
//		bars.getToolBarManager().add(newOperation);
//		bars.getToolBarManager().add(saveOperationsOnDB);


		
		eoltree.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				
				Action doubleClickAction = new DoubleClick_EOL_operation_Action(event.getSelection());
				
				doubleClickAction.run();
			}
		});

		// enable drag and drop of eol file
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		Transfer[] transferTypes = new Transfer[] { FileTransfer.getInstance() };
		eoltree.addDropSupport(operations, transferTypes, new DropListener_for_EOL_Library_Tree(eoltree));

		
	}

	public EOLLibraryContextFilter getTreeFilter() {
		return treeFilter;
	}

	public void setTreeFilter(EOLLibraryContextFilter treeFilter) {
		this.treeFilter = treeFilter;
	}

	/**
	 * It adds a context menu to all F operations available in the EOL library
	 * 
	 * @param check The Check statement selected in EVL tree
	 * @param evltree The EVL tree
	 */
	public void hookContextMenu(EVL_Tree_CheckBlock block, TreeViewer evltree) {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {

				if (eoltree.getSelection().isEmpty()) {
					return;
				}

				if (eoltree.getSelection() instanceof IStructuredSelection) {

					if (block.getBlocks_and_Operations().isEmpty()) {

						Action set_Operation = new Add_Operation_to_Block(evltree, eoltree.getSelection(), block, 0);
						set_Operation.setText("Add to EVL tree");
						set_Operation.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

						Action set_Negated_Operation = new Add_Operation_to_Block(evltree, eoltree.getSelection(), block, 1);
						set_Negated_Operation.setText("Add negated to EVL tree");
						set_Negated_Operation.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

						manager.add(set_Operation);
						manager.add(set_Negated_Operation);

					} else {

						Action set_AND = new Add_Operation_to_Block(evltree, eoltree.getSelection(), block, 2);
						set_AND.setText("AND");
						set_AND.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

						Action set_OR = new Add_Operation_to_Block(evltree, eoltree.getSelection(), block, 3);
						set_OR.setText("OR");
						set_OR.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

						Action set_XOR = new Add_Operation_to_Block(evltree, eoltree.getSelection(), block, 4);
						set_XOR.setText("XOR");
						set_XOR.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

						Action set_NAND = new Add_Operation_to_Block(evltree, eoltree.getSelection(), block, 5);
						set_NAND.setText("NOT AND");
						set_NAND.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

						Action set_NOR = new Add_Operation_to_Block(evltree, eoltree.getSelection(), block, 6);
						set_NOR.setText("NOT OR");
						set_NOR.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

						Action set_NXOR = new Add_Operation_to_Block(evltree, eoltree.getSelection(), block, 7);
						set_NXOR.setText("NOT XOR");
						set_NXOR.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
								.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

						manager.add(set_AND);
						manager.add(set_OR);
						manager.add(set_XOR);
						manager.add(set_NAND);
						manager.add(set_NOR);
						manager.add(set_NXOR);
					}

				}
			}
		});
		Menu menu = menuMgr.createContextMenu(eoltree.getControl());
		eoltree.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, eoltree);
	}

	/**
	 * It adds a context menu to all DO operations available in the EOL library
	 * 
	 * @param d The DO statement selected in EVL
	 */
	public void hookContextMenu(EVL_Tree_FixOperations d) {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				if (eoltree.getSelection().isEmpty()) {
					return;
				}

				if (eoltree.getSelection() instanceof IStructuredSelection) {

					Action set_Redo_Operation = new Add_Do_operation_to_EVL(eoltree.getSelection(), d);
					set_Redo_Operation.setText("Add to EVL tree");
					set_Redo_Operation.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
							.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

					manager.add(set_Redo_Operation);

				}
			}
		});
		Menu menu = menuMgr.createContextMenu(eoltree.getControl());
		eoltree.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, eoltree);
	}
	
	/**
	 * It adds a context menu to all thresholds operations available in the EOL library
	 * 
	 * @param op The operation selected of the Check statement
	 */
	public void hookContextMenu(EVL_Tree_CheckOperation op) {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				if (eoltree.getSelection().isEmpty()) {
					return;
				}

				if (eoltree.getSelection() instanceof IStructuredSelection) {

					Action set_Threshold_Operation = new Add_TH_operation_to_EVL(eoltree.getSelection(), op);
					set_Threshold_Operation.setText("Add this threshold");
					set_Threshold_Operation.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
							.getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));

					manager.add(set_Threshold_Operation);

				}
			}
		});
		Menu menu = menuMgr.createContextMenu(eoltree.getControl());
		eoltree.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, eoltree);
	}

	@Override
	public void setFocus() {
	}

}
