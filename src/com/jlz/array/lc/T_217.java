package com.jlz.array.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author clearlove
 * @ClassName T_217.java
 * @Description 存在重复元素
 * @createTime 2021年04月06日 23:17:00
 */
public class T_217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
