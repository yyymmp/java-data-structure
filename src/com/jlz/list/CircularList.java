package com.jlz.list;

/**
 * @author clearlove
 * @ClassName CircularList.java
 * @Description 循环列表
 * @createTime 2021年03月13日 21:26:00
 */
public class CircularList {

    public static void main(String[] args) {
        Node2 node2 = new Node2(1);
        Node2 node3 = new Node2(2);
        Node2 node4 = new Node2(4);
        node2.append(node3);
        System.out.println(node2.next.getData());
        System.out.println(node3.next.getData());
        node2.append(node4);
        System.out.println(node2.next.getData());
    }

}

class Node2 {

    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        //指向自己
        this.next = this;
    }

    public void append(Node2 node2) {
        Node2 next = this.next;
        this.next = node2;
        node2.next = this;
    }

    public int getData() {
        return data;
    }
}
