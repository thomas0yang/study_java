// Generated from /Users/yangyang32/IdeaProjects/study_java/src/main/java/com/thomas/products/antlr4/SQLBase.g4 by ANTLR 4.5.3
package com.thomas.products.antlr4.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, FROM=2, COMMA=3, ID=4, WS=5;
	public static final int
		RULE_stat = 0, RULE_select_clause = 1, RULE_column_list_clause = 2, RULE_column_name = 3, 
		RULE_table_references = 4;
	public static final String[] ruleNames = {
		"stat", "select_clause", "column_list_clause", "column_name", "table_references"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'from'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "FROM", "COMMA", "ID", "WS"
	};
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
	public String getGrammarFileName() { return "SQLBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatContext extends ParserRuleContext {
		public Select_clauseContext select_clause() {
			return getRuleContext(Select_clauseContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLBaseVisitor ) return ((SQLBaseVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			select_clause();
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

	public static class Select_clauseContext extends ParserRuleContext {
		public Select_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_clause; }
	 
		public Select_clauseContext() { }
		public void copyFrom(Select_clauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintSQLInfoContext extends Select_clauseContext {
		public TerminalNode SELECT() { return getToken(SQLBaseParser.SELECT, 0); }
		public Column_list_clauseContext column_list_clause() {
			return getRuleContext(Column_list_clauseContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLBaseParser.FROM, 0); }
		public Table_referencesContext table_references() {
			return getRuleContext(Table_referencesContext.class,0);
		}
		public PrintSQLInfoContext(Select_clauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).enterPrintSQLInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).exitPrintSQLInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLBaseVisitor ) return ((SQLBaseVisitor<? extends T>)visitor).visitPrintSQLInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_clauseContext select_clause() throws RecognitionException {
		Select_clauseContext _localctx = new Select_clauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_select_clause);
		try {
			_localctx = new PrintSQLInfoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(SELECT);
			setState(13);
			column_list_clause();
			setState(14);
			match(FROM);
			setState(15);
			table_references();
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

	public static class Column_list_clauseContext extends ParserRuleContext {
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLBaseParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLBaseParser.COMMA, i);
		}
		public Column_list_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_list_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).enterColumn_list_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).exitColumn_list_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLBaseVisitor ) return ((SQLBaseVisitor<? extends T>)visitor).visitColumn_list_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_list_clauseContext column_list_clause() throws RecognitionException {
		Column_list_clauseContext _localctx = new Column_list_clauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_column_list_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			column_name();
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(18);
				match(COMMA);
				setState(19);
				column_name();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Column_nameContext extends ParserRuleContext {
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
	 
		public Column_nameContext() { }
		public void copyFrom(Column_nameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintColumnNameContext extends Column_nameContext {
		public TerminalNode ID() { return getToken(SQLBaseParser.ID, 0); }
		public PrintColumnNameContext(Column_nameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).enterPrintColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).exitPrintColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLBaseVisitor ) return ((SQLBaseVisitor<? extends T>)visitor).visitPrintColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_column_name);
		try {
			_localctx = new PrintColumnNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(ID);
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

	public static class Table_referencesContext extends ParserRuleContext {
		public Table_referencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_references; }
	 
		public Table_referencesContext() { }
		public void copyFrom(Table_referencesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintTableNameContext extends Table_referencesContext {
		public TerminalNode ID() { return getToken(SQLBaseParser.ID, 0); }
		public PrintTableNameContext(Table_referencesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).enterPrintTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLBaseListener ) ((SQLBaseListener)listener).exitPrintTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLBaseVisitor ) return ((SQLBaseVisitor<? extends T>)visitor).visitPrintTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_referencesContext table_references() throws RecognitionException {
		Table_referencesContext _localctx = new Table_referencesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_table_references);
		try {
			_localctx = new PrintTableNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(ID);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\7 \4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4"+
		"\27\n\4\f\4\16\4\32\13\4\3\5\3\5\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\2\33\2"+
		"\f\3\2\2\2\4\16\3\2\2\2\6\23\3\2\2\2\b\33\3\2\2\2\n\35\3\2\2\2\f\r\5\4"+
		"\3\2\r\3\3\2\2\2\16\17\7\3\2\2\17\20\5\6\4\2\20\21\7\4\2\2\21\22\5\n\6"+
		"\2\22\5\3\2\2\2\23\30\5\b\5\2\24\25\7\5\2\2\25\27\5\b\5\2\26\24\3\2\2"+
		"\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\7\3\2\2\2\32\30\3\2\2"+
		"\2\33\34\7\6\2\2\34\t\3\2\2\2\35\36\7\6\2\2\36\13\3\2\2\2\3\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}