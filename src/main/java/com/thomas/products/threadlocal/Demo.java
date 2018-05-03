package com.thomas.products.threadlocal;

public class Demo {
    public static ThreadLocal local = new ThreadLocal();

    public static int getThreadID() {
        return ((Integer) local.get()).intValue();
    }

    public static void setThreadId(int val) {
        local.set(val);
    }

    public static void main(String[] args) {
        System.out.println("main method");
        Thread thread1 = new Thread(new OtherThread(1));
        Thread thread2 = new Thread(new OtherThread(2));
        thread1.start();
        thread2.start();
    }
}


class OtherThread implements Runnable {
    private final int val;

    public OtherThread(int val) {
        this.val = val;
    }

    @Override
    public void run() {
        Demo.setThreadId(val);
        for (int i = 0; i < 5; i++) {
            System.out.println("thread " + Thread.currentThread().getId() + "-->" + val + ":" + Demo.getThreadID());
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}