package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_116.java
 * @Description 填充每个节点的下一个右侧节点指针
 * @createTime 2021年03月20日 20:56:00
 */
public class T_116 {


}

class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


class Solution2 {

    public Node connect(Node root) {
        if (root != null && root.left != null) {
            connectNode(root.left, root.right);
        }
        return root;
    }

    public void connectNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectNode(node1.left, node1.right);
        connectNode(node2.left, node2.right);
        connectNode(node1.right, node2.left);
    }
}