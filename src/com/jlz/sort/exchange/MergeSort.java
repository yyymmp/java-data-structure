package com.jlz.sort.exchange;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName MergeSort.java
 * @Description 归并排序
 * @createTime 2021年07月05日 11:11:00
 */
public class MergeSort {

    /**
     * 归并排序:将数组先进行分割,分割到最小单元 即一个 是有序的,再进行合并
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 7, 2};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int low, int hi) {
        //base case
        if (low == hi) {
            return;
        }
        int mid = (low + hi) / 2;
        //对左边进行排序
        sort(arr, low, mid);
        //对右边进行排序
        sort(arr, mid + 1, hi);
        //合并左边与右边
        merge(arr, low, mid + 1, hi);
    }

    public static void merge(int[] arr, int low, int mid, int hi) {
        //两个小数组的大小
        int leftSize = mid - low;
        int rightSize = hi - mid + 1;
        //填充两个数组
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];
        for (int i = low; i < mid; i++) {
            //下标依次是 i-low
            leftArr[i - low] = arr[i];
        }
        for (int i = mid; i <= hi; i++) {
            rightArr[i - mid] = arr[i];
        }
        //合并原来的数组
        int i = 0;
        int j = 0;
        int k = low;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;

            } else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }
        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightArr.length) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
