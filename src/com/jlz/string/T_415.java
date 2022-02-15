package com.jlz.string;

import java.util.List;

/**
 * @author jlz
 * @date 2022年02月15日 16:58
 */
public class T_415 {

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        //一层循环 两个变量 使用while
        while (i >= 0 || j >= 0 || add > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int total = x + y + add;

            add = total / 10;
            sb.append(total % 10);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
    }

}
