package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/interleaving-string/ Q.97
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i, j, m=s1.length(), n=s2.length(), o=s3.length();
        if(m+n!=o)
            return false;
        boolean[][] dp = new boolean[m+1][n+1];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++)
                dp[i][j]=false;
        }
        for(i=0;i<=m;i++){
            for(j=0;j<=n;j++){
                if(i==0 && j==0)
                    dp[i][j]=true;
                else if(i==0){
                    dp[i][j]=(dp[i][j-1] && s3.charAt(j-1)==s2.charAt(j-1));
                }else if(j==0){
                    dp[i][j]=(dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i-1));
                }else{
                    dp[i][j]=((s1.charAt(i-1)==s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1)==s3.charAt(i+j-1) && dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
