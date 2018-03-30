package editors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import helpers.EOL_Utils;
import model.EOL_Library_F_Operation;
import model.EOL_Library_Operation_Superclass;
import views.EOL_Library_Tree;

/**
 * It extends Epsilon EolEditor in order to save changes to a single operation of an EOL file of the library 
 * 
 * @author Stefano
 *
 */
public class Local_EOL_Editor extends EolEditor {

	public static final String ID = "editors.LocalEolEditor";
	
	private EOL_Library_Operation_Superclass itemSelected;

	public Local_EOL_Editor() {
		super();
	}
	
	public EOL_Library_Operation_Superclass getItemSelected() {
		return itemSelected;
	}

	public void setItemSelected(EOL_Library_Operation_Superclass itemSelected) {
		this.itemSelected = itemSelected;
	}
	
	public List<String> getKeywords() {
		return super.getKeywords();
	}

	public List<String> getBuiltinVariables() {
		return super.getBuiltinVariables();
	}

	
	
	/**
	 * It retrieves selected operation from the library tree viewer and overwrites its piece of code in the corresponding EOL file
	 * 
	 * @see org.eclipse.epsilon.eol.dt.editor.EolEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		EolEditor editor = (EolEditor) page.getActiveEditor();
		
		

		File eol_file = new File(itemSelected.getEol_file());
		

		List<String[]> items = new ArrayList<String[]>();

		boolean foundOccurence = false;

		try {

			EolModule oldeolM = new EolModule();
			oldeolM.parse(eol_file);
			AST eolAST = oldeolM.getAst();

			List<AST> old_Ops_list = new ArrayList<AST>();

			// operations in the old eol file
			for (AST operation : AstUtil.getChildren(eolAST, 28)) {
				old_Ops_list.add(operation);
			}

			List<AST> new_Ops_list = new ArrayList<AST>();
			
			//clear eol file
			FileUtils.write(eol_file, "", false);

			//take the new operation from the editor area
			EolModule neweolM = new EolModule();
			neweolM.parse(editor.getText());
			eolAST = neweolM.getAst();

			AST new_operation = AstUtil.getChild(eolAST, 28);

			if (old_Ops_list.isEmpty()) { 

				// if eol file is new, the list of old operations is empty
				
				FileUtils.write(eol_file, new_operation.rewrite(), true);
				old_Ops_list.add(new_operation);
				
				if (new_operation.getFirstChild().getText().startsWith("th_")) {
					items.add(new String[] { new_operation.getFirstChild().getText(), "" });

				} else {
					items.add(new String[] { new_operation.getSecondChild().getText(), new_operation.getFirstChild().getText() });

				}

			} else {

				for (AST old_operation : old_Ops_list) {
					if (EOL_Utils.compare(old_operation, new_operation)) { 
						
						// search for operation to overwrite
						
						new_Ops_list.add(new_operation);
						if (new_operation.getFirstChild().getText().startsWith("th_")) {
							items.add(new String[] { new_operation.getFirstChild().getText(), "" });

						} else {
							items.add(new String[] { new_operation.getSecondChild().getText(), new_operation.getFirstChild().getText() });

						}

						FileUtils.write(eol_file, new_operation.rewrite(), true);

						foundOccurence = true;

					} else { 

						// if not found, add the old operation to the new file
						
						new_Ops_list.add(old_operation);
						if (old_operation.getFirstChild().getText().startsWith("th_")) {
							items.add(new String[] { old_operation.getFirstChild().getText(), "" });

						} else {
							items.add(new String[] { old_operation.getSecondChild().getText(), old_operation.getFirstChild().getText() });

						}

						FileUtils.write(eol_file, old_operation.rewrite(), true);
					}
				}

				if (foundOccurence) { 

					// operation overwritten. End.

					// OverwrittenOperationWarning dialog = new
					// OverwrittenOperationWarning(shell);
					// dialog.create();
					//
					// if (dialog.open() == Window.OK) {
					// return;
					// } else {
					// return;
					// }

				} else { 
					
					// no overwritten operation. Append the new operation to the end of the file.
					
					new_Ops_list.add(new_operation);
					if (new_operation.getFirstChild().getText().startsWith("th_")) {
						items.add(new String[] { new_operation.getFirstChild().getText(), "" });

					} else {
						items.add(new String[] { new_operation.getSecondChild().getText(), new_operation.getFirstChild().getText() });

					}

					FileUtils.write(eol_file, new_operation.rewrite(), true);
				}

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		super.doSave(progressMonitor);
		if (!supportsDirtyTextParsing())
			parseModule();
	}

	

}
