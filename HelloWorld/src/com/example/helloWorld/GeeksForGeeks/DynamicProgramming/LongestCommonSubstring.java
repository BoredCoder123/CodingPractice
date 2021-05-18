package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class LongestCommonSubstring
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            System.out.println(longestCommonSubstr(S1, S2, n, m));
        }
    }
    static int longestCommonSubstr(String s1, String s2, int n, int m){
        int i, j;
        int[][] rep = new int[n][m];
        for(i=0;i<n;i++){
            for(j=0;j<m;j++)
                rep[i][j]=0;
        }
        int max=0;

        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    if(i==0 || j==0){
                        rep[i][j]=1;
                        max=Math.max(rep[i][j], max);
                    }else{
                        rep[i][j]=rep[i-1][j-1]+1;
                        max=Math.max(rep[i][j], max);
                    }
                }
            }
        }
        return max;
    }
}
