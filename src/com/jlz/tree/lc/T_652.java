package com.jlz.tree.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author clearlove
 * @ClassName T_652.java
 * @Description 寻找重复的子树
 * @createTime 2021年03月21日 20:55:00
 */
public class T_652 {

    //key 保存序列化的树
    HashMap<String, Integer> container = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        collect(root);
        return ans;

    }

    //后序遍历
    public String collect(TreeNode treeNode) {
        if (treeNode == null) {
            return "#";
        }
        //序列化
        String left = collect(treeNode.left);
        String right = collect(treeNode.right);
        String s = left + "," + right + "," + treeNode.val;
        Integer count = container.getOrDefault(s, 0);
        //如果有人与我重复 加入结果集
        if (count == 1) {
            //加入list
            ans.add(treeNode);
        }
        //出现次数+1  如果超过多次出现 则只加入一次
        container.put(s, count + 1);
        return s;
    }
}


