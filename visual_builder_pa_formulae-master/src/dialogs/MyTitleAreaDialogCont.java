package dialogs;

import java.sql.SQLException;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import model.Db;

public class MyTitleAreaDialogCont extends TitleAreaDialog {

	private Combo c ;  

	  private String contextName;
	  private String title="Insert Context name",message="Insert the name of the Context",lab="Context Name";
	  

	  public MyTitleAreaDialogCont(Shell parentShell) {
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

	    
			try {
				createContextName(container);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    

	    return area;
	  }

	  private void createContextName(Composite container) throws ClassNotFoundException, SQLException {
	    Label lbtFirstName = new Label(container, SWT.NONE);
	    lbtFirstName.setText(lab);

	    GridData dataFirstName = new GridData();
	    dataFirstName.grabExcessHorizontalSpace = true;
	    dataFirstName.horizontalAlignment = GridData.FILL;
	    c = new Combo(container, SWT.READ_ONLY);
	    for(String s : Db.getContexts()){
	    	c.add(s);
	    }
	    c.setLayoutData(dataFirstName);
	  }
	  
	  @Override
	  protected boolean isResizable() {
	    return true;
	  }

	  // save content of the Text fields because they get disposed
	  // as soon as the Dialog closes
	  private void saveInput() {
	    contextName = c.getText();
	   
	  }

	  @Override
	  protected void okPressed() {
	    saveInput();
	    if(c.getText().isEmpty())
	    	return;
	    super.okPressed();
	  }

	  public String getName() {
	    return contextName;
	  }

	  
}