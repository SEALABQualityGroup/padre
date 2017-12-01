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
package org.eclipse.epsilon.common.dt.editor;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.common.dt.preferences.EpsilonPreferencePage;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.dt.util.ThemeChangeListener;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.IModuleValidator;
import org.eclipse.epsilon.common.module.ModuleMarker;
import org.eclipse.epsilon.common.module.ModuleMarker.Severity;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.ISourceViewerExtension2;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;


public abstract class AbstractModuleEditor extends AbstractDecoratedTextEditor { //implements IPropertyListener {
	
	protected Color backgroundColor = null;
	protected Job parseModuleJob = null;
	protected ArrayList<IModuleParseListener> moduleParsedListeners = new ArrayList<IModuleParseListener>();
	protected ArrayList<IAbstractModuleEditorTemplateContributor> templateContributors = new ArrayList<IAbstractModuleEditorTemplateContributor>();

	public static String PROBLEMMARKER = "org.eclipse.epsilon.common.dt.problemmarker";
	
	private ModuleContentOutlinePage outlinePage;

	public AbstractModuleEditor() {
		super();
		setDocumentProvider(new AbstractModuleEditorDocumentProvider());
		setEditorContextMenuId("#TextEditorContext");
	    setRulerContextMenuId("editor.rulerMenu");
	}
	
	public void addModuleParsedListener(IModuleParseListener listener) {
		this.moduleParsedListeners.add(listener);
	}
	
	public ArrayList<IModuleParseListener> getModuleParsedListeners() {
		return moduleParsedListeners;
	}
	
	public boolean removeModuleParsedListener(IModuleParseListener listener) {
		return moduleParsedListeners.remove(moduleParsedListeners);
	}
	
	public void addTemplateContributor(IAbstractModuleEditorTemplateContributor templateContributor) {
		this.templateContributors.add(templateContributor);
	}
	
	public boolean removeTemplateContributor(IAbstractModuleEditorTemplateContributor templateContributor) {
		return this.templateContributors.remove(templateContributor);
	}
	
	protected void notifyModuleParsedListeners(IModule module) {
		for (IModuleParseListener listener : moduleParsedListeners) {
			listener.moduleParsed(this, module);
		}
	}
	
	public AST adaptToAST(Object o) {
		if (o instanceof AST) {
			return (AST) o;
		}
		else return null;
	}
	
