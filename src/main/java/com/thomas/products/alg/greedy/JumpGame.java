package com.thomas.products.alg.greedy;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ，
 * 所以永远不可能到达最后一个下标。
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] num1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(num1)); //true
        System.out.println(canJump2(num1)); //true
        System.out.println(canJump3(num1)); //true
        int[] num2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(num2)); //false
        System.out.println(canJump2(num2)); //false
        System.out.println(canJump3(num2)); //false
    }

    private static boolean canJump(int[] nums) {
        if (null == nums || nums.length == 0)
            return false;

        int curIndex = 0;
        int maxIndex = nums[curIndex] + curIndex;
        while (true) {
            int thisMaxIndex = maxIndex;
            int thisCurIndex = curIndex;

            //判断是否结束或者走不了了
            if (thisMaxIndex + 1 >= nums.length) {
                return true;
            }
            if (nums[thisMaxIndex] <= 0) {
                return false;
            }

            //选择跳的最远的下一步
            for (int i = thisCurIndex + 1; i <= thisMaxIndex; i++) {
                if (nums[i] + i > maxIndex) {
                    maxIndex = nums[i] + i;
                    curIndex = i;
                }
            }
        }
    }


    /**
     * 计算每一个节点所能到达的最远距离，取最大值
     * @param nums
     * @return
     */
    private static boolean canJump2(int[] nums) {
        if (null == nums || nums.length == 0)
            return false;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex == i && nums[i] == 0) return false;
            maxIndex = Math.max(nums[i] + i, maxIndex);
        }
        return maxIndex+1>=nums.length;
    }

    /**
     *  1.从数组的倒数第二个点开始分析。
     *  2.若所跳步数大于等于差距（此时为1）即可到达，此刻只需要判断倒数第三个点是否可以到达第二个点。
     *  3.依次判断，直到判断第一个点能否到达离它最近的可跳跃点即可。
     * @param nums
     * @return
     */
    private static boolean canJump3(int[] nums) {
        if (null == nums || nums.length == 0)
            return false;

        int lastIndex = nums.length - 1;
        for (int i = nums.length-2; i >= 0 ; i--) {
            if (nums[i] + i >= lastIndex) { //从i可以跳到lastIndex
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
}

