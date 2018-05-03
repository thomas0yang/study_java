// Generated from /Users/yangyang32/IdeaProjects/study_java/src/main/java/com/thomas/products/antlr4/SQLBase.g4 by ANTLR 4.5.3
package com.thomas.products.antlr4.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLBaseParser}.
 */
public interface SQLBaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(SQLBaseParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(SQLBaseParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printSQLInfo}
	 * labeled alternative in {@link SQLBaseParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void enterPrintSQLInfo(SQLBaseParser.PrintSQLInfoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printSQLInfo}
	 * labeled alternative in {@link SQLBaseParser#select_clause}.
	 * @param ctx the parse tree
	 */
	void exitPrintSQLInfo(SQLBaseParser.PrintSQLInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#column_list_clause}.
	 * @param ctx the parse tree
	 */
	void enterColumn_list_clause(SQLBaseParser.Column_list_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#column_list_clause}.
	 * @param ctx the parse tree
	 */
	void exitColumn_list_clause(SQLBaseParser.Column_list_clauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printColumnName}
	 * labeled alternative in {@link SQLBaseParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterPrintColumnName(SQLBaseParser.PrintColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printColumnName}
	 * labeled alternative in {@link SQLBaseParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitPrintColumnName(SQLBaseParser.PrintColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printTableName}
	 * labeled alternative in {@link SQLBaseParser#table_references}.
	 * @param ctx the parse tree
	 */
	void enterPrintTableName(SQLBaseParser.PrintTableNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printTableName}
	 * labeled alternative in {@link SQLBaseParser#table_references}.
	 * @param ctx the parse tree
	 */
	void exitPrintTableName(SQLBaseParser.PrintTableNameContext ctx);
}