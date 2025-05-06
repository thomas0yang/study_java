package com.thomas.products.alg;

/**
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 问题解析：这一道题还是比较简单的，我们需要考虑的是如何做，效率最快。
 * 这里有一种很好理解的思路：矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
 * 因此从左下角开始查找，当要查找数字比左下角数字大时。
 * 右移 要查找数字比左下角数字小时，上移。这样找的速度最快。
 *
 * ------
 * 著作权归JavaGuide(javaguide.cn)所有
 * 基于MIT协议
 * 原文链接：https://javaguide.cn/cs-basics/algorithms/the-sword-refers-to-offer.html
 */
public class BinaryArrayFinder {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 5, 8}, {2, 6, 9}, {3, 7, 10}};
        System.out.println(find(8, array));
        System.out.println(find(4, array));
    }

    private static boolean find(int k, int[][] array) {
        int row = array.length-1;
        int column = 0;

        while (row >= 0 && column < array[0].length) {
            if (array[row][column] == k) {
                return true;
            } else if (array[row][column] < k) {
                column++;
            } else {
                row--;
            }
        }


        return false;
    }
}
