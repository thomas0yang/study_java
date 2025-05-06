package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

/**
 *【中等】
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 说明：
 *
 * 为什么返回数值是整数，但输出的答案是数组呢？
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 */
public class RemoveDuplicates2 {

    @Test
    public void test1(){
        int[] nums = {1,1,1,2,2,3}; // 输入数组
        int[] expectedNums = {1,1,2,2,3}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用
        System.out.println(k);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    @Test
    public void test2(){
        int[] nums = {0,0,1,1,1,1,2,3,3}; // 输入数组
        int[] expectedNums = {0,0,1,1,2,3,3}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用
        System.out.println(k);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public int removeDuplicates(int[] nums) {

        int beforeIndex = 0;
        int curIndex = 1;
        int duplicateNum = 0;
        while (curIndex < nums.length) {
            //相等
            if (nums[curIndex] == nums[beforeIndex]) {
                duplicateNum++;
                if (duplicateNum==1) { //有一个重复的数了,则移动beforeIndex到下一个指针，且将curIndex的值移动过来
                    beforeIndex++;
                    nums[beforeIndex] = nums[curIndex];
                    curIndex++;
                } else { //多个重复的数，只移动curIndex
                    curIndex++;
                }
            } else {
                //不等，则移动beforeIndex到下一个指针，且将curIndex的值移动过来
                duplicateNum = 0;
                beforeIndex++;
                nums[beforeIndex] = nums[curIndex];
                curIndex++;
            }
        }
        return  beforeIndex+1;

    }

//    public int removeDuplicates(int[] nums) {
//
//        int beforeIndex = 0;
//        int curIndex = 1;
//        int duplicateNum = 0;
//
//        while (curIndex < nums.length){
//            if (nums[beforeIndex] != nums[curIndex]) { //不相等，迁移一位
//                nums[++beforeIndex] = nums[curIndex]; //移动before到下一位，并为正确的值
//                duplicateNum=0;
//            } else { //相等
//                duplicateNum++; //增加计数
//                if (duplicateNum == 1) {
//                    nums[++beforeIndex] = nums[curIndex]; //移动before到下一位，并为正确的值
//                }
//            }
//            curIndex++;
//        }
//        return beforeIndex+1;
//    }
}
