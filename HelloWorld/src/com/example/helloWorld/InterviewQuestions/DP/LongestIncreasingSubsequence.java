package com.example.helloWorld.InterviewQuestions.DP;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
        System.out.println(longestIncreasingSubsequence(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    private static List<Integer> longestIncreasingSubsequence(int[] arr) {
        List<Integer> ans= new ArrayList<>();
        int l=arr.length, i, j, max=1;
        int[] dp = new int[l];
        for(i=0;i<l;i++)
            dp[i]=1;
        for(i=1;i<l;i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
//                    System.out.println(i+" "+j);
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for(i=0;i<l;i++){
            if(max == dp[i]){
                ans.add(arr[i]);
                max++;
            }
        }
        return ans;
    }
}
