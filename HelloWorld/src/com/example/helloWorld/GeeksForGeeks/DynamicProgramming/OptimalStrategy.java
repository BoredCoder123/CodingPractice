package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;

import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {

        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking total number of testcases
        int t = sc.nextInt();

        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];

            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            //calling the countMaximum() method of class solve
            System.out.println(countMaximum(arr, n));
        }
    }
    static long countMaximum(int arr[], int n)
    {
        int[][] dp = new int[n][n];
        int gap, i, j, x, y,z;
        for(gap=0; gap<n;gap++){
            for(i=0,j=gap; j<n; j++, i++){
                x=((i+2)<=j)?dp[i+2][j]:0;
                y=((i+1)<=j-1)?dp[i+1][j-1]:0;
                z=(i<=(j-2))?dp[i][j-2]:0;
                dp[i][j]=Math.max(arr[i]+Math.min(x,y), arr[j]+Math.min(y,z));
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println(" ");
        }
        return dp[0][n-1];
    }
}