package com.jlz.array;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName ArrayOp3.java
 * @Description 面向对象数组
 * @createTime 2021年03月10日 22:16:00
 */
public class ArrayOp3 {

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        System.out.println(myArray.size());
        //尾部追加
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        System.out.println(myArray.size());
        //删除指定元素
        myArray.del(1);
        myArray.show();
        //获取指定位置元素
        System.out.println(myArray.get(1));
        System.out.println("---------------------");
        myArray.show();
        myArray.insert(1, 2);
        myArray.show();
    }
}

class MyArray {

    private int[] element;

    public MyArray(int size) {
        element = new int[size];
    }

    public MyArray() {
        this.element = new int[0];
    }

    public void insert(int index, int value) {
        int[] ints = new int[element.length + 1];
        for (int i = 0; i < element.length; i++) {
            if (i < index) {
                ints[i] = element[i];
            } else {
                ints[i + 1] = element[i];
            }
        }
        ints[index] = value;
        this.element = ints;
    }

    public int size() {
        return element.length;
    }

    public void del(int index) {
        if (index > element.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("删除下标越界");
        }
        int[] newArr = getNewArr(index, element);

        this.element = newArr;
    }

    static int[] getNewArr(int index, int[] element) {
        int[] newArr = new int[element.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = element[i];
            } else {
                newArr[i] = element[i + 1];
            }
        }
        return newArr;
    }

    public void add(int value) {
        int[] ints = new int[element.length + 1];
        for (int i = 0; i < element.length; i++) {
            ints[i] = element[i];
        }
        ints[ints.length - 1] = value;
        //替换元素组
        this.element = ints;
    }

    public void show() {
        System.out.println(Arrays.toString(element));
    }

    public int get(int index) {
        return element[index];
    }
}
