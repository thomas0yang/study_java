package com.thomas.products.thrift;

import org.apache.thrift.TException;

public class HelloWorldServiceImpl implements HelloWorldService.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return "Hi, " + username + ", Welcome to the Thrift world, enjoy it!";
    }
}