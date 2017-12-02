package helpers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

/**
 * Schedules the showing of a view on the UI thread.
 */
public class ShowView extends UIJob {
	private String viewId;
	private String secondaryId;

	/**
	 * Constructor
	 *
	 * @param viewId
	 *            ID of the view.
	 * @param secondaryId
	 *            Secondary ID of the view, if any.
	 */
	public ShowView(String viewId, String secondaryId) {
		super(viewId + (secondaryId == null ? "" : ":" + secondaryId));
		this.viewId = viewId;
		this.secondaryId = secondaryId;
	}

	/**
	 * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		try {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if (secondaryId != null) {
				page.showView(viewId, secondaryId, IWorkbenchPage.VIEW_ACTIVATE);
			} else {
				if (!page.isPartVisible(page.findView(viewId))) {
					page.bringToTop(page.findView(viewId));
				}

			}
		} catch (PartInitException e) {
			// return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
			// "Problem showing view " + viewId + ".", e);
		}
		return Status.OK_STATUS;
	}
}