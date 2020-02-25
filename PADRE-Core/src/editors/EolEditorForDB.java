//package editors;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.epsilon.common.parse.AST;
//import org.eclipse.epsilon.common.util.AstUtil;
//import org.eclipse.epsilon.eol.EolModule;
//import org.eclipse.epsilon.eol.dt.editor.EolEditor;
//import org.eclipse.ui.IWorkbenchPage;
//import org.eclipse.ui.PlatformUI;
//
//import helpers.EOL_Utils;
//import model.Db;
//import views.F_OperationsOnDB;
//import views.Thresholds_OnDB;
//
//public class EolEditorForDB extends EolEditor {
//
//	public static final String ID = "editors.EolEditorForDB";
//	
//	public EolEditorForDB() {
//		super();		
//	}
//	
//	public List<String> getKeywords() {
//		return super.getKeywords();
//	}
//
//	public List<String> getBuiltinVariables() {
//		return super.getBuiltinVariables();
//	}
//
//	
//	
//	@Override
//	public void doSave(IProgressMonitor progressMonitor) {
//		// TODO Auto-generated method stub
//
//		try {
//			
//			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//			EolEditor editor = (EolEditor) page.getActiveEditor();
//			
//			EolModule eolM = new EolModule();
//
//			eolM.parse(editor.getText());
//
//			AST eolAST = eolM.getAst();
//			
//			AST new_operation = AstUtil.getChild(eolAST, 28);
//			
//			//thresholds functions
//			if (new_operation.getFirstChild().getText().startsWith("th_")) {
//				
//				Thresholds_OnDB th = (Thresholds_OnDB) page.findView("view.Thresholds_OnDB");
//
//				String th_method = null;
//				
//				th_method = Db.get_Th_method_byId(th.selectedOpID);
//				
//				eolM.parse(th_method);
//				eolAST = eolM.getAst();
//				
//				AST old_operation = AstUtil.getChild(eolAST, 28);
//				
//				if (EOL_Utils.compare(old_operation, new_operation))
//				{
//					Db.set_Th_method_byId(th.selectedOpID, new_operation.rewrite());
//				}
//				else
//				{
//					Db.insert_Threshold_function(new_operation.getFirstChild().getText(), new_operation.rewrite());
//				}
//				
//				super.doSave(progressMonitor);
//				if (!supportsDirtyTextParsing())
//					parseModule();
//				return;
//			}
//
//			// metric functions
//			if (new_operation.getSecondChild().getText().startsWith("F_")) {
//				
//				F_OperationsOnDB F = (F_OperationsOnDB) page.findView("view.F_OperationsOnDB");
//				
//				String f_method = null;
//				
//				f_method = Db.get_F_method_byId(F.selectedOpID);
//				
//				eolM.parse(f_method);
//				eolAST = eolM.getAst();
//				
//				AST old_operation = AstUtil.getChild(eolAST, 28);
//				
//				if (EOL_Utils.compare(old_operation, new_operation))
//				{
//					Db.set_F_method_byId(F.selectedOpID, new_operation.rewrite());
//				}
//				else
//				{
////					int return_bool = 0;
////
////					if (new_operation.getThirdChild().getType() == EolParser.PARAMLIST) {
////						// metodo con parametri
////						if (new_operation.getFourthChild().getText().equals("Boolean"))
////							return_bool = 1;
////
////					} else {
////						// semza parametri
////						if (new_operation.getThirdChild().getText().equals("Boolean"))
////							return_bool = 1;
////
////					}
//
//					Db.insert_Metric_function(new_operation.getFirstChild().getText(),
//							new_operation.getSecondChild().getText(), new_operation.rewrite());
//				}
//				
//				super.doSave(progressMonitor);
//				if (!supportsDirtyTextParsing())
//					parseModule();
//				return;
//			}
//
//			
//			//else do functions
//			F_OperationsOnDB redo = (F_OperationsOnDB) page.findView("view.Do_OperationsOnDB");
//
//			String do_method = null;
//			
//			do_method = Db.get_Do_method_byId(redo.selectedOpID);
//			
//			eolM.parse(do_method);
//			eolAST = eolM.getAst();
//			
//			AST old_operation = AstUtil.getChild(eolAST, 28);
//
//			if (EOL_Utils.compare(old_operation, new_operation))
//			{
//				Db.set_Do_method_byId(redo.selectedOpID, new_operation.rewrite());
//			}
//			else
//			{
//				// do_function
//				Db.insert_Do_function(new_operation.getSecondChild().getText(), new_operation.getFirstChild().getText(),
//						new_operation.rewrite());
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		super.doSave(progressMonitor);
//		if (!supportsDirtyTextParsing())
//			parseModule();
//	}
//
//	
//}
