package com.jlz.sort.exchange;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName Bubble.java
 * @Description
 * @createTime 2021年03月14日 13:14:00
 */
public class Bubble {

    public static void main(String[] args) {
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] arr = new int[]{
            10, 6, 90, 8, 7, 1
    };

    //冒泡排序 属于交换排序 将第一个分别与后面的每一个作比较,若大于,则交换位置,否则继续往后比较 一轮下来,就会得到一个最大值
    public static void bubbleSort(int[] arr) {
        //控制比较轮数
        for (int i = 0; i < arr.length - 1; i++) {
            //比较一轮
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果是小于 则交换位置 说明是倒叙
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

}
