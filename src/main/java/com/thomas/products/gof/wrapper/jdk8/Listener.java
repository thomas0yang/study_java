package com.thomas.products.gof.wrapper.jdk8;

import java.util.function.Consumer;

public interface Listener<T> {

    public abstract void onResponse(MessageBoardHandler response);

    public static Listener<MessageBoardHandler> warp(Consumer<MessageBoardHandler> consumer) {
        return new Listener<MessageBoardHandler>() {
            @Override
            public void onResponse(MessageBoardHandler response) {
                consumer.accept(response);
            }
        };
    }
}
