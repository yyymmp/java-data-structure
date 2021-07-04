package com.jlz.backtrack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T_77 {

    public static void main(String[] args) {


//    System.out.println(new BCryptPasswordEncoder().encode("a1234567"));
//    System.out.println(Test.class.getResource("/").getPath() + "/enterprise-apply.docx");
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n,k,1,track);
        return res;
    }
    public void backtrack(int n,int k,int start,LinkedList<Integer> track){
        if (track.size() == k){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (track.contains(i)){
                continue;
            }
            track.addLast(i);
            backtrack(n,k,i,track);
            track.removeLast();
        }
    }



}