package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

/**
 * 【中等】除自身外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * 提示：
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * <p>
 * <p>
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */
public class ProductExceptSelf {

    @Test
    public void test1() {
        int[] num1 = {1, 2, 3, 4};
        int[] exceptedNums1 = {24, 12, 8, 6};

        int[] producted1 = productExceptSelf(num1);
        for (int i = 0; i < exceptedNums1.length; i++) {
            assert producted1[i] == exceptedNums1[i];
        }
        int[] producted12 = productExceptSelf2(num1);
        for (int i = 0; i < exceptedNums1.length; i++) {
            assert producted12[i] == exceptedNums1[i];
        }
        int[] producted13 = productExceptSelf3(num1);
        for (int i = 0; i < exceptedNums1.length; i++) {
            assert producted13[i] == exceptedNums1[i];
        }

        int[] num2 = {-1, 1, 0, -3, 3};
        int[] exceptedNums2 = {0, 0, 9, 0, 0};
        int[] producted2 = productExceptSelf(num2);
        for (int i = 0; i < exceptedNums2.length; i++) {
            assert producted2[i] == exceptedNums2[i];
        }
        int[] producted22 = productExceptSelf2(num2);
        for (int i = 0; i < exceptedNums2.length; i++) {
            assert producted22[i] == exceptedNums2[i];
        }
        int[] producted23 = productExceptSelf3(num2);
        for (int i = 0; i < exceptedNums2.length; i++) {
            assert producted23[i] == exceptedNums2[i];
        }
    }

    /**
     * 方法1: 左右乘积列表
     * 我们不必将所有数字的乘积除以给定索引处的数字得到相应的答案，而是利用索引左侧所有数字的乘积和右侧所有数字的乘积（即前缀与后缀）相乘得到答案。
     * 对于给定索引 i，我们将使用它左边所有数字的乘积乘以右边所有数字的乘积。下面让我们更加具体的描述这个算法。
     * 初始化两个空数组 L 和 R。对于给定索引 i，L[i] 代表的是 i 左侧所有数字的乘积，R[i] 代表的是 i 右侧所有数字的乘积。
     * 我们需要用两个循环来填充 L 和 R 数组的值。对于数组 L，L[0] 应该是 1，因为第一个元素的左边没有元素。对于其他元素：L[i] = L[i-1] * nums[i-1]。
     * 同理，对于数组 R，R[length-1] 应为 1。length 指的是输入数组的大小。其他元素：R[i] = R[i+1] * nums[i+1]。
     * 当 R 和 L 数组填充完成，我们只需要在输入数组上迭代，且索引 i 处的值为：L[i] * R[i]。
     * 时间复杂度：O(N)，其中 N 指的是数组 nums 的大小。
     * 空间复杂度：O(N)
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }


    /**
     * 方法2: 空间复杂度 O(1) 的方法
     * 尽管上面的方法已经能够很好的解决这个问题，但是空间复杂度并不为常数。
     * 由于输出数组不算在空间复杂度内，那么我们可以将 L 或 R 数组用输出数组来计算。先把输出数组当作 L 数组来计算，然后再动态构造 R 数组得到结果。让我们来看看基于这个思想的算法。
     * 初始化 answer 数组，对于给定索引 i，answer[i] 代表的是 i 左侧所有数字的乘积。
     * 构造方式与之前相同，只是我们试图节省空间，先把 answer 作为方法一的 L 数组。
     * 这种方法的唯一变化就是我们没有构造 R 数组。而是用一个遍历来跟踪右边元素的乘积。并更新数组 answer[i]=answer[i]∗R。然后 R 更新为 R=R∗nums[i]，其中变量 R 表示的就是索引右侧数字的乘积。
     * 时间复杂度：O(N)，其中 N 指的是数组 nums 的大小。
     *
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }


    /**
     * 前缀积&后缀积
     * 注意：前积乘后积，先存后乘避开自己；
     * @param nums
     * @return
     */
    public int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int pre = 1, suf = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre;
            pre = pre * nums[i];
        }
        for (int i = n-1; i >= 0; i--) {
            ans[i] = suf * ans[i];
            suf = suf * nums[i];
        }
        return ans;
    }
}
