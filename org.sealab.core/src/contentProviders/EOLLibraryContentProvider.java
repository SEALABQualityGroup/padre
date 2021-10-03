package contentProviders;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import model.EOL_Library_Context_Item;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_Root;
import model.EOL_Library_F_Operation;
import model.EOL_Library_Th_Operation;

/**
 * This class provides the content for the treeViewer in view.EOL_Library_Tree
 * 
 * @author Stefano
 *
 */
public class EOLLibraryContentProvider implements ITreeContentProvider {

	private final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * Gets the root element(s) of the tree
	 * 
	 */
	public Object[] getElements(Object inputElement) {
		// These are the root elements of the tree
		// We don't care what arg0 is, because we just want all
		// the root nodes in the file system
		if (inputElement instanceof EOL_Library_Root) {
			EOL_Library_Root box = (EOL_Library_Root) inputElement;
			Object[] result = new Object[2];
			result[0] = box.getListContexts();
			result[1] = box.getths();
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
		// Get the children
		if (element instanceof EOL_Library_Root || element instanceof EOL_Library_Context_Item || element instanceof List) {
			return true;
		}

		return false;
	}

	/**
	 * Gets the children of the specified object
	 * 
	 */
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof List) {
			List<?> box = (List<?>) parentElement;
			if (!box.isEmpty()) {
				if (box.get(0) instanceof EOL_Library_Context_Item) {
					return box.toArray();
				}
				if (box.get(0) instanceof EOL_Library_Th_Operation) {
					return box.toArray();
				}
				if (box.get(0) instanceof EOL_Library_F_Operation) {
					return box.toArray();
				}
				if (box.get(0) instanceof EOL_Library_DO_Operation) {
					return box.toArray();
				}
			}

		}

		if (parentElement instanceof EOL_Library_Context_Item) {
			EOL_Library_Context_Item box = (EOL_Library_Context_Item) parentElement;
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

