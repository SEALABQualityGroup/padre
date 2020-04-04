package launching.util;

/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

/**
 * This example demonstrates using the 
 * Epsilon Validation Language, the model validation language
 * of Epsilon, in a stand-alone manner 
 * @author Dimitrios Kolovos
 */
public class EvlStandaloneExample extends EpsilonStandaloneExample {
	
//	@Override
//	public IEolModule createModule() {
//		return (IEolModule) new EvlModule();
//	}
	
	@Override
	public IEolExecutableModule createModule() {
		return new EvlModule();
	}

	@Override
	public List<IModel> getModels() throws Exception {
		List<IModel> models = new ArrayList<IModel>();
		AbstractEmfModel model = (AbstractEmfModel) module.getContext().getModelRepository().getModels().get(0);
		models.add(model);
		return models;
	}


	@Override
	public void postProcess() {
		
		EvlModule module = (EvlModule) this.module;
		
		Collection<UnsatisfiedConstraint> unsatisfied = module.getContext().getUnsatisfiedConstraints();
	
		if (unsatisfied.size() > 0) {
			System.err.println(unsatisfied.size() + " constraint(s) have not been satisfied");
			for (UnsatisfiedConstraint uc : unsatisfied) {
				System.err.println(uc.getMessage());
			}
		}
		else {
			System.out.println("All constraints have been satisfied");
		}
	}

}