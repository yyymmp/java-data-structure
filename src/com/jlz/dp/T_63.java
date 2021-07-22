package com.jlz.dp;

/**
 * @author clearlove
 * @ClassName T_63.java
 * @Description
 * @createTime 2021年07月21日 22:20:00
 */
public class T_63 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {
                        0, 0, 0
                }, {
                0, 1, 0
        }, {
                0, 0, 0
        }
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //设f[i][j]到达第i行 第j列 的路径数 则
        //f[i][j] = f[i-1][j] +f[i][j-1] 无障碍的情况下
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        //注意代码里for循环的终止条件，一旦遇到obstacleGrid[i][0] == 1的情况就停止dp[i][0]的赋值1的操作，dp[0][j]同理
        //obstacleGrid[i][0] == 0不满足时 for循环退出 后面都是0
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }
}
