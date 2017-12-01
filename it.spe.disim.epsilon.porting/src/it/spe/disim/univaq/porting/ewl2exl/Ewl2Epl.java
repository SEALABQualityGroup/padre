package it.spe.disim.univaq.porting.ewl2exl;

import it.spe.disim.univaq.porting.Exl2Eyl;
import it.spe.disim.univaq.porting.util.PortingUtil;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dom.Role;
import org.eclipse.epsilon.epl.parse.EplParser;
import org.eclipse.epsilon.ewl.parse.EwlParser;

public class Ewl2Epl extends Exl2Eyl {
	
	public static AST ewl2epl(AST ewlAST){
		AST eplAST = PortingUtil.createModuleAST(EplParser.EPLMODULE, "EPLMODULE");
		
		for(AST wizard : ewlAST.getChildren()){
			Pattern pattern = PortingUtil.createPattern(wizard.getText());
			
			Role role = PortingUtil.createRole(EplParser.ROLE, ":");
			NameExpression mainRole = PortingUtil.createNameExpression("mainRole");
			role.setFirstChild(mainRole);
			NameExpression isTypeOf = PortingUtil.createNameExpression("Operation"); //TODO retrieve it from wizard's guard
			role.addChild(isTypeOf);
			pattern.addChild(role);
			
			AST match = PortingUtil.createModuleAST(EplParser.MATCH, "match");
			AST matchBlock = AstUtil.getChild(wizard, EwlParser.GUARD).getFirstChild();
			match.addChild(matchBlock);
			pattern.addChild(match);
			
			AST onMatch = PortingUtil.createModuleAST(EplParser.ONMATCH, "onmatch");
			AST onMatchBlock = AstUtil.getChild(wizard, EwlParser.DO).getFirstChild();
			onMatch.addChild(onMatchBlock);
			pattern.addChild(onMatch);
			
			eplAST.addChild(pattern);
		}
		
		return eplAST;
	}

}
