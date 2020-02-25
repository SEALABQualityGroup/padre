package it.univaq.disim.sealab.padre.performance.analysis.launching;

import jmt.jmva.commandline.JMVASolver;

public class JmvaExecutor extends JMVASolver {

	public static void main(String args[]) {
		System.out.println("Performing MVA...");
		run("/Users/peo12/workspaces/padre1.0-oxygen/it.spe.disim.univaq.it.plugin.performanceanalysis.zip_expanded/it.spe.disim.univaq.it.plugin.performanceanalysis/bin/examples/BGCS/performanceAnalysis/jmva/BGCS_new.jmva");
	}

	public static void run(String filePath) {
		// new Thread(){
		// public void run() {
		try {
			JMVASolver.main(new String[] { filePath });
			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(filePath);
			e.printStackTrace();
		}
	}
	// }.start();

	// }
}
