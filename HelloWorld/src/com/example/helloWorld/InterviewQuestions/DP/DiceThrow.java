package com.example.helloWorld.InterviewQuestions.DP;

public class DiceThrow {
    public static void main(String[] args) {
        System.out.println(diceThrow(4,2,1));
        System.out.println(diceThrow(2,2,3));
        System.out.println(diceThrow(6,3,8));
        System.out.println(diceThrow(4,2,5));
        System.out.println(diceThrow(4,3,5));
    }

    private static int diceThrow(int m, int n, int x) {
        if(n*m<x)
            return -1;
        else if(n>x)
            return -1;
        int[][] dp = new int[n+1][x+1];
        int i, j, k;
        for(i=0;i<=n;i++) {
            for (j = 0; j <= x; j++) {
                dp[i][j]=0;
            }
        }
        for(j = 1; j <= m && j <= x; j++)
            dp[1][j] = 1;
        for (i = 2; i <= n; i++) {
            for (j = 1; j <= x; j++) {
                for (k = 1; k <= m && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
//        for(i=0;i<=n;i++){
//            for(j=0;j<=x;j++)
//                System.out.print(dp[i][j]+" ");
//            System.out.println(" ");
//        }
        return dp[n][x];
    }
}
