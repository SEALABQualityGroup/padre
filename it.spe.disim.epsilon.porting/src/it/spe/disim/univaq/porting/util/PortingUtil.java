package it.spe.disim.univaq.porting.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.apache.commons.io.FileUtils;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.AndOperatorExpression;
import org.eclipse.epsilon.eol.dom.BooleanLiteral;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.PlusOperatorExpression;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.dom.ReturnStatement;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dom.StringLiteral;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dom.Role;
import org.eclipse.epsilon.epl.parse.EplParser;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dom.Fix;
import org.eclipse.epsilon.evl.parse.EvlParser;
import org.eclipse.epsilon.ewl.dom.Wizard;
import org.eclipse.epsilon.ewl.parse.EwlParser;

public class PortingUtil {

	//private static String basePath = "./src/";
	private static String basePath = "../it.spe.disim.epsilon.antipattern_d-s/";
	private static Boolean evlSolution = true;
	private static Boolean evlDetection = true;
	private static Boolean ewlSolution = true;
	private static Boolean ewlDetection = true;

	public static ExecutableBlock<Boolean> createExecutableBooleanBlock(int type,
			String text) {
		ExecutableBlock<Boolean> exeBlock = new ExecutableBlock<Boolean>(
				Boolean.class);
		exeBlock.setToken((CommonToken) createToken(type, text));
		return exeBlock;
	}

	public static ExecutableBlock<Void> createExecutableVoidBlock(int type,
			String text) {
		ExecutableBlock<Void> exeBlock = new ExecutableBlock<Void>(Void.class);
		exeBlock.setToken((CommonToken) createToken(type, text));
		return exeBlock;
	}

	public static ExecutableBlock<String> createExecutableStringBlock(int type,
			String text) {
		ExecutableBlock<String> exeBlock = new ExecutableBlock<String>(
				String.class);
		exeBlock.setToken((CommonToken) createToken(type, text));
		return exeBlock;
	}

	public static AST createModuleAST(int moduleType, String text) {
		AST module = new AST();
		module.setToken((CommonToken) createToken(moduleType, text));
		return module;
	}

	public static Wizard createWizard(String text) {
		Wizard wizard = new Wizard();
		wizard.setToken((CommonToken) createToken(EwlParser.WIZARD, text.replaceAll("\\s+","_")));
		return wizard;
	}

	public static AST getEplOnMatchBlock(AST patternAST) {
		AST onMatchBlock = AstUtil.getChild(patternAST, EplParser.ONMATCH);
		return onMatchBlock;
	}

	public static AST getEplMatchBlock(AST patternAST) {
		AST matchBlock_EPL = AstUtil.getChild(patternAST, EplParser.MATCH);
		return matchBlock_EPL;
	}

	public static List<AST> getEplRoleBlocks(AST patternAST) {
		List<AST> roles = AstUtil.getChildren(patternAST, EplParser.ROLE);
		return roles;
	}

	public static TypeExpression getMainRole(AST patternAST) {
		List<AST> roleBlocks = getEplRoleBlocks(patternAST);

		for (AST roleBlock : roleBlocks) {
			for (AST roleBlockChild : roleBlock.getChildren()) {
				if (isMainRole(roleBlockChild)
						&& roleBlockChild.getNextSibling().getToken().getType() == 64) {
					return (TypeExpression) roleBlockChild.getNextSibling();
				}
			}
		}
		return null;
	}

	public static boolean isMainRole(AST patternAST) {
		if ((patternAST.getToken().getType() == 19 || patternAST.getToken()
				.getType() == 63)
				&& patternAST.getToken().getText().equals("mainRole")) {
			return true;
		}
		return false;
	}

	public static AndOperatorExpression createAndOperatorExpression(
			String operator) {
		AndOperatorExpression and = new AndOperatorExpression();
		and.setToken((CommonToken) createToken(EplParser.OPERATOR, operator));
		return and;
	}

	public static OperationCallExpression createOperationCallExpression(
			String point) {
		OperationCallExpression opCallExp = new OperationCallExpression();
		opCallExp.setToken((CommonToken) createToken(EplParser.POINT, "."));
		return opCallExp;
	}

	public static NameExpression createNameExpression(String name) {
		NameExpression nameExp = new NameExpression(name);
		nameExp.setToken((CommonToken) createToken(EplParser.NAME, name));
		return nameExp;
	}

