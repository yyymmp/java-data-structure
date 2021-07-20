package com.jlz.dp;

/**
 * @author clearlove
 * @ClassName T_55.java
 * @Description
 * @createTime 2021年07月20日 22:32:00
 */
public class T_55 {

    public boolean canJump(int[] nums) {
        //设f[i]代表能否跳到第i个位置
        boolean[] f = new boolean[nums.length + 1];

        f[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //能够到第i个位置
                if (f[j] && nums[j] + j >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[nums.length - 1];
    }
}
