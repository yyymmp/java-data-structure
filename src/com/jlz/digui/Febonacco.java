package com.jlz.digui;

/**
 * @author clearlove
 * @ClassName Febonacco.java
 * @Description 斐波那契数列
 * @createTime 2021年03月14日 11:02:00
 */
public class Febonacco {

    public static void main(String[] args) {
        System.out.println(getN(6));
    }

    // 1 1 2 3 5 8
    public static int getN(int n) {
        if (n == 2 || n == 1) {
            return 1;
        } else {
            //前两项之和
            return getN(n - 1) + getN(n - 2);
        }

    }
}
