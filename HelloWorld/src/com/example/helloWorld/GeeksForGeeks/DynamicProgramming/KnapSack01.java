package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#
import java.util.*;
import java.io.*;
import java.lang.*;
class KnapSack01 {
    public static void main(String args[]) throws IOException {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //reading total testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            //inserting the values
            for (int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");

            //inserting the weigths
            for (int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            //calling method knapSack() of class Knapsack
            System.out.println(iterativeKnapSack(w, wt, val, n));
        }
    }

    static int iterativeKnapSack(int W, int wt[], int val[], int n)
    {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W)
            return iterativeKnapSack(W, wt, val, n - 1);

        else
            return Math.max(val[n - 1]
                            + iterativeKnapSack(W - wt[n - 1], wt,
                    val, n - 1),
                    iterativeKnapSack(W, wt, val, n - 1));
    }

    static int recursiveKnapSacK(int w, int wt[], int val[], int n){
        int[][] dp = new int[n+1][w+1];
        int i, j;
        for(i=0;i<n+1;i++){
            for(j=0;j<=w;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
