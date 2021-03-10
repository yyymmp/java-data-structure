package com.jlz.array;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName ArrayOp.java
 * @Description 对数组实现删除
 * @createTime 2021年03月08日 23:37:00
 */
public class ArrayOp2 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        //要删除的下表
        int delIndex = 2;
        int[] newArr = new int[a.length - 1];

        for (int i = 0; i < newArr.length; i++) {
            if (i < delIndex) {
                //在删除下标之前的
                newArr[i] = a[i];
            } else {
                newArr[i] = a[i + 1];
            }
        }

        System.out.println(Arrays.toString(newArr));

    }
}
