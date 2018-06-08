package com.thomas.products.cache;

import com.google.common.base.Optional;
import com.google.common.cache.*;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LoadingCacheTest2 {

    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    private static class EchoServer implements Runnable {

        @Override
        public void run() {
            try {
                Set<String> keys = cahceBuilder.asMap().keySet();
                for (String key : keys) {
                    cahceBuilder.refresh(key);
                }
            } catch (Exception e) {

            }
        }
    }

    public static LoadingCache<String, Optional<String>> cahceBuilder = CacheBuilder.newBuilder()
            .maximumSize(20)
//            .expireAfterWrite(1, TimeUnit.SECONDS)
//            .refreshAfterWrite(2, TimeUnit.MILLISECONDS)
            .removalListener(new RemovalListener<String, Optional<String>>() {
                @Override
                public void onRemoval(RemovalNotification<String, Optional<String>> removalNotification) {
                    System.out.println(removalNotification.getKey() + "被移除,value:" + removalNotification.getValue());
                }
            })
            .build(new CacheLoader<String, Optional<String>>() {
                @Override
                public Optional<String> load(String k1) throws Exception {
                    String strProValue = "hello " + k1 + "!";
                    System.out.println("%%%%%" + strProValue);
                    return Optional.fromNullable(strProValue);
                }
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(cahceBuilder.get("jerry"));

        System.out.println(cahceBuilder.get("peida"));

        cahceBuilder.get("jerry1");

        executor.scheduleAtFixedRate(new EchoServer(), 0, 1000, TimeUnit.MILLISECONDS);
    }
}
