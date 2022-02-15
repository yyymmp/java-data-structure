package com.jlz.array.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jlz
 * @date 2022年02月10日 16:30
 */
public class T_56 {

    public static int[][] merge(int[][] intervals) {

        List<int[]> merged = new ArrayList<int[]>();
        //元素个数
        int refer = 0;
        LinkedList<Integer> tmp = new LinkedList<>();

        //Arrays.sort(intervals);

        for (int i = 0; i < intervals.length; i++) {
            //初始化
            if (tmp.isEmpty()) {
                tmp.add(intervals[i][0]);
                tmp.add(intervals[i][1]);
            } else if (tmp.getLast() >= intervals[i][0] && tmp.getFirst()<=intervals[i][1]) {
                //合并
                //tmp.addLast(intervals[i][0]);
                tmp.set(tmp.size()-1,Math.max(tmp.getLast(),intervals[i][1]));
                tmp.set(0,Math.min(intervals[i][0],tmp.getFirst()));
            } else {
                //新的区间  保存已有区间 初始化当前区间
                int[] ints = new int[tmp.size()];
                for (int i1 = 0; i1 < tmp.size(); i1++) {
                    ints[i1] = tmp.get(i1);
                }
                merged.add(ints);
                tmp.clear();

                tmp.addLast(intervals[i][0]);
                tmp.addLast(intervals[i][1]);
            }
        }
        if (!tmp.isEmpty()){
            int[] ints = new int[tmp.size()];
            for (int i1 = 0; i1 < tmp.size(); i1++) {
                ints[i1] = tmp.get(i1);
            }
            merged.add(ints);
        }

        //list 转数组
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] sort(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0] ){
                    //增序
                    int[] tmp = intervals[i];
                    intervals[i] =  intervals[j];
                    intervals[j] = tmp;
                }
            }
        }

        return intervals;
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{
                //{1, 4},
                //{0, 1}

                //{1, 4},
                //{0, 4}
                //{1, 4},
                //{0, 0}

                //{1, 2},
                //{2, 6},
                //{8, 10},
                //{15, 18}

                {2,3},
                {4,5},
                {6,7},
                {8,9},
                {1,10}

        };

        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        //int[][] merge = merge(a);
        //for (int i = 0; i < merge.length; i++) {
        //    System.out.println(Arrays.toString(merge[i]));
        //}
    }
}
