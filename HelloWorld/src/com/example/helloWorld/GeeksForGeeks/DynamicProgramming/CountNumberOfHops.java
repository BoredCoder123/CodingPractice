package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1
import java.util.*;
import java.io.*;
import java.lang.*;

class CountNumberOfHops
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking number of testcases
        int t = sc.nextInt();

        while(t-- > 0)
        {
            //taking number of steps in stair
            int n = sc.nextInt();

            //calling method countWays() of class Hops
            System.out.println(countWays(n));

        }
    }

    static long countWays(int n)
    {
        long[] dp = new long[n+1];
        int i;
        long cnt=0;
        for(i=0;i<=n;i++){
            if(i==0){
                dp[i]=0;
            }else if(i==1){
                dp[i]=1;
            }else if(i==2){
                dp[i]=2;
            }else if(i==3){
                dp[i]=4;
            }else{
                dp[i]=dp[i-2]%1000000007+dp[i-1]%1000000007+dp[i-3]%1000000007;
                dp[i]%=1000000007;
            }
        }
        return dp[n]%1000000007;
    }

}

