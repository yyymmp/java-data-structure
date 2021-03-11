package com.jlz.queue;

/**
 * @author clearlove
 * @ClassName MyQueue.java
 * @Description
 * @createTime 2021年03月11日 22:16:00
 */
public class MyQueue {

    int[] element;

    public MyQueue() {
        element = new int[0];
    }

    //入队在最后加一条数据
    public void add(int value) {
        int[] ints = new int[element.length + 1];
        for (int i = 0; i < element.length; i++) {
            ints[i] = element[i];
        }
        ints[ints.length - 1] = value;
        element = ints;
    }

    //出队
    public int get() throws Exception {
        if (element.length == 0) {
            throw new Exception("空队队列");
        }
        int i = element[0];
        int[] ints = new int[element.length - 1];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = element[j + 1];
        }
        element = ints;
        return i;
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println(myQueue.get());
        System.out.println(myQueue.get());
        System.out.println(myQueue.get());
    }
}
