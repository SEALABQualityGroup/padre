package it.spe.disim.univaq.porting;

import org.eclipse.epsilon.common.parse.AST;

public abstract class Exl2Eyl {

	public static AST adapting4EPL(AST tree) {
		if (tree != null)
			for (AST child : tree.getChildren()) {
				if (isSelf(child)) {
					child.getToken().setText("mainRole");
				}
				adapting4EPL(child);
			}
		return null;
	}
	
	public static AST adapting4EWL(AST tree) {
		if (tree != null)
			for (AST child : tree.getChildren()) {
				if (isMainRole(child)) {
					child.getToken().setText("self");
				}
				adapting4EWL(child);
			}
		return null;
	}

	public static boolean isSelf(AST ast) {
		if ((ast.getToken().getType() == 19 || ast.getToken().getType() == 63)
				&& ast.getToken().getText().equals("self")) {
			return true;
		}
		return false;
	}
	
	public static boolean isMainRole(AST ast) {
		if ((ast.getToken().getType() == 19 || ast.getToken().getType() == 63)
				&& ast.getToken().getText().equals("mainRole")) {
			return true;
		}
		return false;
	}
}
