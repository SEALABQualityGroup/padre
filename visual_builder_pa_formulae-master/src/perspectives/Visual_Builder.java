package perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Visual_Builder implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		// TODO Auto-generated method stub

		String editorArea = layout.getEditorArea();
		
		layout.addView(IPageLayout.ID_PROJECT_EXPLORER, IPageLayout.TOP, 0.7f, editorArea);
		
		layout.addView("view.EVLtree", IPageLayout.RIGHT, 0.4f, "view.EOL_Library_Tree");
		
		layout.addView("view.EOL_Library_Tree", IPageLayout.RIGHT, 0.4f, IPageLayout.ID_PROJECT_EXPLORER);
		
		
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, (float) 0.7, "view.EVLtree");
		right.addView("view.F_OperationsOnDB");
		right.addView("view.Thresholds_OnDB");
		right.addView("view.Do_OperationsOnDB");
		
		layout.addView("org.eclipse.epsilon.evl.dt.views.ValidationView", IPageLayout.BOTTOM, 0.7f, "view.EVLtree");

	}

}
