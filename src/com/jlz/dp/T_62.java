package com.jlz.dp;

/**
 * @author clearlove
 * @ClassName T_62.java
 * @Description
 * @createTime 2021年07月20日 23:22:00
 */
public class T_62 {

    public int uniquePaths(int m, int n) {
        //设f[i][j]到达第i行 第j列 的路径数 则
        //f[i][j] = f[i-1][j] +f[i][j-1]
        int[][] f = new int[m + 1][n + 1];
        f[0][0] = 0;
        //边界情况都是1种  所有的边界情况都是一种
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m][n];
    }
}