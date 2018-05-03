package com.thomas.products.reflection;

import java.lang.reflect.Array;

public class ArrayTester2
{
    public static void main(String args[]) throws InstantiationException, IllegalAccessException
    {
        int[] dims = new int[] { 5, 10, 15 };
        Class<?> type = Integer.TYPE;
        Object array = Array.newInstance(type, dims); // 三维数组
        Object arrayObj = Array.get(array, 3); // 二维数组
        Class<?> cls = arrayObj.getClass().getComponentType();
        System.out.println(cls);
        arrayObj = Array.get(arrayObj, 5); // 一维数组
        Array.setInt(arrayObj, 10, 37);
        int arrayCast[][][] = (int[][][]) array;
        System.out.println(arrayCast[3][5][10]);
    }
}
