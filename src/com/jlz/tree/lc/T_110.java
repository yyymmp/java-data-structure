package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_110.java
 * @Description 平衡二叉树
 * @createTime 2021年03月28日 11:15:00
 */
public class T_110 {

    /**
     * 一棵二叉树是平衡二叉树，当且仅当其所有子树也都是平衡二叉树， 因此可以使用递归的方式判断二叉树是不是平衡二叉树，
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //统计树的高度
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //返回左子树和右子树的最大高度+1
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
