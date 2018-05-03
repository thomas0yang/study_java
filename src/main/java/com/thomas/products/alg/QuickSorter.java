package com.thomas.products.alg;

import java.util.Arrays;

public class QuickSorter {

    public static void main(String[] args) {
        int s[] = {6, 8, 5, 9, 1, 0, 4};
        quick_sort(s, 0, s.length - 1);
        System.err.println(Arrays.toString(s));
    }

    // 快速排序
    private static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            // Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[i];
            while (i < j) {
                while (i < j && s[j] >= x) { // s[j]比标准x大，则不需要变动，j左移
                    j--;
                }
                if (i < j) { // s[j]比标准x小，则把s[j] 替换 s[i] ，并且i右移
                    s[i++] = s[j];
                }

                while (i < j && s[i] <= x) { // s[i]比标准x小，，则不需要变动，i右移
                    i++;
                }
                if (i < j) { // s[i]比标准x大，则把s[i] 替换 s[j] ，并且j左移
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
}
