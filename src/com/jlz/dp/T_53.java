package com.jlz.dp;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author clearlove
 * @ClassName T_53.java
 * @Description 最长子序列
 * @createTime 2021年07月17日 15:35:00
 */
public class T_53 {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(arr);
    }

    public static int maxSubArray(int[] nums) {
        //设fx 等于第i个数结尾的 最长 子序列和
        int[] f = new int[nums.length];
        //初始条件  则第零个数结尾的最长子序就是自己
        int result = f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //考虑 nums[i] 单独成为一段还是加入 f(i-1)f(i−1) 对应的那一段 就是根据这个判断
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            //记录最大值
            result = Math.max(result, f[i]);
        }

        return result;
    }
}
