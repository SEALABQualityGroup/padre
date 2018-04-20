package filters;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import model.EOL_Library_Context_Item;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_Root;
import model.EOL_Library_F_Operation;
import model.EOL_Library_Th_Operation;

/**
 * It allows to filter the EOL library tree by a search string
 *
 */
public class EOLLibraryContextFilter extends ViewerFilter {

	private String searchString;
	private String operationType;

	/**
	 * @param s The name of the context to filter
	 */
	public void setSearchText(String s) {
		// ensure that the value can be used for matching
		this.searchString = s;
	}
	
	/**
	 * @param type The type of operations (F, Do, or Th) to search for.
	 */
	public void setOperationType(String type) {
		// ensure that the value can be used for matching
		this.operationType = type;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if (element instanceof EOL_Library_Root)
		{
			return true;
		}
		if (element instanceof List) 
		{
			List<?> box = (List<?>) element;
			if (!box.isEmpty())
			{
				if (box.get(0) instanceof EOL_Library_Context_Item)
				{
					return true;
				}
				if (box.get(0) instanceof EOL_Library_Th_Operation)
				{
					if (searchString.equals(".*"))
						return true;
					else 
						return false;
				}
				if (box.get(0) instanceof EOL_Library_F_Operation)
				{
					if ("F".matches(operationType))
						return true;
					else
						return false;
				}
				if (box.get(0) instanceof EOL_Library_DO_Operation)
				{
					if ("Do".matches(operationType))
						return true;
					else
						return false;
				}
				if (box.get(0) instanceof EOL_Library_Th_Operation)
				{
					if ("Th".matches(operationType))
						return true;
					else
						return false;
				}
			}
		}
		if (element instanceof EOL_Library_Context_Item)
		{
			EOL_Library_Context_Item c = (EOL_Library_Context_Item)element;
			if (c.getName().matches(searchString))
				return true;
			else 
				return false;
		}
		if (element instanceof EOL_Library_F_Operation) {
			return true;
		}
		if (element instanceof EOL_Library_DO_Operation) {
			return true;
		}
		if (element instanceof EOL_Library_Th_Operation) {
			if (searchString.equals(".*"))
				return true;
			else 
				return false;
		}
		
		return false;
//		StructuredViewer sviewer = (StructuredViewer) viewer;
//		ITreeContentProvider provider = (ITreeContentProvider) sviewer.getContentProvider();
//		for (Object child : provider.getChildren(element)) {
//			
//			String h = child.toString();
//			
//			String y = h;
//		}
//
//		if (searchString == null || searchString.length() == 0) {
//			return true;
//		}
//		String[] p = (String[]) element;
//		if (p[1].matches(searchString)) {
//			matchs++;
//			return true;
//		}
//
//
//		return false;
	}
}
