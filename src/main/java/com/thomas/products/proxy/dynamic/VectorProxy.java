package com.thomas.products.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler
{
    private final Object proxyobj;

    public VectorProxy(Object obj) {
        proxyobj = obj;
    }

    public static Object factory(Object obj) {
        Class<?> cls = obj.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), new VectorProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("before calling " + method);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg + "");
            }
        }
        Object object = method.invoke(proxyobj, args);
        System.out.println("after calling " + method);
        return object;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> v = (List<String>) factory(new Vector<String>(10));
        v.add("New");
        v.add("York");
        System.out.println(v);
        v.remove(0);
        System.out.println(v);
    }
}
