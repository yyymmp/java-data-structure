package com.jlz.tree.lc;

/**
 * @author clearlove
 * @ClassName T_230.java
 * @Description 二叉搜索树中第K小的元素
 * @createTime 2021年03月23日 21:30:00
 */
public class T_230 {

    //遍历位置
    int rant;

    int ans;

    public void kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallest(root.left, k);
        rant++;
        //中序遍历
        if (rant == k) {
            //找到第k小的元素
            ans = root.val;
            return;
        }
        kthSmallest(root.right, k);
    }
}
