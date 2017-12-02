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
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import view.Operations;

public class LocalEolEditor extends EolEditor {

	public static final String ID = "editors.LocalEolEditor";
	
	public LocalEolEditor() {
		super();		
	}
	
	public List<String> getKeywords() {
		return super.getKeywords();
	}

	public List<String> getBuiltinVariables() {
		return super.getBuiltinVariables();
	}

	
	
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// TODO Auto-generated method stub

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		Operations o = (Operations) page.findView("view.Operations");

		EolEditor editor = (EolEditor) page.getActiveEditor();
		
		

		File eol_file = o.getSelectedEolfile();
		List<AST> old_Ops_list = o.ops;
		TableViewer visualops = o.tableViewer;

		List<String[]> items = new ArrayList<String[]>();

		boolean foundOccurence = false;

		try {

			EolModule oldeolM = new EolModule();

			oldeolM.parse(eol_file);

			AST eolAST = oldeolM.getAst();

			visualops.setInput(null);
			old_Ops_list.clear();

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
					if (compare(old_operation, new_operation)) { 
						
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

						// if not found add the old operation to the new file
						
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

			visualops.setInput(items);
			o.ops = new_Ops_list;

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			editor.insertText("\n" + e1.getMessage());
		}

		super.doSave(progressMonitor);
		if (!supportsDirtyTextParsing())
			parseModule();
	}

	public boolean compare(AST oldOp, AST newOp) {

		String firstold = oldOp.getFirstChild().getText();
		String firstnew = newOp.getFirstChild().getText();
		String secondold = oldOp.getSecondChild().getText();
		String secondnew = newOp.getSecondChild().getText();
		String thirdold = oldOp.getThirdChild().getText();
		String thirdnew = newOp.getThirdChild().getText();

		if (oldOp.getFourthChild() != null && newOp.getFourthChild() != null) {
			String fourold = oldOp.getFourthChild().getText();
			String fournew = newOp.getFourthChild().getText();

			if (firstold.equals(firstnew) && secondold.equals(secondnew) && thirdold.equals(thirdnew)
					&& fourold.equals(fournew))
				return true;
			else
				return false;
		}

		if (oldOp.getFourthChild() == null && newOp.getFourthChild() == null) {
			if (firstold.equals(firstnew) && secondold.equals(secondnew) && thirdold.equals(thirdnew))
				return true;
			else
				return false;
		}

		return false;
	}

}
