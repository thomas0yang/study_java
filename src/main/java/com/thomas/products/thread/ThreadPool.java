package com.thomas.products.thread;

import java.util.concurrent.*;

public class ThreadPool {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        printThreadActive("start");
        try {
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() {
                    try {
                        Thread.sleep(1000* 1000);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                        return "error";
                    }
                    return "done";
                }
            });
            try {
                future.get(1, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                printThreadActive("TimeoutException start ");
//                System.out.println(future.cancel(true));
                printThreadActive("TimeoutException end ");
            } catch (InterruptedException e) {
                printThreadActive("InterruptedException start ");
//                System.out.println(future.cancel(true));
                printThreadActive("InterruptedException end ");
            } finally {
                printThreadActive("finally ");
                executorService.submit(new Callable<String>() {
                    @Override
                    public String call() {
                        System.out.println("hello done");
                        return "done";
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }




    public static void printThreadActive(String post){
        System.out.println(post + " "+ ((ThreadPoolExecutor)executorService).getActiveCount());
    }
}
