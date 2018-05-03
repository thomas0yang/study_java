package com.thomas.products.os;


import java.util.Map;

public class ENVTest {
    public static void main(String[] args) {
        Map<String,String> map = System.getenv();
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"=" + entry.getValue());
        }
    }
}
