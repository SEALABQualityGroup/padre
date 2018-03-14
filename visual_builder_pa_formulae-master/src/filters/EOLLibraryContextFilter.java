package filters;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import model.Context2;
import model.Do_operation;
import model.F_operation;
import model.LibraryRoot;
import model.Th_operation;

public class EOLLibraryContextFilter extends ViewerFilter {

	private String searchString;
	private String operationType;

	public void setSearchText(String s) {
		// ensure that the value can be used for matching
		this.searchString = s;
	}
	
	public void setOperationType(String type) {
		// ensure that the value can be used for matching
		this.operationType = type;
	}


	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// TODO Auto-generated method stub

		if (element instanceof LibraryRoot)
		{
			return true;
		}
		if (element instanceof List) 
		{
			List box = (List) element;
			if (!box.isEmpty())
			{
				if (box.get(0) instanceof Context2)
				{
					return true;
				}
				if (box.get(0) instanceof Th_operation)
				{
					if (searchString.equals(".*"))
						return true;
					else 
						return false;
				}
				if (box.get(0) instanceof F_operation)
				{
					if ("F".matches(operationType))
						return true;
					else
						return false;
				}
				if (box.get(0) instanceof Do_operation)
				{
					if ("Do".matches(operationType))
						return true;
					else
						return false;
				}
			}
		}
		if (element instanceof Context2)
		{
			Context2 c = (Context2)element;
			if (c.getName().matches(searchString))
				return true;
			else 
				return false;
		}
		if (element instanceof F_operation) {
			return true;
		}
		if (element instanceof Do_operation) {
			return true;
		}
		if (element instanceof Th_operation) {
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
