package com.jlz.sort.exchange;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName SelectSort.java
 * @Description 选择排序
 * @createTime 2021年07月04日 14:13:00
 */
public class SelectSort {

    public static void main(String[] args) {
        /**
         * 每一轮选一个最小的与未排序第一个比较,得出最小的放在第一位
         */
        int[] arr = new int[]{1, 54, 24, 6456, 78, 32, 900};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //默认最小值是未排序的第一位
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //当前轮次的最小值与第一位替换
            int tmp;
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}
