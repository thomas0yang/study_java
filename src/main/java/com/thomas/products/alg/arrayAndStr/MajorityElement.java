package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

import java.util.Arrays;

/**
 * 【简单】
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class MajorityElement {

    @Test
    public void test1(){
        int[] nums = {2,2,1,1,1,2,2}; // 输入数组

        int k = majorityElement(nums); // 调用
        System.out.println(k);
        assert k == 2;
    }

    @Test
    public void test2(){
        int[] nums = {1,2,3,2,4,2,2}; // 输入数组

        int k = majorityElement(nums); // 调用
        System.out.println(k);
        assert k == 2;
    }


    /**
     * Boyer-Moore 投票算法
     * 如果我们把众数记为+1，把其他数记为−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。对此，可以使用Boyer-Moore投票算法，步骤如下：
     * 1、我们维护一个候选众数candidate和它出现的次数count。初始时candidate可以为任意值，count为0；
     * 2、我们遍历数组nums中的所有元素，对于每个元素x，在判断x之前，如果count的值为0，我们先将x的值赋予candidate，随后我们判断x：
     * 如果x与candidate相等，那么计数器count的值增加1；
     * 如果x与candidate不等，那么计数器count的值减少1。
     * 3、在遍历完成后，candidate即为整个数组的众数。
     *
     * 时间复杂度：O(n)。
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
//        int count = 0;
//        Integer candidate = null;
//
//        for (int num : nums) {
//            if (count == 0) {
//                candidate = num;
//            }
//            count += (num == candidate) ? 1 : -1;
//        }
//
//        return candidate;

        int count = 0;
        Integer candidate = null;
        for (int num: nums) {
            if (count == 0){
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


    /**
     * 排序法
     * 将数组排序。由于多数元素的数量大于 ⌊n/2⌋，排序后位于中间位置的元素必定是多数元素。
     * 时间复杂度：O(nlogn)。
     * 空间复杂度：O(logn)。
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
