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
package org.eclipse.epsilon.epl.execute;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.common.util.UriUtil;
import org.eclipse.epsilon.eol.AbstractModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelReference;
import org.eclipse.epsilon.eol.tools.AbstractTool;
import org.eclipse.epsilon.epl.EplModule;

public class PatternMatcherTool extends AbstractTool {
	
	public void match(String epl, String name, HashMap<String, IModel> modelMap) throws Exception {
		List<IModel> models = new ArrayList<IModel>();
		for (String modelName : modelMap.keySet()) {
			IModel model = modelMap.get(modelName);
			if (!model.getName().equals(modelName)) model = new ModelReference(model);
			models.add(model);
		}
		match(epl, name, models);
	}
	
	public void match(String epl, String name) throws Exception {
		match(epl, name, (Collection<IModel>) null);
	}
	
	public void match(String epl, String name, Collection<IModel> models) throws Exception {
		
		IEolModule callingModule = (IEolModule) context.getModule();
		EplModule module = new EplModule();
		module.getContext().setModule(module);
		
		File file = new File(epl);
		
		if (file.isAbsolute()) {
			if (!file.exists()) throw new EolRuntimeException("File " + epl + " cannot be found");
			module.parse(file);
		} else {
			URI uri = ((AbstractModule)callingModule).getSourceUri();
			if (uri == null) uri = ((AbstractModule)callingModule).getSourceFile().toURI();
			module.parse(UriUtil.resolve(epl, uri));
		}
		
		if (models == null) {
			models = callingModule.getContext().getModelRepository().getModels();
		}
		
		for (IModel model : models) {
			module.getContext().getModelRepository().addModel(model);
		}
		
		PatternMatchModel patternMatchModel = new PatternMatcher().match(module);
		patternMatchModel.setName(name);
		callingModule.getContext().getModelRepository().addModel(patternMatchModel);
		
	}
	
}
