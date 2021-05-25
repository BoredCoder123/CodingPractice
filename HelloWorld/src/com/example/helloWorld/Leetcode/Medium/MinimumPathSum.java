package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/minimum-path-sum/ Q.64
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int i=0, j=0, n=grid.length, m=grid[0].length;
        int[][] dp=new int[n][m];
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(i==0 && j==0)
                    dp[i][j]=grid[i][j];
                else if(i==0)
                    dp[i][j]+=dp[i][j-1]+grid[i][j];
                else if(j==0)
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                else
                    dp[i][j]=Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
