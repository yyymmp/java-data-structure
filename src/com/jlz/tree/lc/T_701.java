package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_701.java
 * @Description 二叉搜索树中的插入操作
 * @createTime 2021年03月24日 22:20:00
 */
public class T_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        //找到插入位置
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
