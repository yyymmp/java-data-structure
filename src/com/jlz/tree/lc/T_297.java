package com.jlz.tree.lc;

import java.util.LinkedList;

/**
 * @author clearlove
 * @ClassName T_297.java
 * @Description 二叉树的序列化与反序列化
 * @createTime 2021年03月25日 22:50:00
 */
public class T_297 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        travse(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : split) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes == null) {
            return null;
        }
        //拿出第一个节点
        String s = nodes.removeFirst();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

    public void travse(TreeNode treeNode, StringBuilder stringBuilder) {
        if (treeNode == null) {
            stringBuilder.append("#").append(",");
            return;
        }
        //前序遍历位置
        stringBuilder.append(treeNode.val).append(",");
        travse(treeNode.left, stringBuilder);
        travse(treeNode.right, stringBuilder);
    }
}
