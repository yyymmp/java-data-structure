package com.jlz.list;

/**
 * @author clearlove
 * @ClassName DoubleNode.java
 * @Description 双向循环列表
 * @createTime 2021年03月13日 21:38:00
 */
public class DoubleNode {

    DoubleNode pre = this;
    DoubleNode next = this;
    int data;

    public DoubleNode(int data) {
        this.data = data;
    }

    //往当前节点追加下一个节点
    public void append(DoubleNode doubleNode) {
        //保存原来的下一个节点
        DoubleNode next = this.next;
        //新节点作为当前节点的下一个节点
        this.next = doubleNode;
        //当前节点指向后一个节点
        doubleNode.pre = this;
        //追加的节点的节后点需要指向当前节点的后节点
        doubleNode.next = next;
        next.pre = doubleNode;
    }

    //移除当前节点的下一个节点
    public void removeAfter() {
        //保存原来的下一个节点
        DoubleNode next = this.next.next;
        this.next = next;
        next.pre = next;

    }

    public static void main(String[] args) {
        DoubleNode doubleNode = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        doubleNode.append(doubleNode2);
        doubleNode.append(doubleNode3);
        //1 -> 3 -> 2
        //n1的数据
        System.out.println(doubleNode.data);
        //n1的下一个的上一个 即自己
        System.out.println(doubleNode.next.pre.data);
        System.out.println(doubleNode.next.next.pre.data);
        //n3的上一个节点
        System.out.println(doubleNode3.pre.data);
        doubleNode.removeAfter();
        doubleNode.removeAfter();
        System.out.println(doubleNode.next.data);
    }
}
