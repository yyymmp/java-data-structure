package com.jlz.array;

/**
 * @author clearlove
 * @ClassName BinarySearch.java
 * @Description 二分查找
 * @createTime 2021年03月10日 22:50:00
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int byBinary = findByBinary(0, a.length - 1, a, 5);
        System.out.println(byBinary);
    }

    public static int findByBinary(int left, int right, int[] a, int target) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (a[mid] > target) {
            right = mid;
            return findByBinary(left, right-1, a, target);
        } else if (a[mid] < target) {
            left = mid;
            return findByBinary(left+1, right, a, target);
        } else {
            return mid;
        }
    }
}
