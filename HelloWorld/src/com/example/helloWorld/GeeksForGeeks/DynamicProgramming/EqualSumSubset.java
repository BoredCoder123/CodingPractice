package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#
import java.io.*;
import java.util.*;

class EqualSumSubset{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);

            int x = equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static int equalPartition(int n, int arr[])
    {
        int sum = 0;
        int i, j;

        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return 0;

        boolean part[][] = new boolean[sum / 2 + 1][n + 1];

        for (i = 0; i <= n; i++)
            part[0][i] = true;

        for (i = 1; i <= sum / 2; i++)
            part[i][0] = false;

        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= arr[j - 1])
                    part[i][j]
                            = part[i][j]
                            || part[i - arr[j - 1]][j - 1];
            }
        }

        if(part[sum / 2][n])
            return 1;
        else
            return 0;
    }
}