package dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * It warns if the built EVL tree hasn't been exported to code
 *
 */
public class UnsavedProjectWarning extends TitleAreaDialog {

	  private boolean b=false;
	  private String title="Warning!",message="Creating a new project all the current data will be lost. Do you want to proceed?";
	  

	  public UnsavedProjectWarning(Shell parentShell) {
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