package com.thomas.products.proxy.statics;

/**
 * 代理角色(秘书),引用了真实角色(领导)
 * 
 * @author yangyang200568
 */
public class ProxySubject implements Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        preRequest();

        if (null == realSubject) {
            realSubject = new RealSubject();
        }
        realSubject.request();

        postRequest();
    }

    private void preRequest() {
        System.out.println("something you want to do before requesting");
    }

    private void postRequest() {
        System.out.println("something you want to do after requesting");
    }
}
