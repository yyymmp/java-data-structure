package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_98.java
 * @Description 验证二叉搜索树
 * @createTime 2021年03月24日 23:13:00
 */
public class T_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {

    }
}
