package it.spe.disim.univaq.porting.evl2exl;

import it.spe.disim.univaq.porting.Exl2Eyl;
import it.spe.disim.univaq.porting.util.PortingUtil;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AndOperatorExpression;
import org.eclipse.epsilon.eol.dom.BooleanLiteral;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.PlusOperatorExpression;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.ReturnStatement;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dom.Role;
import org.eclipse.epsilon.epl.parse.EplParser;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.Fix;
import org.eclipse.epsilon.evl.parse.EvlParser;
import org.eclipse.epsilon.ewl.dom.Wizard;
import org.eclipse.epsilon.ewl.parse.EwlParser;

public class Evl2Ewl extends Exl2Eyl {

	@SuppressWarnings("unchecked")
	public static AST evl2ewl(AST evlAST) {

		AST ewlAST = PortingUtil.createModuleAST(EwlParser.EWLMODULE,
				"EWLMODULE");
		
		for(AST im : AstUtil.getChildren(evlAST, EvlParser.IMPORT)){
			Import imp = PortingUtil.createImportBlock(EolParser.IMPORT,"../evl/"+im.getFirstChild().getText());
			ewlAST.addChild(imp);
		}
		
		for (AST context : AstUtil.getChildren(evlAST, EvlParser.CONTEXT)) {
			for (AST critique : AstUtil.getChildren(context, EvlParser.CRITIQUE)) {
				for (AST fix : AstUtil.getChildren(critique, EvlParser.FIX)) {
					Wizard wizard = PortingUtil.createWizard(critique.getText());
					wizard.setFirstChild(createGuardBlock(critique));
					ExecutableBlock<Void> doBlock = (ExecutableBlock<Void>) AstUtil.getChild(fix, EvlParser.DO);
					ExecutableBlock<String> titleBlock = (ExecutableBlock<String>) AstUtil.getChild(fix, EvlParser.TITLE);
					wizard.addChild(titleBlock);
					wizard.addChild(doBlock);
					ewlAST.addChild(wizard);
				}
			}
		}
		return ewlAST;
	}

	private static AST createGuardBlock(AST critiqueAST) {
		AST guard = PortingUtil.createExecutableBooleanBlock(EwlParser.GUARD,
				"guard");
		OperationCallExpression point = createEwlContext(critiqueAST
				.getParent());
		AndOperatorExpression and = PortingUtil
				.createAndOperatorExpression("and");
		and.setFirstChild(point);
		and.addChild(getCheckBlock(AstUtil.getChild(critiqueAST,
				EvlParser.CHECK).getFirstChild()));
		guard.setFirstChild(and);
		return guard;
	}

	private static OperationCallExpression createEwlContext(AST contextAST) {
		OperationCallExpression point = PortingUtil
				.createOperationCallExpression(".");
		NameExpression nameExp = PortingUtil.createNameExpression("self");
		NameExpression isTypeOf = PortingUtil.createNameExpression("isTypeOf");
		AST parameters = PortingUtil.createParameters("PARAMETERS");
		NameExpression context = PortingUtil.createNameExpression(contextAST
				.getFirstChild().getText());
		parameters.addChild(context);
		isTypeOf.addChild(parameters);
		point.setFirstChild(nameExp);
		point.addChild(isTypeOf);
		return point;
	}

	private static AST getCheckBlock(AST checkAST) {
		if (checkAST.getFirstChild() instanceof IfStatement) {
			return checkAST.getFirstChild().getFirstChild();
		}
		return checkAST.getFirstChild();
	}

}
