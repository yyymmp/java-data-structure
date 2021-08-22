package com.jlz.string;

/**
 * @author clearlove
 * @ClassName T_344.java
 * @Description
 * @createTime 2021年08月22日 23:47:00
 */
public class T_344 {

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            //交换位置
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] s = new char[]{
                'h', 'e', 'l', 'l', 'o'
        };

        reverseString(s);
    }
}
