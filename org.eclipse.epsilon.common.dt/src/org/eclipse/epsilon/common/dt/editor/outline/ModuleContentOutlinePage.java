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
package org.eclipse.epsilon.common.dt.editor.outline;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.IModuleParseListener;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.util.ReflectionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class ModuleContentOutlinePage extends ContentOutlinePage implements IModuleParseListener {

	protected IDocumentProvider documentProvider;
	protected IModule module;
	protected AbstractModuleEditor editor;
	protected ILabelProvider labelProvider;
	protected Action linkWithEditorAction;
	
	public ModuleContentOutlinePage(IDocumentProvider documentProvider,
			AbstractModuleEditor editor, ILabelProvider labelProvider) {
		super();
		this.documentProvider = documentProvider;
		this.editor = editor;
		this.labelProvider = labelProvider;
		addSelectionChangedListener(this);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		getTreeViewer().setContentProvider(createContentProvider());
		getTreeViewer().setLabelProvider(labelProvider);
		getSite().setSelectionProvider(getTreeViewer());
		
		IToolBarManager toolbarManager = getSite().getActionBars().getToolBarManager();
    	toolbarManager.add(new AlphabeticallySortAction());
    	linkWithEditorAction = new LinkWithEditorAction();
    	toolbarManager.add(linkWithEditorAction);
	}
	
	protected IContentProvider createContentProvider() {
		return new ModuleContentProvider();
	}
	
	public boolean isReady() {
		return notDisplayed() || getTreeViewer()!=null;
	}

	private boolean notDisplayed() {
		return getControl() == null || !getControl().isVisible();
	}

	public AST toAst(Object o) {
		return (AST) o;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		
		if (!linkWithEditorAction.isChecked()) return;
		
		try {
			AST selected = editor.adaptToAST(((IStructuredSelection) event.getSelection()).getFirstElement());
			if (selected != null) EclipseUtil.openEditorAt(selected);
		}
		catch (Exception ex) {}
	}
	
	protected EditorSelection getEditorSelection(Object selection) {
		
		AST element = (AST) (selection);
		if (element == null) return null;
		return new EditorSelection(element.getFile(), element.getLine(), element.getColumn());
	}

	public IModule getModule() {
		return module;
	}

	public void setModule(IModule module) {
		this.module = module;
	}
	
	class AlphabeticallySortAction extends Action {
		
		AlphabeticalSorter alphabeticalSorter = null;
		TreeViewer treeViewer = null;
		
		public AlphabeticallySortAction(){
			super(null,AS_CHECK_BOX);
			this.setImageDescriptor(EpsilonCommonsPlugin.getDefault().getImageDescriptor("icons/alphabeticalSorter.gif"));
			this.setDescription("Sorts the contents of the view alphabetically");
			alphabeticalSorter = new AlphabeticalSorter();
			treeViewer = (TreeViewer) ReflectionUtil.getFieldValue(ModuleContentOutlinePage.this ,"treeViewer");
		}
		
		@Override
		public void run(){
			if (this.isChecked()){
				treeViewer.setSorter(alphabeticalSorter);
			}
			else {
				treeViewer.setSorter(null);
			}
		}
	}
	
	class LinkWithEditorAction extends Action {
		public LinkWithEditorAction(){
			super("Link with editor",AS_CHECK_BOX);
			this.setDescription("Links the outline view with the editor");
			this.setImageDescriptor(EpsilonCommonsPlugin.getDefault().getImageDescriptor("icons/linkwitheditor.gif"));
			this.setChecked(true);
		}
	}

	public void moduleParsed(AbstractModuleEditor editor, final IModule module) {
		if (getSite() != null) {
			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				
				public void run() {
					if (getTreeViewer() != null) {
						getTreeViewer().setInput(getOutlineRoot(module));
						//getTreeViewer().expandAll();
					}
				}
			});
		}
	}
	
	public Object getOutlineRoot(IModule module) { return module; }
	
}
