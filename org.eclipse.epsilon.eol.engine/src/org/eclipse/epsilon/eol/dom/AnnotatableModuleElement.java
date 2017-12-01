package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public abstract class AnnotatableModuleElement extends AbstractModuleElement {
	
	protected AnnotationBlock annotationBlock;
	
	public AnnotationBlock getAnnotationBlock() {
		return annotationBlock;
	}
	
	public void setAnnotationBlock(AnnotationBlock annotationBlock) {
		this.annotationBlock = annotationBlock;
	}
	
	@Override
	public void build() {
		super.build();
		annotationBlock = (AnnotationBlock) getAnnotationsAst();
	}
	
	public boolean hasAnnotation(String name) {
		return getAnnotation(name) != null;
	}
	
	protected List<Annotation> getAnnotations(String name) {
		if (annotationBlock == null) return Collections.emptyList();
		
		List<Annotation> annotations = new ArrayList<Annotation>();
		for (Annotation annotation : annotationBlock.getAnnotations()) {
			if (annotation.getName().equals(name)) annotations.add(annotation);
		}
		return annotations;
	}
	
	protected Annotation getAnnotation(String name) {
		if (annotationBlock == null) return null;
		
		for (Annotation annotation : annotationBlock.getAnnotations()) {
			if (annotation.getName().equals(name)) return annotation;
		}
		return null;
	}
	
	public boolean getBooleanAnnotationValue(String name, IEolContext context) throws EolRuntimeException {
		return getBooleanAnnotationValue(name, context, false, true);
	}
	
	public boolean getBooleanAnnotationValue(String name, IEolContext context, boolean ifNotExists, boolean ifNoValue) throws EolRuntimeException {
		Annotation annotation = getAnnotation(name);
		if (annotation == null) return ifNotExists;
		if (!annotation.hasValue()) return ifNoValue;
		
		Object result = null;
		if (annotation instanceof SimpleAnnotation) result = ((SimpleAnnotation) annotation).getValue();
		else if (annotation instanceof ExecutableAnnotation) result = ((ExecutableAnnotation) annotation).getValue(context);
		
		try {
			return new Boolean(result.toString());
		}
		catch (Exception ex) {
			throw new EolIllegalReturnException("Boolean", result, annotation, context);
		}
	}
	
	public List<Object> getAnnotationsValues(String name, IEolContext context) throws EolRuntimeException {
		List<Object> values = new ArrayList<Object>();
		for (Annotation annotation : getAnnotations(name)) {
			values.add(annotation.getValue(context));
		}
		return values;
	}
}
