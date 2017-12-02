package listeners;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import model.Db;

public class saveEOLtoDBListener implements SelectionListener {

	private String workspace;

	AST eolAST;

	public saveEOLtoDBListener(String workspace) {

		this.workspace = workspace;
	}

	public void widgetSelected(SelectionEvent event) {

		Collection<File> allEols = FileUtils.listFiles(new File(workspace), new String[] { "eol" }, true);

		try {

			for (File eol_file : allEols) {
				EolModule eolM = new EolModule();

				eolM.parse(eol_file);

				eolAST = eolM.getAst();

				for (AST operation : AstUtil.getChildren(eolAST, 28)) {

					// threshold functions
					if (operation.getFirstChild().getText().startsWith("th_")) {
						Db.insert_Threshold_function(operation.getFirstChild().getText(), operation.rewrite());

						continue;
					}

					// metric functions
					if (operation.getSecondChild().getText().startsWith("F_")) {
						int return_bool = 0;

						if (operation.getThirdChild().getType() == EolParser.PARAMLIST) {
							// metodo con parametri
							if (operation.getFourthChild().getText().equals("Boolean"))
								return_bool = 1;

						} else {
							// semza parametri
							if (operation.getThirdChild().getText().equals("Boolean"))
								return_bool = 1;

						}

						Db.insert_Metric_function(operation.getFirstChild().getText(),
								operation.getSecondChild().getText(), operation.rewrite(), return_bool);

						continue;
					}

					
					// do_function
					Db.insert_Do_function(operation.getSecondChild().getText(), operation.getFirstChild().getText(),
							operation.rewrite());

				}

			}

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
