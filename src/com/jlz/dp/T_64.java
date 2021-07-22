package com.jlz.dp;

/**
 * @author clearlove
 * @ClassName T_64.java
 * @Description
 * @createTime 2021年07月21日 23:47:00
 */
public class T_64 {


    public static int minPathSum(int[][] grid) {
        //设f[i][j]是到ij的最小和
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m + 1][n + 1];
        //走到左上角只有一种解决方案
        f[0][0] = grid[0][0];
        ;
        //边界情况都是1
        for (int i = 1; i < m; ++i) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; ++j) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[m - 1][n - 1];


    }

}
