import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author jlz
 * @className: T_1641
 * @date 2021/5/6 9:41
 * @description todo
 **/
public class T_1641 {
    /**
     * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
     *
     * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
     */

    public static void main(String[] args) {
        System.out.println((new T_1641()).countVowelStrings(33));
    }

    Character[] characters = new Character[]{
            'a', 'e', 'i', 'o', 'u'
    };
    int res=0;
    public int countVowelStrings(int n) {
        //这里回溯在递归中需要撤回，所以可以使用一些数据结构，直接使用字符串在后期处理会比较麻烦
        Stack<Character> chatStack = new Stack<>();
        backtrack(n,chatStack);
        return res;
    }


    private void backtrack(int n,  Stack<Character> track) {
        if (track.size() >= n){
            res++;
            return;
        }

        for (int i1 = 0; i1 < 5; i1++) {
            if (track.size() > 0 && track.peek() > characters[i1]) {
                continue;
            }
            track.push(characters[i1]);
            backtrack(n,track);
            track.pop();
        }
    }
}
