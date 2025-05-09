package com.thomas.products.alg.arrayAndStr;

import java.util.Arrays;

/**
 *【简单】
 * https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 */
public class MergeTwoOrderedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        int[] expectedNums = {1, 2, 2, 3, 5, 6}; // 长度正确的期望答案
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums1[i] == expectedNums[i];
        }

        int[] nums11 = {1};
        int m1 = 1;
        int[] nums21 = {};
        int n1 = 0;
        merge(nums11, m1, nums21, n1);
        System.out.println(Arrays.toString(nums11)); //{1}

        int[] nums111 = {0};
        int m11 = 0;
        int[] nums211 = {1};
        int n11 = 1;
        merge(nums111, m11, nums211, n11);
        System.out.println(Arrays.toString(nums111)); //{1}

        int[] nums1111 = {2, 3, 4, 0, 0, 0};
        int m111 = 3;
        int[] nums2111 = {1, 1, 3};
        int n111 = 3;
        merge(nums1111, m111, nums2111, n111);
        System.out.println(Arrays.toString(nums1111));
        int[] expectedNums2 = {1, 1, 2, 3, 3, 4}; // 长度正确的期望答案
        for (int i = 0; i < expectedNums2.length; i++) {
            assert nums1111[i] == expectedNums2[i];
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        int i = nums1.length - m - 1;
        int j = nums2.length - 1;
        while ((i >= 0 || j >= 0) && k >= 0) {
            if (i < 0) {
                nums1[k] = nums2[j];
                k--;
                j--;
                continue;
            }
            if (j < 0) {
                nums1[k] = nums1[i];
                k--;
                i--;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }
}
