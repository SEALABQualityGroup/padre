/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.models;

/**
 * Interface for models which can be adapted to a different model type,
 * if required. Mostly useful for adapting model types which do not
 * implement comparison to those who do.
 */
public interface IAdaptableModel extends IModel {

	/**
	 * Tries to adapt the model to a different type. If it is not possible,
	 * this method should return <code>null</code>. 
	 * @param modelType Type to which this model should be adapted.
	 * @return Non-null value if the model could be adapted,
	 * <code>null</code> otherwise.
	 */
	<T> T adaptTo(Class<T> modelType);

}
