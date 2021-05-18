package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/

import java.util.*;
import java.io.*;

public class LongestPathIncreasingBy1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            String[] str=sc.nextLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(str[j]);
            }
        }
        maxLength(arr, n);
    }

    public static void maxLength(int[][] arr, int n){
        int[][] dp = new int[n][n];
        int i, j;
        for(i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                maxLengthUtil(i, j, arr, dp, n);
            }
        }
        int max=-1;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println(" ");
        }
    }

    public static int maxLengthUtil(int x, int y, int[][] arr, int[][] dp, int n){
        if(x<0 || y<0 || x>=n || y>=n)
            return 0;
        else if(dp[x][y]!=-1){
            return dp[x][y];
        }
        int a=0,b=0,c=0,d=0;
        if(x<n-1){
            if(arr[x][y]+1==arr[x+1][y]){
                a= maxLengthUtil(x+1, y, arr, dp, n)+1;
                dp[x][y]=a;
            }
        }
        if(x>0){
            if(arr[x][y]+1==arr[x-1][y]){
                b=maxLengthUtil(x-1, y, arr, dp, n)+1;
                dp[x][y]=b;
            }
        }
        if(y<n-1){
            if(arr[x][y]+1==arr[x][y+1]){
                c=maxLengthUtil(x,y+1, arr, dp, n)+1;
                dp[x][y]=c;
            }
        }
        if(y>0){
            if(arr[x][y]+1==arr[x][y-1]){
                d=maxLengthUtil(x, y-1, arr, dp, n)+1;
                dp[x][y]=d;
            }
        }
        dp[x][y]=Math.max(a,Math.max(b,Math.max(c,Math.max(d,1))));
        return dp[x][y];
    }
}
