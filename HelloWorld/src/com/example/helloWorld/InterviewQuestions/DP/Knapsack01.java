package com.example.helloWorld.InterviewQuestions.DP;

public class Knapsack01 {
    public static void main(String[] args) {
        System.out.println(knapsack01(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
        System.out.println(knapsack01(new int[]{10, 15, 40}, new int[]{1,2,3}, 6));
        System.out.println(knapsack01(new int[]{10, 15, 40}, new int[]{1,2,3}, 5));
        System.out.println(knapsack01(new int[]{20, 15, 40}, new int[]{1,2,3}, 5));
    }

    private static int knapsack01(int[] value, int[] weight, int maxWeight) {
        int max=0, n=value.length, i, j;
        int[][] dp = new int[n+1][maxWeight+1];
        for(i=0;i<=n;i++)
            dp[i][0]=0;
        for(i=0;i<=maxWeight;i++)
            dp[0][i]=0;
        for(i=1;i<=n;i++){
            for(j=1;j<=maxWeight;j++){
                dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                if(j>=weight[i-1]){
                    dp[i][j]=Math.max(dp[i][j], value[i-1]+dp[i-1][j-weight[i-1]]);
                }
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
