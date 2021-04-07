package com.jlz.list.lc;

/**
 * @author clearlove
 * @ClassName T_offer24.java
 * @Description 反转链表
 * @createTime 2021年04月01日 23:07:00
 */
public class T_offer24 {

    public ListNode reverseList(ListNode head) {
        //双指针迭代
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //将节点暂存
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
