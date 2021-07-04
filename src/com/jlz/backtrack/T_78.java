import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jlz
 * @className: T_78
 * @date 2021/5/6 11:34
 * @description todo
 **/
public class T_78 {

    public static void main(String[] args) {
        (new T_78()).subsets(new int[]{1,2,3});
    }
    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            System.out.println(tmp);
            //更新索引位置
            backtrack(j + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
