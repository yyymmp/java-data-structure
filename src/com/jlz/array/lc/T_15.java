package com.jlz.array.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 三数之和
 * 特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
 * 对数组进行排序。
 * 遍历排序后数组：
 * 若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
 * 对于重复元素：跳过，避免出现重复解
 * 令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
 * 当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
 * 若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
 * 若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
 * @author jlz
 * @date 2022年01月19日 15:19
 */
public class T_15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{
                -2,0,0,2,2
        }));
        //[[-1,-1,2],[-1,0,1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        //剪枝
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return ans;
            }
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    String key = String.valueOf(nums[i]) + String.valueOf(nums[l]) + String.valueOf(nums[r]);
                    if (!set.contains(key)){
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        set.add(key);
                    }

                    while (l < r && nums[l] == nums[l + 1]) {
                        ++l;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        --r;
                    }

                    ++l;
                    --r;


                } else {
                    //大于0 右指针左移
                    if (nums[i] + nums[l] + nums[r] > 0) {
                        --r;
                    }
                    //小于零 左指针右移
                    if (nums[i] + nums[l] + nums[r] < 0) {
                        ++l;
                    }
                }
            }

        }

        return ans;

    }
}
