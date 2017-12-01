package it.spe.disim.univaq.porting;

import it.spe.disim.univaq.porting.evl2exl.Evl2Epl;
import it.spe.disim.univaq.porting.evl2exl.Evl2Ewl;
import it.spe.disim.univaq.porting.util.PortingUtil;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.evl.EvlModule;

public class MainTest {

	public static void main(String[] args) throws URISyntaxException, Exception {
		MainTest test = new MainTest();

		AST ewlASTGen, eplASTGen, evlAST;
		String sourceFile = "/Users/daniele/git/epsilon_framework/it.spe.disim.epsilon.antipattern_d-s/evl/AP-UML-MARTE.evl";

		/** Evl -> Epl & Evl -> Ewl **/
		EvlModule evlM = new EvlModule();
		evlM.parse(test.getFileURI(sourceFile));
		evlAST = evlM.getAst();
		eplASTGen = Evl2Epl.evl2epl(evlAST);
		PortingUtil.ast2file(eplASTGen, "AP-UML-MARTE-generated", "epl");
		
		evlM.parse(test.getFileURI(sourceFile));
		evlAST = evlM.getAst();
		ewlASTGen = Evl2Ewl.evl2ewl(evlAST);
		PortingUtil.ast2file(ewlASTGen, "AP-UML-MARTE-generated", "ewl");
	}

	public URI getFileURI(String fileName) throws URISyntaxException {

//		URI binUri = getClass().getResource(fileName).toURI();
		URI uri = null;
		
		File tempFile = new File(fileName);
		URI binUri = tempFile.toURI();
		
		if (binUri.toString().indexOf("bin") > -1) {
			uri = new URI(binUri.toString().replaceAll("bin", "src"));
		} else {
			uri = binUri;
		}
		return uri;
	}
}
