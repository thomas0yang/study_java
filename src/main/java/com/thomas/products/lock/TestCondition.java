package com.thomas.products.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，
 * 以便通过将这些对象与任意 Lock 实现组合使用，为每个对象提供多个等待 set（wait-set）。
 * 其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。
 * 线程之间除了同步互斥，还要考虑通信。在Java5之前我们的通信方式为：wait 和 notify。
 * 那么Condition的优势是支持多路等待，就是我们可以定义多个Condition，每个condition控制线程的一条执行通路。
 * 传统方式只能是一路等待。
 */
public class TestCondition {
    public static void main(String[] args) {
        final Bus bus = new Bus();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 1; i <= 50;i++){
                    bus.sub1();
                }
            }
        }).start();
       new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 1; i <= 50;i++){
                    bus.sub2();
                }
            }
        }).start();
       new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i = 1; i <= 50;i++){
                    bus.sub3();
                }
            }
        }).start();
    }

}
class Bus{
    int flag = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    public void sub1(){
        lock.lock();
        try{
            while(flag!=1){
                try {
                    //this.wait();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 1; i <= 10; i++){
                System.out.println("老大循环"+i+"次");
            }
            //this.notify();
            condition2.signal();
            flag = 2;
        }finally{
            lock.unlock();
        }
    }
    public void sub2(){
        lock.lock();
        try{
            while(flag!=2){
                try {
                    //this.wait();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 1; i <= 20;i++){
                System.out.println("老二"+i+"次");
            }
        //  this.notify();
            condition3.signal();
            flag = 3;
        }finally{
            lock.unlock();
        }
    }
    public void sub3(){
        lock.lock();
        try{
            while(flag!=3){
                try {
                    //this.wait();
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 1; i <= 30;i++){
                System.out.println("老三"+i+"次");
            }
        //  this.notify();
            condition1.signal();
            flag = 1;
        }finally{
            lock.unlock();
        }
    }
}