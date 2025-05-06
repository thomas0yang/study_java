package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

import java.util.Arrays;

/**
 * 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class RotateArray {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7}; // 输入数组
        int[] expectedNums = {5, 6, 7, 1, 2, 3, 4}; // 长度正确的期望答案
        int k = 3;

        rotate3(nums, k); // 调用

        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    /**
     * 时间 O(n)
     * 空间 O(n)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int len = nums.length - 1;
            int tmp = nums[len];
            for (int j = len; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length - 1;
        int[] tmp = new int[k];
        int i = 0;
        int tmpK = k - 1;
        for (int j = len; j >= 0; j--) {
            if (i++ < k) {
                tmp[tmpK--] = nums[j];
            } else {
                nums[j + k] = nums[j];
            }
        }
        for (int j = 0; j < k; j++) {
            nums[j] = tmp[j];
        }
    }


    /**
     * 我们可以使用额外的数组来将每个元素放至正确的位置。
     * 用 n 表示数组的长度，我们遍历原数组，将原数组下标为 i 的元素放至新数组下标为 (i+k) mod n 的位置，最后将新数组拷贝至原数组即可。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
