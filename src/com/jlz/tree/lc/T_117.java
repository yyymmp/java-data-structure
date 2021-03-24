package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_117.java
 * @Description 二叉搜索树中的搜索
 * @createTime 2021年03月24日 22:44:00
 */
public class T_117 {


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
