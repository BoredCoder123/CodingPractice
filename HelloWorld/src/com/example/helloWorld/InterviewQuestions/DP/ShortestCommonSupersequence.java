package com.example.helloWorld.InterviewQuestions.DP;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("geek", "eke"));
        System.out.println(shortestCommonSupersequence("AGGTAB", "GXTXAYB"));
    }

    private static int shortestCommonSupersequence(String s1, String s2) {
        int n=s1.length(), m=s2.length(), i, j;
        int[][] dp = new int[n+1][m+1];
        for(i=0;i<=n;i++)
            dp[i][0]=i;
        for(i=0;i<=m;i++)
            dp[0][i]=i;
        for(i=1;i<=n;i++){
            for(j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+1;
            }
        }
        return dp[n][m];
    }
}
