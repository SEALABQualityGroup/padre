package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;


public abstract class Expression extends AbstractExecutableModuleElement {
	
	protected EolType resolvedType = EolAnyType.Instance;
	
	public EolType getResolvedType() {
		return resolvedType;
	}
	
	public boolean hasResolvedType() {
		return resolvedType != null &&
			resolvedType != EolAnyType.Instance;
	}
	
	@Override
	public String rewrite(){
		String toString = "";
		toString += getFirstChild().rewrite() + " " + getText() + " " + getSecondChild().rewrite();
		return toString;
	}
}
