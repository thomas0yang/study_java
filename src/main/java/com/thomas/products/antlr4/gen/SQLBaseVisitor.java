// Generated from /Users/yangyang32/IdeaProjects/study_java/src/main/java/com/thomas/products/antlr4/SQLBase.g4 by ANTLR 4.5.3
package com.thomas.products.antlr4.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLBaseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLBaseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLBaseParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(SQLBaseParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printSQLInfo}
	 * labeled alternative in {@link SQLBaseParser#select_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintSQLInfo(SQLBaseParser.PrintSQLInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLBaseParser#column_list_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_list_clause(SQLBaseParser.Column_list_clauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printColumnName}
	 * labeled alternative in {@link SQLBaseParser#column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintColumnName(SQLBaseParser.PrintColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printTableName}
	 * labeled alternative in {@link SQLBaseParser#table_references}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintTableName(SQLBaseParser.PrintTableNameContext ctx);
}