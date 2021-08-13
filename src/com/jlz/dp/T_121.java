package com.jlz.dp;

import static java.lang.Math.max;

/**
 * @author jlz
 * @className: T_121
 * @date 2021/8/5 17:40
 * @description 股票问题合集:
 * dp1: 121     买卖股票的最佳时机 一次
 * dp2: 122     买卖股票的最佳时机 无限次
 * dp3: 123     买卖股票的最佳时机 最多2次
 * dp4: 188     买卖股票的最佳时机 最多k次
 **/
public class T_121 {
    //121原题
    //动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    //暴力  运行超时
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = max(max, prices[j] - prices[i]);
            }
        }
        if (max < 0) {
            return 0;
        }
        return max;
    }


    /************************************股票问题合集************************************/
    /**
     * //设f[i][k][j] 是第i天的利润
     * //i :天数
     * //k :可交易次数  本体中0<= k <= 1;
     * //j :当前天是否持股  0:不持股 1:持股
     * //dp[2][3][1]代表今天是第二天，现在我手上持有股票，至今为止最多进行3次交易。
     * int n = prices.length;
     * int k = 3;
     * int[][][] fd = new int[n][2][k];
     * //确定状态转移方程 当前手上不持股 有两种情况:
     * //1: 昨天就未持股 且今天未操作 则 dp[i][k][0] = dp[i-1][k][0]
     * //2: 昨天持股 但是今天卖出 则 dp[i][k][0] = dp[i-1][k-1][1] + prices[i]  卖出,所以前一天的利润+今天的利润 dp[i-1][k][1] + prices[i]
     * //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k-1][1] + prices[i])
     * <p>
     * //当前手上持股 有两种情况
     * //1: 昨天持股 今天无操作 则 dp[i][k][1] = dp[i-1][k][1]
     * //2: 昨天未持股 今天面买入 则 dp[i][k][1] = dp[i-1][k][0] - prices[i]  买入: 收益需要减买入的钱
     * //dp[i][k][1] =  max(dp[i-1][k][1],dp[i-1][k][0] - prices[i])
     * <p>
     * //可得状态转移方程:
     * //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     */

    /**
     * 只能交易一次
     *
     * @param prices
     * @return
     */
    public static int dp1(int[] prices) {
        int n = prices.length;
        //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
        //k = 1 直接带入公式
        //dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
        //dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]) = max(dp[i-1][1][1], -prices[i])
        //边界条件 dp[i-1][0][0]=0, 始终不操作
        //简化k
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]) = max(dp[i-1][1], -prices[i])
        //开数组
        int[][] fd = new int[n][2];
        //边界条件
        //第一天 无操作 没有利润
        fd[0][0] = 0;
        //第一天 买入 则-prices[0]
        fd[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            fd[i][0] = max(fd[i - 1][0], fd[i - 1][1] + prices[i]);
            fd[i][1] = max(fd[i - 1][1], -prices[i]);
        }
        return Math.max(fd[n - 1][0], 0);
    }

    /**
     * 交易多次  k为正无穷
     *
     * @param prices
     * @return
     */
    public static int dp2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

        //k为正无穷 k与k-1 等效
        //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
        //与k无关 简化动态转移方程
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
        int n = prices.length;
        int[][] fd = new int[n][2];
        //边界条件
        //第一天 无操作 没有利润
        fd[0][0] = 0;
        //第一天 卖出 则-prices[0]
        fd[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            fd[i][0] = max(fd[i - 1][0], fd[i - 1][1] + prices[i]);
            fd[i][1] = max(fd[i - 1][1], fd[i - 1][0] - prices[i]);
        }
        return Math.max(fd[n - 1][0], 0);
    }

    /**
     * 交易2次  k = 2
     *
     * @param prices
     * @return
     */
    public static int dp3(int[] prices) {
        int k = 2;//  需要穷举k的情况
        //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

        int n = prices.length;
        int[][][] fd = new int[n][k + 1][2];

        //边界情况
        for (int ki = 0; ki <= k; ki++) {
            //第一天 未持股 买入 卖出 为零
            fd[0][ki][0] = 0;
            //第一天持股  买入 卖出 不可能
            fd[0][ki][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int kj = k; kj >= 1; kj--) {
                fd[i][kj][0] = Math.max(fd[i - 1][kj][0], fd[i - 1][kj][1] + prices[i]);
                fd[i][kj][1] = Math.max(fd[i - 1][kj][1], fd[i - 1][kj - 1][0] - prices[i]);
            }
        }
        return Math.max(fd[n - 1][k][0], 0);
    }

    /**
     * 最多完成交易k次   0<k< n/2
     * 当k>n/2 时 此时的k的含义等于正无穷  即解法2 dp2
     *
     * @param prices
     * @return
     */
    public static int dp4(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            return dp2(prices);
        }

        int[][][] fd = new int[n][k + 1][2];
        //边界情况
        for (int ki = 0; ki <= k; ki++) {
            //第一天 未持股 买入 卖出 为零
            fd[0][ki][0] = 0;
            //第一天持股  买入 卖出 不可能
            fd[0][ki][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int kj = k; kj >= 1; kj--) {
                fd[i][kj][0] = Math.max(fd[i - 1][kj][0], fd[i - 1][kj][1] + prices[i]);
                fd[i][kj][1] = Math.max(fd[i - 1][kj][1], fd[i - 1][kj - 1][0] - prices[i]);
            }
        }
        return Math.max(fd[n - 1][k][0], 0);
    }

    //冷冻期 一天
    public static int dp5(int[] prices) {
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
        //冷冻期  第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
        if (prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] fd = new int[n][2];
        //边界条件
        //第一天 无操作 没有利润
        fd[0][0] = 0;
        //第一天 卖出 则-prices[0]
        fd[0][1] = -prices[0];

//        //第二天不持股的情况
//        fd[1][0] = Math.max(fd[0][0], fd[0][1] + prices[0]);
//        //第二天持股的情况
//        fd[i][1] = max(fd[i - 1][1], fd[i - 2][0] - prices[i]);
        for (int i = 1; i < n; i++) {
            fd[i][0] = max(fd[i - 1][0], fd[i - 1][1] + prices[i]);
            //这里i-2数组移除 判断临界问题
            if (i == 1) {
                //如果是第二天 且持股  则: 1 跟随第一天持股 2第一天未买入 第二天买入
                fd[1][1] = Math.max(fd[0][1], -prices[1]);
            } else {
                fd[i][1] = max(fd[i - 1][1], fd[i - 2][0] - prices[i]);
            }
        }
        return Math.max(fd[n - 1][0], 0);
    }

    //卖出时含手续费
    public static int dp6(int[] prices, int fee) {
        //卖出时减去手续费 其余不变
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]-fee)
        //dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] fd = new int[n][2];
        //边界条件
        //第一天 无操作 没有利润
        fd[0][0] = 0;
        //第一天 卖出 则-prices[0]
        fd[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            fd[i][0] = max(fd[i - 1][0], fd[i - 1][1] + prices[i] - fee);
            fd[i][1] = max(fd[i - 1][1], fd[i - 1][0] - prices[i]);
        }
        return Math.max(fd[n - 1][0], 0);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 0, 2
//                2, 1, 4
//                3, 3, 5, 0, 0, 3, 1, 4
        };

        System.out.println(dp5(arr));
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        //历史最低价
        int min = Integer.MAX_VALUE;
        //最大利润
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
