package com.example.helloWorld.GeeksForGeeks.Recursion;
//https://practice.geeksforgeeks.org/problems/special-keyboard3018/1
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class SpecialKkeyboard{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());

            So ob = new So();
            System.out.println(ob.optimalKeys(N));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class So{
    static int optimalKeys(int n){
        if(n<7)
            return n;

        int max=0, b;
        for(b=n-3;b>=1;b--){
            int cur=(n-b-1)*optimalKeys(b);
            max=Math.max(max, cur);
        }
        return max;
    }
}
