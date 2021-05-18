package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/edit-distance3702/1#
import java.util.*;
import java.lang.*;
import java.io.*;
class EditDistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            int ans = editDistance(s, t);
            System.out.println(ans);
        }
    }
    public static int editDistance(String str1, String str2) {
        int n=str2.length(), m=str1.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;

                else if (j == 0)
                    dp[i][j] = i;

                else if (str1.charAt(i - 1)== str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],( Math.min(dp[i - 1][j], dp[i - 1][j - 1])));
            }
        }

        return dp[m][n];
    }
}