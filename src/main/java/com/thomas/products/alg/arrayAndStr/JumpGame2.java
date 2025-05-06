package com.thomas.products.alg.arrayAndStr;

/**
 * 【中等】【贪心】
 * https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class JumpGame2 {
    public static void main(String[] args) {
        int[] num1 = {2, 3, 1, 1, 4};
        assert 2 == minJumpStep(num1); //2
        assert 2 == minJumpStep2(num1); //2
        assert 2 == minJumpStep3(num1); //2

        int[] num2 = {3, 2, 1, 0, 4};
        assert -1 == minJumpStep(num2); //-1
        assert -1 == minJumpStep2(num2); //-1
        assert -1 == minJumpStep3(num2); //-1

        int[] num3 = {3, 2, 3, 1, 0, 4, 1};
        assert 3 == minJumpStep(num3); //3
        assert 3 == minJumpStep2(num3); //3
        assert 3 == minJumpStep3(num3); //3
    }

    private static int minJumpStep(int[] nums) {
        if (null == nums || nums.length == 0)
            return -1;

        int jumpStep = 0;
        int curIndex = 0;
        int maxIndex = nums[curIndex] + curIndex;
        while (true) {
            int thisMaxIndex = maxIndex;
            int thisCurIndex = curIndex;
            jumpStep++; //正常跳1步

            //判断是否结束或者走不了了
            if (thisMaxIndex + 1 >= nums.length) {
                return jumpStep;
            }
            if (nums[thisMaxIndex] <= 0) {
                return -1;
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
     *
     * @param nums
     * @return
     */
    private static int minJumpStep2(int[] nums) {
        if (null == nums || nums.length == 0)
            return -1;
        int curMaxIndex = 0; // 当前覆盖的最远距离下标
        int nextMaxIndex = 0; // 下一步覆盖的最远距离下标
        int step = 0; // 记录走的步数
        for (int i = 0; i < nums.length - 1; i++) { // 注意这里是小于nums.size() - 1，这是关键所在。最后一步不用走
            if (nextMaxIndex == i && nums[i] == 0) return -1;
            nextMaxIndex = Math.max(nums[i] + i, nextMaxIndex); // 更新下一步覆盖的最远距离下标
            if (curMaxIndex == i) { // 遇到当前覆盖的最远距离下标
                step++;             // 走1步
                curMaxIndex = nextMaxIndex; // 更新当前覆盖的最远距离下标
            }
        }
        return step;
    }

    /**
     * 计算每一个节点所能到达的最远距离，取最大值
     * 最简单最容易理解
     * @param nums
     * @return
     */
    private static int minJumpStep3(int[] nums) {
        if (null == nums || nums.length == 0)
            return -1;
        int minStep = -1;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + i > maxIndex) { //如果跳跃的范围超过了最大跳跃索引，则采用该跳跃方式，并计数+1
                maxIndex = nums[i] + i;
                minStep++;
            }
        }
        return maxIndex >= nums.length - 1 ? minStep : -1;
    }
}

