package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public class VariableDeclaration extends TypeInitialiser {
	
	protected List<Expression> parameterExpressions = new ArrayList<Expression>();
	protected NameExpression nameExpression = null;
	protected boolean instantiate;
	protected boolean external;
	protected TypeExpression typeExpression = null;
	
	public VariableDeclaration() {}
	
	public VariableDeclaration(NameExpression nameExpression, TypeExpression typeExpression, boolean instantiate, Expression... parameterExpressions) {
		this.nameExpression = nameExpression;
		this.typeExpression = typeExpression;
		this.instantiate = instantiate;
		for (Expression parameterExpression : parameterExpressions) {
			this.parameterExpressions.add(parameterExpression);
		}
	}
	
	@Override
	public void build() {
		super.build();
		nameExpression = (NameExpression) getFirstChild();
		instantiate = getText().equalsIgnoreCase("new");
		external = getText().equals("ext");
		typeExpression = (TypeExpression) getSecondChild();
		if (typeExpression != null) {
			AST parametersAst = typeExpression.getNextSibling();
			if (parametersAst != null) {
				for (AST parameterAst : parametersAst.getChildren()) {
					parameterExpressions.add((Expression) parameterAst);
				}
			}
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		EolType variableType = null;
		if (typeExpression == null){ // No type defined
			variableType = EolAnyType.Instance;
		}
		else { // Type defined
			variableType = (EolType) context.getExecutorFactory().executeAST(typeExpression, context);
		}
		
		if (external) {
			Variable variable = context.getFrameStack().get(getName());
			if (variable != null) { return variable; }
		}
		
		//TODO : Add try-catch and support for EolInstantiationExceptions
		Object newInstance = initialiseType(variableType, parameterExpressions, context, instantiate);
		
		Variable variable = new Variable(getName(), newInstance, variableType);
		context.getFrameStack().put(variable);
		return variable;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		if (typeExpression != null) typeExpression.compile(context);
		EolType type = null;
		if (typeExpression != null) type = typeExpression.getCompilationType();
		else type = EolAnyType.Instance;
		if (context.getFrameStack().getTopFrame().contains(getName())) {
			context.addErrorMarker(this, "Variable " + getName() + " has already been defined");
		}
		else {
			context.getFrameStack().put(new Variable(getName(), type));
		}
	}
	
	public String getName() {
		return nameExpression.getName();
	}
	
	public boolean isInstantiate() {
		return instantiate;
	}
	
	public void setInstantiate(boolean instantiate) {
		this.instantiate = instantiate;
	}
	
	public boolean isExternal() {
		return external;
	}
	
	public void setExternal(boolean external) {
		this.external = external;
	}
	
	public TypeExpression getTypeExpression() {
		return typeExpression;
	}
	
	public void setTypeExpression(TypeExpression typeExpression) {
		this.typeExpression = typeExpression;
	}
	
	public NameExpression getNameExpression() {
		return nameExpression;
	}
	
	public void setNameExpression(NameExpression nameExpression) {
		this.nameExpression = nameExpression;
	}
	
	public List<Expression> getParameterExpressions() {
		return parameterExpressions;
	}
}
