package com.jlz.string;

/**
 * @author clearlove
 * @ClassName T_917.java
 * @Description
 * @createTime 2021年08月22日 23:53:00
 */
public class T_917 {

    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (Character.isLetter(chars[i]) && Character.isLetter(chars[j])) {
                //交换位置
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
                i++;
                j--;
                continue;
            }
            if (!Character.isLetter(chars[i])) {
                i++;
                continue;
            }
            if (!Character.isLetter(chars[j])) {
                j--;
            }

        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
    }
}
