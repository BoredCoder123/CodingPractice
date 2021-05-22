package com.example.helloWorld.Leetcode.Medium;

import java.util.LinkedList;

//https://leetcode.com/problems/interval-list-intersections/ Q.986
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length==0 || secondList.length==0)
            return new int[0][0];
        LinkedList<int[]> ans=new LinkedList<>();
        int i, j;
        for(i=0,j=0;i<firstList.length && j<secondList.length;){
            int lo=Math.max(firstList[i][0], secondList[j][0]);
            int hi=Math.min(firstList[i][1], secondList[j][1]);
            if(lo<=hi)
                ans.add(new int[]{lo, hi});

            if(firstList[i][1]<secondList[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
