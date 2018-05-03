package com.thomas.products.reflection;

import java.lang.reflect.Array;

public class ArrayTester1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> stringClass = Class.forName("java.lang.String");
        Object stringArray = Array.newInstance(stringClass, 10);
        Array.set(stringArray, 5, "hello World");
        Object object = Array.get(stringArray, 5);
        System.out.println(object);

        int[] ints = {0, 1, 2, 3, 4, 5};
        Array.set(ints, 3, 1111);
        Object object2 = Array.get(ints, 3);
        System.out.println(object2);
    }
}
