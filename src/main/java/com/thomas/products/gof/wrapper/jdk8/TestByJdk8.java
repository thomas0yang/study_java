package com.thomas.products.gof.wrapper.jdk8;

import java.util.function.Consumer;

/**
 */
public class TestByJdk8 {
    public static void main(String[] args) {
        MessageBoardHandler mb = new MessageBoard();
//        mb.filter("mb一定要学好装饰模式！");
        Consumer<MessageBoardHandler> ensitivesWarpper = (p) -> p.filter("^^过滤掉政治敏感的字眼!");
        Consumer<MessageBoardHandler> htmlWarpper = (p) -> p.filter("^^过滤掉HTML标签!");

//        ensitivesWarpper.accept(mb);
//        htmlWarpper.accept(mb);

//        MessageBoardDecorator2 messageBoardDecorator2 = new MessageBoardDecorator2(mb);
//        messageBoardDecorator2.warp(ensitivesWarpper);
//        mb.filter("一定要学好装饰模式！");


        htmlWarpper.accept(mb);
        System.out.println("=========");
        Listener<MessageBoardHandler> warp1 = Listener.warp(ensitivesWarpper); //方法容器
        Listener<MessageBoardHandler> warp2 = Listener.warp(htmlWarpper);

        warp1.onResponse(mb);
        warp2.onResponse(mb);
    }
}


