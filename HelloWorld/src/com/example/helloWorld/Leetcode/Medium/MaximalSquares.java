package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/maximal-square/ Q.221
public class MaximalSquares {
    public int maximalSquare(char[][] matrix) {
        int i, j, max=0, n=matrix.length, m=matrix[0].length;
        int[][] dp = new int[n][m];
        for(i=0;i<n;i++){
            for(j=0;j<m;j++)
                dp[i][j]=0;
        }
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(i==0 && j==0){
                    if(matrix[i][j]=='0')
                        dp[i][j]=0;
                    else{
                        dp[i][j]=1;
                        max=1;
                    }
                }else if(i==0){
                    if(matrix[i][j]=='0')
                        dp[i][j]=0;
                    else{
                        dp[i][j]=1;
                        max=Math.max(max, dp[i][j]);
                    }
                }else if(j==0){
                    if(matrix[i][j]=='0')
                        dp[i][j]=0;
                    else{
                        dp[i][j]=1;
                        max=Math.max(max, dp[i][j]);
                    }
                }else{
                    if(matrix[i][j]=='0')
                        dp[i][j]=0;
                    else{
                        dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                        max=Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        // for(i=0;i<n;i++){
        //     for(j=0;j<m;j++)
        //         System.out.print(dp[i][j]+" ");
        //     System.out.println(" ");
        // }
        return max*max;
    }
}
