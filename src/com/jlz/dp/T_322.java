package com.jlz.dp;

import static java.lang.Math.min;

import javax.crypto.spec.PSource;

/**
 * @author clearlove
 * @ClassName T_322.java
 * @Description
 * @createTime 2021年07月17日 13:37:00
 */
public class T_322 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        System.out.println(coinChange(arr, 11));
        ;
    }

    public static int coinChange(int[] coins, int amount) {
        //设f[x]= 最少需要多少枚硬币拼出amount
        int[] f = new int[amount + 1];
        int n = coins.length;
        //初始条件   dp[0]:0最少需要多少硬币拼出  0面值最少需要0枚硬币拼出
        f[0] = 0;
        //从小到大的顺序  算出从1-amount最少都需要多少硬币拼出  从小到达算 后者可以利用前者
        for (int i = 1; i <= amount; i++) {
            f[i] = Integer.MAX_VALUE;
            //最后一枚  最后一枚可能是coins的任意一个
            for (int j = 0; j < n; j++) {
                //状态转移方程: 为什么不能等于无穷大 因为这是属于最后一步拼不出的情况 f[i - coins[j]] 已经是无穷大了
                if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[amount];
    }
}

