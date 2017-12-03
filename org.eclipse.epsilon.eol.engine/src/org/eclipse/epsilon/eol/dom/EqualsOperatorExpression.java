package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolObjectComparator;

public class EqualsOperatorExpression extends EagerOperatorExpression {

	public EqualsOperatorExpression() {}
	
	public EqualsOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	@Override
	public Object execute(Object o1, Object o2, IEolContext context) throws EolRuntimeException {
		return EolObjectComparator.equals(o1, o2);
	}
	
	@Override
	public String rewrite(){
		String toString = "";
		
		
		if(getParent() instanceof StatementBlock){
			AST p = getParent();
			while(p.getType() != EolParser.EOLMODULE && p.getType() != EolParser.T__92 && p.getType() != EolParser.T__84 && p.getType() != EolParser.T__89)
			{
				if (p.getType() != EolParser.WHILE && p.getType() != EolParser.ELSE && p.getType() != EolParser.CASE && p.getType() != 36 && p.getType() != EolParser.HELPERMETHOD && p.getType() != EolParser.FOR && p.getType() != EolParser.IF && p.getType() != EolParser.T__86)
				{
					toString += "\t";
				}
				
				p = p.getParent();
			}
			
			toString += getFirstChild().rewrite() + " == " + getSecondChild().rewrite() + ";";
		}
		else
		{
			toString += getFirstChild().rewrite() + " == " + getSecondChild().rewrite() + "";
		}
		
		return toString;
	}
	
}
