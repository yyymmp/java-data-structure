package com.jlz.sort.exchange;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName ShellSort.java
 * @Description
 * @createTime 2021年07月04日 22:19:00
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 54, 24, 6456, 78, 32, 900};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; //间隔序列 1,4,13,40...
        }
        //每间隔多少 为一组
        //直到间隔序列为1时 排序完成
        while (h >= 1) {
            //从第h个元素开始 逐个对其所在组进行直接插入排序操作  每一个for循环 比较的是一组
            for (int i = h; i < N; i++) {
                //组内进行排序
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        int tmp;
                        tmp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = tmp;
                    }
                }
            }
            //一轮组内排序之后 间隔序列减小
            h = h / 3;
        }
    }
}
