package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

import java.util.Arrays;

/**
 * 【困难】 分发糖果——资本家发工资算法
 * 思路雷同ProductExceptSelf（除自身外数组的乘积）
 * https://leetcode.cn/problems/candy/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * <p>
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * <p>
 * 提示：
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 */
public class Candy {

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
