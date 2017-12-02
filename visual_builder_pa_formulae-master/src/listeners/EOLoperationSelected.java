package listeners;

import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;


public class EOLoperationSelected implements SelectionListener {

	private List<AST> ops;
	private org.eclipse.swt.widgets.List visualops;
	private Text eolcode;

	AST eolAST;

	public EOLoperationSelected(List<AST> ops, org.eclipse.swt.widgets.List visualops, Text area) {
		this.ops = ops;
		this.visualops = visualops;
		this.eolcode = area;
	}

	public void widgetSelected(SelectionEvent event) {
        int[] selectedItems = visualops.getSelectionIndices();
        String outString = "";
        for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
          outString += selectedItems[loopIndex];
        eolcode.setText(ops.get(Integer.parseInt(outString)).rewrite());
      }

      public void widgetDefaultSelected(SelectionEvent event) {
      }
}
