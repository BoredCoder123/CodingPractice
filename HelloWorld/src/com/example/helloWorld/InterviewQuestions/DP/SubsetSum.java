package com.example.helloWorld.InterviewQuestions.DP;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));
        System.out.println(subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }

    private static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length, i, j;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(i=0;i<=n;i++)
            dp[i][0]=true;
        for(i=1;i<=sum;i++)
            dp[0][i]=false;
        for(i=1;i<=n;i++){
            for(j=1;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=arr[i-1])
                    dp[i][j]|=dp[i-1][j-arr[i-1]];
            }
            if(dp[i][sum]==true)
                return true;
        }
        return false;
    }
}
