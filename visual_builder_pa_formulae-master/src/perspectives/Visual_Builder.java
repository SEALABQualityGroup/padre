package perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * It represents the perspective of the plug-in, identified as EVL Visual Builder
 * It allows to change the default size of views
 * 
 * @author Stefano Di Francesco
 *
 */
public class Visual_Builder implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {

		String editorArea = layout.getEditorArea();
		
		layout.addView(IPageLayout.ID_PROJECT_EXPLORER, IPageLayout.TOP, 0.7f, editorArea);
		
		layout.addView("views.EVL_Tree", IPageLayout.RIGHT, 0.4f, "views.EOL_Library_Tree");
		
		layout.addView("views.EOL_Library_Tree", IPageLayout.RIGHT, 0.4f, IPageLayout.ID_PROJECT_EXPLORER);
		
		
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, (float) 0.7, "views.EVL_Tree");
		right.addView("views.F_OperationsOnDB");
		right.addView("views.Thresholds_OnDB");
		right.addView("views.Do_OperationsOnDB");
		
		IFolderLayout bottomright = layout.createFolder("bottomright", IPageLayout.BOTTOM, (float) 0.7, "views.EVL_Tree");
		bottomright.addView("org.eclipse.epsilon.evl.dt.views.ValidationView");
		bottomright.addView("org.eclipse.ui.console.ConsoleView");
		
	}

}
