package com.jlz.sort.exchange;

import java.util.Arrays;

/**
 * @author clearlove
 * @ClassName HeapSort.java
 * @Description
 * @createTime 2021年07月05日 18:57:00
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] tree = new int[]{2, 5, 3, 1, 10, 4};
        headSort(tree, 6);
        //对第零个节点 即根节点做heapify操作
//        heapify(tree, tree.length, 0);   //构建堆  [10, 5, 3, 4, 1, 2]  即大顶堆
        //对任意数组进行构建合法堆
//        buildHeap(tree, 6);
        //根据已有堆排序  根节点与最后一个节点作交换 交换后删除最后一个节点 再次从根节点进行heapify
        System.out.println(Arrays.toString(tree));
        //

    }

    public static void headSort(int[] tree, int n) {
        buildHeap(tree, n);
        for (int i = n - 1; i >= 0; i--) {
            //交换根节点与最后一个节点
            swap(tree, i, 0);
            //交换之后 对堆进行heapify
            heapify(tree, i, 0);
        }
    }

    public static void buildHeap(int[] tree, int n) {
        //最后一个节点
        int lastNode = n - 1;
        //最后一个节点的父节点
        int p1 = (lastNode - 1) / 2;
        // 3 -> 2 -> 1 ->0  从下往上分别进行heapify操作
        for (int i = p1; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    /**
     * @param tree
     * @param n    总节点个数
     * @param i    对哪个节点进行heapify操作 即调整为正确的堆 heapify的过程是从上往下走的
     */
    public static void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }
        //找到 i的两个子节点
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        //找到最大值
        int max = i;
        if (c1 < n && tree[max] < tree[c1]) {
            max = c1;
        }
        if (c2 < n && tree[max] < tree[c2]) {
            max = c2;
        }

        //找到最大值后  与i做交换 因为要把最大值换到根节点
        if (i != max) {
            swap(tree, max, i);
            //heapify的过程是自顶向下  与谁做了交换 则对该子树进行heapify操作  对第max个继续heapify
            heapify(tree, n, max);
        }
    }

    private static void swap(int[] tree, int max, int i) {
        int tmp;
        tmp = tree[max];
        tree[max] = tree[i];
        tree[i] = tmp;
    }
}
