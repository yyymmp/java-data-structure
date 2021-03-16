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
}
