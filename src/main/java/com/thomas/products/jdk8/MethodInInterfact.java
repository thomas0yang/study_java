package com.thomas.products.jdk8;

interface MethodInInterfact {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
    static double round(int a) {
        return Math.round(a);
    }
}