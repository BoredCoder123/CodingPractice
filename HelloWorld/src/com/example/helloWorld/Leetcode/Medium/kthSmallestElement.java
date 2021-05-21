package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/ Q.378
import java.util.PriorityQueue;

public class kthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.add(matrix[i][j]);
            }
        }
        int i=0;
        while(k>0){
            i=pq.poll().intValue();
            k--;
        }
        return i;
    }
}
