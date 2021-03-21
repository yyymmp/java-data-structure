package com.jlz.tree.lc;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName T_654.java
 * @Description
 * @createTime 2021年03月20日 22:58:00
 */
public class T_654 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        solution3.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }
}

class Solution3 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return builde(nums, 0, nums.length - 1);
    }

    /**
     * @Description:
     * @Param: [nums, l, h] 数组 及其数组索引
     * @Return: com.jlz.tree.lc.TreeNode
     * @Author: clearLove
     * @Date: 2021/3/20 23:24
     */
    public TreeNode builde(int[] nums, int l, int h) {
        if (l > h) {
            return null;
        }
        //找到最大值 及其所在的索引
        int index = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = l; i <= h; i++) {
            if (maxValue < nums[i]) {
                index = i;
                maxValue = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxValue);
        //继续构建
        root.left = builde(nums, l, index - 1);
        root.right = builde(nums, index + 1, h);
        return root;
    }
}
