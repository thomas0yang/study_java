package com.thomas.products.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyang32 on 16/10/7.
 */
public class SetSizeTest {

    public static void main(String[] args) {
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

        System.out.println();

    }

}
