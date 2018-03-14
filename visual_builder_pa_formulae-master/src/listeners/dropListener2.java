package listeners;

import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;


public class dropListener2 extends ViewerDropAdapter {

	private final TreeViewer viewer;

	public dropListener2(TreeViewer viewer) {
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

		

//		String[] segments = location.segments();
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		view.EOL_Library_Tree eolview = (view.EOL_Library_Tree) page.findView("view.EOL_Library_Tree");

		eolview.populate(path);

		return false;
	}

	

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		return true;

	}
}