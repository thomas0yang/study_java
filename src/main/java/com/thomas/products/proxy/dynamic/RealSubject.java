package com.thomas.products.proxy.dynamic;

/**
 * 真实角色(领导)
 * 
 * @author yangyang200568
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("real subject request");
    }

}
