package com.jlz.dp;


/**
 * @author jlz
 * @className: T_416
 * @date 2021/8/16 11:06
 * @description 背包问题合集
 * 相关问题
 * 「力扣」上的 0-1 背包问题：
 * <p>
 * 「力扣」第 416 题：分割等和子集（中等）；
 * 「力扣」第 474 题：一和零（中等）；
 * 「力扣」第 494 题：目标和（中等）；
 * 「力扣」第 879 题：盈利计划（困难）；
 * 「力扣」上的 完全背包问题：
 * <p>
 * 「力扣」第 322 题：零钱兑换（中等）；
 * 「力扣」第 518 题：零钱兑换 II（中等）；
 * 「力扣」第 1449 题：数位成本和为目标值的最大数字（困难）。
 * 这里要注意鉴别：「力扣」第 377 题，不是「完全背包」问题。
 **/
public class T_416 {

    private static int count;
    /**
     * 416分割等等和子集
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        //找到相等的两部分 则只需要找到 sum(nums)/2 的数据即可分为等和子集
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if ((sum & 1) == 1) {
            //奇数直接返回
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            //这种情况不存在 如 12345  target = 5  则最大值都不能超过target
            return false;
        }
        //开数组
        //设f[i][j]从 数组的[0,i]下标范围内 选取若干个正整数（可以是0个），是否存在一种选取方案使得被选取的正整数的和等于j
        //f[i][j] = f[i-1][j] || f[i-1][j-nums[i]]
        //边界条件 初始值  如果选取的目标为0  则可以不选
        int length = nums.length;
        boolean[][] fd = new boolean[length][target + 1];

        //j=0 则全部true
        for (int i = 0; i < length; i++) {
            fd[i][0] = true;
        }
        // i=0 则只有第一位为true
        fd[0][nums[0]] = true;

        //从0-i个数里面找  找到和为target的数字
        //设f[i][j]表示为能否找到一种方案 使得i中有若干个整数的和为j
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j > nums[i]) {
                    //加入这个数  或者不加
                    fd[i][j] = fd[i - 1][j] | fd[i - 1][j - nums[i]];
                } else {
                    //如果当前的target直接小于该数 做选择: 不能加入该数
                    fd[i][j] = fd[i - 1][j];
                }
            }
        }

        return fd[length - 1][target];
    }

    /**
     * 474 10问题
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        //定义三维数组dp，其中dp[i][j][k] 表示在前i个字符串中，使用j个0和k个1的情况下最多可以得到的字符串数量。
        //假设数组str 的长度为 ll，则最终答案为[l][m][n]
        //设第i个元素的0个数 zeros  1的个数是ones
        //f[i][j][k] = f[i-1][j][k]
        int length = strs.length;
        int[][][] fd = new int[length + 1][m + 1][n + 1];
        //边界值 当i==0时, 则没有子集
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0) {
                        //边界条件
                        fd[i][j][k] = 0;
                        continue;
                    }
                    //计算第i个元素的0/1 个数
                    int[] zerosOnes = getZerosOnes(strs[i - 1]);
                    int zeros = zerosOnes[0];
                    int ones = zerosOnes[1];
                    fd[i][j][k] = fd[i - 1][j][k];
                    //如果可以加 说明
                    if (zeros <= j && ones <= k) {
                        //该串加与不加中做选择最大值
                        fd[i][j][k] = Math.max(fd[i][j][k], fd[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }

        return fd[length][m][n];

    }

    /**
     * 474辅助函数 计算二进制字符串的01个数
     *
     * @param str
     * @return
     */
    public static int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }


    /**
     * 494 目标和 回溯方式
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return count;

    }

    public static void  dfs(int[] nums, int target, int index, int sum) {
        //base case
        if (index == nums.length){
            //出现目标
            if (target == count){
                count++;
            }
        }else{
            dfs(nums,target,index+1,sum+nums[index]);
            dfs(nums,target,index+1,sum-nums[index]);
        }
    }
    /**##########################################494 end################**/

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 11, 5};
        String[] arrayStr = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(arrayStr, 5, 3));
    }
}
