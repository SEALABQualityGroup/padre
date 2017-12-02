package filters;

import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class ContextFilter extends ViewerFilter {

	private String searchString;

	private List<Integer> ids_list = null;

	private int matchs = 0;

	public void setSearchText(String s) {
		// ensure that the value can be used for matching
		this.searchString = s;
		matchs = 0;
	}

	public void set_indexing(List<Integer> s) {
		// ensure that the value can be used for matching
		this.ids_list = s;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// TODO Auto-generated method stub

		if (searchString == null || searchString.length() == 0) {
			return true;
		}
		String[] p = (String[]) element;
		if (p[1].matches(searchString)) {
			matchs++;
			return true;
		}

		if (ids_list != null) {
			ids_list.remove(matchs);
		}

		return false;
	}
}