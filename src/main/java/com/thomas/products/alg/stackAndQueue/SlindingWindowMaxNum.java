package com.thomas.products.alg.stackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * https://leetcode.cn/problems/sliding-window-maximum/description/
 * https://oi-wiki.org/ds/monotonous-queue/
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class SlindingWindowMaxNum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow2(nums, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MonotonicQueue queue = new MonotonicQueue(k);
        for (int i = 0; i < k - 1; i++) {
            queue.add(nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            queue.add(nums[i]);
            result[i - k + 1] = queue.peek();
        }
        return result;
    }


    private static class MonotonicQueue {
        Deque<Integer> deque;
        int maxSize = 0;

        public MonotonicQueue(int maxSize) {
            this.maxSize = maxSize;
            this.deque = new LinkedList<>();
        }
        
        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            if (deque.size() > maxSize) {
                deque.remove();
            }
            deque.add(val);
        }

        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }

}
