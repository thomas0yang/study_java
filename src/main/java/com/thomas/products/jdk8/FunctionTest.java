package com.thomas.products.jdk8;

import java.util.function.Function;

/**
 * Created by yangyang32 on 16/8/30.
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<String, Integer> f = a -> Integer.parseInt(a) + 1;
        Integer integer = f.apply("1234");
        System.out.println(integer);
    }
}

