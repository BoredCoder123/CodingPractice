package com.example.helloWorld.GeeksForGeeks.StackAndQueue;
//https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1#
import java.util.*;
import java.lang.*;
import java.io.*;

public class nextLargerElement {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
            long[] res = nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }

    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] ans=new long[n];
        Stack<Long> stk= new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(stk.isEmpty()){
                ans[i]=-1;
                stk.push(arr[i]);
            }else{
                if(arr[i]<stk.peek()){
                    ans[i]=stk.peek();
                    stk.push(arr[i]);
                }
                else{
                    while(arr[i]>=stk.peek()){
                        long x=stk.pop();
                        if(stk.isEmpty())
                            break;
                    }
                    if(stk.isEmpty()){
                        ans[i]=-1;
                        stk.push(arr[i]);
                    }else{
                        ans[i]=stk.peek();
                        stk.push(arr[i]);
                    }
                }
            }
        }
        return ans;
    }

}