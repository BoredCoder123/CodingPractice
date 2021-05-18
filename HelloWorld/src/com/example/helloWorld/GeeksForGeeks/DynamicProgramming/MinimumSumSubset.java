package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1#
import java.io.*;
import java.util.*;
class MinimumSumSubset
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            for(int i = 0;i<n;i++)
                A[i] = sc.nextInt();
            System.out.println(minDiffernce(A,n));
        }
    }
    public static int minDiffernce(int arr[], int n)
    {
        int i, j, sum=0;
        for(i=0;i<n;i++)
            sum+=arr[i];

        boolean dp[][]=new boolean[n+1][sum+1];

        for(i=0;i<=n;i++)
            dp[i][0]=true;
        for(i=1;i<=sum;i++)
            dp[0][i]=false;

        for(i=1;i<=n;i++){
            for(j=1;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(arr[i-1]<=j){
                    dp[i][j]|=dp[i-1][j-arr[i-1]];
                }
            }
        }
        int diff=Integer.MAX_VALUE;

        for(j=sum/2; j>=0;j--){
            if(dp[n][j]==true){
                diff=sum-2*j;
                break;
            }
        }
        return Math.abs(diff);
    }
}
