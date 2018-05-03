package com.thomas.products.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReetrantLock相比于synchronized一个很明显的机制差异就是ReetrantLock
 * 可以中断一个正在等候获得锁的线程，也可以通过投票得到锁，如果不想等下去，那么就是它了。
 */
public class TestReentrantLock {
    /** * @param args */
    public static void main(String[] args) {
        final Output output = new Output();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    output.print("Hello Beauty");
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    output.print("Hello World");
                }
            }
        }).start();
    }
}

class Output {
    Lock lock = new ReentrantLock();
    public void print(String name) {
        lock.lock();
        try {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        } finally {
            lock.unlock(); // 请记住一定要在finally块里释放锁，ReentrantLock不会自动释放锁，不然程序抛出异常
        }
    }
}