package com.thomas.products.alg;

import java.util.Arrays;

/**
 * 适用于少量数据排序
 * 
 * @author yangyang200568
 */
public class InsertSorter {

    public static void main(String[] args) {
        int s[] = {6, 8, 5, 9, 1, 0, 4};
        insertSort(s);
        System.err.println(Arrays.toString(s));
    }

    /**
     * 插入排序
     * 
     * @param s
     * @return
     */
    private static int[] insertSort(int[] s) {
        for (int i = 1; i < s.length; i++) {
            for (int j = i; j > 0; j--) {
                if (s[j] < s[j - 1]) {
                    int temp = s[j];
                    s[j] = s[j - 1];
                    s[j - 1] = temp;
                } else {
                    break; // 接下来是无用功
                }
            }
        }
        return s;
    }
}