	public void insertText(String text) {
		IDocument doc = this.getDocumentProvider().getDocument(
				this.getEditorInput());
		TextSelection selection = (TextSelection) getSelectionProvider().getSelection();
		try {
			doc.replace(selection.getOffset(), 0, text);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	public final static String EDITOR_MATCHING_BRACKETS = "matchingBrackets";
	public final static String EDITOR_MATCHING_BRACKETS_COLOR= "matchingBracketsColor";
	
	@Override
	protected void configureSourceViewerDecorationSupport(
			SourceViewerDecorationSupport support) {

		super.configureSourceViewerDecorationSupport(support);
		char[] matchChars = {'(', ')', '[', ']', '{', '}'}; 		
		ICharacterPairMatcher matcher = new DefaultCharacterPairMatcher(matchChars ,
				IDocumentExtension3.DEFAULT_PARTITIONING);
		support.setCharacterPairMatcher(matcher);
		support.setMatchingCharacterPainterPreferenceKeys(EDITOR_MATCHING_BRACKETS,EDITOR_MATCHING_BRACKETS_COLOR);
		
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(EDITOR_MATCHING_BRACKETS, true);
		store.setDefault(EDITOR_MATCHING_BRACKETS_COLOR, "128,128,128");
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class required) {
		if (IContentOutlinePage.class.equals(required)) {
			return outlinePage;
		}

		return super.getAdapter(required);
	}
	
	public List<String> getAssertions(){
		return Arrays.asList("assert", "assertError");
	}
	
	public List<String> getTypes(){
		// The list returned by Arrays.asList cannot be changed in size,
		// as it is just a wrapper over the Java array. Therefore, any
		// calls to add/remove will return an UnsupportedOperationException.
		return new ArrayList<String>(Arrays.asList(
			"String", "Boolean", "Integer", "Real",
			"Any", "Map", "Collection", "Bag", "Sequence",
			"Set", "OrderedSet", "Native", "List"));
	}
	
	public abstract List<String> getKeywords();

	public abstract List<String> getBuiltinVariables();

	public ModuleContentOutlinePage createOutlinePage() {
		
		ModuleContentOutlinePage outline = 
			new ModuleContentOutlinePage(
					this.getDocumentProvider(), 
					this, 
					createModuleElementLabelProvider());
		
		/*
		ModuleContentOutlinePage outline = new AstOutlinePage(this.getDocumentProvider(), this, new AstModuleElementLabelProvider());
		*/
		
		addModuleParsedListener(outline);
		
		return outline;
	}

	public abstract IModule createModule();
	
	public abstract ModuleElementLabelProvider createModuleElementLabelProvider();
	
	ProjectionSupport projectionSupport;

	AnnotationModel annotationModel;

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		ProjectionViewer viewer = (ProjectionViewer) getSourceViewer();
		projectionSupport = new ProjectionSupport(viewer,
				getAnnotationAccess(), getSharedColors());
		projectionSupport.install();

		// turn projection mode on
		viewer.doOperation(ProjectionViewer.TOGGLE);
		annotationModel = viewer.getProjectionAnnotationModel();
		//updateFoldingStructure();
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent,
			IVerticalRuler ruler, int styles) {

		ISourceViewer viewer = new ProjectionViewer(parent, ruler,
				getOverviewRuler(), isOverviewRulerVisible(), styles);
		
		//IDocument doc = this.getDocumentProvider().getDocument(
		//		this.getEditorInput());
		//autoclosingPairManager = new AutoclosingPairManager(doc, getSourceViewerConfiguration().getUndoManager(viewer));
		//viewer.getTextWidget().addVerifyKeyListener(autoclosingPairManager);
		getSourceViewerDecorationSupport(viewer);
		
		return viewer;
	}
	
	//TODO : Improve the folding functionality

//	boolean useCodeFolding = false;
//	
//	public void updateFoldingStructure() {
//		if (!useCodeFolding) return;
//		
//		IModule module = createModule();
//		IDocument doc = this.getDocumentProvider().getDocument(
//				this.getEditorInput());
//		
//		try {
//			annotationModel.removeAllAnnotations();
//			module.parse(doc.get());
//			ListIterator li = module.getChildren().listIterator();
//			while (li.hasNext()){
//				ModuleElement child = (ModuleElement) li.next();
//				ProjectionAnnotation annotation = new ProjectionAnnotation();
//				Position pos =  new Position(0);
//				
//				int startOffset = 0;
//				
//				if (li.hasPrevious()){
//					startOffset = doc.getLineOffset(Math.max(child.getAst().getLine() - 1,0)) + child.getAst().getColumn();	
//				}
//				
//				int endOffset = Math.max(doc.getLength(),0);
//				if (li.hasNext()) {
//					ModuleElement nextElement = (ModuleElement) li.next();
//					endOffset = doc.getLineOffset(Math.max(nextElement.getAst().getLine() - 2,0)) + nextElement.getAst().getColumn() - 1;	
//					li.previous();
//				}
//				
//				pos.setOffset(startOffset);
//				pos.setLength(endOffset-startOffset);
//				annotationModel.addAnnotation(annotation,pos);
//			}
//
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// annotationModel.modifyAnnotationPosition(annotation,new
		// Position(0,10));
		/*
		 * Annotation[] annotations = new Annotation[positions.size()];
		 * 
		 * //this will hold the new annotations along //with their corresponding
		 * positions HashMap newAnnotations = new HashMap();
		 * 
		 * for(int i = 0; i < positions.size();i++) { ProjectionAnnotation
		 * annotation = new ProjectionAnnotation();
		 * 
		 * newAnnotations.put(annotation, positions.get(i));
		 * 
		 * annotations[i] = annotation; }
		 * 
		 * annotationModel.mmodifyAnnotation(oldAnnotations,
		 * newAnnotations,null);
		 * 
		 * oldAnnotations = annotations;
		 */
	//}
	
	public SourceViewerConfiguration createSourceViewerConfiguration() {
		return new AbstractModuleEditorSourceViewerConfiguration(this);
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		try {
			super.init(site, input);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		
		setSourceViewerConfiguration(createSourceViewerConfiguration());
		
		PlatformUI.getWorkbench().getThemeManager().addPropertyChangeListener(new ThemeChangeListener() {
			
			@Override
			public void themeChange() {
				ISourceViewer viewer= getSourceViewer();
				if (!(viewer instanceof ISourceViewerExtension2))
					return;

				((ISourceViewerExtension2)viewer).unconfigure();
				setSourceViewerConfiguration(createSourceViewerConfiguration());
				viewer.configure(getSourceViewerConfiguration());
			}
		});
		
		outlinePage = createOutlinePage();
		
		
		final int delay = 1000;
		
		parseModuleJob = new Job("Parsing module") {
			
			protected int status = -1;
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				if (!isClosed()) {
					int textHashCode = getText().hashCode();
					if (status != textHashCode) {
						parseModule();
						status = textHashCode;
					}
					
					this.schedule(delay);
				}
				
				return Status.OK_STATUS;
			}
		};
		
		parseModuleJob.setSystem(true);
		parseModuleJob.schedule(delay);
	
	}
	
	public boolean isClosed() {
		return this.getDocumentProvider() == null;
	}
	
	public String getText() {
		return this.getDocumentProvider().getDocument(
				this.getEditorInput()).get();
	}
	
	public void parseModule() {
		
		// Return early if the file is opened in an unexpected editor (e.g. in a Subclipse RemoteFileEditor)
		if (!(getEditorInput() instanceof FileEditorInput)) return;
		
		FileEditorInput fileInputEditor = (FileEditorInput) getEditorInput();
		IFile file = fileInputEditor.getFile();
		
		final IModule module = createModule();
		final IDocument doc = this.getDocumentProvider().getDocument(
				this.getEditorInput());
		
		// Replace tabs with spaces to match
		// column numbers produced by the parser
		String code = doc.get();
		code = code.replaceAll("\t", " ");
		
		try {
			module.reset();
			module.parse(code, new File(file.getLocation().toOSString()));
		} catch (Exception e) {
			
		}
		
		// Update problem markers
		// TODO: Update problem markers in all referenced files
		try {
			// Delete all the old markers
			for (String markerType : getMarkerTypes()) {
				file.deleteMarkers(markerType, true, IResource.DEPTH_INFINITE);
			}
			
			// Create markers for parse problems
			for (ParseProblem problem : module.getParseProblems()) {
				Map<String, Object> attr = new HashMap<String, Object>();
				attr.put(IMarker.LINE_NUMBER, new Integer(problem.getLine()));
				attr.put(IMarker.MESSAGE, problem.getReason());				
				int markerSeverity;
				if (problem.getSeverity() == ParseProblem.ERROR) {
					markerSeverity = IMarker.SEVERITY_ERROR;
				}
				else {
					markerSeverity = IMarker.SEVERITY_WARNING;
				}
				attr.put(IMarker.SEVERITY, markerSeverity);
				MarkerUtilities.createMarker(file, attr, AbstractModuleEditor.PROBLEMMARKER);
			}
			
			// If the module has no parse problems, pass it on to the validators
			// Use try/catch to protect against unexpected exceptions in the validators
			if (module.getParseProblems().isEmpty()) {
				
				try {
					if (EpsilonCommonsPlugin.getDefault().getPreferenceStore().getBoolean(EpsilonPreferencePage.ENABLE_STATIC_ANALYSIS)) {
						if (module instanceof IEolExecutableModule) {
							EolCompilationContext compilationContext = ((IEolExecutableModule) module).getCompilationContext();
							compilationContext.setModelFactory(new ModelTypeExtensionFactory());
						}
						createMarkers(module.compile(), doc, file, AbstractModuleEditor.PROBLEMMARKER);
					}
					
					for (IModuleValidator validator : ModuleValidatorExtensionPointManager.getDefault().getExtensions()) {
						String markerType = (validator.getMarkerType() == null ? AbstractModuleEditor.PROBLEMMARKER : validator.getMarkerType());
						createMarkers(validator.validate(module), doc, file, markerType);
					}
				}
				catch (Exception ex) { LogUtil.log(ex); }
				
			}
			
		} catch (CoreException e1) {}
		
		if (module != null && module.getParseProblems().size() == 0) {
			notifyModuleParsedListeners(module);
		}
		
	}
	
	private void createMarkers(List<ModuleMarker> moduleMarkers, IDocument doc, IFile file, String markerType) throws BadLocationException, CoreException {
		if (moduleMarkers == null) return;
		
		for (ModuleMarker moduleMarker : moduleMarkers) {
			Map<String, Object> attr = new HashMap<String, Object>();
			Region region = moduleMarker.getRegion();
			int startOffset = doc.getLineOffset(region.getStart().getLine()-1) + region.getStart().getColumn();
			int endOffset = doc.getLineOffset(region.getEnd().getLine()-1) + region.getEnd().getColumn();
			attr.put(IMarker.CHAR_START, startOffset);
			attr.put(IMarker.CHAR_END, endOffset);
			attr.put(IMarker.MESSAGE, moduleMarker.getMessage());
			if (moduleMarker.getSeverity() == Severity.Error) {
				attr.put(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			}
			else if (moduleMarker.getSeverity() == Severity.Warning) {
				attr.put(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
			}
			else {
				attr.put(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
			}
			
			MarkerUtilities.createMarker(file, attr, markerType);
		}
	}
	
	private Collection<String> getMarkerTypes() {
		final Set<String> markerTypes = new HashSet<String>();
		markerTypes.add(AbstractModuleEditor.PROBLEMMARKER);
		
		for (IModuleValidator validator : ModuleValidatorExtensionPointManager.getDefault().getExtensions()) {
			markerTypes.add(validator.getMarkerType());
		}
		return markerTypes;
	}
	
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		// TODO Auto-generated method stub
		super.doSave(progressMonitor);
		if (!supportsDirtyTextParsing()) parseModule();
	}
	
	protected abstract boolean supportsHyperlinks();
	
	protected abstract boolean supportsDirtyTextParsing();
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	@Override
	public void close(boolean save) {
		parseModuleJob.cancel();
		super.close(save);
	}
	
	public final List<Template> getTemplates() {
		
		List<Template> templates = new ArrayList<Template>();
		
		for (IAbstractModuleEditorTemplateContributor contributor : templateContributors) {
			templates.addAll(contributor.getTemplates());
		}
		
		return templates;
	}
	
	private static final String CONTENTASSIST_PROPOSAL_ID = 
		   "org.eclipse.common.dt.editor.AbsractModuleEditor.ContentAssistProposal"; 
		protected void createActions() {
		   super.createActions();

		   // This action will fire a CONTENTASSIST_PROPOSALS operation
		   // when executed
		   IAction action = 
		      new TextOperationAction(new ResourceBundle(){

				@Override
				public Enumeration<String> getKeys() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				protected Object handleGetObject(String key) {
					// TODO Auto-generated method stub
					return null;
				}},
		      "ContentAssistProposal", this, SourceViewer.CONTENTASSIST_PROPOSALS);
		   action.setActionDefinitionId(CONTENTASSIST_PROPOSAL_ID);

		   // Tell the editor about this new action
		   setAction(CONTENTASSIST_PROPOSAL_ID, action);

		   // Tell the editor to execute this action 
		   // when Ctrl+Spacebar is pressed
		   setActionActivationCode(CONTENTASSIST_PROPOSAL_ID,' ', -1, SWT.CTRL);
		}
		
}
