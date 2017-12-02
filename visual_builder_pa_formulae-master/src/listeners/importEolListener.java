package listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class importEolListener implements SelectionListener {

	private List<AST> ops = new ArrayList<AST>();
	private org.eclipse.swt.widgets.List visualops;
	private Shell shell;

	AST eolAST;

	public importEolListener(List<AST> ops, org.eclipse.swt.widgets.List visualops, Shell s) {
		this.ops = ops;
		this.visualops = visualops;
		this.shell = s;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		FileDialog dialog = new FileDialog(shell);
		dialog.setText("Load EOL code...");
		dialog.setFilterPath("c:\\");
		dialog.setFilterNames(new String[] { "All Files (*.eol)" });
		dialog.setFilterExtensions(new String[] { "*.eol" });
		String dir = dialog.open();
		

		try {
			
			File eol_file = new File(dir);
			EolModule eolM = new EolModule();

			eolM.parse(eol_file);

			eolAST = eolM.getAst();

			visualops.removeAll();
			ops.clear();
			for (AST operation : AstUtil.getChildren(eolAST, 28)) {
				visualops.add(operation.getSecondChild().getText() + " for " + operation.getFirstChild().getText() + " context");
				ops.add(operation);
			}

			

			
			// for(AST im : AstUtil.getChildren(eolAST, 28)){
			// console.setText(im.getFirstChild().getText());
			// Import imp =
			// PortingUtil.createImportBlock(EolParser.IMPORT,"../evl/"+im.getFirstChild().getText());
			// eplAST.addChild(imp);
			// }

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
//			eolcode.setText("No library selected");
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}
}
