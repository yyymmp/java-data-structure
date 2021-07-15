package com.jlz.string;

/**
 * @author jlz
 * @className: T_58
 * @date 2021/7/14 17:34
 * @description todo
 **/
public class T_58 {
    //todo 不应该使用split 可以从后往前遍历 直到遇到第一个空格
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if (arr.length>0){
            return arr[arr.length-1].length();
        }
        return 0;
    }
}
