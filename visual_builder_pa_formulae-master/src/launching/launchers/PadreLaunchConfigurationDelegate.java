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
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugTarget;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dt.launching.EvlDebugger;
import org.osgi.framework.Bundle;

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
	public IEolExecutableModule createModule() {
		return new EvlModule();
	}

	@Override
	protected EolDebugger createDebugger() {
		return new EvlDebugger();
	}

	@Override
	protected void preExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {
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

	private String getFilePath(String path) {
		Bundle bundle = Platform.getBundle("it.univaq.disim.sealab.padre.performanceanalysis");
		URL fileURL = bundle.getResource(path);
		String finalPath = "";
		try {
			finalPath = FileLocator.resolve(fileURL).getFile();
			return java.nio.file.Paths.get(finalPath).normalize().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return finalPath;
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

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor progressMonitor) throws CoreException {
		this.configuration = configuration;
		launch(configuration, mode, launch, progressMonitor, createModule(), createDebugger(),
				EolLaunchConfigurationAttributes.SOURCE, true, true);
	}

	public boolean launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor progressMonitor, IEolExecutableModule module, EolDebugger debugger,
			String lauchConfigurationSourceAttribute, boolean setup, boolean disposeModelRepository)
			throws CoreException {

		iLaunch = launch;
		monitor = progressMonitor;
		debuggerz = debugger;

		collectListeners();

		if (setup)
			EpsilonConsole.getInstance().clear();

		apsEvlFilePath = getConfiguration().getAttribute("source", "");

//		// checkModel evl file
//		IEolExecutableModule m = createModule();
//		String checkModuleEvl = getFilePath(Platform.getBundle("it.univaq.disim.sealab.padre.performanceanalysis")
//				.getResource("modelchecking/jmva/checkModel.evl").getPath());
//		ILaunchConfigurationWorkingCopy checkModelConfig = configuration.getWorkingCopy();
//		checkModelConfig.setAttribute("source", checkModuleEvl);
//		aboutToParse(checkModelConfig, mode, launch, progressMonitor, m);
//		if (!parse(m, lauchConfigurationSourceAttribute, checkModelConfig, mode, launch, progressMonitor))
//			return false;
//		
//		EolDebugTarget checkModelTarget = null;
//		
//		try {
//			EclipseContextManager.setup(m.getContext(), checkModelConfig, progressMonitor, launch, setup);
//			aboutToExecute(checkModelConfig, mode, launch, progressMonitor, m);
//			String subtask = "PADRE - Model Checking";
//			progressMonitor.subTask(subtask);
//			progressMonitor.beginTask(subtask, 100);
//			final String name = launch.getAttribute(lauchConfigurationSourceAttribute);
//			if ("run".equalsIgnoreCase(mode)) {
//				result = m.execute();
//			} else if ("debug".equalsIgnoreCase(mode)) {
//				// Copy launch configuration attributes to launch
//				Map<?, ?> configurationAttributes = configuration.getAttributes();
//				for (Object key : configurationAttributes.keySet()) {
//					launch.setAttribute(key + "", configurationAttributes.get(key) + "");
//				}
//				checkModelTarget = new EolDebugTarget(launch, m, debugger, name);
//				debugger.setTarget(checkModelTarget);
//				launch.addDebugTarget(checkModelTarget);
//				result = checkModelTarget.debug();
//			}
//
//			executed(checkModelConfig, mode, launch, progressMonitor, m, result);
//
//		} catch (Exception e) {
//			e = EolRuntimeException.wrap(e);
//			e.printStackTrace();
//			m.getContext().getErrorStream().println(e.toString());
//			progressMonitor.setCanceled(true);
//			return false;
//		} finally {
//			if (checkModelTarget != null) {
//				if (!disposeModelRepository)
//					launch.removeDebugTarget(checkModelTarget);
//			}
//			teardown(m.getContext(), disposeModelRepository);
//		}

		// APs evl file
		aboutToParse(configuration, mode, launch, progressMonitor, module);

		if (!parse(module, lauchConfigurationSourceAttribute, configuration, mode, launch, progressMonitor))
			return false;

		EolDebugTarget target = null;

		try {
			EclipseContextManager.setup(module.getContext(), configuration, progressMonitor, launch, setup);
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

	// TODO: Report parse errors better
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

}
