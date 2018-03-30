package helpers;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import model.EOL_Library_Context_Item;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_F_Operation;
import model.EOL_Library_Th_Operation;

public class fillTreeModel2 {

	private Tree tree;
	private List<EOL_Library_Context_Item> context_list;
	private List<EOL_Library_Th_Operation> th_list;

	public fillTreeModel2(Tree tree, List<EOL_Library_Context_Item> contexts, List<EOL_Library_Th_Operation> thresholds) {
		this.tree = tree;
		this.context_list = contexts;
		this.th_list = thresholds;
	}

	public void fill() {
		tree.setRedraw(false);

		TreeItem contextRoot = new TreeItem(tree, SWT.NONE);
		contextRoot.setText("Context list");

		for (EOL_Library_Context_Item i : context_list) {
			TreeItem contextItem = new TreeItem(contextRoot, SWT.NONE);
			contextItem.setText(i.getName());
			contextItem.setData(i);
			
			TreeItem effeList = new TreeItem(contextItem, SWT.NONE);
			effeList.setText("F");
			effeList.setData(i);
			
			for (EOL_Library_F_Operation effeMap : i.geteffe()) {
				TreeItem effeItem = new TreeItem(effeList, SWT.NONE);
				effeItem.setText(effeMap.getName());
				effeItem.setData(i);
			}
			
			TreeItem duList = new TreeItem(contextItem, SWT.NONE);
			duList.setText("Do");
			duList.setData(i);
			
			for (EOL_Library_DO_Operation duMap : i.getdu()) {
				TreeItem duItem = new TreeItem(duList, SWT.NONE);
				duItem.setText(duMap.getName());
				duItem.setData(i);
			}
		}
		contextRoot.setExpanded(true);
		
		TreeItem threshold_Root = new TreeItem(tree, SWT.NONE);
		threshold_Root.setText("Thresholds list");
		
		for (EOL_Library_Th_Operation i : th_list) {
			TreeItem thItem = new TreeItem(threshold_Root, SWT.NONE);
			thItem.setText(i.getName());
			thItem.setData(i);
		}
		
		tree.setRedraw(true);
	}

}