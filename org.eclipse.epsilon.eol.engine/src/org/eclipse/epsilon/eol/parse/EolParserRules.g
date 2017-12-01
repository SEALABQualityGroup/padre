/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 * -----------------------------------------------------------------------------
 * ANTLR 3 License
 * [The "BSD licence"]
 * Copyright (c) 2005-2008 Terence Parr
 * All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
parser grammar EolParserRules;
options {backtrack=true; output=AST;}

tokens {
	FORMAL;
	PARAMLIST;
	ASSIGNMENT;
	SPECIAL_ASSIGNMENT;
	HELPERMETHOD;
	StatementBlock;
	FOR;
	IF;
	ELSE;
	WHILE;
	SWITCH;
	CASE;
	DEFAULT;
	RETURN;
	BREAK;
	BREAKALL;
	CONTINUE;
	TRANSACTION;
	COLLECTION;
	ABORT;
	CollectionType;
	ModelElementType;
	PARAMETERS;
	NewExpression;
	VAR;
	NEW;
	ANNOTATIONBLOCK;
	EXECUTABLEANNOTATION;
	DELETE;
	THROW;
	EXPRLIST;
	EXPRRANGE;
	NativeType;
	MultiplicativeExpression;
	OPERATOR;
	EXPRESSIONINBRACKETS;
	FeatureCall;
	EOLMODULE;
	BLOCK;
	FEATURECALL;
	TYPE;
	ENUMERATION_VALUE;
	IMPORT;
	MODELDECLARATION;
	NAMESPACE;
	ALIAS;
	DRIVER;
	MODELDECLARATIONPARAMETERS;
	MODELDECLARATIONPARAMETER;
	ITEMSELECTOR;
	MAP;
	KEYVAL;
	KEYVALLIST;
}

@members {

public void setTokenType(ParserRuleReturnScope tree, int type) {
	((CommonTree) tree.getTree()).getToken().setType(type);
}

}

operationDeclarationOrAnnotationBlock
	: operationDeclaration|annotationBlock
	;

modelDeclaration
	@after {
		$tree.getExtraTokens().add($sem);
		$tree.getToken().setType(MODELDECLARATION);
	}
	:	m='model'^ NAME modelAlias? modelDriver? modelDeclarationParameters? sem=';'!
	;

modelAlias
	:  a='alias'^ NAME (','! NAME)*
	{$a.setType(ALIAS);}
	;

modelDriver
	:  d='driver'^ NAME
	{$d.setType(DRIVER);}
	;

modelDeclarationParameters
	@after {
		$tree.getExtraTokens().add($cb);
		$tree.getToken().setType(MODELDECLARATIONPARAMETERS);
	}
	: s='{'^ modelDeclarationParameter? (','! modelDeclarationParameter)* cb='}'!
	;
	
modelDeclarationParameter
	: NAME e='='^ STRING
	{$e.setType(MODELDECLARATIONPARAMETER);}
	;
	
operationDeclaration
	@after {
		$tree.getExtraTokens().add($cp);
		$tree.getToken().setType(HELPERMETHOD);
	}
	:	('operation'|'function')^ (ctx=typeName {setTokenType(ctx,TYPE);})? operationName=NAME op='('! formalParameterList? cp=')'! (':'! returnType=typeName {setTokenType(returnType,TYPE);})? statementBlock
	;
	
importStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	i='import'^ STRING sem=';'!
	{$i.setType(IMPORT);}
	;

block
	@after{
		$tree.setImaginary(true);
	}
	:	statement*
	-> ^(BLOCK statement*)
	;

statementBlock
	@after{
		$tree.getExtraTokens().add($s); 
		$tree.getExtraTokens().add($e);
	}
	:	s='{'! block e='}'!
	;

formalParameter
	@after {
	//	$tree.setImaginary(true);
	}
	:	NAME (':' pt=typeName {setTokenType(pt,TYPE);})?
		-> ^(FORMAL NAME typeName?)
	;

formalParameterList
	@after {
		$tree.setImaginary(true);
	}
	:	formalParameter (',' formalParameter)*
	-> ^(PARAMLIST formalParameter*)
	;

executableAnnotation
	: d='$'^ x=. logicalExpression
	{$d.setType(EXECUTABLEANNOTATION);}
	;

annotation
	:	Annotation|executableAnnotation
	;

annotationBlock
	@after {
		$tree.setImaginary(true);
	}
	: annotation+
	-> ^(ANNOTATIONBLOCK annotation+)
	;
	
typeName
	@after {
		$tree.getToken().setType(TYPE);
	}
	: pathName | nativeType | collectionType
	;

