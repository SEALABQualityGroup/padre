package listeners;


import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import model.Db;

public class updateEOLonDBListener_Deprecated implements SelectionListener {

	private Text eolcode;

	List<Integer> F_ops, Th_ops, Do_ops;
	org.eclipse.swt.widgets.List Do_visualops, F_visualops, Th_visualops;
	AST eolAST;


	public updateEOLonDBListener_Deprecated(Text eolcode, List<Integer> F_ops, List<Integer> Th_ops, List<Integer> Do_ops,
			org.eclipse.swt.widgets.List Do_visualops, org.eclipse.swt.widgets.List F_visualops, org.eclipse.swt.widgets.List Th_visualops) {

		this.eolcode = eolcode;

		this.F_ops = F_ops;
		this.Th_ops = Th_ops;
		this.Do_ops = Do_ops;
		
		this.Do_visualops = Do_visualops;
		this.F_visualops = F_visualops;
		this.Th_visualops = Th_visualops;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		
		

		int[] selectedItems = Do_visualops.getSelectionIndices();
		String outString = "";

		if (selectedItems.length > 0) {
			for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
				outString += selectedItems[loopIndex];
			
			try {

				int operation_id = Do_ops.get(Integer.parseInt(outString));

				EolModule neweolM = new EolModule();
				neweolM.parse(eolcode.getText());
				eolAST = neweolM.getAst();
				
				AST operation = AstUtil.getChild(eolAST, 28);

				Db.set_Do_method_byId(operation_id, operation.rewrite());
				
				

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
				eolcode.append("\n" + e1.getMessage());
			}
		}

		
		
		
		
		
		selectedItems = Th_visualops.getSelectionIndices();
		outString = "";

		if (selectedItems.length > 0) {
			for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
				outString += selectedItems[loopIndex];
			
			try {

				int operation_id = Th_ops.get(Integer.parseInt(outString));

				EolModule neweolM = new EolModule();
				neweolM.parse(eolcode.getText());
				eolAST = neweolM.getAst();
				
				AST operation = AstUtil.getChild(eolAST, 28);

				Db.set_Th_method_byId(operation_id, operation.rewrite());
				
				

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
				eolcode.append("\n" + e1.getMessage());
			}
		}

		
		
		
		
		selectedItems = F_visualops.getSelectionIndices();
		outString = "";

		if (selectedItems.length > 0) {
			for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
				outString += selectedItems[loopIndex];
			
			try {

				int operation_id = F_ops.get(Integer.parseInt(outString));

				EolModule neweolM = new EolModule();
				neweolM.parse(eolcode.getText());
				eolAST = neweolM.getAst();
				
				AST operation = AstUtil.getChild(eolAST, 28);

				Db.set_F_method_byId(operation_id, operation.rewrite());
				
				

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
				eolcode.append("\n" + e1.getMessage());
			}
		}
		
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

}
