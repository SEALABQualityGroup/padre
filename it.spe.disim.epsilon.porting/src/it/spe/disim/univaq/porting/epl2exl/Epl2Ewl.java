package it.spe.disim.univaq.porting.epl2exl;

import it.spe.disim.univaq.porting.Exl2Eyl;
import it.spe.disim.univaq.porting.util.PortingUtil;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AndOperatorExpression;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.epl.parse.EplParser;
import org.eclipse.epsilon.ewl.dom.Wizard;
import org.eclipse.epsilon.ewl.parse.EwlParser;

public class Epl2Ewl extends Exl2Eyl {

	public static AST epl2ewl(AST eplAST) {

		AST ewlAST = PortingUtil.createModuleAST(EwlParser.EWLMODULE,
				"EWLMODULE");

		for (AST patternAST : AstUtil.getChildren(eplAST, EplParser.PATTERN)) {

			Wizard wizardAST = PortingUtil.createWizard(patternAST.getText());

			ExecutableBlock<Boolean> ewlGuard = PortingUtil
					.createExecutableBooleanBlock(EwlParser.GUARD, "guard");
			if (PortingUtil.isEwlDetection()) {
				ewlGuard = createEwlGuard(patternAST);
			} else {
				ewlGuard.addChild(null);
			}

			ExecutableBlock<String> ewlTitle = PortingUtil
					.createExecutableStringBlock(EwlParser.TITLE, "title");

			// Titolo del wizard
			StringLiteral title = PortingUtil.createStringLiteral(patternAST
					.getText());
			ewlTitle.addChild(title);

			// Solution
			ExecutableBlock<Void> ewlDo = PortingUtil
					.createExecutableVoidBlock(EwlParser.DO, "do");

			AST onMatchEpl = PortingUtil.getEplOnMatchBlock(patternAST);
			if (PortingUtil.isEwlSolution() && onMatchEpl != null) {
				AST bak = onMatchEpl;
				adapting4EWL(bak);
				ewlDo.addChild((StatementBlock) bak.getFirstChild());
			} else {
				ewlDo.addChild(null);
			}

			wizardAST.setFirstChild(ewlGuard);
			wizardAST.addChild(ewlTitle);
			wizardAST.addChild(ewlDo);

			ewlAST.addChild(wizardAST);
		}

		return ewlAST;

	}

	public static ExecutableBlock<Boolean> createEwlGuard(AST patternAST) {
		AST matchBlock = PortingUtil.getEplMatchBlock(patternAST);
		// creo il sottoalbero GUARD
		@SuppressWarnings("unchecked")
		ExecutableBlock<Boolean> ewlGuard = (ExecutableBlock<Boolean>) PortingUtil
				.createExecutableBooleanBlock(EwlParser.GUARD, "guard");
		// crea il primo sottoalbero di GUARD
		AndOperatorExpression and = PortingUtil
				.createAndOperatorExpression("and");
		// crea il sottoalbero "sx" di and
		// AndOperatorExpression andIsTypeOf = PortingUtil
		// .createOperationExpression("and");
		// crea il sottoalbero . con i due sottoalberi figli
		// 1 self
		// 2 isTypeOf
		OperationCallExpression point = PortingUtil
				.createOperationCallExpression(".");
		NameExpression self = PortingUtil.createNameExpression("self");
		NameExpression isTypeOf = PortingUtil.createNameExpression("isTypeOf");

		// crea il sottoalbero PARAMETERS del nodo isTypeOf
		AST parameters = PortingUtil.createParameters("PARAMETERS");
		TypeExpression mainRole = PortingUtil.getMainRole(patternAST);

		NameExpression isTypeOfPar = PortingUtil.createNameExpression(mainRole
				.getText());
		parameters.addChild(isTypeOfPar);

		// aggiunge il sottoalbero PARAMETERS al padre
		isTypeOf.addChild(parameters);

		point.setFirstChild(self);
		point.addChild(isTypeOf);

		// aggiungono i figli:
		// 1 self.isTypeOf()
		// 2 l'AST MATCH di EPL
		and.setFirstChild(point);

		adapting4EWL(matchBlock);
		and.addChild(matchBlock.getChild(0));

		ewlGuard.addChild(and);

		return ewlGuard;

	}
}
