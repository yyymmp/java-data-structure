package com.jlz.string;

import static java.lang.Math.min;
import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @author jlz
 * @className: T_165
 * @date 2021/7/14 18:06
 * @description todo
 **/
public class T_165 {
    public static void main(String[] args) {
        String version1 = "1.0.1"; String version2 = "1";
        System.out.println(compareVersion(version1, version2));
    }
    public static int compareVersion(String version1, String version2) {
        //以点为分割点 按块比较
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length;
        int n2 = v2.length;
        int i1;int i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            //块不够位数 补零进行比较
            i1 = i<n1?Integer.parseInt(v1[i]):0;
            i2 = i<n2?Integer.parseInt(v2[i]):0;

            if (i1 > i2){
                return 1;
            }else if (i1 < i2){
                return -1;
            }
        }
        return 0;
    }
}
