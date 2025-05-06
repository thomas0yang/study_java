package com.thomas.products.alg.arrayAndStr;

import org.junit.Test;

/**
 * 【中等】加油站
 * https://leetcode.cn/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * 示例 1:
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 * 示例 2:
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 *
 * 提示:
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 */
public class GasStation {

    @Test
    public void test1() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        assert 3 == canCompleteCircuit(gas, cost);
        assert 3 == canCompleteCircuit2(gas, cost);
    }

    @Test
    public void test2() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        assert -1 == canCompleteCircuit(gas, cost);
        assert -1 == canCompleteCircuit2(gas, cost);
    }


    /**
     * 解法一：
     * 1、寻找始发站startIndex（gas-cost>=0），始发站能够走到最后
     * 2、第二轮检测从0到始发站，是否可以走完
     *
     * 走完标准：累计gas-累计cost >= 0
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int accSumOfGas = 0; // 到达下一个加油站加油之前的累计剩余油量
        int startIndex = 0; // 始发站
        for (int i = 0; i < len; i++) {
            accSumOfGas += gas[i] - cost[i];
            if (accSumOfGas < 0) { // 走不动了, 说明之前的始发站不行，从i+1重新出发
                startIndex = i + 1;
                accSumOfGas = 0;
            }
        }
        // 判断累计剩余油量能否走完startIdx之前的加油站
        for (int i = 0; i < startIndex; i++) {
            accSumOfGas += gas[i] - cost[i];
            if (accSumOfGas < 0) {
                return -1;
            }
        }
        return startIndex;
    }

    /**
     * 重点就两句话：
     * 1、两个数组之差的总和必须大于等于0，否则不能完成绕行
     * 2、一个站的收益如果小于0，肯定不能作为起点；而连续的多个站也可以等效地看做一个站，如果其累积收益小于0，就跳过，寻找下一个。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int startIndex = 0; // 始发站
        int totalAccSumOfGas = 0; //所有站的累计收益（连续的多个站也可以等效地看做一个站）
        int curAccSumOfGas = 0; //从startindex到i的多个站的累计收益
        for (int i = 0; i < len; i++) {
            curAccSumOfGas += gas[i] - cost[i];
            totalAccSumOfGas += gas[i] - cost[i];
            if (curAccSumOfGas < 0) { // 走不动了, 说明之前的始发站不行，从i+1重新出发
                startIndex = i + 1;
                curAccSumOfGas = 0;
            }
        }
        return totalAccSumOfGas >= 0 ? startIndex : -1;
    }
}
