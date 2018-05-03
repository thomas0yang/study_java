package com.thomas.products.alg;

import java.util.Arrays;

/**
 * 最大子数组问题
 * <p>
 * 要求一个数组连续下标和的最大值,数组的元素可正、可负、可为零,例如-2,5,3,-6,4,-8,6将返回8。
 * 
 * @author yangyang200568
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int s[] = {-2, 5, 3, -6, 4, -8, 6};
        // int s[] = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
        System.err.println(maxSubArry1(s));
        System.err.println(maxSubArry2(s));
        System.err.println(maxSubArry3(s));
    }

    /**
     * 动态规划法
     * <p>
     * 当我们加上一个正数时，和会增加；当我们加上一个负数时，和会减少。如果当前得到的和是个负数，那么这个和在接下来的累加中应该抛弃并重新清零，
     * 不然的话这个负数将会减少接下来的和。
     * 
     * @param s
     * @return
     */
    private static int maxSubArry3(int[] s) {
        int cur_sum = s[0];
        int max_sum = s[0];
        for (int i = 1; i < s.length; i++) {
            if (cur_sum < 0) {
                cur_sum = 0;
            }
            cur_sum += s[i];

            if (cur_sum > max_sum) {
                max_sum = cur_sum;
            }
        }
        return max_sum;
    }

    /**
     * 二分法
     * 
     * @param s
     * @return
     */
    private static int maxSubArry2(int[] s) {

        int mid = s.length / 2;
        if (mid == 0) {
            return s[0];
        }
        int l_max = maxSubArry2(Arrays.copyOfRange(s, 0, mid)); // 最大值在左边
        int r_max = maxSubArry2(Arrays.copyOfRange(s, mid, s.length)); // 最大值在右边

        int m_max = 0; // 最大值跨左边、右边
        int sum = 0;
        for (int i = mid + 1; i < s.length; i++) {
            sum += s[i];
            if (sum > m_max) {
                m_max = sum;
            }
        }
        sum = m_max;
        for (int i = mid; i >= 0; i--) {
            sum += s[i];
            if (sum > m_max) {
                m_max = sum;
            }
        }
        return Math.max(l_max, Math.max(r_max, m_max));
    }

    /**
     * 暴力枚举法
     * 
     * @param s
     * @return
     */
    private static int maxSubArry1(int[] s) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum = 0;
            for (int j = i; j < s.length; j++) {
                sum += s[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
