package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_105.java
 * @Description 根据前序遍历和中序遍历构造二叉树
 * @createTime 2021年03月21日 22:51:00
 */
public class T_105 {

    public static void main(String[] args) {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 主要思路: 找到根节点 然后分别构建左右子树
         */
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end, int[] inorder, int inStart, int inEnd) {
        if (start > end) {
            return null;
        }
        //获取根节点
        int root = preorder[start];
        //找到中序遍历中根节点的索引位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            //没有重复元素
            if (root == inorder[i]) {
                index = i;
                break;
            }
        }
        /**
         * 如何找到两个数组中的左子树和右子树的位置
         * 中序数组中,找到index位置 即可确定
         * 前序不是很好确定,但是可以根据index来计算左子树的大小
         */
        int leftSize = index - inStart;
        TreeNode rootNode = new TreeNode(root);
        //找到前序的左节点数组和中序的左节点数组  不包含index 因为index是根节点所在索引
        rootNode.left = build(preorder, start + 1, start + leftSize, inorder, inStart, index - 1);
        rootNode.right = build(preorder, start + leftSize + 1, end, inorder, index + 1, inEnd);

        return rootNode;
    }
}
