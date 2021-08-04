package com.jlz.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jlz
 * @className: T_119
 * @date 2021/8/4 14:09
 * @description 杨辉三角2
 **/
public class T_119 {

    public static List<Integer> getRow(int rowIndex) {
        //设f[i] 是第i行的数字  则f[i]
        List<Integer> f = Arrays.asList(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new LinkedList<>();
            //第一位
            list.add(1);
            for (int i1 = 0; i1 < f.size() - 1; i1++) {
                list.add(f.get(i1) + f.get(i1 + 1));
            }
            list.add(1);
            f = list;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
