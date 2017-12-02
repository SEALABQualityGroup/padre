package listeners;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import model.Db;


public class DB_Th_operationSelected implements SelectionListener {

	private List<Integer> ops;
	private org.eclipse.swt.widgets.List visualops;
	private Text eolcode;

	AST eolAST;

	public DB_Th_operationSelected(List<Integer> ops, org.eclipse.swt.widgets.List visualops, Text area) {
		this.ops = ops;
		this.visualops = visualops;
		this.eolcode = area;
	}

	public void widgetSelected(SelectionEvent event) {
		int[] selectedItems = visualops.getSelectionIndices();
        String outString = "";
        for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
          outString += selectedItems[loopIndex];
        
        int operation_id = ops.get(Integer.parseInt(outString));
        
        String th_method = null;
		try {
			th_method = Db.get_Th_method_byId(operation_id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        eolcode.setText(th_method);
      }

      public void widgetDefaultSelected(SelectionEvent event) {
    	  int[] selectedItems = visualops.getSelectionIndices();
          String outString = "";
          for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
            outString += selectedItems[loopIndex];
          
          int operation_id = ops.get(Integer.parseInt(outString));
          
          String th_method = null;
  		try {
  			th_method = Db.get_Th_method_byId(operation_id);
  		} catch (ClassNotFoundException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
          eolcode.setText(th_method);
      }
}
