package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_106.java
 * @Description 根据中序和后序还原二叉树
 * @createTime 2021年03月22日 22:16:00
 */
public class T_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
            int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        //根据后序找到跟根节点的值
        int rootVal = postorder[postEnd];
        //找到根节点在中序的位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        root.left = buildTree(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
