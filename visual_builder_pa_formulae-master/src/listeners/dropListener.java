package listeners;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import helpers.fillTreeModel;
import model.Evl;
import model.ImportStatement;

public class dropListener extends ViewerDropAdapter {

    private final TreeViewer viewer;
    private final Evl evl;

    public dropListener(TreeViewer viewer, Evl evl) {
        super(viewer);
        this.viewer = viewer;
        this.evl = evl;
    }

    @Override
    public void drop(DropTargetEvent event) {
//        int location = this.determineLocation(event);
//        String target = (String) determineTarget(event);
//        String translatedLocation ="";
//        switch (location){
//        case 1 :
//            translatedLocation = "Dropped before the target ";
//            break;
//        case 2 :
//            translatedLocation = "Dropped after the target ";
//            break;
//        case 3 :
//            translatedLocation = "Dropped on the target ";
//            break;
//        case 4 :
//            translatedLocation = "Dropped into nothing ";
//            break;
//        }
//        System.out.println(translatedLocation);
//        System.out.println("The drop was done on the element: " + target );
        super.drop(event);
    }

    @Override
    public boolean performDrop(Object data) {
    	
    	String[] text = (String[])data;
    	StringBuilder builder = new StringBuilder();
    	for (String value : text) {
    	    builder.append(value);
    	}
    	String path = builder.toString();
    	
    	
    	
    	IPath location = Path.fromOSString(path);    	
    	String[] segments = location.segments();
    	
    	String importFile = "\"" + segments[segments.length - 2] + "/" + segments[segments.length -1] + "\";\n";
    	ImportStatement newImp = new ImportStatement(importFile);
		List<ImportStatement> iList = evl.getImportList();
		iList.add(newImp);
		evl.setImportList(iList);
		
		viewer.getTree().removeAll();
		viewer.getTree().setData(evl);
		new fillTreeModel(viewer.getTree(), evl).fill();
		
        return false;
    }

    @Override
    public boolean validateDrop(Object target, int operation,
            TransferData transferType) {
        return true;

    }
}