package contentProviders;

import java.util.List;

import org.eclipse.jface.viewers.LabelProvider;

import model.EVL_Tree_CheckStatement;
import model.EVL_Tree_Container;
import model.EVL_Tree_Context_Item;
import model.EVL_Tree_FixOperations;
import model.EVL_Tree_FixStatement;
import model.BooleanOperators;
import model.EVL_Tree_ImportStatement;
import model.EVL_Tree_Message;
import model.EVL_Tree_CheckOperation;
import model.EVL_Tree_FixTitle;

/**
 * This class provides labels for items of EVL tree.
 * 
 * @author Stefano
 *
 */
public class EVL_Tree_LabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof List) {
			List<?> box = (List<?>) element;
			if (!box.isEmpty()) {
				if (box.get(0) instanceof EVL_Tree_ImportStatement) {
					return "Import list";
				}
				if (box.get(0) instanceof EVL_Tree_FixStatement) {
					return "Fix list";
				}
			} else return "Import list";
		}

		if (element instanceof EVL_Tree_ImportStatement) {
			return ((EVL_Tree_ImportStatement) element).toString();
		}
		
		if (element instanceof EVL_Tree_Context_Item) {
			return ("context " + ((EVL_Tree_Context_Item) element).getName());
		}
		
		if (element instanceof EVL_Tree_Container) {
			return ((EVL_Tree_Container) element).getType() + " " + ((EVL_Tree_Container) element).getName();
		}
		
		if (element instanceof EVL_Tree_CheckStatement) {
			return "check: not";
		}
		
		if (element instanceof EVL_Tree_CheckOperation) {
			EVL_Tree_CheckOperation op = (EVL_Tree_CheckOperation) element;
			String result = "";
			if (op.getOp() != BooleanOperators.EMPTY) {
				result += op.getOp().toString();
			}
			return result + " " + op.getPredicate().toString();
		}
		
		if (element instanceof EVL_Tree_Message) {
			EVL_Tree_Message m = (EVL_Tree_Message) element;
			return "message : " + m.getText();
		}
		
		if (element instanceof EVL_Tree_FixStatement) {
			return "fix:";
		}
		
		if (element instanceof EVL_Tree_FixTitle) {
			EVL_Tree_FixTitle t = (EVL_Tree_FixTitle) element;
			return "title: " + t.getText();
		}
		
		if (element instanceof EVL_Tree_FixOperations) {
			return "Do";
		}
		
		if (element instanceof String) {
			String m = (String) element;
			return m;
		}
		
		return null;
	}
}

