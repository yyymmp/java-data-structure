package com.saimo.java11;

/**
 * @author jlz
 * @className: T_101
 * @date 2021/3/26 15:44
 * @description 对称二叉树
 **/
public class T_101 {
    public boolean isSymmetric(TreeNode root) {

        return isSymmetric(root, root);

    }
    boolean isSymmetric(TreeNode left,TreeNode right){
        //需要判断两棵树同时为空 或同时不为空
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        //比较树1的左树和树2的右树  比较树1的右数和树2的左树
        return  left.val == right.val && isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right);
    }

}
