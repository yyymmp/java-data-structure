import java.util.*;

/**
 * @author jlz
 * @className: T_131
 * @date 2021/5/7 10:49
 * @description todo
 **/
public class T_131 {

    public static void main(String[] args) {
        System.out.println((new T_131()).partition("aab"));
    }
    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * 回文串 是正着读和反着读都一样的字符串。
     */
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        //字符串栈
        Deque<String> track = new ArrayDeque<>();

        backtrack(0,s.length(),s.toCharArray(),track);

        return res;
    }

   private void backtrack(int index,int length,char[] chars,  Deque<String> track) {
        if (index == length){
            res.add(new ArrayList<>(track));
            return;
        }

        //从起始位置开始遍历
        for (int i = index;i<length;i++){
            //从index 到 i 是否是回文串
            if (!checkPalindrome(chars, index, i)) {
                continue;
            }
            track.addLast(new String(chars, index, i + 1 - index));
            System.out.println(track);
            //
            backtrack(i+1,length,chars,track);
            track.removeLast();
        }
    }


    //判断是否是回文
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
