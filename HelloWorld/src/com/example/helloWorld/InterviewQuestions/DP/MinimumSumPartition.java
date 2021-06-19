package com.example.helloWorld.InterviewQuestions.DP;

public class MinimumSumPartition {
    public static void main(String[] args) {
        System.out.println(minimumSumPartition(new int[]{1,6,11, 5}));
        System.out.println(minimumSumPartition(new int[]{3, 1, 4, 2, 2, 1}));
    }

    private static int minimumSumPartition(int[] arr) {
        int diff=Integer.MAX_VALUE, i, j, sum=0, l=arr.length;
        for(i=0;i<l;i++){
            sum+=arr[i];
        }
        boolean[][] dp = new boolean[l+1][sum+1];
        for(i=0;i<=l;i++) dp[i][0]=true;
        for(i=1;i<=sum;i++) dp[0][i]=false;
        for(i=1;i<=l;i++){
            for(j=1;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(arr[i-1]<=j)
                    dp[i][j]|=dp[i-1][j-arr[i-1]];
            }
        }
        for(i=0;i<=l;i++){
            for(j=0;j<=sum;j++){
                System.out.printf("%6s ",dp[i][j]);
            }
            System.out.println(" ");
        }

        for(i=sum/2;i>=0;i--){
            if(dp[l][i]){
                diff=sum-2*i;
                break;
            }
        }

        return diff;
    }
}
