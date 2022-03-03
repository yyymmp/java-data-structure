package com.jlz.digui;

/**
 * @author jlz
 * @date 2022年03月03日 17:27
 */
public class T_258 {

    public static int addDigits(int num) {
        //base case
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num =  num / 10;
        }
        sum += num;
        return addDigits(sum);
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
