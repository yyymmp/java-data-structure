package com.jlz.stack;

/**
 * @author clearlove
 * @ClassName MyStack.java
 * @Description
 * @createTime 2021年03月11日 21:53:00
 */
public class MyStack {

    int[] element;

    public MyStack() {
        this.element = new int[0];
    }

    //压入
    public void push(int value) {
        int[] ints = new int[element.length + 1];
        for (int i = 0; i < element.length; i++) {
            ints[i] = element[i];
        }
        ints[ints.length - 1] = value;
        //替换元素组
        this.element = ints;
    }

    //取出
    public int pop() throws Exception {
        if (element.length == 0) {
            throw new Exception("栈已空");
        }
        int[] ints = new int[element.length - 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = element[i];
        }
        int value = element[element.length - 1];
        this.element = ints;
        return value;
    }

    //查看栈顶
    public int peek() throws Exception {
        if (element.length == 0) {
            throw new Exception("栈已空");
        }
        return this.element[element.length - 1];
    }

    public boolean isEmpty() {
        return element.length == 0;
    }

    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.pop();
    }
}
