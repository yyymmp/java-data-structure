package com.jlz.dp;

/**
 * @author clearlove
 * @ClassName T_5.java
 * @Description  最长回文串
 * @createTime 2021年07月18日 23:49:00
 */
public class T_5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        //设f[i][j]是i到j之间的回文串
        boolean[][] f = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            f[i][i] = true;
        }
        if (n < 2) {
            return s;
        }
        int maxlength = 1;
        int begin = 0;
        //L 回文字符串长度
        //分别获取长度从2-n长度的字符串  分别从i开始遍历 根据当前回文串的长度算得右边界的长度
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                //确定右边界 L = j-i+1 可得 j= L+i-1
                int j = L + i - 1;
                //如果越界 那么当前L长度的回文创不存在
                if (j >= n) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    f[i][j] = false;
                } else {
                    //如果长度小于3 则只需要两个相等 必是回文串
                    if (j - i < 3) {
                        f[i][j] = true;
                    } else {
                        //从小串向大串转移
                        f[i][j] = f[i + 1][j - 1];
                    }
                }

                if (f[i][j] && j - i + 1 > maxlength) {
                    maxlength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlength);
    }

    /**
     * 暴力枚举
     *
     * @param s
     * @return
     */
    public static String Palindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        for (int L = n; L > 1; L--) {
            loop:
            for (int i = 0; i < n; i++) {
                int j = L + i - 1;
                if (j >= n) {
                    break loop;
                }
                if (isPalindrome(s.substring(i, j + 1))) {
                    return s.substring(i, j + 1);
                }
            }
        }
        return s.substring(0, 1);
    }

    public static void main(String[] args) {
        System.out.println(Palindrome("bb"));
    }

    private static boolean isPalindrome(String input) {
        int begin = 0, end = input.length() - 1;
        char[] chars = input.toCharArray();

        while (begin < end) {
            if (chars[begin] == chars[end]) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
