package com.example.helloWorld.InterviewQuestions.DP;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        System.out.println(matrixChainMultiplication(new int[]{10, 20, 30, 40, 30}));
        System.out.println(matrixChainMultiplication(new int[]{40, 20, 30, 10, 30}));
    }

    private static int matrixChainMultiplication(int[] arr) {
        int n=arr.length, i, j, k, l, q;
        int[][] dp = new int[n][n];
        for(i=0;i<n;i++)
            dp[i][i]=0;
        for(l=2;l<n;l++){               //Length of the matrix chain
            for(i=1;i<n-l+1;i++){       //Start of i
                j=i+l-1;                //end of chain
                if(j==n)
                    continue;
                dp[i][j]=Integer.MAX_VALUE;
                for(k=i;k<=j-1;k++){        //Minimum value of all the matrices between i and j
                    q=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j],q);
                }
            }
        }
        return dp[1][n-1];
    }
}
