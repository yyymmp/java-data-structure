package com.jlz.list.lc;

/**
 * @author clearlove
 * @ClassName T_237.java
 * @Description 删除链表中的节点
 * @createTime 2021年04月01日 21:00:00
 */
public class T_237 {

    //这里只给了一个节点   如何删除
    //其实删除的不是自己 只是将别人的值赋值给自己 然后将别人删除 等于变相删除了自己
    public void deleteNode(ListNode node) {
        node.val = node.next.val;  //将自己伪装倒霉蛋
        node.next = node.next.next; //删除倒霉蛋
    }
}
