package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
// { Driver Code Starts
import java.io.*;
import java.util.*;

class LongestIncreasingSubsequence{
    public static void main(String args[]) throws IOException {

        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){

            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            //calling longestSubsequence() method of class
            //Solution
            System.out.println(longestSubsequence(n,array));
            t--;
        }
    }
    static int optimizedLongestSubsequence(int size, int a[])
    {
        int dp[]=new int[size];
        dp[0]=a[0];
        int len=1;
        for(int i=1;i<size;i++){
            if(a[i]>dp[len-1])
                dp[len++]=a[i];
            else{
                int c=ceilIdx(dp,0,len-1,a[i]);
                dp[c]=a[i];
            }
        }
        return len;
    }
    static int ceilIdx(int dp[],int st,int end,int x){
        while(st<end){
            int mid=(st+end)/2;
            if(dp[mid]>=x)
                end=mid;
            else
                st=mid+1;
        }
        return end;
    }

    static int longestSubsequence(int s, int a[])
    {
        int[] ans= new int[s];
        int max=0;
        ans[0]=1;
        for(int i=0;i<s;i++)
            ans[i]=1;
        for(int i=1;i<s;i++){
            for(int j=i-1;j>=0;j--){
                if(a[i]>a[j]){
                    if(ans[j]==max){
                        // System.out.println(i+" "+j+" "+ans[i]+" "+ans[j]);
                        ans[i]=Math.max(ans[i], ans[j]+1);
                        max=Math.max(max, ans[i]);
                        break;
                    }else{
                        ans[i]=Math.max(ans[i], ans[j]+1);
                        max=Math.max(max, ans[i]);
                    }
                }
            }
        }
        // for(int i=0;i<s;i++)
        //     System.out.println(ans[i]);
        return max;
    }
}
