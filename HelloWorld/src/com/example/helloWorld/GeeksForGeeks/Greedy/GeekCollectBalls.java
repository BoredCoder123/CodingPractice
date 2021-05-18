package com.example.helloWorld.GeeksForGeeks.Greedy;
//https://practice.geeksforgeeks.org/problems/geek-collects-the-balls5515/1
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GeekCollectBalls{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            String arr1[] = in.readLine().trim().split("\\s+");
            String arr2[] = in.readLine().trim().split("\\s+");
            int a[] = new int[N];
            int b[] = new int[M];
            for(int i = 0;i < N;i++)
                a[i] = Integer.parseInt(arr1[i]);
            for(int i = 0;i < M;i++)
                b[i] = Integer.parseInt(arr2[i]);

            System.out.println(maxBalls(N, M, a, b));
        }
    }
    static int maxBalls(int n, int m, int a[], int b[])
    {
        int first=0,second=0,res=0;
        int i=0,j=0;
        while(i<n&& j<m)
        {
            if(a[i]<b[j]){
                first+=a[i++];
            }
            else if(a[i]>b[j])
            {
                second+=b[j++];
            }
            else
            {
                res+=Math.max(first,second)+a[i];
                first=0;
                second=0;
                int temp=a[i];
                ++i;
                temp=b[j];
                ++j;
                while(i<n && a[i]==temp)
                    res+=a[i++];
                while(j<m && b[j]==temp)
                    res+=b[j++];
            }
        }
        while(i<n)
        {
            first+=a[i++];
        }
        while(j<m)
        {
            second+=b[j++];
        }
        res+=Math.max(first,second);
        return res;
    }
}
