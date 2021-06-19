package com.example.helloWorld.InterviewQuestions.DP;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(editDistance("geek", "gesek"));
        System.out.println(editDistance("cat", "cut"));
        System.out.println(editDistance("sunday", "saturday"));
    }

    private static int editDistance(String s1, String s2) {
        int l1=s1.length(), l2=s2.length(), i, j;
        int[][] dp = new int[l1+1][l2+1];
        dp[0][0]=0;
        for(i=1;i<=l1;i++)
            dp[i][0]=i;
        for(i=1;i<=l2;i++)
            dp[0][i]=i;
        for(i=1;i<=l1;i++){
            for(j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                }
            }
        }
        for(i=0;i<=l1;i++){
            for(j=0;j<=l2;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println(" ");
        }
        return dp[l1][l2];
    }
}
