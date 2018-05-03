package com.thomas.products.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 5, 300, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.CallerRunsPolicy()
                );
        for (int i=1; i<15; i++){
            executor.execute(new Task(i));
        }
        executor.shutdown();
    }
}

class Task implements Runnable{
    public Task(int num){
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("任务名称="+"taskName"+num);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private final int num;
}
