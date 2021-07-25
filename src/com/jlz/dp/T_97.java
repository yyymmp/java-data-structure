package com.jlz.dp;

import com.jlz.sort.exchange.T;

/**
 * @author clearlove
 * @ClassName T_97.java
 * @Description 交错字符串
 * @createTime 2021年07月25日 15:05:00
 */
public class T_97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        /**
         * 分析: s3是由s1和s2交错而成 需开二维数组
         * 设f[i][j]为s1的前i个字符与s2的前j个字母能否交错组成s3的前i+j个元素 ,s3的最后一个元素可能来自s1或者s2
         *  但不管来自谁 一定要与s3的最后一个元素相等 则推导
         * 1、f(i-1,j) && s1[i-1]==s3[p]
         * 2、f(i,j-1) && s2[j-1]==s3[p]
         */
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        boolean[][] f = new boolean[n1 + 1][n2 + 1];
        f[0][0] = true;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                //最后一位
                int p = i + j - 1;
                if (i > 0) {
                    //从s1获取
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    //从s2获取
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n1][n2];

    }

    //使用递归 +优化 存储已经计算过的结果
    public boolean helper(String s1, String s2, String s3, int i, int j, int k, Boolean[][] visit) {
        // i j k 分别是s1,s2,s3的指针
        //base case
        if (i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (visit[i][j] != null) {
            return visit[i][j];
        }
        if (k >= s3.length()) {
            return false;
        }
        if (i < s1.length()) {
            if (s1.charAt(i) == s3.charAt(k) && helper(s1, s2, s3, i + 1, j, k + 1, visit)) {
                //将i和k移动
                return true;
            }
        }
        if (j < s2.length()) {
            if (s2.charAt(j) == s3.charAt(k) && helper(s1, s2, s3, i, j + 1, k + 1, visit)) {
                //将i和k移动
                return true;
            }
        }
        return visit[i][j] = false;

    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new T_97().helper(s1, s2, s3, 0, 0, 0, new Boolean[s1.length() + 1][s2.length() + 1]));
    }

}
