package com.example.helloWorld.GeeksForGeeks.Greedy;
//https://practice.geeksforgeeks.org/problems/largest-number-possible5028/1
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class LargestNumber{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);

            System.out.println(findLargest(N, S));
        }
    }
    static String findLargest(int n, int s){
        if(n*9<s || (s==0 && n!=1))
            return "-1";
        else{
            String str="";
            while(n>0){
                if(s>=9){
                    str+="9";
                    s-=9;
                    n--;
                }else if(s>0){
                    str+=String.valueOf(s);
                    s=0;
                    n--;
                }else{
                    str+="0";
                    n--;
                }
            }
            return str;
        }
    }
}
