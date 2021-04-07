package com.jlz.array.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clearlove
 * @ClassName T_350.java
 * @Description 两个数组的交集
 * @createTime 2021年04月06日 23:35:00
 */
public class T_350 {

    //使用双指针 同时遍历两个数组
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0, index = 0;

        //输出数组
        int[] intersection = new int[Math.min(length1, length2)];

        //同时遍历两个数组的方法
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                //相等时 保存数据
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
