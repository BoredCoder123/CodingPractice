package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/unique-paths-ii/ Q.63
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length, m=grid[0].length, i=0, j=0;
        int[][] dp = new int[n][m];
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    if(i==0 && j==0)
                        dp[i][j]=1;
                    else if(i==0)
                        dp[i][j]=dp[i][j-1];
                    else if(j==0)
                        dp[i][j]=dp[i-1][j];
                    else
                        dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        // for(i=0;i<n;i++){
        //     for(j=0;j<m;j++)
        //         System.out.print(dp[i][j]+" ");
        //     System.out.println(" ");
        // }
        return dp[i-1][j-1];
    }
}
