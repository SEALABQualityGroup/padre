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
package launching.launchers;

import java.io.File;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugTarget;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dt.launching.EvlDebugger;

import view.PadreEVLValidationViewFixer;

public class PadreLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {

	private static PadreLaunchConfigurationDelegate instance = null;
	private static IProgressMonitor monitor = null;
	private static EolDebugger debuggerz = null;
	private static ILaunch iLaunch = null;
	private static String apsEvlFilePath = "";

	public IProgressMonitor getProgressMonitor() {
		return monitor;
	}

	public ILaunch getILaunch() {
		return iLaunch;
	}

	public EolDebugger getDebugger() {
		return debuggerz;
	}

	public String getApsEvlFilePath() {
		return apsEvlFilePath;
	}

	public static PadreLaunchConfigurationDelegate getInstance() {
		return instance;
	}

	public PadreLaunchConfigurationDelegate() {
		super();
		instance = this;
	}

	@Override
	public IEolModule createModule() {
		return new EvlModule();
	}

	@Override
	protected EolDebugger createDebugger() {
		return new EvlDebugger();
	}

	@Override
	protected void preExecute(IEolModule module) throws CoreException, EolRuntimeException {
//		IEolExecutableModule m = createModule();
//		String checkModuleEvl = getFilePath(Platform.getBundle("it.univaq.disim.sealab.padre.performanceanalysis").getResource("modelChecking/jmva/checkModel.evl").getPath());
//		try {
//			m.parse(new File(checkModuleEvl));
//			m.compile();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		super.preExecute(m);
//		((EvlModule)m).setUnsatisfiedConstraintFixer(new PadreEVLValidationViewFixer());

		super.preExecute(module);
		((EvlModule) module).setUnsatisfiedConstraintFixer(new PadreEVLValidationViewFixer());
	}

	public ILaunchConfiguration getConfiguration() {
		return configuration;
	}

//	public ILaunch getLaunch() {
//		return launch;
//	}
//	
//	public IProgressMonitor getProgressMonitor() {
//		return progressMonitor;
//	}

	public void launch(ILaunchConfiguration configuration, String mode,
					   ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		
		this.configuration = configuration;
		
		launch(configuration, mode, launch, progressMonitor, createModule(), createDebugger(),
				EolLaunchConfigurationAttributes.SOURCE, true, true);
	}

	public boolean launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor progressMonitor, IEolModule module, EolDebugger debugger,
			String lauchConfigurationSourceAttribute, boolean setup, boolean disposeModelRepository)
			throws CoreException {

		iLaunch = launch;
		monitor = progressMonitor;
		debuggerz = debugger;

		collectListeners();

		if(setup)
			EpsilonConsole.getInstance().clear();

		apsEvlFilePath = getConfiguration().getAttribute("source", "");

		// APs evl file
		aboutToParse(configuration, mode, launch, progressMonitor, module);

		if (!parse(module, lauchConfigurationSourceAttribute, configuration, mode, launch, progressMonitor))
			return false;

		EolDebugTarget target = null;

		try {
			
			EclipseContextManager.setup(module.getContext(), configuration, progressMonitor, launch, setup);
			
			
			IEolContext context = module.getContext();
			EmfModel model = (EmfModel) module.getContext().getModelRepository().getModelByName("UML");	
			
			/*
			EList<EPackage> martePackages = 
					org.eclipse.papyrus.MARTE.MARTEPackage.eINSTANCE.getESubpackages();
	
			for(EPackage temp: martePackages) {
				model.setMetamodelUri(temp.getNsURI());
				model.setMetamodelFile(temp.getNsURI());

			}
			
			EPackage.Registry.INSTANCE.put(
					org.eclipse.papyrus.MARTE.MARTE_AnalysisModel.GQAM.GQAMPackage.eNS_URI,
					GQAMPackage.eINSTANCE
			);
			*/

			System.out.println(model);			
			
			aboutToExecute(configuration, mode, launch, progressMonitor, module);
			
			String subtask = "Refactoring";
			
			progressMonitor.subTask(subtask);
			progressMonitor.beginTask(subtask, 100);

			if ("run".equalsIgnoreCase(mode)) {
				result = module.execute();
				
			} else if ("debug".equalsIgnoreCase(mode)) {
				// Copy launch configuration attributes to launch
				Map<?, ?> configurationAttributes = configuration.getAttributes();
				
				for (Object key : configurationAttributes.keySet()) {
					launch.setAttribute(key + "", configurationAttributes.get(key) + "");
				}

				final String name = launch.getAttribute(lauchConfigurationSourceAttribute);
				
				target = new EolDebugTarget(launch, module, debugger, name);
				
				debugger.setTarget(target);
				launch.addDebugTarget(target);
				
				result = target.debug();
			}

			executed(configuration, mode, launch, progressMonitor, module, result);

		} catch (Exception e) {
			e = EolRuntimeException.wrap(e);
			e.printStackTrace();
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
			return false;
		} finally {
			if (target != null) {
				if (!disposeModelRepository)
					launch.removeDebugTarget(target);
			}
			teardown(module.getContext(), disposeModelRepository);
		}

		progressMonitor.done();

		return true;
	}

	protected boolean parse(IModule module, String sourceAttribute, ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		String subTask = "";

		IFile file = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(configuration.getAttribute(sourceAttribute, "")));
		String fileName = file.getLocation().toOSString();

		subTask = "Parsing " + fileName;
		progressMonitor.subTask(subTask);
		progressMonitor.beginTask(subTask, 100);

		boolean parsed = false;

		try {
			parsed = module.parse(new File(fileName));
		} catch (Exception e) {
			e.printStackTrace(EpsilonConsole.getInstance().getErrorStream());
			return false;
		}

		progressMonitor.done();

		if (!parsed) {
			for (ParseProblem problem : module.getParseProblems()) {
				EpsilonConsole.getInstance().getErrorStream().println(problem.toString());
			}
		}

		return parsed;

	}

	@Override
	public IEolModule getDefaultModule(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getLanguage() {
		// TODO Auto-generated method stub
		return null;
	}

}
