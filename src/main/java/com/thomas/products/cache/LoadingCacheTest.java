package com.thomas.products.cache;

import com.google.common.base.Optional;
import com.google.common.cache.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// https://www.jianshu.com/p/f4b99b70bd76

public class LoadingCacheTest {

    public static LoadingCache<String, Optional<String>> cahceBuilder = CacheBuilder.newBuilder().maximumSize(1)
            .expireAfterWrite(1, TimeUnit.SECONDS)
            .refreshAfterWrite(2, TimeUnit.MILLISECONDS)
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

        cahceBuilder.get("jerry");

        cahceBuilder.get("peida");

        Thread.sleep(1000);

        cahceBuilder.get("jerry1");

    }
}
