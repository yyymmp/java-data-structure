package com.jlz.tree.lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author clearlove
 * @ClassName T_671.java
 * @Description
 * @createTime 2021年07月27日 21:38:00
 */
public class T_671 {

    //#############解法一
    Set<Integer> treeSet = new TreeSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        if (treeSet.size() == 1) {
            return -1;
        }
        Iterator<Integer> iterator = treeSet.iterator();
        ArrayList<Integer> list = new ArrayList<>(treeSet);
        if (list.size() > 1) {
            return list.get(1);
        }
        return -1;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        treeSet.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    //############解法二
    //取最大值
    long ans = Long.MAX_VALUE;

    public int findSecondMinimumValue2(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int minval = root.val;
        dfs(root, minval);
        if (ans == Long.MAX_VALUE) {
            return -1;
        }
        return (int) ans;
    }

    private void dfs(TreeNode root, int minval) {
        if (root == null) {
            return;
        }
        //遍历过程中 如果当前值大于根节点 并且当前值小于已更新后的ans 则更新ans
        //当第一遍遍历时 必然
        if (root.val > minval && root.val < ans) {
            ans = root.val;
        }
        dfs(root.left, minval);
        dfs(root.right, minval);
    }
}
