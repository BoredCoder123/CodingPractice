package com.example.helloWorld.Leetcode.Medium;

import java.util.Scanner;

public class PaintHouse {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] cost= new int[n][3];
        for(int i=0;i<n;i++){
            String[] temp = sc.nextLine().split(" ");
            cost[i][0]=Integer.parseInt(temp[0]);
            cost[i][1]=Integer.parseInt(temp[1]);
            cost[i][2]=Integer.parseInt(temp[2]);
        }
        System.out.println(findMinCost(cost));
    }

    private static int findMinCost(int[][] costs){
        int i, n=costs.length;
        int[][] dp =new int[n][3];
        for(i=0;i<n;i++){
            if(i==0){
                dp[0][0]=costs[0][0];
                dp[0][1]=costs[0][1];
                dp[0][2]=costs[0][2];
            }else{
                dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+costs[i][0];
                dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+costs[i][1];
                dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+costs[i][2];
            }
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}