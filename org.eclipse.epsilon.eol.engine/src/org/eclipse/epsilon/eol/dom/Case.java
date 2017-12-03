package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.parse.EolParser;

public class Case extends AbstractModuleElement {
	
	protected Expression condition;
	protected StatementBlock body;
	
	@Override
	public void build() {
		super.build();
		if (getChildCount() == 2) { // regular case
			condition = (Expression) getFirstChild();
			body = (StatementBlock) getSecondChild();
		} else { // default
			body = (StatementBlock) getFirstChild();
		}
	}
	
	public Expression getCondition() {
		return condition;
	}
	
	public void setCondition(Expression condition) {
		this.condition = condition;
	}
	
	public StatementBlock getBody() {
		return body;
	}
	
	public void setBody(StatementBlock body) {
		this.body = body;
	}
	
	@Override
	public String rewrite(){
		
		String toString = "\n";
		
		AST p = getParent();
		while(p.getType() != EolParser.EOLMODULE)
		{
			if (p.getType() != EolParser.BLOCK)
			{
				toString += "\t";
			}
			p = p.getParent();
		}
			
		toString += getText() + " " + getFirstChild().rewrite() + " :\n";
		
		
		for(AST child : getChildren())
		{
			if (child.getType() != EolParser.STRING)
				toString += child.rewrite();
		}
		
		return toString;
	}
}
