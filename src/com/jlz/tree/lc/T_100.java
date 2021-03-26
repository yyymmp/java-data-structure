package com.saimo.java11;

/**
 * @author jlz
 * @className: T_100
 * @date 2021/3/26 15:21
 * @description 相同的树
 **/
public class T_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //二者必须同时为null 或者不为null
        if ((p == null && q != null) || (p != null && q == null)){
            return false;
        }
        if (p == null && q == null){
            return true;
        }
        //比较值
        if (p.val != q.val){
            return false;
        }

        //左子树与右子树递归
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
