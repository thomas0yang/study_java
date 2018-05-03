package com.thomas.products.antlr4;

import com.thomas.products.antlr4.gen.SQLBaseBaseVisitor;
import com.thomas.products.antlr4.gen.SQLBaseLexer;
import com.thomas.products.antlr4.gen.SQLBaseParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by yangyang32 on 16/8/17.
 */
public class Test {
    public static void main(String[] args) {
        String sql = "select a,b from t";

        //1 词法解析
        SQLBaseLexer lexer = new SQLBaseLexer(new ANTLRInputStream(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //2 语法解析
        SQLBaseParser parser = new SQLBaseParser(tokens);
        SQLBaseParser.StatContext stat = parser.stat();

//        //3 遍历打印
//        ParseTreeWalker walker = new ParseTreeWalker();
//        SQLBaseBaseListener listener = new SQLBaseBaseListener();
//        walker.walk(listener, stat);

        //3 遍历打印2
        SQLBaseBaseVisitor visitor = new SQLBaseBaseVisitor();
        visitor.visit(stat);
    }
}
