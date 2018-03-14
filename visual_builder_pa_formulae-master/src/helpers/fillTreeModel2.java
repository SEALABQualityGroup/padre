package helpers;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import model.Context2;
import model.Do_operation;
import model.F_operation;
import model.Th_operation;

public class fillTreeModel2 {

	private Tree tree;
	private List<Context2> context_list;
	private List<Th_operation> th_list;

	public fillTreeModel2(Tree tree, List<Context2> contexts, List<Th_operation> thresholds) {
		this.tree = tree;
		this.context_list = contexts;
		this.th_list = thresholds;
	}

	public void fill() {
		tree.setRedraw(false);

		TreeItem contextRoot = new TreeItem(tree, SWT.NONE);
		contextRoot.setText("Context list");

		for (Context2 i : context_list) {
			TreeItem contextItem = new TreeItem(contextRoot, SWT.NONE);
			contextItem.setText(i.getName());
			contextItem.setData(i);
			
			TreeItem effeList = new TreeItem(contextItem, SWT.NONE);
			effeList.setText("F");
			effeList.setData(i);
			
			for (F_operation effeMap : i.geteffe()) {
				TreeItem effeItem = new TreeItem(effeList, SWT.NONE);
				effeItem.setText(effeMap.getName());
				effeItem.setData(i);
			}
			
			TreeItem duList = new TreeItem(contextItem, SWT.NONE);
			duList.setText("Do");
			duList.setData(i);
			
			for (Do_operation duMap : i.getdu()) {
				TreeItem duItem = new TreeItem(duList, SWT.NONE);
				duItem.setText(duMap.getName());
				duItem.setData(i);
			}
		}
		contextRoot.setExpanded(true);
		
		TreeItem threshold_Root = new TreeItem(tree, SWT.NONE);
		threshold_Root.setText("Thresholds list");
		
		for (Th_operation i : th_list) {
			TreeItem thItem = new TreeItem(threshold_Root, SWT.NONE);
			thItem.setText(i.getName());
			thItem.setData(i);
		}
		
		tree.setRedraw(true);
	}

}