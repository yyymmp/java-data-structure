package com.jlz.list.lc;


/**
 * 盛最多水的容器
 *
 * @author jlz
 * @date 2022年01月19日 14:37
 */
public class T_11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        if (height.length == 1) {
            return height[0];
        }
        int i = 0;
        int j = height.length - 1;
        int res = Math.min(height[i], height[j]) * (j - i);
        //移动数字小的指针
        while (i < j) {
            res = Math.max(Math.min(height[i], height[j]) * (j - i), res);

            if (height[i] > height[j]) {
                --j;
            } else {
                ++i;
            }
        }

        return res;

    }
}
