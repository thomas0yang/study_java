// Generated from /Users/yangyang32/IdeaProjects/study_java/src/main/java/com/thomas/products/antlr4/SQLBase.g4 by ANTLR 4.5.3
package com.thomas.products.antlr4.gen;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link SQLBaseVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class SQLBaseBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SQLBaseVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStat(SQLBaseParser.StatContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPrintSQLInfo(SQLBaseParser.PrintSQLInfoContext ctx) {
		System.out.println(ctx.getText());
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitColumn_list_clause(SQLBaseParser.Column_list_clauseContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPrintColumnName(SQLBaseParser.PrintColumnNameContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPrintTableName(SQLBaseParser.PrintTableNameContext ctx) {
		System.out.println("table:" + ctx.getText());
		return visitChildren(ctx); }
}