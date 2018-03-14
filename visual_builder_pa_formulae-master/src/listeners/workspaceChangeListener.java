package listeners;

import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class workspaceChangeListener implements IResourceChangeListener {

	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	view.EOL_Library_Tree libraryview = (view.EOL_Library_Tree) page.findView("view.EOL_Library_Tree");

	public void resourceChanged(IResourceChangeEvent event) {

		// IPath Library_PATH = new Path(libraryview.path);

		// we are only interested in POST_CHANGE events
		if (event.getType() != IResourceChangeEvent.POST_CHANGE)
			return;

		IResourceDelta rootDelta = event.getDelta();

		// get the delta, if any, for the library directory
		// IResourceDelta libraryDelta = rootDelta.findMember(Library_PATH);
		// if (libraryDelta == null)
		// return;

		final ArrayList<IResource> changed = new ArrayList<IResource>();

		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) {

				if (!(delta.getKind() == IResourceDelta.CHANGED || delta.getKind() == IResourceDelta.MOVED_FROM
						|| delta.getKind() == IResourceDelta.MOVED_TO || delta.getKind() == IResourceDelta.ADDED
						|| delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.REPLACED))
					return true;

				// only interested in content changes
				// if ((delta.getFlags() & IResourceDelta.CONTENT) == 0)
				// return true;

				IResource resource = delta.getResource();
				// only interested in files with the "eol" extension
				if (resource.getType() == IResource.FILE && "eol".equalsIgnoreCase(resource.getFileExtension())) {
					changed.add(resource);
				}
				return true;
			}
		};

		try {
			rootDelta.accept(visitor);
		} catch (CoreException e) {
			// open error dialog with syncExec or print to plugin log file
		}

		// nothing more to do if there were no changed text files
		if (changed.size() == 0)
			return;

		// post this update to the table
		Display display = PlatformUI.getWorkbench().getDisplay();

		if (!display.isDisposed()) {

			display.asyncExec(new Runnable() {
				public void run() {


					libraryview.populate(libraryview.path);
				}
			});
		}

//		libraryview.populate(libraryview.path, changed);
	}

};
