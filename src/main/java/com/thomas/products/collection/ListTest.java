package com.thomas.products.collection;

import com.google.common.collect.Iterables;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>(1);
        for (Object o : list) {
            System.out.println(o);
        }
        Vector<String> bcc = new Vector<String>();
        bcc.add("qianyiwei@sohu-inc.com");
        bcc.add("kecao@sohu-inc.com");
        bcc.add("linwang201925@sohu-inc.com");
        bcc.add("chrissychen@sohu-inc.com");
        bcc.add("helenjiang@sohu-inc.com");
        bcc.add("carol@sohu-inc.com");


//        System.err.println(bcc); //调用迭代器
//
        for (String s:bcc) { //调用迭代器
            System.err.println(s);
        }

        for (int i = 0; i < bcc.size(); i++) { //没有调用迭代器
            System.err.println(bcc.get(i));
        }

        Set<String> set =new HashSet<>();
        set.add("carol@sohu-inc.com");
        set.add("kecao@sohu-inc.com");

        Iterator<String> iterator = bcc.iterator();
        while(iterator.hasNext()){
            String request = (String)iterator.next();
            if(!set.contains(request)) {
                iterator.remove();
            }
        }

        System.err.println(bcc);

        final String[] collectors = Iterables.toArray(bcc, String.class); //google guava
        for (int i = 0; i < collectors.length; i++) {
            System.err.println(collectors[i]);
        }
    }
}
