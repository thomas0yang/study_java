package com.thomas.products.collection;

import java.util.*;

/**
 * Created by yangyang32 on 16/10/7.
 */
public class SetSizeTest {

    public static void main(String[] args) {
//        testInsertSize();
        testAddall();

    }

    private static void testAddall() {
        Set<String> set = new HashSet<>();
        List<String> list = Arrays.asList("1","2","1");
        set.addAll(list);
        System.out.println(list);
        System.out.println(set);
    }

    private static void testInsertSize() {
        //distinct 最大值
        int distinctMax=100000000;
        //distinct 预期数量
        int size=1000;
        //测试插入数据量
        int testDataSize=100000;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < testDataSize; i++) {
            set.add("中华人民共和国"+i);
        }
    }

}
