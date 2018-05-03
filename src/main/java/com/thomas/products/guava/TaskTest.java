package com.thomas.products.guava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskTest {
    static ScheduledThreadPoolExecutor stpe = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //构造一个ScheduledThreadPoolExecutor对象，并且设置它的容量为5个
        stpe = new ScheduledThreadPoolExecutor(5);
        MyTask task = new MyTask();
        //隔2秒后开始执行任务，并且在上一次任务开始后隔一秒再执行一次；
        //stpe.scheduleWithFixedDelay(task, 2, 1, TimeUnit.SECONDS);
        //隔6秒后执行一次，但只会执行一次。  
        ScheduledFuture<?> schedule = stpe.schedule(task, 1, TimeUnit.SECONDS);
        System.err.println(schedule.isDone());
        stpe.shutdown();
    }

    private static String getTimes() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return format.format(date);
    }

    private static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("2= " + getTimes());
        }
    }
}  