package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/cutted-segments1642/1#
import java.util.*;
import java.io.*;
import java.lang.*;

class MaximumCutSegments
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //reading total testcases
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());


            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");

            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);


            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(maximizeCuts(n, x, y, z));
        }
    }
    public static int maximizeCuts(int n, int x, int y, int z)
    {
        int i, j;
        int[] arr = new int[3];
        arr[0]=x;
        arr[1]=y;
        arr[2]=z;

        int[][] dp = new int[4][n+1];
        for(i=0;i<4;i++){
            dp[i][0]=1;
        }
        for(i=1;i<=n;i++){
            dp[0][i]=0;
        }

        for(i=1;i<4;i++){
            for(j=1;j<=n;j++){
                if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    if(dp[i][j-arr[i-1]]==0){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-arr[i-1]] + dp[i][arr[i-1]]);
                    }
                }
            }
        }
        return dp[3][n];
    }
}