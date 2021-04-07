package com.jlz.array.lc;

/**
 * @author clearlove
 * @ClassName T_189.java
 * @Description 旋转数组
 * @createTime 2021年04月06日 23:07:00
 */
public class T_189 {

    public void rotate(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        //利用数学计算
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, nums.length);
    }
}