	public static AST createParameters(String parameters) {
		AST parametersAST = new AST();
		parametersAST.setToken((CommonToken) createToken(EplParser.PARAMETERS,
				parameters));
		return parametersAST;
	}

	public static Token createToken(int type, String text) {
		CommonToken token = new CommonToken(type, text);
		return token;
	}

	public static StringLiteral createStringLiteral(String text) {
		StringLiteral str = new StringLiteral();
		str.setToken((CommonToken) createToken(EolParser.STRING, text));
		return str;
	}

	public static String ASTRewrite(AST ast) {
		String toString = "";

		for (AST child : ast.getChildren()) {
			toString += child.rewrite();
		}
		return toString;
	}

	public static void ast2file(AST ast, String extension) {
		try {
			FileUtils.writeStringToFile(new File(basePath + extension + "/basic."
					+ extension), ASTRewrite(ast));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ast2file(AST ast, String filename, String extension) {
		try {
			FileUtils.writeStringToFile(new File(basePath + extension + "/"+filename+"."
					+ extension), ASTRewrite(ast));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ast2file(AST ast, File file) {
		try {
			FileUtils.writeStringToFile(file, ASTRewrite(ast));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*************EVL*********************/
	
	public static ConstraintContext createConstaintContext(String c){
		ConstraintContext context = new ConstraintContext();
		context.setToken(createToken(EvlParser.CONTEXT, c));
		return context;
	}
	
	public static TypeExpression createTypeExpression(String role){
		TypeExpression exp = new TypeExpression();
		exp.setToken(createToken(EvlParser.TYPE, role));
		return exp;
	}
	
	public static Constraint createConstraint(String str){
		Constraint constraint = new Constraint();
		constraint.setToken(createToken(EvlParser.CONSTRAINT, str));
		return constraint;
	}
	
	public static StatementBlock createStatementBlock(int type, String text, Statement...statements){
		StatementBlock block = new StatementBlock(statements);
		block.setToken(createToken(type, text));
		return block;
	}
	
	public static IfStatement createIfStatement(int type, String text){
		IfStatement ifStatement = new IfStatement();
		ifStatement.setToken(createToken(type, text));
		return ifStatement;
	}
	
	public static ReturnStatement createReturnStatement(int type, String text){
		ReturnStatement returnStatement = new ReturnStatement();
		returnStatement.setToken(createToken(type, text));
		return returnStatement;
	}
	
	public static Statement[] list2array(List<Statement> statements){
		Statement[] sts = new Statement[statements.size()];
		
		int i = 0;
		for(Statement st : statements){
			sts[i] = st;
			i++;
		}
		
		return sts;
	}

	public static BooleanLiteral createBooleanLiteral(int type, String text) {
		BooleanLiteral booleanLiteral = new BooleanLiteral();
		booleanLiteral.setToken((CommonToken) createToken(EolParser.BOOLEAN, text));
		return booleanLiteral;
	}

	public static PlusOperatorExpression createPlusOperatorExpression(
			int type, String text) {
		PlusOperatorExpression plus = new PlusOperatorExpression();
		plus.setToken(createToken(type, text));
		return plus;
	}
	
	public static PropertyCallExpression createPropertyCallExpression(int type, String text) {
		PropertyCallExpression prop = new PropertyCallExpression();
		prop.setToken(createToken(type, text));
		return prop;
	}
	
	public static Fix createFixBlock(int type, String text) {
		Fix fixBlock = new Fix();
		fixBlock.setToken(createToken(type, text));
		return fixBlock;
	}

	public static boolean isEvlDetection() {
		return evlDetection;
	}
	
	public static boolean isEvlSolution() {
		return evlSolution;
	}
	public static boolean isEwlDetection() {
		return ewlDetection;
	}
	
	public static boolean isEwlSolution() {
		return ewlSolution;
	}

	public static Pattern createPattern(String text) {
		Pattern pattern = new Pattern();
		pattern.setToken(createToken(EplParser.PATTERN, text.replaceAll("\\s+","_")));
		return pattern;
	}

	public static Role createRole(int type, String text) {
		Role role = new Role();
		role.setToken(createToken(type, text));
		return role;
	}

	public static Import createImportBlock(int type, String text) {
		Import imp = new Import();
		imp.setToken(createToken(type, "import"));
		imp.addChild(PortingUtil.createStringLiteral(text));
		return imp;
	}
}