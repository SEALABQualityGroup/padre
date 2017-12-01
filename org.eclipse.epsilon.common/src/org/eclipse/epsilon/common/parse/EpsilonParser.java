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
package org.eclipse.epsilon.common.parse;

import java.lang.reflect.Field;

import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.eclipse.epsilon.common.util.ReflectionUtil;

public abstract class EpsilonParser extends Parser {
	
	private boolean printErrors = false;
	
	public EpsilonParser(TokenStream tokenstream) {
		super(tokenstream);
	}

	public EpsilonParser(TokenStream tokenstream,
			RecognizerSharedState recognizersharedstate) {
		super(tokenstream, recognizersharedstate);
	}
	
	public abstract TreeAdaptor getTreeAdaptor();
	
	public abstract void setTreeAdaptor(TreeAdaptor adaptor);
	
	protected boolean isSupertype(Class<?> parent, Class<?> child) {
		if (parent == child) {
			return true;
		}
		else if (child.getSuperclass() != null) {
			return isSupertype(parent, child.getSuperclass());
		}
		else {
			return false;
		}
		
	}
	
	public void setDeepTreeAdaptor(TreeAdaptor adaptor) {
		
		setTreeAdaptor(adaptor);
		
		for (Field f : this.getClass().getFields()) {
			try {
				if (isSupertype(EpsilonParser.class, f.getType())) {
					Object value = ReflectionUtil.getFieldValue(this, f.getName());
					EpsilonParser delegate = (EpsilonParser) value;
					if (delegate.getTreeAdaptor() != adaptor) {
						delegate.setDeepTreeAdaptor(adaptor);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void prepareForGUnit() {
		printErrors = true;
	}
	
	@Override
	public void displayRecognitionError(String[] tokenNames,
	                                    RecognitionException re) {
		
		EpsilonParseProblemManager.INSTANCE.reportException(
				re.line, re.charPositionInLine, getErrorMessage(re, getTokenNames())
		);
		
		if (printErrors) {
			super.displayRecognitionError(tokenNames, re);
		}
	}
	
}
