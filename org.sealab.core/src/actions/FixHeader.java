package actions;

import org.eclipse.jface.action.Action;

public class FixHeader extends Action {
	public FixHeader() {
		this.setText("Available refactoring actions");
		this.setEnabled(false);
	}

	@Override
	public void run() {}
}