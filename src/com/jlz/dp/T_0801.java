package com.jlz.dp;

/**
 * @author clearlove
 * @ClassName T_0801.java
 * @Description
 * @createTime 2021年07月18日 15:12:00
 */
public class T_0801 {

    public static void main(String[] args) {
        waysToStep(3);
    }

    public static int waysToStep(int n) {
        //设f[x]到x阶阶梯的次数 则最后一部可能是1阶 2阶 3阶
        //当爬第 i 个阶梯时，有可能是从第 i - 1i−1 个阶梯爬上来的（选择只爬一层）；也有可能是从第 i - 2i−2 个阶梯爬上来的（选择爬两层）；还有可能是从第 i - 3i−3 个阶梯爬上来的（选择爬三层）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        //则 f[x] = f[x-1] +f[x-2]+f[x-3]
        int[] f = new int[n + 1];
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        //初始条件
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 4;
        for (int i = 4; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000007 + f[i - 3];
            f[i] = f[i] % 1000000007;
        }
        return f[n];
    }
}
