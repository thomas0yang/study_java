package com.thomas.products.alg.stackAndQueue;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class TopKItem {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        topk(nums);
    }


    private static void topk(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0 )+ 1);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> entry : collect) {
            System.out.println(entry.getKey());
        }
    }
}
