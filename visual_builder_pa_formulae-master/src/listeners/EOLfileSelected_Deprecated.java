package listeners;

import java.io.File;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class EOLfileSelected_Deprecated implements SelectionListener {

	private List<AST> ops;
	private org.eclipse.swt.widgets.List visualops, library;
	private String workspace;

	AST eolAST;

	public EOLfileSelected_Deprecated(List<AST> ops, org.eclipse.swt.widgets.List library, org.eclipse.swt.widgets.List visualops, String workspace) {
		this.ops = ops;
		this.visualops = visualops;
		this.library = library;
		this.workspace = workspace;
	}

	public void widgetSelected(SelectionEvent event) {
		int[] selectedItems = library.getSelectionIndices();
		String outString = "";
		for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
			outString += selectedItems[loopIndex];

		try {

			File eol_file = new File(workspace + "\\" + library.getItem(Integer.parseInt(outString)));

			EolModule eolM = new EolModule();

			eolM.parse(eol_file);

			eolAST = eolM.getAst();

			visualops.removeAll();
			ops.clear();
			for (AST operation : AstUtil.getChildren(eolAST, 28)) {
				visualops.add(operation.getSecondChild().getText() + " for " + operation.getFirstChild().getText()
						+ " context");
				ops.add(operation);
			}
			
			if (ops.isEmpty())
				visualops.add("No operations");

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			// eolcode.setText("No library selected");
		}
	}

	public void widgetDefaultSelected(SelectionEvent event) {
		// TODO Auto-generated method stub
	}
}
