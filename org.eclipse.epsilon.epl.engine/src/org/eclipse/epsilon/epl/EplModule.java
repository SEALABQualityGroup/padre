/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.EpsilonParser;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.AstExplorer;
import org.eclipse.epsilon.epl.dom.Cardinality;
import org.eclipse.epsilon.epl.dom.Domain;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dom.Role;
import org.eclipse.epsilon.epl.execute.PatternMatchModel;
import org.eclipse.epsilon.epl.execute.PatternMatcher;
import org.eclipse.epsilon.epl.parse.EplLexer;
import org.eclipse.epsilon.epl.parse.EplParser;
import org.eclipse.epsilon.erl.ErlModule;

public class EplModule extends ErlModule implements IEolExecutableModule{
	
	protected List<Pattern> declaredPatterns = new ArrayList<Pattern>();
	protected IEolContext context;
	protected boolean repeatWhileMatchesFound = false;
	protected int maxLoops = INFINITE;
	protected String patternMatchModelName = "P";
	
	public static final int INFINITE = -1;
	
	public static void main(String[] args) throws Exception {
		EplModule module = new EplModule();
		//module.parse(new File("/Users/dimitrioskolovos/Downloads/eclipse-modeling-kepler/workspace/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/parse/test.epl"));
		//new AstExplorer(module.getAst(), EplParser.class);
		module.parse("pre{ System.user.prompt('foo?');}");
		module.execute();
	}
	
	public EplModule() {
		reset();
	}
	
	@Override
	protected Lexer createLexer(ANTLRInputStream inputStream) {
		return new EplLexer(inputStream);
	}

	@Override
	public EpsilonParser createParser(TokenStream tokenStream) {
		return new EplParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "eplModule";
	}
	
	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("epl", EplModule.class);
		return importConfiguration;
	}
	
	@Override
	public AST adapt(AST cst, AST parentAst) {
		switch (cst.getType()) {
			case EplParser.PATTERN: return new Pattern();
			case EplParser.CARDINALITY: return new Cardinality();
			case EplParser.GUARD: return new ExecutableBlock<Boolean>(Boolean.class);
			case EplParser.DOMAIN: return new Domain();
			case EplParser.ROLE: return new Role();
			case EplParser.ACTIVE: return new ExecutableBlock<Boolean>(Boolean.class);
			case EplParser.OPTIONAL: return new ExecutableBlock<Boolean>(Boolean.class);
		}
		return super.adapt(cst, parentAst);
	}
	
	@Override
	public void buildModel() throws Exception {
		super.buildModel();
		for (AST patternAst : AstUtil.getChildren(ast, EplParser.PATTERN)) {
			declaredPatterns.add((Pattern) patternAst);
		}
	}
	
	public List<Pattern> getDeclaredPatterns() {
		return declaredPatterns;
	}
	
	protected ArrayList<Pattern> patterns = null;
	
	public List<Pattern> getPatterns() {
		if (patterns == null) {
			patterns = new ArrayList<Pattern>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof EplModule)) {
					EplModule module = (EplModule) import_.getModule();
					patterns.addAll(module.getPatterns());
				}
			}
			patterns.addAll(declaredPatterns);
		}
		return patterns;
	}
	
	@Override
	public List<ModuleElement> getModuleElements() {
		final List<ModuleElement> children = new ArrayList<ModuleElement>();
		children.addAll(getImports());
		children.addAll(getDeclaredPre());
		children.addAll(getDeclaredPatterns());
		children.addAll(getDeclaredPost());
		children.addAll(getDeclaredOperations());
		return children;
	}
	
	@Override
	public IEolContext getContext() {
		return context;
	}
	
	public void setContext(EolContext context) {
		this.context = context;
	}
	
	@Override
	public void reset() {
		super.reset();
		declaredPatterns.clear();
		context = new EolContext();
	}

	@Override
	public Object execute() throws EolRuntimeException {
		prepareContext(context);
		execute(getPre(), context);
		
		PatternMatcher patternMatcher = new PatternMatcher();
		PatternMatchModel matchModel = null;
		try {
			int loops = 1;
			matchModel = patternMatcher.match(this);
			if (repeatWhileMatchesFound) {
				
				while (!matchModel.allContents().isEmpty()) {
					if (maxLoops != INFINITE) {
						if (loops == maxLoops) break;
					}
					matchModel = patternMatcher.match(this);
					loops++;
				}
			}
		}
		catch (Exception ex) {
			EolRuntimeException.propagate(ex);
		}
		
		execute(getPost(), context);
		
		return matchModel;
	}
	
	public int getMaxLoops() {
		return maxLoops;
	}
	
	public void setMaxLoops(int maxLoops) {
		this.maxLoops = maxLoops;
	}
	
	public boolean isRepeatWhileMatches() {
		return repeatWhileMatchesFound;
	}
	
	public void setRepeatWhileMatches(boolean repeatWhileMatches) {
		this.repeatWhileMatchesFound = repeatWhileMatches;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EplParser.PRE;
	}

	@Override
	protected int getPostBlockTokenType() {
		return EplParser.POST;
	}
	
	public int getMaximumLevel() {
		int maximumLevel = 0;
		for (Pattern pattern : getPatterns()) {
			maximumLevel = Math.max(maximumLevel, pattern.getLevel());
		}
		return maximumLevel;
	}
	
	public String getPatternMatchModelName() {
		return patternMatchModelName;
	}
	
	public void setPatternMatchModelName(String patternMatchModelName) {
		this.patternMatchModelName = patternMatchModelName;
	}

	@Override
	public void setContext(IEolContext context) {
		this.context = context;
	}
}
