package com.jlz.array.lc;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName T_283.java
 * @Description 移动零
 * @createTime 2021年04月07日 22:37:00
 */
public class T_283 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //什么都不用管 先记录不是0的元素
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //最后 把所有的零加上
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
