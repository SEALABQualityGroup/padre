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
package org.eclipse.epsilon.common.dt.editor.hyperlinks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.IModuleParseListener;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.ArrayUtil;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.util.EolParserUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;

public class AbstractModuleEditorHyperlinkDetector implements IHyperlinkDetector, IModuleParseListener {

	protected AbstractModuleEditor editor;
	protected HashMap<AST, IRegion> astRegions = new HashMap<AST, IRegion>();
	protected IEolLibraryModule module = null;
	
	public List<IHyperlink> createHyperlinks(AST ast) {
		
		ArrayList<IHyperlink> hyperlinks = new ArrayList<IHyperlink>();
		
		for (Object op : module.getOperations()) {
			Operation operation = (Operation) op;
			if (operation.getName().equals(ast.getText()) && operation.getFormalParameters().size() == ast.getFirstChild().getChildren().size()) {
				hyperlinks.add(new ASTHyperlink(astRegions.get(ast), operation, operation.toString()));
			}
		}
		
		if (hyperlinks.isEmpty()) {
			for (Object op : module.getOperations()) {
				Operation operation = (Operation) op;
			
				if (operation.getName().equals(ast.getText())) {
					hyperlinks.add(new ASTHyperlink(astRegions.get(ast), operation, operation.toString()));
				}
			}	
		}
		
		return hyperlinks;
	}

	public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
			IRegion region, boolean canShowMultipleHyperlinks) {
		
		for (AST ast : astRegions.keySet()) {
			IRegion candidateRegion = astRegions.get(ast);
			
			if (region.getOffset() <= candidateRegion.getOffset() + candidateRegion.getLength() 
					&& region.getOffset() >= candidateRegion.getOffset()) {
				
				IHyperlink[] hyperlinks = new ArrayUtil<IHyperlink>()
					.toArray(createHyperlinks(ast), IHyperlink.class);
				
				if (hyperlinks.length > 0) return hyperlinks;
			}
			
		}
		
		return null;
		
	}

	public void moduleParsed(AbstractModuleEditor editor, IModule module) {
		astRegions.clear();
		this.editor = editor;
		this.module = (IEolLibraryModule) module;
		findInterestingASTs(module.getAst());
	}
	
	protected void findInterestingASTs(AST ast) {
		
		if (ast == null) return;
		
		IDocument doc = editor.getDocumentProvider().getDocument(
				editor.getEditorInput());
		
		if (EolParserUtil.isOperationCall(ast)) {
			try {
				int linkOffset = doc.getLineOffset(ast.getLine()-1) + ast.getColumn();
				astRegions.put(ast, new Region(linkOffset, ast.getText().length()));
			} catch (BadLocationException e) { }
		}
		
		for (Object child : ast.getChildren()) {
			if (child instanceof AST) {
				findInterestingASTs((AST) child);
			}
		}
	}
	
}
