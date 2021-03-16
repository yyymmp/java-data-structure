package com.jlz.tree;

/**
 * @author clearlove
 * @ClassName TreeNode.java
 * @Description 节点类
 * @createTime 2021年03月16日 22:05:00
 */
public class TreeNode {


    //节点的权 即节点的值
    int value;

    //左儿子
    TreeNode leftNode;

    //右儿子
    TreeNode rightNode;

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    /**
     * 前序遍历  该方法需要写在node节点中
     */
    public void frontShow() {
        //根节点
        System.out.println(value);
        //左节点
        if (leftNode != null) {
            leftNode.frontShow();
        }
        //右节点
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    //中序遍历
    public void midShow() {
        if (leftNode != null) {
            leftNode.midShow();
        }
        System.out.println(value);
        if (leftNode != null) {
            rightNode.midShow();
        }
    }

    //查找节点
    public TreeNode findFrondSearch(int i) {
        TreeNode target = null;
        if (i == value) {
            //直接返回当前节点
            return this;
        }
        if (leftNode != null) {
            target = leftNode.findFrondSearch(i);
            if (target == null) {
                target = rightNode.findFrondSearch(i);
            }
        }
        return target;
    }

    //删除子点
    public void deleteChildrenTree(int i) {
        //删除时需要找到父节点 将父节点的指针设为null
        TreeNode parent = this;
        if (leftNode.getValue() == i) {
            parent.setLeftNode(null);
            return;
        }
        if (rightNode.getValue() == i) {
            parent.setRightNode(null);
            return;
        }
        //如果没找到 则递归查找
        parent = this.leftNode;
        parent.deleteChildrenTree(i);
        parent = this.rightNode;
        parent.deleteChildrenTree(i);
    }
}
