package com.jlz.list.lc;

import java.util.Stack;

/**
 * @author clearlove
 * @ClassName T_234.java
 * @Description 回文链表 使用栈结构进行存储 再出栈与链表遍历比较
 * @createTime 2021年04月05日 23:34:00
 */
public class T_234 {

    public boolean isPalindrome(ListNode head) {
        //使用栈结构
        ListNode tmp = head;
        Stack<Integer> listNodeStack = new Stack<>();
        //压栈
        while (tmp != null) {
            listNodeStack.push(tmp.val);
            tmp = tmp.next;
        }
        //出栈  即从尾部遍历  此时可与链表遍历比较比较
        while (head != null) {
            if (head.val != listNodeStack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
