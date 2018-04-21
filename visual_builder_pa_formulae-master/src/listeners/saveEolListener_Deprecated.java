package listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import org.apache.commons.io.FileUtils;

public class saveEolListener_Deprecated implements SelectionListener {

	private Text eolcode;
	private org.eclipse.swt.widgets.List library, visualops;
	private String workspace;
	private File eol_file;
	private List<AST> ops;
	private boolean foundOccurence;

	AST eolAST;

	public saveEolListener_Deprecated(Text eolcode, org.eclipse.swt.widgets.List library, String workspace, List<AST> ops,
			org.eclipse.swt.widgets.List visualops) {

		this.eolcode = eolcode;
		this.library = library;
		this.workspace = workspace;
		this.ops = ops;
		this.visualops = visualops;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		
		foundOccurence = false;

		int[] selectedItems = library.getSelectionIndices();
		String outString = "";

		if (selectedItems.length > 0) {
			for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
				outString += selectedItems[loopIndex];

			String path = workspace + "\\" + library.getItem(Integer.parseInt(outString));
			eol_file = new File(path);

			try {

				EolModule oldeolM = new EolModule();

				oldeolM.parse(eol_file);

				eolAST = oldeolM.getAst();

				visualops.removeAll();
				ops.clear();
				for (AST operation : AstUtil.getChildren(eolAST, 28)) {
					ops.add(operation);
				}
				
				
				List<AST> tempOps = new ArrayList<AST>();
				FileUtils.write(eol_file, "", false);

				EolModule neweolM = new EolModule();
				neweolM.parse(eolcode.getText());
				eolAST = neweolM.getAst();

				for (AST operation : AstUtil.getChildren(eolAST, 28)) {

					if (ops.isEmpty()) {

						FileUtils.write(eol_file, operation.rewrite(), true);
						ops.add(operation);
						visualops.add(operation.getSecondChild().getText() + " for " + operation.getFirstChild().getText() + " context");
						
					} else {
						
						for (AST oldOp : ops) {
							if (compare(oldOp, operation)) {
								tempOps.add(operation);
								visualops.add(operation.getSecondChild().getText() + " for "
										+ operation.getFirstChild().getText() + " context");

								FileUtils.write(eol_file, operation.rewrite(), true);
								
								foundOccurence = true;

							} else {

								tempOps.add(oldOp);
								visualops.add(oldOp.getSecondChild().getText() + " for "
										+ oldOp.getFirstChild().getText() + " context");

								FileUtils.write(eol_file, oldOp.rewrite(), true);
							}
						}
						
						if (foundOccurence) {
							
							ops = tempOps;
							
//							OverwrittenOperationWarning dialog = new OverwrittenOperationWarning(shell);
//							dialog.create();
//							
//							if (dialog.open() == Window.OK) {
//								return;
//							}
//							else{
//								return;
//							}
//							
						} else {
							tempOps.add(operation);
							visualops.add(operation.getSecondChild().getText() + " for "
									+ operation.getFirstChild().getText() + " context");

							FileUtils.write(eol_file, operation.rewrite(), true);
							
							
							ops = tempOps;
						}
						
						
					}

				}

				

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
				eolcode.append("\n" + e1.getMessage());
			}
		} else {

//			SelectFileWarning dialog = new SelectFileWarning(shell);
//			dialog.create();
//			
//			if (dialog.open() == Window.OK) {
//				return;
//			}
//			else{
//				return;
//			}
		}

	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean compare(AST oldOp, AST newOp) {
		
		String firstold = oldOp.getFirstChild().getText();
		String firstnew = newOp.getFirstChild().getText();
		String secondold = oldOp.getSecondChild().getText();
		String secondnew = newOp.getSecondChild().getText();
		String thirdold = oldOp.getThirdChild().getText();
		String thirdnew = newOp.getThirdChild().getText();
		
		if (oldOp.getFourthChild() != null && newOp.getFourthChild() != null)
		{
			String fourold = oldOp.getFourthChild().getText();
			String fournew = newOp.getFourthChild().getText();
			
			if (firstold.equals(firstnew) && secondold.equals(secondnew) && thirdold.equals(thirdnew) && fourold.equals(fournew))
				return true;
			else 
				return false;
		}

		if (oldOp.getFourthChild() == null && newOp.getFourthChild() == null)
		{
			if (firstold.equals(firstnew) && secondold.equals(secondnew) && thirdold.equals(thirdnew))
				return true;
			else 
				return false;
		}
		
		return false;
			

//		if (oldOp.getThirdChild().getType() == EolParser.PARAMLIST) {
//			// Metodo con parametri
//
//			if (oldOp.getFourthChild().getType() == EolParser.BLOCK) {
//				// returns void
//				if (oldOp.getFirstChild().getText().equals(newOp.getFirstChild().getText())
//						&& oldOp.getSecondChild().getText().equals(newOp.getSecondChild().getText())
//						&& oldOp.getThirdChild().getText().equals(newOp.getThirdChild().getText()))
//					return true;
//				else
//					return false;
//			} else {
//				// returns a type
//				if (oldOp.getFirstChild().getText().equals(newOp.getFirstChild().getText())
//						&& oldOp.getSecondChild().getText().equals(newOp.getSecondChild().getText())
//						&& oldOp.getThirdChild().getText().equals(newOp.getThirdChild().getText())
//						&& oldOp.getFourthChild().getText().equals(newOp.getFourthChild().getText()))
//					return true;
//				else
//					return false;
//
//			}
//
//		} else {
//			if (oldOp.getSecondChild().getType() == EolParser.PARAMLIST) {
//				// metodo con parametri senza contesto
//
//				if (oldOp.getThirdChild().getType() == EolParser.BLOCK) {
//					// returns void
//					if (oldOp.getFirstChild().getText().equals(newOp.getFirstChild().getText())
//							&& oldOp.getSecondChild().getText().equals(newOp.getSecondChild().getText()))
//						return true;
//					else
//						return false;
//				} else {
//					// returns a type
//					if (oldOp.getFirstChild().getText().equals(newOp.getFirstChild().getText())
//							&& oldOp.getSecondChild().getText().equals(newOp.getSecondChild().getText())
//							&& oldOp.getThirdChild().getText().equals(newOp.getThirdChild().getText()))
//						return true;
//					else
//						return false;
//				}
//			} else {
//				// Metodi threshold
//				if (oldOp.getThirdChild().getType() == EolParser.BLOCK) {
//					if (oldOp.getFirstChild().getText().equals(newOp.getFirstChild().getText())
//							&& oldOp.getSecondChild().getText().equals(newOp.getSecondChild().getText()))
//						return true;
//					else
//						return false;
//
//				} else {
//					// metodi senza parametri
//					if (oldOp.getFirstChild().getText().equals(newOp.getFirstChild().getText())
//							&& oldOp.getSecondChild().getText().equals(newOp.getSecondChild().getText())
//							&& oldOp.getThirdChild().getText().equals(newOp.getThirdChild().getText()))
//						return true;
//					else
//						return false;
//				}
//			}
//
//		}
	}
}
