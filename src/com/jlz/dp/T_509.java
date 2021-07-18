package com.jlz.dp;

/**
 * @author clearlove
 * @ClassName T_509.java
 * @Description
 * @createTime 2021年07月18日 22:01:00
 */
public class T_509 {

    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        //初始化条件
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
