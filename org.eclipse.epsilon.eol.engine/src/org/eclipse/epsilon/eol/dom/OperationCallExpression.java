package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.execute.operations.simple.SimpleOperation;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolNoType;

public class OperationCallExpression extends FeatureCallExpression {
	
	protected NameExpression nameExpression = null;
	protected List<Expression> parameterExpressions = new ArrayList<Expression>();
	protected boolean contextless;
	
	public OperationCallExpression() {}
	
	public OperationCallExpression(Expression targetExpression, NameExpression nameExpression, Expression... parameterExpressions) {
		this.targetExpression = targetExpression;
		this.nameExpression = nameExpression;
		this.contextless = (targetExpression == null);
		for (Expression parameterExpression : parameterExpressions) {
			this.parameterExpressions.add(parameterExpression);
		}
	}
	
	public OperationCallExpression(boolean contextless) {
		this.contextless = contextless;
	}
	
	@Override
	public void build() {
		super.build();
		AST parametersAst = null;
		if (!contextless) {
			targetExpression = (Expression) getFirstChild();
			nameExpression = (NameExpression) getSecondChild();
			parametersAst = getSecondChild().getFirstChild();
		}
		else {
			nameExpression = new NameExpression(this.getText());
			nameExpression.setRegion(this.getRegion());
			nameExpression.setUri(this.getUri());
			nameExpression.setModule(this.getModule());
			parametersAst = getFirstChild();
		}
		for (AST parameterAst : parametersAst.getChildren()) {
			parameterExpressions.add((Expression) parameterAst);
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		Object targetObject;
		String operationName = nameExpression.getName();
		
		if (!contextless) {
			targetObject = context.getExecutorFactory().executeAST(targetExpression, context);
		}
		else {
			targetObject = EolNoType.NoInstance;
		}
		
		IModel owningModel = context.getModelRepository().getOwningModel(targetObject);
		
		// Non-overridable operations
		AbstractOperation operation = context.getOperationFactory().getOperationFor(operationName);
		if (operation != null && (!operation.isOverridable())){
			return operation.execute(targetObject, nameExpression, new ArrayList<Parameter>(), parameterExpressions, context);
		}
		
		// Operation contributor for model elements
		OperationContributor modelOperationContributor = null;
		if (owningModel != null && owningModel instanceof IOperationContributorProvider) {
			modelOperationContributor = ((IOperationContributorProvider) owningModel).getOperationContributor();
		}
		
		// Method contributors that use the unevaluated AST
		ObjectMethod objectMethod = null;
		
		if (modelOperationContributor != null) {
			objectMethod = modelOperationContributor.findContributedMethodForUnevaluatedParameters(targetObject, operationName, parameterExpressions, context);
		}
		if (objectMethod == null) {
			objectMethod = context.getOperationContributorRegistry().findContributedMethodForUnevaluatedParameters(targetObject, operationName, parameterExpressions, context);
		}
		
		if (objectMethod != null) {
			return wrap(objectMethod.execute(new Object[]{nameExpression}, nameExpression));
		}
		
		ArrayList<Object> parameterValues = new ArrayList<Object>();
		
		for (Expression parameter : parameterExpressions) {
			parameterValues.add(context.getExecutorFactory().executeAST(parameter, context));
		}
		
		// Execute user-defined operation (if isArrow() == false)
		if (context.getModule() instanceof IEolLibraryModule && !isArrow()){
			Operation helper = ((IEolLibraryModule) context.getModule()).getOperations().getOperation(targetObject, nameExpression , parameterValues, context);
			if (helper != null){
				return ((IEolLibraryModule) context.getModule()).getOperations().execute(targetObject, helper, parameterValues, context);
			}
		}
		
		// Method contributors that use the evaluated parameters
		if (modelOperationContributor != null) {
			objectMethod = modelOperationContributor.findContributedMethodForEvaluatedParameters(targetObject, operationName, parameterValues.toArray(), context);
		}
		
		if (objectMethod == null) {
			objectMethod = context.getOperationContributorRegistry().findContributedMethodForEvaluatedParameters(targetObject, operationName, parameterValues.toArray(), context);
		}
		
		if (objectMethod != null) {
			return wrap(objectMethod.execute(parameterValues.toArray(), nameExpression));
		}

		// Execute user-defined operation (if isArrow() == true)
		if (operation instanceof SimpleOperation) {
			return ((SimpleOperation) operation).execute(targetObject, parameterValues, context, nameExpression);
		}

		throw new EolIllegalOperationException(targetObject, operationName, nameExpression, context.getPrettyPrinterManager());
		
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		if (targetExpression != null) targetExpression.compile(context);
		for (Expression parameterExpression : parameterExpressions) {
			parameterExpression.compile(context);
		}
	}
	
	public String getOperationName() {
		return nameExpression.getText();
	}
	
	public void setContextless(boolean contextless) {
		this.contextless = contextless;
	}
	
	public boolean isContextless() {
		return contextless;
	}
	
	public List<Expression> getParameterExpressions() {
		return parameterExpressions;
	}
	
	@Override
	public String rewrite(){
		String toString = "";
		if(this.getSecondChild() != null){
			toString += getFirstChild().rewrite() +getText() + getSecondChild().rewrite();
		}else{
			toString += getText() + getFirstChild().rewrite();
		}
		if(getParent() instanceof StatementBlock){
			toString += ";\n";
		}
		return toString;
	}
}
