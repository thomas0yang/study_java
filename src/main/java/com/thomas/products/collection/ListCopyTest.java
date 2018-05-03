package com.thomas.products.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListCopyTest {
    public static void main(String[] args) {

        List<String[]> list = new ArrayList<String[]>(3);
        String[] a= {"1","1a"};
        String[] b= {"2","2a"};
        String[] c= {"3","3a"};
        list.add(a);
        list.add(b);
        list.add(c);
        List<String[]> dist = new ArrayList<String[]>(Arrays.asList(new String[list.size()][0]));
        Collections.copy(dist, list);
        String[] strings = list.get(0);
        strings[0] = "100";
        list.iterator();
        list.clear();
        System.out.println(dist);

//        List<String> list = new ArrayList<String>(3);
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        List<String> dist =
//                new ArrayList<String>(Arrays.asList(new String[list.size()]));
//        Collections.copy(dist, list);
//        System.out.println(dist);
    }
}
