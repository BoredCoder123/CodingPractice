package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/palindromic-substrings Q.647
public class countSubstrings {
    public int countSubstrings(String s) {
        if(s.length()==1)
            return 1;
        int n=s.length(), i, j, k;
        boolean[][] dp = new boolean[n][n];
        for(i=0;i<n;i++){
            for(j=0;j<n;j++)
                dp[i][j]=false;
        }
        int cnt=0;
        for(i=0;i<n;i++){
            dp[i][i]=true;
            cnt++;
        }
        for(i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                cnt++;
            }
        }

        for(k=3;k<=n;k++){
            for(i=0;i<n-k+1;i++){
                j=i+k-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
