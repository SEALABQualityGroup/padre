//package actions;
//
//import java.io.File;
//
//import org.eclipse.core.runtime.Path;
//import org.eclipse.epsilon.common.parse.AST;
//import org.eclipse.epsilon.evl.EvlModule;
//import org.eclipse.jface.action.Action;
//import org.eclipse.jface.viewers.TreeViewer;
//import org.eclipse.jface.window.Window;
//
//import dialogs.MessageDialog_EXL_Name;
////import it.univaq.disim.sealab.padre.epsilon_porting.evl2exl.Evl2Epl;
////import it.univaq.disim.sealab.padre.epsilon_porting.util.PortingUtil;
//import model.EVL_Tree_Root;
//
///**
// * It saves the EVL tree as an EPL file code
// *
// */
//public class Save_EPL_file_Action extends Action {
//
//	private TreeViewer evltree;
//	private EVL_Tree_Root evl;
//	private String eol_library_path;
//
//	public Save_EPL_file_Action(TreeViewer evltree, EVL_Tree_Root evl, String eol_library_path) {
//		super();
//		this.evltree = evltree;
//		this.evl = evl;
//		this.eol_library_path = eol_library_path;
//	}
//	
//	public void run() {
//		
//		String eplfileName = "";
//		MessageDialog_EXL_Name dialog2 = new MessageDialog_EXL_Name(evltree.getControl().getShell());
//		dialog2.create();
//		if (dialog2.open() == Window.OK) {
//			eplfileName = dialog2.getName();
//
//		} else {
//			return;
//		}
//		
//		String dir = Path.fromOSString(eol_library_path).removeLastSegments(1).toPortableString();
//		dir = Path.fromPortableString(dir).append(eplfileName + ".epl").toPortableString();
//		File EPL_file;
//		EPL_file = new File(dir);
//
//		try {
//
//			EvlModule evlM = new EvlModule();
//			evlM.parse(evl.toString());
//			AST evlAST = evlM.getAst();
////			AST eplASTGen = Evl2Epl.evl2epl(evlAST);
////			PortingUtil.ast2file(eplASTGen, EPL_file);
//
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//	}
//}
