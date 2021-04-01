package com.jlz.list.lc;

/**
 * @author clearlove
 * @ClassName T_19.java
 * @Description 删除链表的倒数第 N 个结点
 * @createTime 2021年04月01日 22:04:00
 */
public class T_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针同样是为了找到要删除节点当前节点和上一个节点
        ListNode slow = head, tar = head, fast = head.next;
        while (n > 0) {
            tar = tar.next;
            n--;
        }
        //如果此时cur等于null值，则说明要删除的是节点是第一个节点
        if(tar == null){
            return head.next;
        }
        while (tar.next != null) {
            slow = slow.next;
            fast = fast.next;
            tar = tar.next;
        }
        //找到要删除的点
        slow.next = fast.next;
        return head;
    }
}
