package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/longest-palindromic-substring/submissions/ Question number 5
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n=s.length(), i=0, j=0, k=0;
        if(n<2)
            return s;
        else if(n==2){
            if(s.charAt(0)==s.charAt(1))
                return s;
            else
                return Character.toString(s.charAt(0));
        }
        boolean[][] dp = new boolean[n][n];
        for(i=0;i<n;i++){
            for(j=0;j<n;j++)
                dp[i][j]=false;
        }

        for(i=0;i<n;i++)
            dp[i][i]=true;

        for(i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
                dp[i][i+1]=true;
        }

        for(k=3;k<=n;k++){
            for(i=0;i<n-k+1;i++){
                j=i+k-1;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j))
                    dp[i][j]=true;
            }
        }

        int max=0, maxI=0, maxJ=0;
        for(i=0;i<n;i++){
            for(j=i;j<n;j++){
                if((i-j>max) || (j-i>max) && dp[i][j]){
                    maxI=i;
                    maxJ=j;
                    max=Math.abs(i-j);
                }
                // System.out.print(dp[i][j]);
            }
            // System.out.println(" ");
        }
        // System.out.println(maxI+" "+maxJ+" "+max);
        return s.substring(maxI, maxJ+1);
    }
}