package contentProviders;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import model.EVL_Tree_CheckStatement;
import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EVL_Tree_FixOperations;
import model.EVL_Tree_Root;
import model.EVL_Tree_FixStatement;
import model.EVL_Tree_ImportStatement;
import model.EVL_Tree_CheckOperation;

/**
 * This class provides the content for the treeViewer in views.EVL_Tree
 * @author Stefano
 *
 */
public class EVL_Tree_ContentProvider implements ITreeContentProvider {

	private final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * Gets the root element(s) of the tree
	 * 
	 */
	public Object[] getElements(Object inputElement) {
		// These are the root elements of the tree
		// We don't care what arg0 is, because we just want all
		// the root nodes in the file system
		if (inputElement instanceof EVL_Tree_Root) {
			EVL_Tree_Root box = (EVL_Tree_Root) inputElement;
			
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
	 */
	public boolean hasChildren(Object element) {

		if (element instanceof EVL_Tree_Root) {
			return true;
		}
		if (element instanceof List) {
			List<?> l = (List<?>)element;
			if (l.size() > 0)
				return true;
			else
				return false;
		}
		if (element instanceof EVL_Tree_Context_Item) {
			EVL_Tree_Context_Item c = (EVL_Tree_Context_Item)element;
			if (c.getContainers().size() > 0)
				return true;
			else 
				return false;
		}
		if (element instanceof EVL_Tree_Container) {
			EVL_Tree_Container c = (EVL_Tree_Container)element;
			if (c.getCheck() != null || c.getMessage() != null || c.getFixList().size() > 0)
				return true;
			else 
				return false;
		}
		if (element instanceof EVL_Tree_CheckStatement) {
			EVL_Tree_CheckStatement c = (EVL_Tree_CheckStatement)element;
			if (c.getOperations().size() > 0)
				return true;
			else 
				return false;
		}
		if (element instanceof EVL_Tree_FixStatement) {
			EVL_Tree_FixStatement f = (EVL_Tree_FixStatement)element;
			if (f.getTitle() != null || f.getDoList() != null)
				return true;
			else 
				return false;
		}
		if (element instanceof EVL_Tree_FixOperations) {
			EVL_Tree_FixOperations d = (EVL_Tree_FixOperations)element;
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
	 */
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof EVL_Tree_Context_Item) {
			EVL_Tree_Context_Item box = (EVL_Tree_Context_Item) parentElement;
			return box.getContainers().toArray();
		}
		
		if (parentElement instanceof EVL_Tree_Container) {
			EVL_Tree_Container box = (EVL_Tree_Container) parentElement;
			List<Object> children = new ArrayList<Object>();
			if (box.getCheck() != null)
				children.add(box.getCheck());
			if (box.getMessage() != null)
				children.add(box.getMessage());
			if (box.getFixList().size() > 0)
				children.add(box.getFixList());
			return children.toArray();
		}
		
		if (parentElement instanceof EVL_Tree_CheckStatement) {
			EVL_Tree_CheckStatement box = (EVL_Tree_CheckStatement) parentElement;
			return box.getOperations().toArray();
		}
		
		if (parentElement instanceof EVL_Tree_FixStatement) {
			EVL_Tree_FixStatement box = (EVL_Tree_FixStatement) parentElement;
			List<Object> children = new ArrayList<Object>();
			if (box.getTitle() != null)
				children.add(box.getTitle());
			if (box.getDoList() != null)
				children.add(box.getDoList());
			return children.toArray();
		}
		
		if (parentElement instanceof EVL_Tree_FixOperations) {
			EVL_Tree_FixOperations box = (EVL_Tree_FixOperations) parentElement;
			return box.getFunctions().toArray();
		}

		if (parentElement instanceof List) {
			List<?> box = (List<?>) parentElement;
			if (!box.isEmpty()) {
				if (box.get(0) instanceof EVL_Tree_ImportStatement) {
					return box.toArray();
				}
				if (box.get(0) instanceof EVL_Tree_Context_Item) {
					return box.toArray();
				}
				if (box.get(0) instanceof EVL_Tree_CheckOperation) {
					return box.toArray();
				}
				if (box.get(0) instanceof EVL_Tree_FixStatement) {
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


