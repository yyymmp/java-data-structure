package com.jlz.backtrack;

import com.jlz.list.LinkList;
import com.jlz.list.lc.ListNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author clearlove
 * @ClassName T_46.java
 * @Description 回溯问题之全排列问题
 * @createTime 2021年04月11日 15:43:00
 */
public class T_46 {

    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        //存储路径
        LinkedList track = new LinkedList();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            //说明已经遍历到了子节点 将路径保存
            //tip: 因为track是引用 所以需要重新new对象
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //将数组的每一个元素都作为顶点进行遍历
            if (track.contains(nums[i])) {
                //如果路径中含有这个 则进入跳过当前遍历
                continue;
            }
            //添加到路径
            track.add(nums[i]);
            //进入下一层
            backtrack(nums, track);
            //从track撤销
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        (new T_46()).permute(nums);
    }
}
