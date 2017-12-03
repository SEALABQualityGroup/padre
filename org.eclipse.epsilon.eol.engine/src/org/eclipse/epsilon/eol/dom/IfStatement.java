package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public class IfStatement extends Statement {
	
	protected Expression conditionExpression;
	protected StatementBlock thenStatementBlock;
	protected StatementBlock elseStatementBlock;
	
	public IfStatement() {}
	
	public IfStatement(Expression conditionExpression, StatementBlock thenStatementBlock, StatementBlock elseStatementBlock) {
		this.conditionExpression = conditionExpression;
		this.thenStatementBlock = thenStatementBlock;
		this.elseStatementBlock = elseStatementBlock;
	}

	@Override
	public void build() {
		super.build();
		conditionExpression = (Expression) getFirstChild();
		thenStatementBlock = toStatementBlock(getSecondChild());
		if (getChildCount() == 3) elseStatementBlock = toStatementBlock(getThirdChild());
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
		Object condition = context.getExecutorFactory().executeAST(conditionExpression, context);
		
		if (!(condition instanceof Boolean)) throw new EolIllegalReturnException("Boolean", condition, conditionExpression, context);
		
		Object result = null;
		
		if (((Boolean) condition).booleanValue()){
			result = context.getExecutorFactory().executeAST(thenStatementBlock, context);
		}
		else if (elseStatementBlock != null){
			result = context.getExecutorFactory().executeAST(elseStatementBlock, context);
		}
		
		context.getFrameStack().leaveLocal(this);
		return result;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		conditionExpression.compile(context);
		
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, thenStatementBlock);
		thenStatementBlock.compile(context);
		context.getFrameStack().leaveLocal(thenStatementBlock);
		
		if (elseStatementBlock != null) {
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, elseStatementBlock);
			elseStatementBlock.compile(context);
			context.getFrameStack().leaveLocal(elseStatementBlock);
		}
		
		if (conditionExpression.hasResolvedType() && conditionExpression.getResolvedType() != EolPrimitiveType.Boolean) {
			context.getMarkers().add(new ModuleMarker(conditionExpression, "Condition must be a Boolean", Severity.Error));
		}
		
	}
	
	public Expression getConditionExpression() {
		return conditionExpression;
	}
	
	public void setConditionExpression(Expression conditionExpression) {
		this.conditionExpression = conditionExpression;
	}
	
	public StatementBlock getThenStatementBlock() {
		return thenStatementBlock;
	}
	
	public void setThenStatementBlock(StatementBlock thenStatementBlock) {
		this.thenStatementBlock = thenStatementBlock;
	}
	
	public StatementBlock getElseStatementBlock() {
		return elseStatementBlock;
	}
	
	public void setElseStatementBlock(StatementBlock elseStatementBlock) {
		this.elseStatementBlock = elseStatementBlock;
	}
	
	@Override
	public String rewrite(){

		String toString = "\n";
		
		//Indentazione
		AST p = getParent();
		while(p.getType() != EolParser.EOLMODULE && p.getType() != 89)
		{
			if (p.getType() != EolParser.WHILE && p.getType() != EolParser.CASE && p.getType() != 36 && p.getType() != EolParser.HELPERMETHOD && p.getType() != EolParser.FOR && p.getType() != EolParser.IF)
			{
				toString += "\t";
			}
			p = p.getParent();
		}
			
		toString += "if" +"( ";
		
		AST first = getFirstChild();
		AST second = getSecondChild();
		AST third = getThirdChild();
		
		toString += first.rewrite() + " )\n";
		
		if (third != null)
		{
			toString += second.rewrite();
			toString += toString.substring(0,  toString.indexOf("if")) + "else\n" + third.rewrite();
		}
		else
		{
			if (second instanceof OperationCallExpression)
			{
				toString += toString.substring(1, toString.indexOf("if")) + "\t" + second.rewrite() + ";";
			}
			else
			{
				toString += second.rewrite();
			}
			
		}	
		
		return toString;
	}
}
