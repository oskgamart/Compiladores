// Generated from com\ok\duck.g4 by ANTLR 4.9.2
package com.ok;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class duckLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PROGRAM", "MAIN", "END", "VAR", "VOID", "PRINT", "WHILE", "DO", "IF", 
			"ELSE", "INT_T", "FLOAT_T", "ASSIGN", "GT", "LT", "NE", "SEMICOLON", 
			"COMMA", "COLON", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "PLUS", "MINUS", 
			"MULT", "DIV", "ID", "CTE_INT", "CTE_FLOAT", "CTE_STRING", "WS", "LBRACKET", 
			"RBRACKET"
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


	public duckLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "duck.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00ce\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\7\35\u00a4\n\35\f\35\16\35\u00a7\13\35\3\36\6\36\u00aa\n\36\r\36"+
		"\16\36\u00ab\3\37\6\37\u00af\n\37\r\37\16\37\u00b0\3\37\3\37\6\37\u00b5"+
		"\n\37\r\37\16\37\u00b6\3 \3 \3 \3 \7 \u00bd\n \f \16 \u00c0\13 \3 \3 "+
		"\3!\6!\u00c5\n!\r!\16!\u00c6\3!\3!\3\"\3\"\3#\3#\2\2$\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\7"+
		"\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4\2$$^^\5\2\13\f\17\17\"\"\2\u00d4"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2"+
		"\2\5O\3\2\2\2\7T\3\2\2\2\tX\3\2\2\2\13\\\3\2\2\2\ra\3\2\2\2\17g\3\2\2"+
		"\2\21m\3\2\2\2\23p\3\2\2\2\25s\3\2\2\2\27x\3\2\2\2\31|\3\2\2\2\33\u0082"+
		"\3\2\2\2\35\u0084\3\2\2\2\37\u0086\3\2\2\2!\u0088\3\2\2\2#\u008b\3\2\2"+
		"\2%\u008d\3\2\2\2\'\u008f\3\2\2\2)\u0091\3\2\2\2+\u0093\3\2\2\2-\u0095"+
		"\3\2\2\2/\u0097\3\2\2\2\61\u0099\3\2\2\2\63\u009b\3\2\2\2\65\u009d\3\2"+
		"\2\2\67\u009f\3\2\2\29\u00a1\3\2\2\2;\u00a9\3\2\2\2=\u00ae\3\2\2\2?\u00b8"+
		"\3\2\2\2A\u00c4\3\2\2\2C\u00ca\3\2\2\2E\u00cc\3\2\2\2GH\7r\2\2HI\7t\2"+
		"\2IJ\7q\2\2JK\7i\2\2KL\7t\2\2LM\7c\2\2MN\7o\2\2N\4\3\2\2\2OP\7o\2\2PQ"+
		"\7c\2\2QR\7k\2\2RS\7p\2\2S\6\3\2\2\2TU\7g\2\2UV\7p\2\2VW\7f\2\2W\b\3\2"+
		"\2\2XY\7x\2\2YZ\7c\2\2Z[\7t\2\2[\n\3\2\2\2\\]\7x\2\2]^\7q\2\2^_\7k\2\2"+
		"_`\7f\2\2`\f\3\2\2\2ab\7r\2\2bc\7t\2\2cd\7k\2\2de\7p\2\2ef\7v\2\2f\16"+
		"\3\2\2\2gh\7y\2\2hi\7j\2\2ij\7k\2\2jk\7n\2\2kl\7g\2\2l\20\3\2\2\2mn\7"+
		"f\2\2no\7q\2\2o\22\3\2\2\2pq\7k\2\2qr\7h\2\2r\24\3\2\2\2st\7g\2\2tu\7"+
		"n\2\2uv\7u\2\2vw\7g\2\2w\26\3\2\2\2xy\7k\2\2yz\7p\2\2z{\7v\2\2{\30\3\2"+
		"\2\2|}\7h\2\2}~\7n\2\2~\177\7q\2\2\177\u0080\7c\2\2\u0080\u0081\7v\2\2"+
		"\u0081\32\3\2\2\2\u0082\u0083\7?\2\2\u0083\34\3\2\2\2\u0084\u0085\7@\2"+
		"\2\u0085\36\3\2\2\2\u0086\u0087\7>\2\2\u0087 \3\2\2\2\u0088\u0089\7#\2"+
		"\2\u0089\u008a\7?\2\2\u008a\"\3\2\2\2\u008b\u008c\7=\2\2\u008c$\3\2\2"+
		"\2\u008d\u008e\7.\2\2\u008e&\3\2\2\2\u008f\u0090\7<\2\2\u0090(\3\2\2\2"+
		"\u0091\u0092\7*\2\2\u0092*\3\2\2\2\u0093\u0094\7+\2\2\u0094,\3\2\2\2\u0095"+
		"\u0096\7}\2\2\u0096.\3\2\2\2\u0097\u0098\7\177\2\2\u0098\60\3\2\2\2\u0099"+
		"\u009a\7-\2\2\u009a\62\3\2\2\2\u009b\u009c\7/\2\2\u009c\64\3\2\2\2\u009d"+
		"\u009e\7,\2\2\u009e\66\3\2\2\2\u009f\u00a0\7\61\2\2\u00a08\3\2\2\2\u00a1"+
		"\u00a5\t\2\2\2\u00a2\u00a4\t\3\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6:\3\2\2\2\u00a7\u00a5"+
		"\3\2\2\2\u00a8\u00aa\t\4\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac<\3\2\2\2\u00ad\u00af\t\4\2\2"+
		"\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\7\60\2\2\u00b3\u00b5\t\4\2\2"+
		"\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7>\3\2\2\2\u00b8\u00be\7$\2\2\u00b9\u00bd\n\5\2\2\u00ba\u00bb"+
		"\7^\2\2\u00bb\u00bd\13\2\2\2\u00bc\u00b9\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7$\2\2\u00c2@\3\2\2\2\u00c3\u00c5"+
		"\t\6\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b!\2\2\u00c9B\3\2\2\2\u00ca"+
		"\u00cb\7]\2\2\u00cbD\3\2\2\2\u00cc\u00cd\7_\2\2\u00cdF\3\2\2\2\n\2\u00a5"+
		"\u00ab\u00b0\u00b6\u00bc\u00be\u00c6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}