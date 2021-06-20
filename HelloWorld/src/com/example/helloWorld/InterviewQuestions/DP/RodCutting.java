package com.example.helloWorld.InterviewQuestions.DP;

public class RodCutting {
    public static void main(String[] args) {
        System.out.println(rodCutting(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(rodCutting(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
    }

    private static int rodCutting(int[] arr) {
        int n=arr.length, i, j;
        int[] dp = new int[n];
        dp[0]=arr[0];
        for(i=1;i<n;i++){
            dp[i]=arr[i];
            for(j=0;j<i;j++){
                dp[i]=Math.max(dp[i], arr[j]+dp[i-j-1]);
            }
        }
        for(i=0;i<n;i++)
            System.out.print(dp[i]+" ");
        System.out.println(" ");
        return dp[n-1];
    }
}
