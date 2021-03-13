package com.jlz.list;

/**
 * @author clearlove
 * @ClassName LinkList.java
 * @Description
 * @createTime 2021年03月11日 23:36:00
 */
public class LinkList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.append(new Node(2)).append(new Node(3)).append(new Node(4));
        node.show();
        node.delNode();
        node.show();
        node.insertAfter(new Node(8));
        node.show();
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    //追加节点 可无线追加
    public Node append(Node node) {
        //当前节点
        Node cur = this;
        //如果当前节点的指针不为null
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        return this;
    }

    public void show() {
        Node cur = this;
        while (cur != null) {
            System.out.print(cur.data + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    //获取下一个节点
    public Node getNext() {
        return this.next;
    }

    //获取节点数据
    public int getData() {
        return this.data;
    }

    //当前节点是否最后
    public boolean isLast() {
        return this.next == null;
    }

    //删除下一节点
    public void delNode() {
        //保存下下一个节点
        Node next = this.next.next;
        this.next = next;
    }

    //插入下一节点
    public void insertAfter(Node node) {
        //取出下一个节点
        Node next = this.next;
        this.next = node;
        node.next = next;
    }
}
