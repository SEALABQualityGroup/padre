package contentProviders;

import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;

import model.EOL_Library_Context_Item;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_Root;
import model.EOL_Library_F_Operation;
import model.EOL_Library_Th_Operation;

/**
 * This class provides labels for item of EOL library tree.
 * @author Stefano
 *
 */
public class EOLLibraryLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof EOL_Library_Root) {
			return ((EOL_Library_Root) element).getName();
		}
		if (element instanceof EOL_Library_Context_Item) {
			return ((EOL_Library_Context_Item) element).getName();
		}

		if (element instanceof List) {
			List<?> box = (List<?>) element;
			if (!box.isEmpty()) {
				if (box.get(0) instanceof EOL_Library_Context_Item) {
					return "Contexts list";
				}
				if (box.get(0) instanceof EOL_Library_Th_Operation) {
					return "Thresholds list";
				}
				if (box.get(0) instanceof EOL_Library_F_Operation) {
					return "F";
				}
				if (box.get(0) instanceof EOL_Library_DO_Operation) {
					return "Do";
				}
			}

			return "___";
		}
		if (element instanceof EOL_Library_F_Operation) {
			return ((EOL_Library_F_Operation) element).getName();
		}
		if (element instanceof EOL_Library_DO_Operation) {
			return ((EOL_Library_DO_Operation) element).getName();
		}
		if (element instanceof EOL_Library_Th_Operation) {
			return ((EOL_Library_Th_Operation) element).getName();
		}
		return null;
	}
}


