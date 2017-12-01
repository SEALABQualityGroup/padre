package dialogs;

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

public class MyTitleAreaDialogNewProject extends TitleAreaDialog {

	  
	  private String contextName;
	  private boolean b=false;
	  private String title="Warning!",message="Creating a new project all the current data will be lost. Do you want to proceed?";
	  

	  public MyTitleAreaDialogNewProject(Shell parentShell) {
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
	    //Composite container = new Composite(area, SWT.NONE);
	    //container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    //GridLayout layout = new GridLayout(2, false);
	    //container.setLayout(layout);

	    //createContextName(container);
	    

	    return area;
	  }

	  @Override
	  protected boolean isResizable() {
	    return true;
	  }

	  // save content of the Text fields because they get disposed
	  // as soon as the Dialog closes
	  

	  @Override
	  protected void okPressed() {
	    
	    this.b=true;
	    super.okPressed();
	  }

	  public boolean getConfirm() {
	    return b;
	  }

	  
}