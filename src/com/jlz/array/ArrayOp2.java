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
        int[] newArr = MyArray.getNewArr(delIndex, a);

        System.out.println(Arrays.toString(newArr));

    }
}
