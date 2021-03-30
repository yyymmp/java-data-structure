package com.jlz.tree.lc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author clearlove
 * @ClassName T_111.java
 * @Description 二叉树的最小深度
 * @createTime 2021年03月30日 23:45:00
 */
public class T_111 {

    //广度优先
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                //取出
                TreeNode poll = queue.poll();
                //判断是否是叶子节点
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                //递进深度
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }
            depth++;
        }
        return depth;
    }
}
