package com.jlz.digui;

import java.util.concurrent.TimeUnit;

/**
 * @author clearlove
 * @ClassName Hanoi.java
 * @Description 汉诺塔问题
 * @createTime 2021年03月14日 11:52:00
 */
public class Hanoi {

    public static void main(String[] args) {
        han(3, 'A', 'B', 'C');
    }

    /**
     * @Description:
     * @Param: [n, from, in, to] 多少个盘子
     * @Return: void
     * @Author: clearLove
     * @Date: 2021/3/14 12:10
     */
    public static void han(int n, char from, char in, char to) {
        //不管有多少个盘子 总的来说只有两种情况
        if (n == 1) {
            System.out.println("将第一个盘子从" + from + "移到" + to);
        } else {
            //多个盘子分为将上面的所有盘子从借助c移到b
            han(n - 1, from, to, in);
            //将最下面的移动c
            System.out.println("将第" + n + "个盘子从" + from + "移到" + to);
            //再将b上面的借助A移到C
            han(n - 1, in, from, to);
        }

        /** 总结: 不管有多少个盘子  可以全部基于两个盘子来看
         *  如果是一个盘子,那么直接将从A移动到C
         *  如果是两个盘子,则需要将上面的一个盘组从A先移动到B 再将剩下的最有一个从A移动到C,再将B上面的盘子借助A移动到C
         */
    }
}
