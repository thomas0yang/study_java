package com.thomas.products.array;

import java.util.Arrays;

public class Client {

    public static void main(final String[] args) {
        final int[] s1={1,2,3,4,5,6};
        final int s4[] = Arrays.copyOfRange(s1, 2, 10);//��ݷ�Χ����s1���
        System.out.printf("������ (����)\t%s%n", Arrays.toString(s4));
        System.out.printf("������ (����)\t%s%n", s4.length);
        //		System.err.println(b1.equals(b2));

        final String[] aks = new String[]
                                        { "b6d6f8e3dfde8ad7", "adsfasd", "asdfsadfsa", "39d5613e2fefeb3a", "c86b08bfd34a670a", "12648bd6fa3cb662",
                                        "a1e5455c846fee9f" };
        System.out.print(aks.length);
    }
}
