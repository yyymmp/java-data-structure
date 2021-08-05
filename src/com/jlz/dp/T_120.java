package com.jlz.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jlz
 * @className: T_120
 * @date 2021/8/4 14:55
 * @description todo
 **/
public class T_120 {
    //自上而下
    public static int minimumTotal(List<List<Integer>> triangle) {
        //由上而下
        //设f[i][j]是从顶部走到i j 位置的最小路径和
        //则 f[i][j] = min(f[i-1][j] + f[i-1][j-1]) + c[i][j]
        //特殊情况: 当j=0时 f[i][0] = f[i-1][0] + c[i][0]
        //当j == i 时, 即最后一个元素 f[i][i] = f[i-1]f[i-1] + c[i][j]
        int n = triangle.size();
        int[][] f = new int[n + 1][n + 1];
        //初始值
        f[0][0] = triangle.get(0).get(0);
        //i从1开始  i=0是初始值
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            //j从1开始 j=0是特殊情况 也就是f[i][0]
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int min = f[n - 1][0];
        for (int i = 0; i < f[n - 1].length - 1; i++) {
            min = Math.min(f[n - 1][i], min);
        }
        return min;
    }

    //自下而上
    public static int minimumTotal2(List<List<Integer>> triangle) {
        //设f[i][j]是到底边的最短距离  则
        //f[i][j] = min(f[i+1][j],f[i+1][j+1])+ triangle[i][j]
        int n = triangle.size();
        int[][] f = new int[n + 1][n + 1];
        //从下往上
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        for (int i = 0; i < f.length; i++) {
            System.out.println(Arrays.toString(f[i]));
        }
        return f[0][0];
    }

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(2);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<Integer> l3 = Arrays.asList(6, 5, 7);
        List<Integer> l4 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);
        System.out.println(minimumTotal2(triangle));
    }
}
