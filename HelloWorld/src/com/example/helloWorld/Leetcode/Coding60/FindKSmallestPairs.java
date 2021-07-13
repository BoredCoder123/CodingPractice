package com.example.helloWorld.Leetcode.Coding60;

import java.util.*;

public class FindKSmallestPairs {

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1,2}, new int[]{3}, 3));
    }

    public static List<List<Integer>> kSmallestPairs(int[] num1, int[] num2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> h = new PriorityQueue<>((Pair p1, Pair p2)-> p1.sum-p2.sum);
        for(int i=0;i<num1.length;i++){
            for(int j=0;j<num2.length;j++){
                System.out.println("x "+num1[i]+" "+num2[j]);
                h.add(new Pair(num1[i], num2[j]));
            }
        }
        for(int itr=0;itr<h.size();itr++){
            System.out.println(itr+" "+h.size());
            Pair p=h.peek();
            h.poll();
            System.out.println(itr+" "+p.i+" "+p.j+" "+p.sum);
        }
        // for(int i=0;i<h.size() && i<k;i++){
        //     Pair p=h.poll();
        //     List<Integer> t = new ArrayList<>();
        //     t.add(p.i);
        //     t.add(p.j);
        //     ans.add(t);
        // }
        return ans;
    }

    static class Pair{
        int i, j, sum=0;
        public Pair(int i, int j){
            this.i=i;
            this.j=j;
            sum=i+j;
        }
    }
}
