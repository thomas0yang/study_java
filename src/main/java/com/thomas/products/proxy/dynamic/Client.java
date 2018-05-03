package com.thomas.products.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yangyang200568
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler dynamicSubject = new DynamicSubject(subject);
        Class<? extends Subject> clazz = subject.getClass();
        Subject newProxyInstance = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                dynamicSubject);

        newProxyInstance.request();
    }
}
