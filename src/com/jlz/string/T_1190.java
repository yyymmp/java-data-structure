package com.jlz.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author clearlove
 * @ClassName T_1190.java
 * @Description
 * @createTime 2021年08月24日 22:40:00
 */
public class T_1190 {

    public String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                //如果是左括号 将之前的字符串先存起来 将桑乾字符串归零以求得内层字符串
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                //如果是右括号 则反转当前内层
                sb.reverse();
                //并将从栈中弹出一个
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
