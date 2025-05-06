package com.thomas.products.alg.arrayAndStr;

public class GuPiao {
    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int expected1 = 5;
        assert expected1 == maxProfit(prices1);
        assert expected1 == max1(prices1);

        int[] prices2 = {7,6,4,3,1};
        int expected2 = 0;
        assert expected2 == maxProfit(prices2);
        assert expected2 == max1(prices2);

        int[] prices22 = {2,25,1,23};
        int expected22 = 23;
        assert expected22 == maxProfit(prices22);
        assert expected22 == max1(prices22);

        int[] prices3 = {7,1,5,3,6,4};
        int expected3 = 23;
        assert expected3 == maxProfit2(prices3);
        assert expected3 == max2(prices3);

        int[] prices4 = {1,2,3,4,5};
        int expected4 = 23;
        assert expected4 == maxProfit2(prices4);
        assert expected4 == max2(prices4);

        int[] prices5 = {7,6,4,3,1};
        int expected5 = 0;
        assert expected5 == maxProfit2(prices5);
        assert expected5 == max2(prices5);
    }

    /**
     * 等同于max1
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int minNum = prices[0];

        for (int i = 1; i < length; i++) {
            if (prices[i] < minNum) {
                minNum = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i]- minNum);
        }
        return maxProfit;
    }

    /**
     * 等同于max2
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int minNum = prices[0]; //模拟买入。

        for (int i = 1; i < length; i++) {
            if (prices[i] > minNum) { //卖出。如果挣钱就卖出，模拟买入（记录下最小值）
                maxProfit += prices[i] - minNum;
                minNum = prices[i];
            } else {
                minNum = prices[i]; //买入。如果比模拟买入值小，之前买入作废，继续模拟买入。
            }
        }
        return maxProfit;
    }



    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * <p>
     * 示例 2：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     * @param prices
     * @return
     */
    private static int max1(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int min = prices[0]; //买入最小值
        int result = 0;     //卖出最大值

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > result) { //每次都计算卖出是否合适
                result = prices[i] - min;
            }
            if (prices[i] < min) { //每次判断是否碰到更小的，只记录最小值、无需计算结果
                min = prices[i];
            }
//            System.out.println("min="+ min + "\tresult="+ result);
        }
        return result;
    }


    /**
     * 在每一天，你可以决定是否购买和/或出售股票。
     * 你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     *
     * 示例 1：
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     *      总利润为 4 + 3 = 7 。
     *
     * 示例 2：
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，
     * 在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      总利润为 4 。
     * 或者
     * 1买入、2卖出，1
     * 2买入、3卖出，1
     * 3买入、4卖出，1
     * 4买入、5卖出，1
     * 1+1+1+1=4
     *
     * 示例 3：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 交易无法获得正利润，
     * 所以不参与交易可以获得最大利润，最大利润为 0 。
     * @param prices
     * @return
     */
    private static int max2(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] >0) {
                result += (prices[i] - prices[i-1]);
//                System.out.println("i="+ i + "\tresult="+ result);
            }
        }
        return result;
    }
}
