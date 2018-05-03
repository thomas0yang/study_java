package com.thomas.products.jvm;

public class TestWrap {
    public static void main(String[] args) {
        ActionListener.wrap(response-> System.out.println("test1"+response));
        ActionListener.wrap(response-> System.out.println("test2"+response));
    }
}
