package com.jlz.array;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName ArrayOp.java
 * @Description 对数组实现增加操作
 * @createTime 2021年03月08日 23:37:00
 */
public class ArrayOp {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};

        int[] b = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        b[b.length - 1] = 4;
        System.out.println(Arrays.toString(b));
    }
}
