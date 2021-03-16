package com.jlz.tree;

/**
 * @author clearlove
 * @ClassName BinaryTree.java
 * @Descriptione 二叉树
 * @createTime 2021年03月16日 22:08:00
 */
public class BinaryTree {

    //数的根节点
    TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    //前序遍历 根左右
    public void fontShow() {
        root.frontShow();
    }

    //中序遍历 左根右
    public void midShow() {
        root.midShow();
    }

    //前序查找
    public TreeNode findFrondSearch(int i) {
        return root.findFrondSearch(i);
    }

    //删除子树
    public void deleteChildrenTree(int i) {
        if (root.getValue() == i) {
            root = null;
        } else {
            root.deleteChildrenTree(i);
        }
    }
}
