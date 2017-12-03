package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ExpressionInBrackets extends Expression {
	
	protected Expression expression;
	
	@Override
	public void build() {
		super.build();
		expression = (Expression) getFirstChild();
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return context.getExecutorFactory().executeAST(expression, context);
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		expression.compile(context);
		resolvedType = expression.getResolvedType();
	}
	
	@Override
	public String rewrite(){
		String toString = "";
		
		//Indentazione
		if (getParent().getType() == EolParser.BLOCK)
		{
			AST p = getParent();
			while(p.getType() != EolParser.EOLMODULE && p.getType() != EolParser.T__92 && p.getType() != EolParser.T__84 && p.getType() != EolParser.T__89)
			{
				if (p.getType() != EolParser.HELPERMETHOD && p.getType() != EolParser.FOR && p.getType() != EolParser.IF && p.getType() != EolParser.T__86)
				{
					toString += "\t";
				}
				
				p = p.getParent();
			}
		}
		
		
		toString += getText();
		for(AST child : getChildren()){
			toString += child.rewrite();
		}
		toString += ")";
		
		if (getParent().getType() == EolParser.BLOCK)
		{
			toString += ";";
		}
		return toString;
	}
}
