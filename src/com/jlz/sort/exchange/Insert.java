package com.jlz.sort.exchange;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName Insert.java
 * @Description 直接插入排序
 * @createTime 2021年03月14日 22:53:00
 */
public class Insert {

    public static void main(String[] args) {
        int[] arr = new int[]{
                5, 4, 6, 1, 8, 9, 2
        };
//        insertSort2(arr);
//        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        //从第二个开始遍历
        for (int i = 1; i < arr.length; i++) {
            //如果当前数字比前一个数字小
            if (arr[i] < arr[i - 1]) {
                //保存这个数 插入到前面的有序
                int tmp = arr[i];
                //遍历当前数字前面的数字 为当前i索引的值找到合适位置
                //只要tmp小于该数字 则需要后移
                int j;
                for (j = i - 1; j >= 0 && tmp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                //外层循环的当前元素  赋值给不满足条件的第一个 即插入到有序
                arr[j + 1] = tmp;
            }
        }
    }


    public static void insertSort2(int[] arr) {
        //从第二个开始遍历
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //内存循环 只排一边
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //则交换
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
    /**
     * 总接: 遍历时,将前面全部排好序 再往后遍历一位时,如果出现违反规则,那么交换位置,将这个移动到合适的地方
     */
}
