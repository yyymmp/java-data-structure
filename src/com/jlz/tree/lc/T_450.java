package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_450.java
 * @Description 删除二叉搜索树中的节点
 * @createTime 2021年03月24日 21:39:00
 */
public class T_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        //框架
        if (root.val == key) {
            //找到数字 如何删除
            //情况1 该节点是叶子节点 则直接删除
            if (root.left == null && root.right == null) {
                return null;
            }
            //情况2: 只有一个非空子节点，那么它要让这个孩子接替自己的位置
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //情况2: 两个节点的父节点 选择 右子树中最小的那个节点来接替自己
            // 找到右子树的最小节点
            TreeNode minNode = getMin(root.right);
            // 把 root 改成 minNode
            root.val = minNode.val;
            // 转而去删除 minNode
            root.right = deleteNode(root.right, minNode.val);

        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
