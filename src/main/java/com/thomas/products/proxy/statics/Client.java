package com.thomas.products.proxy.statics;

/**
 * 客户端（请领导办事请的人，不认识领导，请领导秘书办事）
 * 
 * @author yangyang200568
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.request();
    }
}
