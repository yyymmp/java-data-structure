package com.jlz.dp;

import java.util.stream.Stream;

/**
 * @author clearlove
 * @ClassName T_392.java
 * @Description t包含s
 * @createTime 2021年07月18日 10:23:00
 */
public class T_392 {

    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        //双指针  i指向t j指向s 遍历 相等时j前进  结束时j到了末尾 则包含
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        //双指针
        int i, j = 0;
        for (i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                ++j;
                if (j == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean dyIsSubsequence(String s, String t) {
        //动态规划写法
        //设f[i][j]是字符串t的第i个元素和字符串s的第j个元素中公共子序列的长度
        //最后一步 有两种情况  遍历两个字符串 字符相同 那么 f[i][j] = f[i-1][j-1]+1
        //如果不同 那么 f[i][j]应该是和上一个的值是一样的 公共子序列长度不变  f[i][j] = f[i][j-1]
        int m = s.length();
        int n = t.length();
        if (m > n) {
            return false;
        }
        //初始条件 默认为零
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[n][m] == s.length();
    }
}
