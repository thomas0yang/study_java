package com.thomas.products.alg;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class SkipList {

    public static void main(String[] args) {
        Map<Integer,Integer> skipList = new ConcurrentSkipListMap<Integer,Integer>();
        skipList.put(9,9);
        skipList.put(1,1);
        skipList.put(3,3);
        skipList.put(5,5);
        skipList.put(11,11);
        skipList.put(7,7);
        System.out.println(skipList.get(7));
        System.out.println(skipList.get(8));
    }
}