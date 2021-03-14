package com.jlz.sort.exchange;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName Quick.java
 * @Description 快速排序
 * @createTime 2021年03月14日 20:24:00
 */
public class Quick {

    /**
     * 快读排序的思想: 分别用两个指针指向一个头和尾 使用一个中间数,一般使用第一个数组元素 当大于元素大于第一个 元素放在右边  小于标准值时 放在左边
     */

    /**
     * @Description:
     * @Param: [arr, start, end] start: 从哪里开始 end: 从哪里结束
     * @Return: void
     * @Author: clearLove
     * @Date: 2021/3/14 21:08
     */
    public static void quick(int[] arr, int start, int end) {
        if (start < end) {
            int stand = arr[start];
            //坐标
            int low = start;
            int high = end;
            //循环查找比标准数大的数与比标准数小的数
            while (low < high) {
                //右边数数字比标准数大 直接移动下标前移
                while (low < high && stand <= arr[high]) {
                    //高指针
                    high--;
                }
                //右边数数字比标准数小 使用右边数字替换左边 并并左边下标右移
                arr[low] = arr[high];

                //左边数字 小于标准数  则左边指针不断右移
                while (low < high && stand >= arr[low]) {
                    low++;
                }
                //当指定到此时,说明出现了左边数字大于标准数 需要替换
                arr[high] = arr[low];
            }
            //最后 将基准数插入两指针重合处
            arr[low] = stand;
            //一次循环结束 可以得到第一个基准数 左边都是小的 右边都是大的

            //处理小数字
            quick(arr, start, low);
            //处理大数字
            quick(arr, low + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                5, 4, 6, 1, 8, 9, 2
        };
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
