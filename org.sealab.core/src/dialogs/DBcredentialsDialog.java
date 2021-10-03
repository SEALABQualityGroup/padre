package dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * It asks for the title to assign to a Fix
 *
 */
public class DBcredentialsDialog extends TitleAreaDialog {

	private Text DB_URL, DB_USER, DB_PASSWORD;
	private String url, user, pass;
	private String title = "Database connection", message = "Insert credentials.";

	public DBcredentialsDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();
		setTitle(title);
		setMessage(message, IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		createContextName(container);

		return area;

	}

	private void createContextName(Composite container) {
		
		GridData db_URL = new GridData();
		db_URL.grabExcessHorizontalSpace = true;
		db_URL.horizontalAlignment = GridData.FILL;
		
		Label db_url_label = new Label(container, SWT.NONE);
		db_url_label.setText("Database URL");
		DB_URL = new Text(container, SWT.BORDER);
		DB_URL.setLayoutData(db_URL);
		DB_URL.setText("jdbc:mysql://localhost/local_visual_builder");
		
		Label user_label = new Label(container, SWT.NONE);
		user_label.setText("User");
		DB_USER = new Text(container, SWT.BORDER);
		DB_USER.setLayoutData(db_URL);
		
		Label pass_label = new Label(container, SWT.NONE);
		pass_label.setText("Password");
		DB_PASSWORD = new Text(container, SWT.PASSWORD | SWT.BORDER);
		DB_PASSWORD.setLayoutData(db_URL);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	// save content of the Text fields because they get disposed
	// as soon as the Dialog closes
	private void saveInput() {
		url = DB_URL.getText();
		user = DB_USER.getText();
		pass = DB_PASSWORD.getText();

	}

	@Override
	protected void okPressed() {
		saveInput();
		if (DB_URL.getText().isEmpty() || DB_USER.getText().isEmpty())
			return;
		super.okPressed();
	}

	public List<String> getCredentials() {
		List<String> result = new ArrayList<String>();
		result.add(url);
		result.add(user);
		result.add(pass);
		return result;
	}

}