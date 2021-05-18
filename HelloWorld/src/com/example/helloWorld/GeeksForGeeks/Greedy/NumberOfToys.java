package com.example.helloWorld.GeeksForGeeks.Greedy;
//https://practice.geeksforgeeks.org/problems/maximize-toys0331/1
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String st[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(st[0]);
            int K = Integer.parseInt(st[1]);
            String st1[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st1[i]);

            System.out.println(toyCount(N, K, arr));
        }
    }
    static int toyCount(int n, int k, int arr[])
    {
        Arrays.sort(arr);
        int cnt=0, sum=0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]<=k){
                sum=sum+arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}