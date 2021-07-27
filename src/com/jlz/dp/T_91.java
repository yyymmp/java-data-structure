package com.jlz.dp;


/**
 * @author clearlove
 * @ClassName T_91.java
 * @Description
 * @createTime 2021年07月23日 00:11:00
 */
public class T_91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        //这两种情况并不是互斥的情况,而是一种组合的情况
        //如果第i-1位不为零 那么第i位可以自己组合 f[i] = f[i - 1] 使用一个字符
        //如果使用两个字符 则需要i-2位不等为零 如果为这样的话i-1 i就不能组合
        //并且这两个字符组需要在0-26之间
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] = f[i] + f[i - 2];
            }
        }
        return f[n];
    }
}
