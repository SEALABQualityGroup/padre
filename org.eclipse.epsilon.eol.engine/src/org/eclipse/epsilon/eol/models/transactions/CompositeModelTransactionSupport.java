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
package org.eclipse.epsilon.eol.models.transactions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.models.IModel;

public class CompositeModelTransactionSupport implements IModelTransactionSupport {
	
	protected List<IModel> models = new ArrayList<IModel>();
	
	public void commitTransaction() {
		for (IModel model : getModels()) {
			model.getTransactionSupport().commitTransaction();
		}
	}

	public void rollbackTransaction() {
		for (IModel model : getModels()) {
			model.getTransactionSupport().rollbackTransaction();
		}
	}

	public void startTransaction() {
		for (IModel model : getModels()) {
			model.getTransactionSupport().startTransaction();
		}
	}
	
	public List<IModel> getModels() {
		return models;
	}
	
}
