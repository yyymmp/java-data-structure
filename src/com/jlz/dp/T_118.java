package com.jlz.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jlz
 * @className: T_118
 * @date 2021/8/3 15:34
 * @description 杨辉三角
 **/
public class T_118 {
    public static List<List<Integer>> generate(int numRows) {
        //设f[i] 是第i行的数字  则f[i]
        //开list 数组
        List<List<Integer>> f = new ArrayList<>();

        //初始值
        f.add(Arrays.asList(1));


        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            //第一位
            list.add(1);
            List<Integer> arrayList = f.get(i - 1);
            for (int i1 = 0; i1 < arrayList.size() - 1; i1++) {
                list.add(arrayList.get(i1) + arrayList.get(i1 + 1));
            }
            list.add(1);
            f.add(list);
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(generate(6));
    }
}
