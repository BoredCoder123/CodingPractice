package com.example.helloWorld.InterviewQuestions.DP;

public class OptimalStrategyForGame {
    public static void main(String[] args) {
        System.out.println(optimalStrategyForGame(new int[]{5, 3, 7, 10}));
        System.out.println(optimalStrategyForGame(new int[]{8, 15, 3, 7}));
    }

    private static int optimalStrategyForGame(int[] arr) {
        int n=arr.length, i, j, k, x, y, z;
        int[][] dp = new int[n][n];
        for(i=0;i<n;i++) {
            for (j = 0; j < n; j++) {
                dp[i][j] = 0;
                dp[i][j] = 0;
            }
        }
        for(k=0;k<n;k++){
            for(i=0, j=k;j<n;i++,j++){
                x=0;y=0;z=0;
                if(k>=2){
                    x=dp[i+2][j];
                    y=dp[i+1][j-1];
                    z=dp[i][j-2];
                }
                dp[i][j]=Math.max(arr[i]+Math.min(x,y), arr[j]+Math.min(y,z));
                System.out.println(i+" "+j+" "+k+" "+x+" "+y+" "+z+" "+dp[i][j]);
            }
        }
        return dp[0][n-1];
    }
}
