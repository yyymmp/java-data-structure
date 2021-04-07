package com.jlz.list.lc;

/**
 * @author clearlove
 * @ClassName T_141.java
 * @Description 环形链表
 * @createTime 2021年04月05日 23:41:00
 */
public class T_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        //使用快慢指针 若环形 则快慢指针必会相遇
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
