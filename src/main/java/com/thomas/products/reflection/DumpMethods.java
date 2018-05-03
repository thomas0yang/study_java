package com.thomas.products.reflection;

import java.lang.reflect.Method;

public class DumpMethods {
    // com.sohu.tv.reflection.DumpMethods
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(args[0]);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
