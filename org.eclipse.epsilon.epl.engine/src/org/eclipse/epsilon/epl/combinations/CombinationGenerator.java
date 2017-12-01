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
package org.eclipse.epsilon.epl.combinations;

import java.util.List;

public interface CombinationGenerator<T> {
	
	public boolean hasMore() throws Exception;
	
	public List<T> getNext() throws Exception;
	
	public void reset();
	
	public void producedValidCombination();
	
}
