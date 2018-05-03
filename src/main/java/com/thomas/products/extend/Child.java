package com.thomas.products.extend;

public class Child extends Super {

    int a = 1;

    int b = 1;

    @Override
    public void hello() {
        super.hello();
        System.err.println("child hello()");
    }

    @Override
    public int getA() {
        return a;
    }

    @Override
    public void setA(int a) {
        this.a = a;
    }

    public void setSuperA(int a) {
        super.setA(a);
    }

}
