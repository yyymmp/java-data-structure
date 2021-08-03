package com.jlz.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jlz
 * @className: T_179
 * @date 2021/7/15 14:58
 * @description todo
 **/
public class T_179 {
    public static void main(String[] args) {
        int[] nums = {0,0};
        largestNumber(nums);
    }
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsToWord = new String[n];
        for(int i=0;i<n;i++){
            numsToWord[i] = String.valueOf(nums[i]);
        }
        //数组排序 可以直接使用字符串比较大小
        Arrays.sort(numsToWord,(a,b)-> (b+a).compareTo(a+b));

        System.out.println(Arrays.toString(numsToWord));
        StringBuilder res = new StringBuilder();
        if (numsToWord[0] .equals( "0")){
            return "0";
        }
        for (String s : numsToWord) {
            res.append(s);
        }
        return res.toString();

    }
}

