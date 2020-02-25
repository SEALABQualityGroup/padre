package listeners;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import helpers.EOL_Utils;


/**
 * It is executed when a folder is dropped in the EOL library tree viewer
 * Then it calls the method to update the library data structure
 * 
 * @author Stefano
 *
 */
public class DropListener_for_EOL_Library_Tree extends ViewerDropAdapter {

	private final TreeViewer viewer;

	public DropListener_for_EOL_Library_Tree(TreeViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	public void drop(DropTargetEvent event) {
		// int location = this.determineLocation(event);
		// String target = (String) determineTarget(event);
		// String translatedLocation ="";
		// switch (location){
		// case 1 :
		// translatedLocation = "Dropped before the target ";
		// break;
		// case 2 :
		// translatedLocation = "Dropped after the target ";
		// break;
		// case 3 :
		// translatedLocation = "Dropped on the target ";
		// break;
		// case 4 :
		// translatedLocation = "Dropped into nothing ";
		// break;
		// }
		// System.out.println(translatedLocation);
		// System.out.println("The drop was done on the element: " + target );
		super.drop(event);
	}

	@Override
	public boolean performDrop(Object data) {

		String[] text = (String[]) data;
		StringBuilder builder = new StringBuilder();
		for (String value : text) {
			builder.append(value);
		}
		String path = builder.toString();

		EOL_Utils.update_EOL_Library_Data_Structure(path);

		return false;
	}	

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		return true;

	}
}