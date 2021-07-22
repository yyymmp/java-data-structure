package com.jlz.dp;

/**
 * @author clearlove
 * @ClassName T_70.java
 * @Description
 * @createTime 2021年07月22日 22:02:00
 */
public class T_70 {

    public int climbStairs(int n) {
        //设f[n]为 可以爬到n阶的种数 则 f[n] = f[n-1]+f[n-2]
        int[] f = new int[n + 1];
        if (n <= 1) {
            return 1;
        }
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
