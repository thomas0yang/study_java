package com.thomas.products.math;

public class Client {

    public static void main(String[] args) {
        int i = 1;
        double j = 1000d;
        double p = 1200d;
        System.err.println(i / j * p);
        System.err.println(i * p / j);

        System.err.println(1 / 0);
    }
}
