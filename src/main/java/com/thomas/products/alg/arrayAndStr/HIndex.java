package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 *
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
 * 一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 * 翻译：数组中有h个不小于h的值，求最大的h
 *
 * 示例 1：
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 *
 * 示例 2：
 * 输入：citations = [1,3,1]
 * 输出：1
 *
 *
 * 提示：
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 */
public class HIndex {

    @Test
    public void test1() {
        int[] num1 = {3,0,6,1,5};
        assert 3 == hIndex(num1);

        int[] num2 = {1,3,1};
        assert 1 == hIndex(num2);
    }
    public int hIndex(int[] citations) {
//        Arrays.sort(citations);
        sort(citations);
        int citationNum = 0;
        int useCnt = 0;
        /**
         * 引用次数num[i]    [6, 5, 3, 1, 0]
         * 第i+1文章          1, 2, 3, 4, 5
         * 解释为i+1文章数量引用次数超过num[i]次
         *
         * 倒序检查，可以保证最大的那个h
         * 如果文章数 >= 至少引用次数，则满足h指数
         * 否则不满足h指数，跳出
         * 此时记录的文章数和引用次数的最小值为h指数
         */
        for (int i = citations.length-1; i >=0 ; i--) {
            // i+1 表示至少的文章数
            // citations[i] 表示至少的引用次数
            if (i + 1 >= citations[i]) {
                citationNum = i+1;
                useCnt = citations[i];
            } else {
                break;
            }
        }
        return Math.min(citationNum, useCnt);
    }

    public void sort(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            for (int j = i; j < citations.length; j++) {
                if (citations[i] < citations[j]) {
                    int temp = citations[i];
                    citations[i] = citations[j];
                    citations[j] = temp;
                }
            }
        }
    }


}
