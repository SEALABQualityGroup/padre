/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.compile.m3.Metamodel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ModelDeclaration extends AbstractModuleElement implements ICompilableModuleElement {

	protected NameExpression nameExpression;
	protected List<NameExpression> aliasNameExpressions = new ArrayList<NameExpression>();
	protected NameExpression driverNameExpression;
	protected List<ModelDeclarationParameter> modelDeclarationParameters = new ArrayList<ModelDeclarationParameter>();
	protected Metamodel metamodel = null;
	
	public ModelDeclaration() {}
	
	@Override
	public void build() {
		super.build();
		nameExpression = (NameExpression) getFirstChild();
		driverNameExpression = (NameExpression) AstUtil.getChild(this, EolParser.DRIVER).getFirstChild();
		AST aliasesAst = AstUtil.getChild(this, EolParser.ALIAS);
		if (aliasesAst != null) {
			for (AST aliasAst : aliasesAst.getChildren()) {
				aliasNameExpressions.add((NameExpression) aliasAst);
			}
		}
		AST parametersAst = AstUtil.getChild(this, EolParser.MODELDECLARATIONPARAMETERS);
		if (parametersAst != null) {
			for (AST parameterAst : parametersAst.getChildren()) {
				modelDeclarationParameters.add((ModelDeclarationParameter) parameterAst);
			}
		}
	}

	public NameExpression getNameExpression() {
		return nameExpression;
	}

	public void setNameExpression(NameExpression nameExpression) {
		this.nameExpression = nameExpression;
	}
	
	public NameExpression getDriverNameExpression() {
		return driverNameExpression;
	}

	public void setDriverNameExpression(NameExpression driverNameExpression) {
		this.driverNameExpression = driverNameExpression;
	}

	public List<NameExpression> getAliasNameExpressions() {
		return aliasNameExpressions;
	}

	public List<ModelDeclarationParameter> getModelDeclarationParameters() {
		return modelDeclarationParameters;
	}
	
	public ModelDeclarationParameter getModelDeclarationParameter(String parameterName) {
		for (ModelDeclarationParameter parameter : modelDeclarationParameters) {
			if (parameter.getKey().equals(parameterName)) return parameter;
		}
		return null;
	}
	
	public List<?> getModuleElements() {
		return Collections.emptyList();
	}

	@Override
	public void compile(EolCompilationContext context) {
		if (context.getModelFactory() == null) return;
		IModel model = context.getModelFactory().createModel(driverNameExpression.getName());
		if (model == null) {
			context.addErrorMarker(driverNameExpression, "Unknown type of model: " + driverNameExpression.getName());
		}
		else {
			StringProperties stringProperties = new StringProperties();
			for (ModelDeclarationParameter parameter : modelDeclarationParameters) {
				stringProperties.put(parameter.getKey(), parameter.getValue());
			}
			metamodel = model.getMetamodel(stringProperties, context.getRelativePathResolver());
			if (metamodel != null) {
				for (String error : metamodel.getErrors()) {
					context.addErrorMarker(this, error);
				}
				for (String warning : metamodel.getWarnings()) {
					context.addWarningMarker(this, warning);
				}
			}
		}
	}
	
	public Metamodel getMetamodel() {
		return metamodel;
	}
	
}
