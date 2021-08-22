package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_121test.java
 * @Description
 * @createTime 2021年08月09日 23:57:00
 */
public class T_121test {

    //设状态转移数组dp[天数][当前是否持股][卖出的次数]
    //一:今天手头没有持有 则有两种情况  1 昨天本身就没有持有,而今天没有买入  2 昨天持有 但今天卖出
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
    //二: 今天手头持有 则 1 昨天持有 今天继续持有dp[i-1][k][1], 2 昨天未持有今天买入 dp[i-1][k-1][0] - prices[i]
    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

    //确定初始值
    //dp[i][0][0] = 0  当交易次数未零时 利润为0
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        //开数组 天数prices.length 是否持股 1 持股 2 不持股  卖出次数 2
        int[][][] dp = new int[prices.length][2][3];
        int MIN_VALUE = Integer.MIN_VALUE;//因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALUE
        //初始化
        dp[0][0][0] = 0;//第一天休息
        dp[0][0][1] = dp[0][1][1] = MIN_VALUE;//第一天不可能卖出 不管当前是否持有 不管卖出次数
        dp[0][0][2] = dp[0][1][2] = MIN_VALUE;//第一天不可能卖出 不管当前是否持有 不管卖出次数
        dp[0][1][0] = -prices[0];//第一天买入
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            dp[i][1][2] = MIN_VALUE;
        }
        return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));

    }
}
