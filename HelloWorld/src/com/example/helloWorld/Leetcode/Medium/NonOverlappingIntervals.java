package com.example.helloWorld.Leetcode.Medium;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals Q.435
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        int i, n=intervals.length, cnt=0;
        boolean[] removed=new boolean[n];
        int end=intervals[0][1];
        for(i=1;i<n;i++){
            if(intervals[i][0]<end){
                cnt++;
                end=Math.min(end, intervals[i][1]);
                // System.out.println(i+" "+end);
            }else
                end=intervals[i][1];
        }
        return cnt;
    }
}
