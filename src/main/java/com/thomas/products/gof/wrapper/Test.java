package com.thomas.products.gof.wrapper;

/**
 * @author leno 客户端测试
 */
public class Test {
    public static void main(String[] args) {
        MessageBoardHandler mb = new MessageBoard();
        String content = mb.filter("一定要学好装饰模式！");
        System.out.println(content);

        mb = new HtmlFilter(new SensitiveFilter(new MessageBoard()));
        content = mb.filter("一定要学好装饰模式！");
        System.out.println(content);
    }
}
