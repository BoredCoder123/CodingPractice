package com.example.helloWorld.InterviewQuestions;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ABCDGH", "AEDFHR"));
        System.out.println(longestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }

    private static String longestCommonSubsequence(String s1, String s2) {
        int max=0, l1=s1.length(), l2=s2.length(), i, j;
        int[][] dp = new int[l1+1][l2+1];
        for(i=0;i<=l1;i++)   dp[i][0]=0;
        for(i=0;i<=l2;i++)   dp[0][i]=0;
        for(i=1;i<=l1;i++){
            for(j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
//        for(i=0;i<=l1;i++){
//            for(j=0;j<=l2;j++)
//                System.out.print(dp[i][j]+" ");
//            System.out.println(" ");
//        }
        String ans="", temp="";
        if(dp[l1][l2]==0)
            return "";
        else{
            for(i=l2;i>0;i--){
                if(dp[l1][i]>dp[l1][i-1]) {
                    temp=ans;
                    ans = Character.toString(s2.charAt(i - 1));
                    ans+=temp;
                }
            }
        }
        return ans;
    }
}
