package com.thomas.products.extend;

public class Client {

    public static void main(String[] args) {
        Child ch = new Child();
        ch.setSuperA(10);
        System.err.println(ch.getA());
        System.err.println(ch.b);
        ch.hello();
    }
}