pathName
	:	(metamodel=NAME '!'!)?
		head=packagedType^
		('#'! label=NAME)?
	
		{
			if ($metamodel != null) {
				$head.tree.token.setText(metamodel.getText() + "!" + $head.tree.token.getText());		
			}
			
			if (label != null) {
				$head.tree.token.setText($head.tree.token.getText() + "#" + label.getText());
				$head.tree.token.setType(ENUMERATION_VALUE);
			}	
		}
	;

packagedType
	: head=NAME ('::'! field=NAME! 
			{ 
				$head.setText($head.getText() + "::" + $field.getText()); 
				((CommonToken) head).setStopIndex(((CommonToken)field).getStopIndex());
			}
		)*
	;

nativeType
	@after{
		$tree.getExtraTokens().add($s); 
		$tree.getExtraTokens().add($e);
		$tree.getToken().setType(TYPE);
	}
	:	'Native'^ s='('! STRING e=')'!
	;

collectionType
	@after{
		$tree.getExtraTokens().add($op); 
		$tree.getExtraTokens().add($cp);
		$tree.getToken().setType(TYPE);
	}
	: 	('Collection'|'Sequence'|'List'|'Bag'|'Set'|'OrderedSet'|'Map')^
		((op='('! tn=typeName {setTokenType(tn,TYPE);} (',' tn=typeName {setTokenType(tn,TYPE);})* cp=')'!) |
		 (op='<'! tn=typeName {setTokenType(tn,TYPE);} (',' tn=typeName {setTokenType(tn,TYPE);})* cp='>'!)
		)?
	;

statement 
	:	statementA | statementB
	;

statementA
	: assignmentStatement | expressionStatement | forStatement
		| ifStatement | whileStatement | switchStatement | returnStatement | breakStatement
	;
	
statementB
	: breakAllStatement | returnStatement | transactionStatement
		| abortStatement | continueStatement | throwStatement
		| deleteStatement
	;

statementOrStatementBlock
	:	statement | statementBlock;

expressionOrStatementBlock
	:	':'! logicalExpression | statementBlock
	;

forStatement
	:	f='for'^ '('! formalParameter 'in'! logicalExpression ')'! statementOrStatementBlock
	{$f.setType(FOR);}
	;

ifStatement
	:	i='if'^ '('! logicalExpression ')'! statementOrStatementBlock elseStatement?
	{$i.setType(IF);}	
	;
	
switchStatement
	:	s='switch'^ '('! logicalExpression ')'! '{'! caseStatement* defaultStatement? '}'!
	{$s.setType(SWITCH);}	
	;
	
caseStatement
	:	c='case'^ logicalExpression ':'! (block | statementBlock)
	{$c.setType(CASE);}	
	;
	
defaultStatement
	:	d='default'^ ':'! (block | statementBlock)
	{$d.setType(DEFAULT);}	
	;
	
elseStatement
	@after {
		$tree.getExtraTokens().add($e);
	}
	:	e='else'! statementOrStatementBlock
	;

whileStatement
	:	w='while'^ '('! logicalExpression ')'! statementOrStatementBlock
	{$w.setType(WHILE);}
	;

returnStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	r='return'^ logicalExpression? sem=';'!
	{$r.setType(RETURN);}
	;

throwStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	t='throw'^ logicalExpression? sem=';'!
	{$t.setType(THROW);}
	;

deleteStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	d='delete'^ logicalExpression? sem=';'!
	{$d.setType(DELETE);}
	;
			
breakStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	b='break'^ sem=';'!
	{$b.setType(BREAK);}
	;

breakAllStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	b='breakAll'^ sem=';'!
	{$b.setType(BREAKALL);}
	;

continueStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	c='continue'^ sem=';'!
	{$c.setType(CONTINUE);}
	;

abortStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	a='abort'^ sem=';'!
	{$a.setType(ABORT);}
	;

transactionStatement
	:	t='transaction'^ (NAME (',' NAME)*)? statementOrStatementBlock
	{$t.setType(TRANSACTION);}
	;

assignmentStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	logicalExpression ((normal=':='^|normal='+='^|normal='-='^|normal='*='^|normal='/='^) {normal.setType(ASSIGNMENT);}|special='::='^ {special.setType(SPECIAL_ASSIGNMENT);}) logicalExpression sem=';'!
		
	;

expressionStatement
	@after {
		$tree.getExtraTokens().add($sem);
	}
	:	(postfixExpression op='='^ logicalExpression {$op.setType(OPERATOR);} | logicalExpression) sem=';'!
	;

logicalExpression
	:	relationalExpression ((op='or'^|op='and'^|op='xor'^|op='implies'^) relationalExpression
		{$op.setType(OPERATOR);})*
	;

