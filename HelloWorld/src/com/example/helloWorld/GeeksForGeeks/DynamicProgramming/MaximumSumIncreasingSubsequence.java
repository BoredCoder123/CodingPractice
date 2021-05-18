package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
import java.io.*;
import java.util.*;
class MaximumSumIncreasingSubsequence
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int Arr[] = new int[n];
            for(int i = 0;i<n;i++)
                Arr[i] = sc.nextInt();
            System.out.println(maxSumIS(Arr,n));
        }
    }
    public static int maxSumIS(int arr[], int n)
    {
        int[] dp = new int[n];
        int max=arr[0];
        for(int i=0;i<n;i++)
            dp[i]=arr[i];
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i], dp[j]+arr[i]);
                    max=Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}