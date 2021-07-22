package com.jlz.tree.lc;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName T_96.java
 * @Description 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * @createTime 2021年07月11日 19:13:00
 */
public class T_96 {

    public static void main(String[] args) {
        int[] a = {2, 5, 7};
        System.out.println(coinChange(a, 29));
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
