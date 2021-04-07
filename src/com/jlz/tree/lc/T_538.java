package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_538.java
 * @Description 把二叉搜索树转换为累加树
 * @createTime 2021年03月23日 21:56:00
 */
public class T_538 {


    int sum;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum = root.val + sum;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


}
