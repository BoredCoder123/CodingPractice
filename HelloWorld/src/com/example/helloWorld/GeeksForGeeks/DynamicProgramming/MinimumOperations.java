package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1#
import java.io.*;
import java.util.*;
class MinimumOperations
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            System.out.println(minOperation(n));
        }
    }
    public static int minOperation(int n)
    {
        int[] dp = new int[n+1];
        int i;
        for(i=0;i<n+1 ;i++){
            if(i==0 || i==1){
                dp[i]=i;
            }
            else if(i%2==0){
                dp[i]=dp[i/2]+1;
            }else{
                dp[i]=dp[i-1]+1;
            }
        }
        return dp[n];
    }
}