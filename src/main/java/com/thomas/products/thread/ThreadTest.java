package com.thomas.products.thread;

public class ThreadTest {

    public static Object obj = new Object();

    public static void main(String[] args) {
        Thread a = new Thread("111"){
            @Override
            public void run(){
                while (true) {
                    synchronized (obj) {
                        System.err.println("111first");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.err.println("111after");
                    }
                }
            }
        };
        a.start();

        Thread b = new Thread("222") {
            @Override public void run() {
                // while (true) {
                    // synchronized (obj) {
                        System.err.println("222222first");
                        obj.notifyAll();
                        System.err.println("222222after");
                    // }
                // }
            }
        };
        b.start();
    }


}
