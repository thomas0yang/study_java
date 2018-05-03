package com.thomas.products.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock是针对于共享数据的读写优化，多线程在读操作是不会产生互斥的，而在写操作时才有互斥，在大数据量的 同时读写操作时，会效率很多。
 */
public class TestReentrantReadWriteLock {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final Queue queue = new Queue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    queue.putData();
                    break;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    queue.getData();
                }
            }
        }).start();
    }
}
class Queue{
    private Object data;//被共享
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public void getData(){
        rwl.readLock().lock();//不互斥，大家都可以访问
        try{
            System.out.println(Thread.currentThread().getName()+"准备读取数据");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"获得数据"+this.data);
        }finally{
            rwl.readLock().unlock();
        }

    }
    public void putData(){
        rwl.writeLock().lock();//写锁互斥，一个线程进来，读写的其它线程都不能访问
        try{
            System.out.println(Thread.currentThread().getName()+"准备存入数据");
            rwl.writeLock().lock();
            this.data = new Random().nextInt(500);
            rwl.writeLock().unlock();//记住此操作不可省略
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存入数据"+this.data);
        }finally{
            rwl.writeLock().unlock();//记住此操作不可省略
        }
    }
}