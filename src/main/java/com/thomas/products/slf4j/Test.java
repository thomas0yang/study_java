package com.thomas.products.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yangyang32 on 17/4/27.
 */
public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        String s = "Hello world";
        try {
            Integer i = Integer.valueOf(s);
        } catch (NumberFormatException e) {
            log.error("Failed to {} format", "aaaaa", e);
        }
    }
}
