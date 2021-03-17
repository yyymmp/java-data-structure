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
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        treeNode.setRoot(root);
        root.setLeftNode(left);
        root.setRightNode(right);
        //为第二层节点创建子节点
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        left.setLeftNode(left2);
        left.setRightNode(right2);

        TreeNode left5 = new TreeNode(6);
        TreeNode right6 = new TreeNode(7);
        right.setLeftNode(left5);
        right.setRightNode(right6);

        treeNode.fontShow();

        treeNode.deleteChildrenTree(2);
        System.out.println("++++++++++++++++++++++++++++");
        treeNode.fontShow();
//        System.out.println(treeNode.findFrondSearch(3).getValue());
        //数组顺序存储树结构
        System.out.println("+++++++++++++++++");
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        ArrayTree arrayTree = new ArrayTree(ints);
        arrayTree.fontShow2();
    }


}