relationalExpression
	:	additiveExpression ((op='=='^ relationalExpression | op='='^ relationalExpression |
	                      (op='>'^|op='<'^|op='>='^|op='<='^|op='<>'^) additiveExpression)
		{$op.setType(OPERATOR);})*
	;

additiveExpression
	:	multiplicativeExpression ((op='+'^|op='-'^) multiplicativeExpression
		{$op.setType(OPERATOR);})*
	;
	
multiplicativeExpression
	:	unaryExpression ((op='*'^|op='/'^) unaryExpression
		{$op.setType(OPERATOR);})*
	;

unaryExpression
	:	((op='not'^|op='-'^) {$op.setType(OPERATOR);})? shortcutOperatorExpression
	;
	
shortcutOperatorExpression
	:	postfixExpression ((op='++'^) {$op.setType(OPERATOR);})?
	;
	
postfixExpression
	:	itemSelectorExpression ((POINT|ARROW)^ fc=featureCall
		{setTokenType(fc,FEATURECALL);} (is='['^ logicalExpression ']'! {$is.setType(ITEMSELECTOR);})*
		)*
	;

itemSelectorExpression 
	: primitiveExpression (is='['^ primitiveExpression ']'!
		{$is.setType(ITEMSELECTOR);})*
	;
	
featureCall
	: simpleFeatureCall | declarativeFeatureCall
	;

simpleFeatureCall
	: 	n=NAME^ parameterList?
	{$n.setType(FEATURECALL);}
	;

parameterList
	@after {
		$tree.setImaginary(true);
		$tree.getExtraTokens().add($op);
		$tree.getExtraTokens().add($cp);
	}
	:	op='(' (logicalExpression (',' logicalExpression)*)? cp=')'
		-> ^(PARAMETERS logicalExpression*)
	;

declarativeFeatureCall
	@after {
		$tree.getExtraTokens().add($op);
		$tree.getExtraTokens().add($cp);
	}
	:	NAME^ op='('! formalParameterList '|'! logicalExpression (','! logicalExpression)* cp=')'!
	;

newExpression
	:	n='new'^ tn=typeName {setTokenType(tn,TYPE);} parameterList?
	{$n.setType(NEW);}
	;

variableDeclarationExpression
	@after{
		String txt;
		if (n != null) {txt = "new";}
		else { txt = v.getText();}
		$tree.getToken().setText(txt);
		$tree.getToken().setType(VAR);
	}
	:	(v='var'^|v='ext'^) NAME (':'! n='new'!? t=typeName {setTokenType(t, TYPE);} parameterList?)? 
	;

literalSequentialCollection
	@after {
		$tree.getExtraTokens().add($ob);
		$tree.getExtraTokens().add($cb);
	}
	:	(l='Collection'^|l='Sequence'^|l='List'^|l='Bag'^|l='Set'^|l='OrderedSet'^) ob='{'!  expressionListOrRange? cb='}'!
	{$l.setType(COLLECTION);}
	;

expressionRange
	: logicalExpression exp='..'^ logicalExpression
	{$exp.setType(EXPRRANGE);}
	; 

expressionList
	@after {
		$tree.setImaginary(true);
	}
	: logicalExpression (',' logicalExpression)*
	-> ^(EXPRLIST logicalExpression+)
	; 

expressionListOrRange
	:	expressionRange | expressionList
	;

literalMapCollection
	@after {
		$tree.getExtraTokens().add($ob);
		$tree.getExtraTokens().add($cb);
	}
	:	m='Map'^ ob='{'! keyvalExpressionList? cb='}'!
	{$m.setType(MAP);}
	;

keyvalExpressionList
	@after {
		$tree.setImaginary(true);
	}
	:	keyvalExpression (',' keyvalExpression)*
	-> ^(KEYVALLIST keyvalExpression+)
	;

keyvalExpression
	// The first child is an additive expression, to avoid ambiguity in things like "1 = 2 = 3"
	:	additiveExpression eq='='^ logicalExpression
	{$eq.setType(KEYVAL);}
	;
primitiveExpression 
	:	literalSequentialCollection | literalMapCollection | literal | featureCall | pathName | nativeType
		| collectionType  | logicalExpressionInBrackets
		| newExpression | variableDeclarationExpression
	;

logicalExpressionInBrackets
	@after {
		$tree.getExtraTokens().add($ob);
		$tree.getExtraTokens().add($cb);
		$tree.setImaginary(true);
	}
	:	ob='('^ logicalExpression cb=')'!
	{$ob.setType(EXPRESSIONINBRACKETS);}
	;
	
literal
	:	STRING | INT | FLOAT | BOOLEAN
	;
