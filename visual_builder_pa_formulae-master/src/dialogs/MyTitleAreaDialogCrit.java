package dialogs;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MyTitleAreaDialogCrit extends TitleAreaDialog {

	private Text txtCritiqueName;
	  

	  private String contextName,type;
	  private String lab;
	  

	  public MyTitleAreaDialogCrit(Shell parentShell) {
	    super(parentShell);
	    
	  }

	  @Override
	  public void create() {
	    super.create();
	    setTitle("Choose the type of construct");
	    setMessage("Choose if you want to insert a critique or a constraint construct, and type his name.", IMessageProvider.INFORMATION);
	  }

	  @Override
	  protected Control createDialogArea(Composite parent) {
	    Composite area = (Composite) super.createDialogArea(parent);
	    
	    Composite radioComp = new Composite(area, SWT.NONE);
	    radioComp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
	    Button[] radios = new Button[2];

	    radios[0] = new Button(radioComp, SWT.RADIO);
	    radios[0].setSelection(false);
	    radios[0].setText("Critique");
	    radios[0].setBounds(10, 5, 75, 30);
	    
	    radios[1] = new Button(radioComp, SWT.RADIO);
	    radios[1].setText("Constraint");
	    radios[1].setBounds(10, 30, 75, 30);
	    radios[1].setSelection(false);
	   radios[0].addSelectionListener(new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			type="critique";
			//System.out.println(type);
			
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
	    });
	    radios[1].addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				type="constraint";
				//System.out.println(type);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	    Composite container = new Composite(area, SWT.NONE);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    GridLayout layout = new GridLayout(2, false);
	    container.setLayout(layout);

	    createContextName(container);
	    

	    return area;
	  }

	  private void createContextName(Composite container) {
	    Label lbtFirstName = new Label(container, SWT.NONE);
	    lbtFirstName.setText("Insert name");

	    GridData dataFirstName = new GridData();
	    dataFirstName.grabExcessHorizontalSpace = true;
	    dataFirstName.horizontalAlignment = GridData.FILL;

	    txtCritiqueName = new Text(container, SWT.BORDER);
	    txtCritiqueName.setLayoutData(dataFirstName);
	  }
	  
	  


	  @Override
	  protected boolean isResizable() {
	    return true;
	  }

	  // save content of the Text fields because they get disposed
	  // as soon as the Dialog closes
	  private void saveInput() {
	    contextName = txtCritiqueName.getText();
	   
	  }

	  @Override
	  protected void okPressed() {
	    if (type.equals("")) {
			System.out.println("Select type");
			return;
		}
	    if(txtCritiqueName.getText().isEmpty())
	    	return;
	    
		saveInput();
	    super.okPressed();
	  }

	  public String getName() {
	    return contextName;
	  }
	  public String getType(){
		  return this.type;
	  }

	  
}