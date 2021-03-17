package com.jlz.tree;

/**
 * @author clearlove
 * @ClassName ArrayTree.java
 * @Description 数组存储完全二叉树
 * @createTime 2021年03月17日 22:39:00
 */
public class ArrayTree {

    int[] data;

    public ArrayTree(int[] data) {
        this.data = data;
    }

    public void fontShow2() {
        fontShow(0);
    }

    /**
     * 顺序存储结构在逻辑树中的特点
     * 任意n的左节点在数组中的索引是 2n+1
     * 任意n的右节点在数组中的索引是 2n+2
     * @param index
     */

    public void fontShow(int index) {
        System.out.println(data[index]);
        //任意节点下面的左子树 2n+1
        if (2 * index + 1 < data.length) {
            fontShow(2 * index + 1);
        }
        //任意节点下面的右子树 2n+2
        if (2 * index + 2 < data.length) {
            fontShow(2 * index + 2);
        }

    }
}
