package com.jlz.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author clearlove
 * @ClassName T_96.java
 * @Description
 * @createTime 2021年07月24日 19:00:00
 */
public class T_96 {
    //分析
    //G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
    //设f[i]是以i为根节点构成的不同二叉树的个数 左子树0-i 右子树 i+1 - n
    //分别以不用的i作为根节点所构成的不同二叉树的个数之和  不同的二叉搜索树的总数 G(n)，是对遍历所有 ii (1 \le i \le n)(1≤i≤n) 的 F(i, n)F(i,n) 之和。
    //可得: G(n) = f(1)+f(2)+f(3)+f(4)+...+f(n)
    //当以i为根节点时 左边能构成二叉搜索树的个数*右边 左子树*右子树
    //f(i)=G(i−1)∗G(n−i)  卡特兰数 公式
    //综合两个公式可以得到 卡特兰数 公式
    //G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)

//    public static int numTrees(int n) {
//        int[] f = new int[n + 1];
//        //初始条件
//        f[0] = 0;
//        f[1] = 1;
//        //求g(n)
//        for (int i = 2; i < n; i++) {
//            //分别1-i之间 作为根节点时
//            for (int j = 1; j < i + 1; j++) {
//                //左边*右边
//                f[i] += f[j - 1] * f[i - j];
//            }
//        }
//        return f[n];
//    }

    //使用递归的方
    static Map<Integer, Integer> map = new HashMap<>();
    static int res = 0;

    public static int numTreesRec(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            //左边结点个数 i-1
            //先从缓存种获取
            Integer left = map.get(i - 1);
            if (left == null) {
                //如果没有缓存 则调用方法计算
                left = numTreesRec(i - 1);
                map.put(i - 1, left);
            }
            //右边个数 n-i
            Integer right = map.get(n - i);
            if (right == null) {
                right = numTreesRec(n - i);
                map.put(n - i, right);
            }
            res = res + left * right;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numTreesRec(3));
    }

    static Map<Integer, Integer> memo = new HashMap<>();

    public static int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            Integer left = memo.get(i - 1);
            if (left == null) {
                left = numTrees(i - 1);
                memo.put(i - 1, left);
            }

            Integer right = memo.get(n - i);
            if (right == null) {
                right = numTrees(n - i);
                memo.put(n - i, right);
            }

            result = result + left * right;
        }
        return result;
    }
}
