package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

import java.util.Arrays;

/**
 * 【困难】 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 示例 3：
 * 输入：height = [5,5,1,7,1,1,5,2,7,6]
 * 输出：23
 *
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class TrapRainWater {

    @Test
    public void test1() {
        int[] num1 = {1, 0, 2};
        int[] exceptedNums1 = {2, 1, 2};

        int[] producted1 = candy(num1);
        for (int i = 0; i < exceptedNums1.length; i++) {
            assert producted1[i] == exceptedNums1[i];
        }
    }

    @Test
    public void test2() {
        int[] num1 = {1, 2, 2};
        int[] exceptedNums1 = {1, 2, 1};

        int[] producted1 = candy(num1);
        for (int i = 0; i < exceptedNums1.length; i++) {
            assert producted1[i] == exceptedNums1[i];
        }
    }

    @Test
    public void test3() {
        int[] num1 = {1,2,2,2,1};
        int[] exceptedNums1 = {1,2,1,2,1};

        int[] producted1 = candy(num1);
        for (int i = 0; i < exceptedNums1.length; i++) {
            assert producted1[i] == exceptedNums1[i];
        }
    }

    public int[] candy(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        Arrays.fill(answer, 1); //初始化1

        // 1. 从左往右遍历: 如果"左边"比"右边"分高，则左边+1
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                answer[i]++;
            }
        }

        // 1. 从右往左遍历: 如果"右边"比"左边"分高，则右边+1
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                answer[i]++;
            }
        }
        return answer;
    }
}
