package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/coin-change2448/1

import java.io.*;
import java.util.*;
class CoinChange
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for(int i = 0;i<m;i++)
                Arr[i] = sc.nextInt();
            System.out.println(recursivecount(Arr,m,n));
        }
    }
    public static long recursivecount(int s[], int m, int n)
    {
        if(n==0)
            return 1;
        if(n<0)
            return 0;
        if(m<=0 && n>=1)
            return 0;

        return recursivecount(s, m-1, n)+recursivecount(s, m, n-s[m-1]);
    }
    //m is the size of the array, n is the sum to obtained
    public static long iterativeCount(int s[], int m, int n){
        long[][] dp = new long[m+1][n+1];
        int i, j;
        for(i=0;i<=m;i++){
            for(j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=0;
                }
                if(j==0){
                    dp[i][j]=1;
                }
                if(i==1){
                    if(j%s[i-1]==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=0;
                    }
                }
                if(i>1 && j>0){
                    if(j<s[i-1]){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i][j-s[i-1]]+dp[i-1][j];
                    }
                }
            }
        }
        // for(i=0;i<=m;i++){
        //     for(j=0;j<=n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println(" ");
        // }
        return dp[m][n];
    }
}
