package com.example.helloWorld.Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/triangle/ Q.120
public class Triangle {
    public int minimumTotal(List<List<Integer>> list) {
        List<List<Integer>> dp =new ArrayList<List<Integer>>();
        if(list.size()==1)
            return list.get(0).get(0).intValue();
        int i, j;
        int n=list.size(), m=0;
        for(i=n-1;i>=0;i--){
            if(i==n-1)
                dp.add(0, list.get(i));
            else{
                List<Integer> fromMainList = list.get(i);
                List<Integer> toBeAdded= new ArrayList<Integer>();
                for(j=0;j<fromMainList.size();j++){
                    int confirm=fromMainList.get(j);
                    int fir=dp.get(0).get(j).intValue();
                    int sec=dp.get(0).get(j+1).intValue();
                    toBeAdded.add(j, confirm+(Math.min(fir, sec)));
                }
                dp.add(0, toBeAdded);
            }
        }
        return dp.get(0).get(0).intValue();
    }
}
