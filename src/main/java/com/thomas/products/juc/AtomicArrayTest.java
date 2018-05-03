package com.thomas.products.juc;

import java.util.List;

/**
 * Created by yangyang32 on 16/9/19.
 */
public class AtomicArrayTest {

    public static void main(String[] args) {
        AtomicArray<String> firstResults = new AtomicArray<>(4);
        firstResults.set(0, "hello");
        firstResults.set(1, "world");
        firstResults.set(2, null);
        firstResults.set(3, "!");

        List<AtomicArray.Entry<String>> entries = firstResults.asList();
        for (AtomicArray.Entry<String> entry : entries) {
            System.out.println(entry.index + " " + entry.value);
        }

    }
}
