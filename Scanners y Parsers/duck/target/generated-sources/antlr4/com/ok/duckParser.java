// Generated from com\ok\duck.g4 by ANTLR 4.9.2
package com.ok;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class duckParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, MAIN=2, END=3, VAR=4, VOID=5, PRINT=6, WHILE=7, DO=8, IF=9, 
		ELSE=10, INT_T=11, FLOAT_T=12, ASSIGN=13, GT=14, LT=15, NE=16, SEMICOLON=17, 
		COMMA=18, COLON=19, LPAREN=20, RPAREN=21, LBRACE=22, RBRACE=23, PLUS=24, 
		MINUS=25, MULT=26, DIV=27, ID=28, CTE_INT=29, CTE_FLOAT=30, CTE_STRING=31, 
		WS=32, LBRACKET=33, RBRACKET=34;
	public static final int
		RULE_programa = 0, RULE_vars = 1, RULE_varDef = 2, RULE_varDefID = 3, 
		RULE_multipleVar = 4, RULE_funcs = 5, RULE_funcArguments = 6, RULE_multipleFuncArguments = 7, 
		RULE_body = 8, RULE_bodyStatement = 9, RULE_statement = 10, RULE_assign = 11, 
		RULE_condition = 12, RULE_elsePart = 13, RULE_cycle = 14, RULE_print = 15, 
		RULE_printExpresion = 16, RULE_multiplePrint = 17, RULE_expresion = 18, 
		RULE_expresionFinal = 19, RULE_exp = 20, RULE_expFinal = 21, RULE_termino = 22, 
		RULE_terminoFinal = 23, RULE_factor = 24, RULE_sumaResta = 25, RULE_id_cte = 26, 
		RULE_f_call = 27, RULE_f_call_expresion = 28, RULE_m_f_call_expresion = 29, 
		RULE_type = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "vars", "varDef", "varDefID", "multipleVar", "funcs", "funcArguments", 
			"multipleFuncArguments", "body", "bodyStatement", "statement", "assign", 
			"condition", "elsePart", "cycle", "print", "printExpresion", "multiplePrint", 
			"expresion", "expresionFinal", "exp", "expFinal", "termino", "terminoFinal", 
			"factor", "sumaResta", "id_cte", "f_call", "f_call_expresion", "m_f_call_expresion", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'main'", "'end'", "'var'", "'void'", "'print'", "'while'", 
			"'do'", "'if'", "'else'", "'int'", "'float'", "'='", "'>'", "'<'", "'!='", 
			"';'", "','", "':'", "'('", "')'", "'{'", "'}'", "'+'", "'-'", "'*'", 
			"'/'", null, null, null, null, null, "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "MAIN", "END", "VAR", "VOID", "PRINT", "WHILE", "DO", 
			"IF", "ELSE", "INT_T", "FLOAT_T", "ASSIGN", "GT", "LT", "NE", "SEMICOLON", 
			"COMMA", "COLON", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "PLUS", "MINUS", 
			"MULT", "DIV", "ID", "CTE_INT", "CTE_FLOAT", "CTE_STRING", "WS", "LBRACKET", 
			"RBRACKET"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "duck.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public duckParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(duckParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(duckParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(duckParser.SEMICOLON, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public FuncsContext funcs() {
			return getRuleContext(FuncsContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(duckParser.MAIN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(duckParser.END, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(PROGRAM);
			setState(63);
			match(ID);
			setState(64);
			match(SEMICOLON);
			setState(65);
			vars();
			setState(66);
			funcs();
			setState(67);
			match(MAIN);
			setState(68);
			body();
			setState(69);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(duckParser.VAR, 0); }
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitVars(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_vars);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(VAR);
				setState(72);
				varDef();
				}
				break;
			case MAIN:
			case VOID:
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(duckParser.ID, 0); }
		public VarDefIDContext varDefID() {
			return getRuleContext(VarDefIDContext.class,0);
		}
		public TerminalNode COLON() { return getToken(duckParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(duckParser.SEMICOLON, 0); }
		public MultipleVarContext multipleVar() {
			return getRuleContext(MultipleVarContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitVarDef(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ID);
			setState(77);
			varDefID();
			setState(78);
			match(COLON);
			setState(79);
			type();
			setState(80);
			match(SEMICOLON);
			setState(81);
			multipleVar();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefIDContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(duckParser.COMMA, 0); }
		public TerminalNode ID() { return getToken(duckParser.ID, 0); }
		public VarDefIDContext varDefID() {
			return getRuleContext(VarDefIDContext.class,0);
		}
		public VarDefIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterVarDefID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitVarDefID(this);
		}
	}

	public final VarDefIDContext varDefID() throws RecognitionException {
		VarDefIDContext _localctx = new VarDefIDContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDefID);
		try {
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(COMMA);
				setState(84);
				match(ID);
				setState(85);
				varDefID();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleVarContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public MultipleVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterMultipleVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitMultipleVar(this);
		}
	}

	public final MultipleVarContext multipleVar() throws RecognitionException {
		MultipleVarContext _localctx = new MultipleVarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multipleVar);
		try {
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				varDef();
				}
				break;
			case MAIN:
			case VOID:
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncsContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(duckParser.VOID, 0); }
		public TerminalNode ID() { return getToken(duckParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(duckParser.LPAREN, 0); }
		public FuncArgumentsContext funcArguments() {
			return getRuleContext(FuncArgumentsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(duckParser.RPAREN, 0); }
		public TerminalNode LBRACKET() { return getToken(duckParser.LBRACKET, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(duckParser.RBRACKET, 0); }
		public TerminalNode SEMICOLON() { return getToken(duckParser.SEMICOLON, 0); }
		public FuncsContext funcs() {
			return getRuleContext(FuncsContext.class,0);
		}
		public FuncsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterFuncs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitFuncs(this);
		}
	}

	public final FuncsContext funcs() throws RecognitionException {
		FuncsContext _localctx = new FuncsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcs);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(VOID);
				setState(94);
				match(ID);
				setState(95);
				match(LPAREN);
				setState(96);
				funcArguments();
				setState(97);
				match(RPAREN);
				setState(98);
				match(LBRACKET);
				setState(99);
				vars();
				setState(100);
				body();
				setState(101);
				match(RBRACKET);
				setState(102);
				match(SEMICOLON);
				setState(103);
				funcs();
				}
				break;
			case MAIN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncArgumentsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(duckParser.ID, 0); }
		public TerminalNode COLON() { return getToken(duckParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MultipleFuncArgumentsContext multipleFuncArguments() {
			return getRuleContext(MultipleFuncArgumentsContext.class,0);
		}
		public FuncArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterFuncArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitFuncArguments(this);
		}
	}

	public final FuncArgumentsContext funcArguments() throws RecognitionException {
		FuncArgumentsContext _localctx = new FuncArgumentsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcArguments);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(ID);
				setState(109);
				match(COLON);
				setState(110);
				type();
				setState(111);
				multipleFuncArguments();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleFuncArgumentsContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(duckParser.COMMA, 0); }
		public FuncArgumentsContext funcArguments() {
			return getRuleContext(FuncArgumentsContext.class,0);
		}
		public MultipleFuncArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleFuncArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterMultipleFuncArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitMultipleFuncArguments(this);
		}
	}

	public final MultipleFuncArgumentsContext multipleFuncArguments() throws RecognitionException {
		MultipleFuncArgumentsContext _localctx = new MultipleFuncArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multipleFuncArguments);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(COMMA);
				setState(117);
				funcArguments();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(duckParser.LBRACE, 0); }
		public BodyStatementContext bodyStatement() {
			return getRuleContext(BodyStatementContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(duckParser.RBRACE, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(LBRACE);
			setState(122);
			bodyStatement();
			setState(123);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BodyStatementContext bodyStatement() {
			return getRuleContext(BodyStatementContext.class,0);
		}
		public BodyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterBodyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitBodyStatement(this);
		}
	}

	public final BodyStatementContext bodyStatement() throws RecognitionException {
		BodyStatementContext _localctx = new BodyStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bodyStatement);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
			case WHILE:
			case IF:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				statement();
				setState(126);
				bodyStatement();
				}
				break;
			case RBRACE:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public CycleContext cycle() {
			return getRuleContext(CycleContext.class,0);
		}
		public F_callContext f_call() {
			return getRuleContext(F_callContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				condition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				cycle();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				f_call();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(135);
				print();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(duckParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(duckParser.ASSIGN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(duckParser.SEMICOLON, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ID);
			setState(139);
			match(ASSIGN);
			setState(140);
			expresion();
			setState(141);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(duckParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(duckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(duckParser.RPAREN, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElsePartContext elsePart() {
			return getRuleContext(ElsePartContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(duckParser.SEMICOLON, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(IF);
			setState(144);
			match(LPAREN);
			setState(145);
			expresion();
			setState(146);
			match(RPAREN);
			setState(147);
			body();
			setState(148);
			elsePart();
			setState(149);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElsePartContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(duckParser.ELSE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElsePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterElsePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitElsePart(this);
		}
	}

	public final ElsePartContext elsePart() throws RecognitionException {
		ElsePartContext _localctx = new ElsePartContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_elsePart);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(ELSE);
				setState(152);
				body();
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CycleContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(duckParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(duckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(duckParser.RPAREN, 0); }
		public TerminalNode DO() { return getToken(duckParser.DO, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(duckParser.SEMICOLON, 0); }
		public CycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cycle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterCycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitCycle(this);
		}
	}

	public final CycleContext cycle() throws RecognitionException {
		CycleContext _localctx = new CycleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cycle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(WHILE);
			setState(157);
			match(LPAREN);
			setState(158);
			expresion();
			setState(159);
			match(RPAREN);
			setState(160);
			match(DO);
			setState(161);
			body();
			setState(162);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(duckParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(duckParser.LPAREN, 0); }
		public PrintExpresionContext printExpresion() {
			return getRuleContext(PrintExpresionContext.class,0);
		}
		public MultiplePrintContext multiplePrint() {
			return getRuleContext(MultiplePrintContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(duckParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(duckParser.SEMICOLON, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(PRINT);
			setState(165);
			match(LPAREN);
			setState(166);
			printExpresion();
			setState(167);
			multiplePrint();
			setState(168);
			match(RPAREN);
			setState(169);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintExpresionContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode CTE_STRING() { return getToken(duckParser.CTE_STRING, 0); }
		public PrintExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printExpresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterPrintExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitPrintExpresion(this);
		}
	}

	public final PrintExpresionContext printExpresion() throws RecognitionException {
		PrintExpresionContext _localctx = new PrintExpresionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_printExpresion);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case PLUS:
			case MINUS:
			case ID:
			case CTE_INT:
			case CTE_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				expresion();
				}
				break;
			case CTE_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(CTE_STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplePrintContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(duckParser.COMMA, 0); }
		public PrintExpresionContext printExpresion() {
			return getRuleContext(PrintExpresionContext.class,0);
		}
		public MultiplePrintContext multiplePrint() {
			return getRuleContext(MultiplePrintContext.class,0);
		}
		public MultiplePrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplePrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterMultiplePrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitMultiplePrint(this);
		}
	}

	public final MultiplePrintContext multiplePrint() throws RecognitionException {
		MultiplePrintContext _localctx = new MultiplePrintContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_multiplePrint);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(COMMA);
				setState(176);
				printExpresion();
				setState(177);
				multiplePrint();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpresionFinalContext expresionFinal() {
			return getRuleContext(ExpresionFinalContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitExpresion(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			exp();
			setState(183);
			expresionFinal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionFinalContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(duckParser.GT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode LT() { return getToken(duckParser.LT, 0); }
		public TerminalNode NE() { return getToken(duckParser.NE, 0); }
		public ExpresionFinalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresionFinal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterExpresionFinal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitExpresionFinal(this);
		}
	}

	public final ExpresionFinalContext expresionFinal() throws RecognitionException {
		ExpresionFinalContext _localctx = new ExpresionFinalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expresionFinal);
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GT:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(GT);
				setState(186);
				exp();
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(LT);
				setState(188);
				exp();
				}
				break;
			case NE:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				match(NE);
				setState(190);
				exp();
				}
				break;
			case SEMICOLON:
			case COMMA:
			case RPAREN:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public ExpFinalContext expFinal() {
			return getRuleContext(ExpFinalContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			termino();
			setState(195);
			expFinal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpFinalContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(duckParser.PLUS, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(duckParser.MINUS, 0); }
		public ExpFinalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expFinal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterExpFinal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitExpFinal(this);
		}
	}

	public final ExpFinalContext expFinal() throws RecognitionException {
		ExpFinalContext _localctx = new ExpFinalContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expFinal);
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(PLUS);
				setState(198);
				exp();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(MINUS);
				setState(200);
				exp();
				}
				break;
			case GT:
			case LT:
			case NE:
			case SEMICOLON:
			case COMMA:
			case RPAREN:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminoContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminoFinalContext terminoFinal() {
			return getRuleContext(TerminoFinalContext.class,0);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterTermino(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitTermino(this);
		}
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_termino);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			factor();
			setState(205);
			terminoFinal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminoFinalContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(duckParser.MULT, 0); }
		public TerminoContext termino() {
			return getRuleContext(TerminoContext.class,0);
		}
		public TerminalNode DIV() { return getToken(duckParser.DIV, 0); }
		public TerminoFinalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminoFinal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterTerminoFinal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitTerminoFinal(this);
		}
	}

	public final TerminoFinalContext terminoFinal() throws RecognitionException {
		TerminoFinalContext _localctx = new TerminoFinalContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_terminoFinal);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MULT:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(MULT);
				setState(208);
				termino();
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(DIV);
				setState(210);
				termino();
				}
				break;
			case GT:
			case LT:
			case NE:
			case SEMICOLON:
			case COMMA:
			case RPAREN:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(duckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(duckParser.RPAREN, 0); }
		public SumaRestaContext sumaResta() {
			return getRuleContext(SumaRestaContext.class,0);
		}
		public Id_cteContext id_cte() {
			return getRuleContext(Id_cteContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factor);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(LPAREN);
				setState(215);
				expresion();
				setState(216);
				match(RPAREN);
				}
				break;
			case PLUS:
			case MINUS:
			case ID:
			case CTE_INT:
			case CTE_FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				sumaResta();
				setState(219);
				id_cte();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SumaRestaContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(duckParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(duckParser.MINUS, 0); }
		public SumaRestaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumaResta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterSumaResta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitSumaResta(this);
		}
	}

	public final SumaRestaContext sumaResta() throws RecognitionException {
		SumaRestaContext _localctx = new SumaRestaContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sumaResta);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				match(PLUS);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				match(MINUS);
				}
				break;
			case ID:
			case CTE_INT:
			case CTE_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_cteContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(duckParser.ID, 0); }
		public TerminalNode CTE_INT() { return getToken(duckParser.CTE_INT, 0); }
		public TerminalNode CTE_FLOAT() { return getToken(duckParser.CTE_FLOAT, 0); }
		public Id_cteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_cte; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterId_cte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitId_cte(this);
		}
	}

	public final Id_cteContext id_cte() throws RecognitionException {
		Id_cteContext _localctx = new Id_cteContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_id_cte);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << CTE_INT) | (1L << CTE_FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class F_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(duckParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(duckParser.LPAREN, 0); }
		public F_call_expresionContext f_call_expresion() {
			return getRuleContext(F_call_expresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(duckParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(duckParser.SEMICOLON, 0); }
		public F_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterF_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitF_call(this);
		}
	}

	public final F_callContext f_call() throws RecognitionException {
		F_callContext _localctx = new F_callContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_f_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(ID);
			setState(231);
			match(LPAREN);
			setState(232);
			f_call_expresion();
			setState(233);
			match(RPAREN);
			setState(234);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class F_call_expresionContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public M_f_call_expresionContext m_f_call_expresion() {
			return getRuleContext(M_f_call_expresionContext.class,0);
		}
		public F_call_expresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f_call_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterF_call_expresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitF_call_expresion(this);
		}
	}

	public final F_call_expresionContext f_call_expresion() throws RecognitionException {
		F_call_expresionContext _localctx = new F_call_expresionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_f_call_expresion);
		try {
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case PLUS:
			case MINUS:
			case ID:
			case CTE_INT:
			case CTE_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				expresion();
				setState(237);
				m_f_call_expresion();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class M_f_call_expresionContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(duckParser.COMMA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public M_f_call_expresionContext m_f_call_expresion() {
			return getRuleContext(M_f_call_expresionContext.class,0);
		}
		public M_f_call_expresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_m_f_call_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterM_f_call_expresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitM_f_call_expresion(this);
		}
	}

	public final M_f_call_expresionContext m_f_call_expresion() throws RecognitionException {
		M_f_call_expresionContext _localctx = new M_f_call_expresionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_m_f_call_expresion);
		try {
			setState(247);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(COMMA);
				setState(243);
				expresion();
				setState(244);
				m_f_call_expresion();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT_T() { return getToken(duckParser.INT_T, 0); }
		public TerminalNode FLOAT_T() { return getToken(duckParser.FLOAT_T, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof duckListener ) ((duckListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !(_la==INT_T || _la==FLOAT_T) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00fe\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\5\3M\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5Z\n\5\3\6\3\6\5\6^\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7m\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\bu\n\b\3\t\3\t\3\t\5\tz\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13"+
		"\u0084\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u008b\n\f\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u009d\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\5\22\u00b0\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u00b7\n\23\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00c3\n\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u00cd\n\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u00d7\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u00e0\n\32\3\33\3\33\3\33\5\33\u00e5\n\33\3\34\3\34\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u00f3\n\36\3\37\3\37\3\37"+
		"\3\37\3\37\5\37\u00fa\n\37\3 \3 \3 \2\2!\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>\2\4\3\2\36 \3\2\r\16\2\u00f8\2@\3\2"+
		"\2\2\4L\3\2\2\2\6N\3\2\2\2\bY\3\2\2\2\n]\3\2\2\2\fl\3\2\2\2\16t\3\2\2"+
		"\2\20y\3\2\2\2\22{\3\2\2\2\24\u0083\3\2\2\2\26\u008a\3\2\2\2\30\u008c"+
		"\3\2\2\2\32\u0091\3\2\2\2\34\u009c\3\2\2\2\36\u009e\3\2\2\2 \u00a6\3\2"+
		"\2\2\"\u00af\3\2\2\2$\u00b6\3\2\2\2&\u00b8\3\2\2\2(\u00c2\3\2\2\2*\u00c4"+
		"\3\2\2\2,\u00cc\3\2\2\2.\u00ce\3\2\2\2\60\u00d6\3\2\2\2\62\u00df\3\2\2"+
		"\2\64\u00e4\3\2\2\2\66\u00e6\3\2\2\28\u00e8\3\2\2\2:\u00f2\3\2\2\2<\u00f9"+
		"\3\2\2\2>\u00fb\3\2\2\2@A\7\3\2\2AB\7\36\2\2BC\7\23\2\2CD\5\4\3\2DE\5"+
		"\f\7\2EF\7\4\2\2FG\5\22\n\2GH\7\5\2\2H\3\3\2\2\2IJ\7\6\2\2JM\5\6\4\2K"+
		"M\3\2\2\2LI\3\2\2\2LK\3\2\2\2M\5\3\2\2\2NO\7\36\2\2OP\5\b\5\2PQ\7\25\2"+
		"\2QR\5> \2RS\7\23\2\2ST\5\n\6\2T\7\3\2\2\2UV\7\24\2\2VW\7\36\2\2WZ\5\b"+
		"\5\2XZ\3\2\2\2YU\3\2\2\2YX\3\2\2\2Z\t\3\2\2\2[^\5\6\4\2\\^\3\2\2\2][\3"+
		"\2\2\2]\\\3\2\2\2^\13\3\2\2\2_`\7\7\2\2`a\7\36\2\2ab\7\26\2\2bc\5\16\b"+
		"\2cd\7\27\2\2de\7#\2\2ef\5\4\3\2fg\5\22\n\2gh\7$\2\2hi\7\23\2\2ij\5\f"+
		"\7\2jm\3\2\2\2km\3\2\2\2l_\3\2\2\2lk\3\2\2\2m\r\3\2\2\2no\7\36\2\2op\7"+
		"\25\2\2pq\5> \2qr\5\20\t\2ru\3\2\2\2su\3\2\2\2tn\3\2\2\2ts\3\2\2\2u\17"+
		"\3\2\2\2vw\7\24\2\2wz\5\16\b\2xz\3\2\2\2yv\3\2\2\2yx\3\2\2\2z\21\3\2\2"+
		"\2{|\7\30\2\2|}\5\24\13\2}~\7\31\2\2~\23\3\2\2\2\177\u0080\5\26\f\2\u0080"+
		"\u0081\5\24\13\2\u0081\u0084\3\2\2\2\u0082\u0084\3\2\2\2\u0083\177\3\2"+
		"\2\2\u0083\u0082\3\2\2\2\u0084\25\3\2\2\2\u0085\u008b\5\30\r\2\u0086\u008b"+
		"\5\32\16\2\u0087\u008b\5\36\20\2\u0088\u008b\58\35\2\u0089\u008b\5 \21"+
		"\2\u008a\u0085\3\2\2\2\u008a\u0086\3\2\2\2\u008a\u0087\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008a\u0089\3\2\2\2\u008b\27\3\2\2\2\u008c\u008d\7\36\2\2\u008d"+
		"\u008e\7\17\2\2\u008e\u008f\5&\24\2\u008f\u0090\7\23\2\2\u0090\31\3\2"+
		"\2\2\u0091\u0092\7\13\2\2\u0092\u0093\7\26\2\2\u0093\u0094\5&\24\2\u0094"+
		"\u0095\7\27\2\2\u0095\u0096\5\22\n\2\u0096\u0097\5\34\17\2\u0097\u0098"+
		"\7\23\2\2\u0098\33\3\2\2\2\u0099\u009a\7\f\2\2\u009a\u009d\5\22\n\2\u009b"+
		"\u009d\3\2\2\2\u009c\u0099\3\2\2\2\u009c\u009b\3\2\2\2\u009d\35\3\2\2"+
		"\2\u009e\u009f\7\t\2\2\u009f\u00a0\7\26\2\2\u00a0\u00a1\5&\24\2\u00a1"+
		"\u00a2\7\27\2\2\u00a2\u00a3\7\n\2\2\u00a3\u00a4\5\22\n\2\u00a4\u00a5\7"+
		"\23\2\2\u00a5\37\3\2\2\2\u00a6\u00a7\7\b\2\2\u00a7\u00a8\7\26\2\2\u00a8"+
		"\u00a9\5\"\22\2\u00a9\u00aa\5$\23\2\u00aa\u00ab\7\27\2\2\u00ab\u00ac\7"+
		"\23\2\2\u00ac!\3\2\2\2\u00ad\u00b0\5&\24\2\u00ae\u00b0\7!\2\2\u00af\u00ad"+
		"\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0#\3\2\2\2\u00b1\u00b2\7\24\2\2\u00b2"+
		"\u00b3\5\"\22\2\u00b3\u00b4\5$\23\2\u00b4\u00b7\3\2\2\2\u00b5\u00b7\3"+
		"\2\2\2\u00b6\u00b1\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7%\3\2\2\2\u00b8\u00b9"+
		"\5*\26\2\u00b9\u00ba\5(\25\2\u00ba\'\3\2\2\2\u00bb\u00bc\7\20\2\2\u00bc"+
		"\u00c3\5*\26\2\u00bd\u00be\7\21\2\2\u00be\u00c3\5*\26\2\u00bf\u00c0\7"+
		"\22\2\2\u00c0\u00c3\5*\26\2\u00c1\u00c3\3\2\2\2\u00c2\u00bb\3\2\2\2\u00c2"+
		"\u00bd\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3)\3\2\2\2"+
		"\u00c4\u00c5\5.\30\2\u00c5\u00c6\5,\27\2\u00c6+\3\2\2\2\u00c7\u00c8\7"+
		"\32\2\2\u00c8\u00cd\5*\26\2\u00c9\u00ca\7\33\2\2\u00ca\u00cd\5*\26\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00c9\3\2\2\2\u00cc\u00cb\3\2"+
		"\2\2\u00cd-\3\2\2\2\u00ce\u00cf\5\62\32\2\u00cf\u00d0\5\60\31\2\u00d0"+
		"/\3\2\2\2\u00d1\u00d2\7\34\2\2\u00d2\u00d7\5.\30\2\u00d3\u00d4\7\35\2"+
		"\2\u00d4\u00d7\5.\30\2\u00d5\u00d7\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d3"+
		"\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\61\3\2\2\2\u00d8\u00d9\7\26\2\2\u00d9"+
		"\u00da\5&\24\2\u00da\u00db\7\27\2\2\u00db\u00e0\3\2\2\2\u00dc\u00dd\5"+
		"\64\33\2\u00dd\u00de\5\66\34\2\u00de\u00e0\3\2\2\2\u00df\u00d8\3\2\2\2"+
		"\u00df\u00dc\3\2\2\2\u00e0\63\3\2\2\2\u00e1\u00e5\7\32\2\2\u00e2\u00e5"+
		"\7\33\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2"+
		"\u00e4\u00e3\3\2\2\2\u00e5\65\3\2\2\2\u00e6\u00e7\t\2\2\2\u00e7\67\3\2"+
		"\2\2\u00e8\u00e9\7\36\2\2\u00e9\u00ea\7\26\2\2\u00ea\u00eb\5:\36\2\u00eb"+
		"\u00ec\7\27\2\2\u00ec\u00ed\7\23\2\2\u00ed9\3\2\2\2\u00ee\u00ef\5&\24"+
		"\2\u00ef\u00f0\5<\37\2\u00f0\u00f3\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00ee"+
		"\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3;\3\2\2\2\u00f4\u00f5\7\24\2\2\u00f5"+
		"\u00f6\5&\24\2\u00f6\u00f7\5<\37\2\u00f7\u00fa\3\2\2\2\u00f8\u00fa\3\2"+
		"\2\2\u00f9\u00f4\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa=\3\2\2\2\u00fb\u00fc"+
		"\t\3\2\2\u00fc?\3\2\2\2\24LY]lty\u0083\u008a\u009c\u00af\u00b6\u00c2\u00cc"+
		"\u00d6\u00df\u00e4\u00f2\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}