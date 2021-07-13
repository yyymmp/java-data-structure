package com.jlz.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author clearlove
 * @ClassName T_6.java
 * @Description 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： P   A   H   N A P L S I I G Y   I   R
 * <p>
 * @createTime 2021年07月12日 21:13:00
 */
public class T_6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";int numRows = 4;
        System.out.println(convert(s, numRows));

    }

    public static String convert(String s, int numRows) {
        //按行读取 ,每一行作为一个list
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringBuilders.add(new StringBuilder());
        }
        //偏移
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            stringBuilders.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        return stringBuilders.stream().collect(Collectors.joining());


    }
}
