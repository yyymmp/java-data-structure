package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_114.java
 * @Description 二叉树展开为列表
 * @createTime 2021年03月21日 14:29:00
 */
public class T_114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //不管如何实现 将递归定义当作定义好的功能
        flatten(root.left);
        flatten(root.right);

        //每一次实现
        //保存右节点
        TreeNode tmp = root.right;

        //将左边拉直的节点赋值到 右边
        root.right = root.left;

        //将左边置为null
        root.left = null;

        //将之前暂存下来的右节点接上去 怎么接上去 找到当前右子树的最下面一个节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        //找到 赋值
        p.right = tmp;

    }
}
