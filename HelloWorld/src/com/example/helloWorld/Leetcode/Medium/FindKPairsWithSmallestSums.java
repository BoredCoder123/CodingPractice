package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/ Q.373
import java.util.*;

public class FindKPairsWithSmallestSums {
    class Pair{
        int x, y, sum=0;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
            sum=x+y;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>(10000, new PairComparator());
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                pq.add(new Pair(nums1[i], nums2[j]));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(k>0 && !pq.isEmpty()){
            List<Integer> l= new ArrayList<>();
            Pair p=pq.poll();
            l.add(p.x);
            l.add(p.y);
            ans.add(l);
            k--;
        }
        return ans;
    }

    class PairComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return p1.sum-p2.sum;
        }
    }
}
