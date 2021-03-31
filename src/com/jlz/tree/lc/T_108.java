package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_108.java
 * @Description 将有序数组转换为二叉搜索树
 * @createTime 2021年03月31日 21:40:00
 */
public class T_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        //选择中间位置作为根节点
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, start, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, end);
        return treeNode;
    }
}
