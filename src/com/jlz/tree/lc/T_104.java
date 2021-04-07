package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_104.java
 * @Description 二叉树的最大深度
 * @createTime 2021年03月27日 23:21:00
 */
public class T_104 {

    int ans;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return ans;
        }
        if (root.left != null) {
            ans++;
        }
        return ans;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return true;
    }
}
