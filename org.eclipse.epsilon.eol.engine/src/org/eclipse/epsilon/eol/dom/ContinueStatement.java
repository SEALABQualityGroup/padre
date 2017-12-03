package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ContinueStatement extends Statement {
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		throw new EolContinueException(this, context);
	}
	
	@Override
	public void compile(EolCompilationContext context) {}
	
	@Override
	public String rewrite(){
		String toString = "";

		//Indentazione
		AST p = getParent();
		while(p.getType() != EolParser.EOLMODULE && p.getType() != 89)
		{
			if (p.getType() != EolParser.BLOCK)
			{
				toString += "\t";
			}
			p = p.getParent();
		}
		
		toString += "continue;";
		return toString;
	}
}
