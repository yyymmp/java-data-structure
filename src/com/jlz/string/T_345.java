package com.jlz.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jlz
 * @className: T_345
 * @date 2021/8/19 17:45
 * @description todo
 **/
public class T_345 {

    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList(  'a','e','i','o','u','A','E','I','O','U'));
        int i = 0;
        int j = s.length()-1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (set.contains(chars[i]) && set.contains(chars[j]) && chars[j]- chars[i] != 0){
                //交换
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
                i++;
                j--;
                continue;
            }
            if (!set.contains(chars[i])){
                i++;
            }else if (!set.contains(chars[j])){
                j--;
            }else{
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }
}
