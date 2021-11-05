package view;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dt.views.ValidationViewFixer;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class PadreEVLValidationViewFixer extends ValidationViewFixer {
	public PadreEVLValidationViewFixer() {
		super();
	}

	protected boolean done = false;

	public void fix(IEvlModule module) throws EolRuntimeException {
		try {
			fixImpl(module);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void fixImpl(IEvlModule module) throws Exception {
		PadreEVLValidationView validationView = getValidationView();
		validationView.fix(module, this);
		while (!isDone()) {
			Thread.sleep(100);
		}
	}

	protected PadreEVLValidationView getValidationView() {
		final PadreValidationViewWrapper validationViewWrapper = new PadreValidationViewWrapper();
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				try {
					validationViewWrapper.validationView = (PadreEVLValidationView) PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage().showView("view.PadreEVLValidationView");
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
		return validationViewWrapper.validationView;
	}

	class PadreValidationViewWrapper {
		public PadreEVLValidationView validationView;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
