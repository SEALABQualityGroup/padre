package helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import model.EOL_Library_Context_Item;
import model.EOL_Library_DO_Operation;
import model.EOL_Library_Root;
import model.EOL_Library_F_Operation;
import model.EOL_Library_Th_Operation;

/**
 * It contains a comparator for EOL operations
 * and the code to initialize the EOL library data structure
 *
 */
public class EOL_Utils {

	/**
	 * It compares two operations
	 * @param oldOp It represents the first operation of the comparison
	 * @param newOp It represents the second operation of the comparison
	 * @return true if the signatures of the operations are the same, false otherwise
	 */
	public static boolean compare(AST oldOp, AST newOp) {

		String firstold = oldOp.getFirstChild().getText();
		String firstnew = newOp.getFirstChild().getText();
		String secondold = oldOp.getSecondChild().getText();
		String secondnew = newOp.getSecondChild().getText();
		String thirdold = oldOp.getThirdChild().getText();
		String thirdnew = newOp.getThirdChild().getText();

		if (oldOp.getFourthChild() != null && newOp.getFourthChild() != null) {
			String fourold = oldOp.getFourthChild().getText();
			String fournew = newOp.getFourthChild().getText();

			if (firstold.equals(firstnew) && secondold.equals(secondnew) && thirdold.equals(thirdnew)
					&& fourold.equals(fournew))
				return true;
			else
				return false;
		}

		if (oldOp.getFourthChild() == null && newOp.getFourthChild() == null) {
			if (firstold.equals(firstnew) && secondold.equals(secondnew) && thirdold.equals(thirdnew))
				return true;
			else
				return false;
		}

		return false;
	}
	
	public static void update_EOL_Library_Data_Structure(String library_path) {
		AST eolAST;

//		if (changed.size() > 0) {
//			for (IResource r : changed) {
//
//				File eol_file = r.getFullPath().toFile();
//				EolModule eolM = new EolModule();
//
//				try {
//					eolM.parse(eol_file);
//
//					eolAST = eolM.getAst();
//					
//					Th_operation[] ths= (Th_operation[]) thresholds.toArray();
//					
//					for (AST operation : AstUtil.getChildren(eolAST, 28)) {
//						
//						for (Th_operation t : thresholds) {
//							if (t.getEol_file().equals(eol_file.getCanonicalPath())) {
//								
//							}
//						}
//						
//					}
//					
//
//					TreePath[] treePaths = treeViewer.getExpandedTreePaths();
//					treeViewer.refresh();
//					treeViewer.setExpandedTreePaths(treePaths);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			}
//		} else {
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		views.EOL_Library_Tree eolview = (views.EOL_Library_Tree) page.findView("views.EOL_Library_Tree");
		
		ArrayList<EOL_Library_Context_Item> contexts = new ArrayList<EOL_Library_Context_Item>();
		ArrayList<EOL_Library_Th_Operation> thresholds = new ArrayList<EOL_Library_Th_Operation>();
			try {

				Collection<File> allEols = FileUtils.listFiles(new File(library_path), new String[] { "eol" }, true);

				for (File eol_file : allEols) {
					EolModule eolM = new EolModule();

					eolM.parse(eol_file);

					eolAST = eolM.getAst();

					for (AST operation : AstUtil.getChildren(eolAST, 28)) {

						// threshold functions
						if (operation.getFirstChild().getText().startsWith("th_")) {

							thresholds.add(new EOL_Library_Th_Operation(operation.getFirstChild().getText(), operation.rewrite(),
									eol_file.getCanonicalPath()));
							continue;
						}

						// metric functions
						if (operation.getSecondChild().getText().startsWith("F_")) {

							boolean found = false;
							for (EOL_Library_Context_Item c : contexts) {
								if (operation.getFirstChild().getText().equals(c.getName())) {
									c.geteffe()
											.add(new EOL_Library_F_Operation(operation.getSecondChild().getText(),
													operation.getFirstChild().getText(), operation.rewrite(), eol_file.getAbsolutePath()));
									found = true;
								}
							}

							if (!found) {
								EOL_Library_Context_Item nuovo = new EOL_Library_Context_Item();
								nuovo.setName(operation.getFirstChild().getText());
								List<EOL_Library_F_Operation> nuovoeffe = new ArrayList<EOL_Library_F_Operation>();
								nuovoeffe.add(new EOL_Library_F_Operation(operation.getSecondChild().getText(),
										operation.getFirstChild().getText(), operation.rewrite(),
										eol_file.getCanonicalPath()));
								nuovo.seteffe(nuovoeffe);
								contexts.add(nuovo);
							}

							continue;
						}

						// do_function
						boolean found = false;
						for (EOL_Library_Context_Item c : contexts) {
							if (operation.getFirstChild().getText().equals(c.getName())) {
								c.getdu()
										.add(new EOL_Library_DO_Operation(operation.getSecondChild().getText(),
												operation.getFirstChild().getText(), operation.rewrite(),
												eol_file.getAbsolutePath()));
								found = true;
							}
						}

						if (!found) {
							EOL_Library_Context_Item nuovo = new EOL_Library_Context_Item();
							nuovo.setName(operation.getFirstChild().getText());
							List<EOL_Library_DO_Operation> nuovodu = new ArrayList<EOL_Library_DO_Operation>();
							nuovodu.add(new EOL_Library_DO_Operation(operation.getSecondChild().getText(),
									operation.getFirstChild().getText(), operation.rewrite(),
									eol_file.getAbsolutePath()));
							nuovo.setdu(nuovodu);
							contexts.add(nuovo);
						}

					}

				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			EOL_Library_Root root = new EOL_Library_Root(contexts, thresholds, "library 1");
			root.setPath(library_path);

			eolview.getTreeFilter().setSearchText(".*");
			eolview.getTreeFilter().setOperationType(".*");
			
			eolview.eoltree.setInput(root);

			eolview.eoltree.setExpandedState(root, true);


			IWorkbenchPage page1 = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			views.EVL_Tree evlview = (views.EVL_Tree) page1.findView("views.EVL_Tree");

			evlview.setEol_library_path(library_path);
			evlview.setContexts(contexts);
			evlview.setActions();
			 
		}
	//}
}
