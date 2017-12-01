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
package org.eclipse.epsilon.ewl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolLibraryModule;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.ewl.dom.Wizard;
import org.eclipse.epsilon.ewl.execute.WizardInstance;
import org.eclipse.epsilon.ewl.execute.WizardLoopInstance;
import org.eclipse.epsilon.ewl.execute.context.EwlContext;
import org.eclipse.epsilon.ewl.execute.context.IEwlContext;
import org.eclipse.epsilon.ewl.parse.EwlLexer;
import org.eclipse.epsilon.ewl.parse.EwlParser;


public class EwlModule extends EolLibraryModule implements IEwlModule {
	
	protected List<Wizard> wizards = new ArrayList<Wizard>();
	protected IEwlContext context = null;
	
	public EwlModule(){
		reset();
	}
	
	@Override
	public AST adapt(AST cst, AST parentAst) {
		switch (cst.getType()) {
			case EwlParser.TITLE: return new ExecutableBlock<String>(String.class);
			case EwlParser.GUARD: return new ExecutableBlock<Boolean>(Boolean.class);
			case EwlParser.DO: return new ExecutableBlock<Void>(Void.class);
			case EwlParser.WIZARD: return new Wizard();
		}
		return super.adapt(cst, parentAst);
	}
	
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EwlLexer(inputStream);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EwlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "ewlModule";
	}

	@Override
	public void buildModel() throws Exception {
		
		super.buildModel();
		for (AST wizardAst : AstUtil.getChildren(ast,EwlParser.WIZARD)) {
			wizards.add((Wizard) wizardAst);
		}
	}
	
	public List<WizardInstance> getWizardsFor(Object self) throws EolRuntimeException {
		prepareContext(context);

		final List<WizardInstance> applicableWizards = new ArrayList<WizardInstance>();
		
		for (Wizard wizard : wizards) {
			if (wizard.appliesTo(self,context)){
				applicableWizards.add(new WizardInstance(wizard, self, context));
			}
			else if (self instanceof Collection && !((Collection<?>)self).isEmpty()) {
				// Run the same wizard over a collection of applicable objects

				@SuppressWarnings("unchecked")
				final Collection<Object> collection = (Collection<Object>)self;
				if (allApply(wizard, collection)) {
					applicableWizards.add(new WizardLoopInstance(wizard, collection, context));
				}
			}
		}

		return applicableWizards;
	}

	@Override
	public IEwlContext getContext(){
		return context;
	}
	
	@Override
	public List<ModuleElement> getModuleElements(){
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(wizards);
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	@Override
	public void reset(){
		super.reset();
		wizards = new ArrayList<Wizard>();
		context = new EwlContext();
	}

	private boolean allApply(Wizard wizard, Collection<Object> self) throws EolRuntimeException {
		for (Object o : self) {
			if (!wizard.appliesTo(o, context)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEwlContext) {
			this.context = (IEwlContext) context;
		}
	}

}
