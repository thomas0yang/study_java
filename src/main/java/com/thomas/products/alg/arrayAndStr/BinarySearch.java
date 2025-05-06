package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/binary-search/description/
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class BinarySearch {

    @Test
    public void test1() {
        int[] num1 = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int searchIndex = search(num1, target);
        assert 4 == searchIndex;
    }

    @Test
    public void test2() {
        int[] num1 = {-1, 0, 3, 5, 9, 12};
        int target = 2;

        int searchIndex = search(num1, target);
        assert -1 == searchIndex;
    }


    public static int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if (nums[index] < target) {
                left = index + 1;
            } else if (nums[index] > target) {
                right = index - 1;
            } else {
                return index;
            }
        }
        return -1;
    }
}
