package com.thomas.products.gof.wrapper.jdk8;

import java.util.function.Consumer;

public class MessageBoardDecorator2 implements MessageBoardHandler {

    private MessageBoardHandler handler;

    public MessageBoardDecorator2(MessageBoardHandler handler) {
        this.handler = handler;
    }

    public MessageBoardHandler warp(Consumer<MessageBoardHandler> consumer) {
        return new MessageBoardHandler() {
            @Override
            public void filter(String msg) {
                consumer.accept(handler);
            }
        };
    }

    @Override
    public void filter(String msg) {
         handler.filter(msg);
    }
}