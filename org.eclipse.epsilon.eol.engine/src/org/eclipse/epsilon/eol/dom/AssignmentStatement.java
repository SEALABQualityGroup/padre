package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.parse.EolParser;

public class AssignmentStatement extends Statement {
	
	protected Expression targetExpression;
	protected Expression valueExpression;
	
	public AssignmentStatement() {}
	
	public AssignmentStatement(Expression targetExpression, Expression valueExpression) {
		this.targetExpression = targetExpression;
		this.valueExpression = valueExpression;
	}
	
	@Override
	public void build() {
		super.build();
		targetExpression = (Expression) getFirstChild();
		valueExpression = (Expression) getSecondChild();
		if (getText().equals("+=")) {
			valueExpression = new PlusOperatorExpression(targetExpression, valueExpression);
		}
		else if (getText().equals("-=")) {
			valueExpression = new MinusOperatorExpression(targetExpression, valueExpression);			
		}
		else if (getText().equals("/=")) {
			valueExpression = new DivOperatorExpression(targetExpression, valueExpression);			
		}
		else if (getText().equals("*=")) {
			valueExpression = new TimesOperatorExpression(targetExpression, valueExpression);			
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		// Executing the targetExpression can return either a Variable
		// or a SetterMethod with one argument (set method)
		// Executing the valueExpression will return an object
		
		Object targetExpressionResult = null;
		
		if (targetExpression instanceof PropertyCallExpression) {
			targetExpressionResult = ((PropertyCallExpression) targetExpression).execute(context, true);
		}
		else if (targetExpression instanceof NameExpression) {
			targetExpressionResult = ((NameExpression) targetExpression).execute(context, true);
		}
		else {
			targetExpressionResult = context.getExecutorFactory().executeAST(targetExpression, context);
		}
		
		Object valueExpressionResult = context.getExecutorFactory().executeAST(valueExpression, context);
		
		if (targetExpressionResult instanceof IPropertySetter){
			IPropertySetter setter = (IPropertySetter) targetExpressionResult;
			try {
				Object value = getValueEquivalent(setter.getObject(), valueExpressionResult, context);
				
				setter.invoke(value);
			}
			catch (EolRuntimeException ex){
				if (ex.getAst() == null) {
					ex.setAst(setter.getAst());
				}
				throw ex;
			}
		} else if (targetExpressionResult instanceof Variable){
			Variable variable = (Variable) targetExpressionResult;
			try {
				Object value = getValueEquivalent(variable.getValue(), valueExpressionResult, context);
				variable.setValue(value, context);
			}
			catch (EolRuntimeException ex){
				ex.setAst(targetExpression);
				throw ex;
			}
		} else {
			throw new EolRuntimeException("Internall error. Expected either a SetterMethod or a Variable and got an " + targetExpressionResult + "instead", this);
		}
		
		return null;
		
	}
	
	public Object getValueEquivalent(Object source, Object value, IEolContext context) throws EolRuntimeException {
		return value;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		targetExpression.compile(context);
		valueExpression.compile(context);
	}
	
	@Override
	public String rewrite(){
		String toString = "";
		
		AST p = getParent();
		while(p.getType() != EolParser.EOLMODULE)
		{
			if (p.getType() != EolParser.WHILE && p.getType() != EolParser.CASE && p.getType() != 36 && p.getType() != EolParser.HELPERMETHOD && p.getType() != EolParser.FOR && p.getType() != EolParser.IF)
			{
				toString += "\t";
			}
			p = p.getParent();
		}
		
		toString += getFirstChild().rewrite() + " " + getText() + " " + getSecondChild().rewrite() + ";";
		return toString;
	}
	
}
