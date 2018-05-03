package com.thomas.products.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 该代理类的内部属性为Object类，实际使用时通过该类的构造函数DynamicSubject(Object obj)对其赋值；
 * 此外，在该类还实现了invoke方法，该方法中的 method.invoke(sub,args);
 * 其实就是调用被代理对象的将要被执行的方法，方法参数sub是实际的被代理对象， args为执行被代理对象相应操作所需的参数。
 * 通过动态代理类，我们可以在调用之前或之后执行一些相关操作
 */
public class DynamicSubject implements InvocationHandler {

    private final Object sub;

    public DynamicSubject(Object obj) {
        this.sub = obj;
    }

    private void preRequest() {
        System.out.println("something you want to do before requesting");
    }

    private void postRequest() {
        System.out.println("something you want to do after requesting");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preRequest();
        method.invoke(sub, args);
        postRequest();
        return null;
    }
}
