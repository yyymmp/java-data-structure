package com.jlz.tree;

/**
 * @author clearlove
 * @ClassName TestTree.java
 * @Description 创建一棵树
 * @createTime 2021年03月16日 22:06:00
 */
public class TestTree {

    public static void main(String[] args) {
        BinaryTree treeNode = new BinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        treeNode.setRoot(root);
        root.setLeftNode(left);
        root.setRightNode(right);
    }

}
