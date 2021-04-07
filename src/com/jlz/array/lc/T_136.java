package com.jlz.array.lc;

/**
 * @author clearlove
 * @ClassName T_136.java
 * @Description 只出现一次的数字
 * @createTime 2021年04月06日 23:28:00
 */
public class T_136 {

    /**
     * 相同数字进行异或运算时 总是为零 所以将所有元素进行异或时,则必然得出只出现这一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
