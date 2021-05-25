package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/unique-binary-search-trees/ Q.96
public class NumberOfUniqueBST {
    public int numTrees(int n) {
        //Catalan number 2n C n /(n+1)
        int[] dp = new int[n+1];
        int i, j;
        dp[0]=1;
        dp[1]=1;
        for(i=2;i<=n;i++){
            for(j=0;j<i;j++){
                dp[i]+=dp[i-j-1]*dp[j];
            }
        }
        return dp[n];
    }
}
