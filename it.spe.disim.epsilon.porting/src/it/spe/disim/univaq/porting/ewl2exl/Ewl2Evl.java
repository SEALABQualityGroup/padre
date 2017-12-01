package it.spe.disim.univaq.porting.ewl2exl;

import it.spe.disim.univaq.porting.Exl2Eyl;
import it.spe.disim.univaq.porting.util.PortingUtil;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.BooleanLiteral;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.ReturnStatement;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.Fix;
import org.eclipse.epsilon.evl.parse.EvlParser;
import org.eclipse.epsilon.ewl.parse.EwlParser;

public class Ewl2Evl extends Exl2Eyl {
	
	
	@SuppressWarnings("unchecked")
	public static AST ewl2evl(AST ewlAST){
		
		AST evlAST = PortingUtil.createModuleAST(EvlParser.EVLMODULE, "EVLMODULE");
		
		for(AST wizard : AstUtil.getChildren(ewlAST, EwlParser.WIZARD)){
			ConstraintContext context = PortingUtil.createConstaintContext("context");
			TypeExpression typeExpression = (TypeExpression) getContext(wizard); //TODO retrieve Context from ewl's ast tree
			context.setFirstChild(typeExpression);
			
			Constraint constraint = PortingUtil.createConstraint(wizard.getText());
			
			ExecutableBlock<Boolean> check = PortingUtil.createExecutableBooleanBlock(EvlParser.CHECK, "check");
			StatementBlock checkBlock = createCheckBlock(wizard);
			check.setFirstChild(checkBlock);
			constraint.setFirstChild(check);
			
			ExecutableBlock<String> message = PortingUtil.createExecutableStringBlock(EvlParser.MESSAGE, "message");
			StringLiteral strMessage = PortingUtil.createStringLiteral(wizard.getText());
			message.addChild(strMessage);
			constraint.addChild(message);
			
			Fix fix = PortingUtil.createFixBlock(EvlParser.FIX, "fix");
			ExecutableBlock<Void> doBlock = (ExecutableBlock<Void>) AstUtil.getChild(wizard, EwlParser.DO);
			ExecutableBlock<String> titleAST = (ExecutableBlock<String>) AstUtil.getChild(wizard, EwlParser.TITLE);
			fix.setFirstChild(titleAST); //title
			fix.addChild(doBlock);
			constraint.addChild(fix);
			
			context.addChild(constraint);
			evlAST.addChild(context);
		}
		
		return evlAST;
	}

	@SuppressWarnings("unchecked")
	private static AST getContext(AST wizard){
		ExecutableBlock<Boolean> guard = (ExecutableBlock<Boolean>)AstUtil.getChild(wizard, EwlParser.GUARD);
		
		NameExpression type = (NameExpression) findContext(guard, null);
		if(type != null){
			return PortingUtil.createTypeExpression(type.getText());
		}
		return null;
	}

	private static AST findContext(AST tree, AST returnValue) {
		if (tree != null && returnValue == null)
			for (AST child : tree.getChildren()) {
				if (isSelf(child)) {
					AST parent = child.getParent();
					if(parent instanceof OperationCallExpression){
						if(parent.getSecondChild() instanceof NameExpression && parent.getSecondChild().getText().equals("isTypeOf")){
							returnValue = parent.getSecondChild().getFirstChild().getFirstChild();
							return findContext(parent.getSecondChild().getFirstChild().getFirstChild(), returnValue);
						}
					}
				}
				return findContext(child, returnValue);
			}
		return returnValue;
	}
	
	private static StatementBlock createCheckBlock(AST wizardAST){
		IfStatement ifStatement = (IfStatement) PortingUtil
				.createIfStatement(EvlParser.IF, "if");
		
		ifStatement.setFirstChild(AstUtil.getChild(wizardAST,
				EwlParser.GUARD).getFirstChild());
		
		ReturnStatement returnStatement = (ReturnStatement) PortingUtil
				.createReturnStatement(EvlParser.RETURN, "return");
		BooleanLiteral falseLiteral = PortingUtil.createBooleanLiteral(EvlParser.BOOLEAN, "false");
		returnStatement.setFirstChild(falseLiteral);
		
		StatementBlock returnBlockFalse = PortingUtil.createStatementBlock(
				EvlParser.BLOCK, "BLOCK", returnStatement);
		returnBlockFalse.setFirstChild(returnStatement);
		ifStatement.addChild(returnBlockFalse);
		
		BooleanLiteral trueLiteral = PortingUtil.createBooleanLiteral(EvlParser.BOOLEAN, "true");
		Statement statementTrue = PortingUtil.createReturnStatement(EvlParser.RETURN, "return");
		statementTrue.setFirstChild(trueLiteral);
		
		Statement[] statements = {ifStatement, statementTrue};
		StatementBlock block = PortingUtil.createStatementBlock(
				EvlParser.BLOCK, "BLOCK", statements);
		block.setFirstChild(ifStatement);
		block.addChild(statementTrue);
		return block;
	}
	
}
