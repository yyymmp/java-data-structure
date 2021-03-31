package com.jlz.list.lc;

/**
 * @author clearlove
 * @ClassName T_offer18.java
 * @Description 删除链表的节点
 * @createTime 2021年03月31日 22:32:00
 */
public class T_offer18 {

    //双指针
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head.next, pre = head;
        while (cur != null && cur.val != val) {
            cur = cur.next;
            pre = pre.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
