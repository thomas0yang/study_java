package com.thomas.products.alg.arrayAndStr;

/**
 * 【简单】
 * https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * <p>
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * <p>
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * 用户评测：
 * <p>
 * 评测机将使用以下代码测试您的解决方案：
 * <p>
 * int[] nums = [...]; // 输入数组
 * int val = ...; // 要移除的值
 * int[] expectedNums = [...]; // 长度正确的预期答案。
 * // 它以不等于 val 的值排序。
 * <p>
 * int k = removeElement(nums, val); // 调用你的实现
 * <p>
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // 排序 nums 的前 k 个元素
 * for (int i = 0; i < actualLength; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有的断言都通过，你的解决方案将会 通过。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2,_,_]
 * 解释：你的函数函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
 * 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3,_,_,_]
 * 解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
 * 注意这五个元素可以任意顺序返回。
 * 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3}; // 输入数组
        int val = 3; // 要移除的值
        int[] expectedNums = {2, 2}; // 长度正确的预期答案。
        // 它以不等于 val 的值排序。

        int k = removeElement(nums, val); // 调用你的实现
        System.out.println(k); //2

        assert k == expectedNums.length;
//        Arrays.sort(expectedNums);
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }


        int[] nums1 = {0,1,2,2,3,0,4,2};
        int[] expectedNums1 = {0,1,4,0,3};
        int k1 = removeElement(nums1, 2);
        System.out.println(k1); //5
        for (int i = 0; i < k1; i++) {
            assert nums1[i] == expectedNums1[i];
        }
    }

    public static int removeElement(int[] nums, int val) {
        int waitChangeIndex = waitChangeIndex(nums, nums.length - 1, val);
        int curIndex = 0;
        while (curIndex < waitChangeIndex) {
            if (nums[curIndex] == val) {
                nums[curIndex] = nums[waitChangeIndex];
                nums[waitChangeIndex] = val;
                waitChangeIndex = waitChangeIndex(nums, waitChangeIndex-1, val);
            } else {
                curIndex++;
            }
        }
        return curIndex + 1;
    }

    public static int waitChangeIndex(int[] nums, int k, int val) {
        while (k >= 0) {
            if (nums[k] == val) {
                k--;
            } else {
                break;
            }
        }
        return k;
    }

}
