package com.example.helloWorld.GeeksForGeeks.Hashing;
//https://practice.geeksforgeeks.org/problems/relative-sorting4323/1#
// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


// } Driver Code Ends
//User function Template for Java

class Solution{

    public static int[] sortA1ByA2(int a1[], int n, int a2[], int m)
    {
        HashMap<Integer, Integer> h = new HashMap<>();
        int[] temp = new int[m];
        for(int i=0;i<m;i++){
            h.put(a2[i], i);
            temp[i]=0;
        }
        for(int i=0;i<n;i++){
            if(h.containsKey(a1[i])){
                temp[h.get(a1[i])]++;
                a1[i]=Integer.MIN_VALUE;
            }
        }
        // return temp;
        Arrays.sort(a1);
        int x=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<temp[i];j++){
                a1[x]=a2[i];
                x++;
            }
        }
        return a1;
    }
}



// { Driver Code Starts.
class SortA1ByA2 {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while(t-->0)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a1[]=new int[n];
            int a2[]=new int[m];

            for(int i=0;i<n;i++)
                a1[i]=sc.nextInt();

            for(int i=0;i<m;i++)
                a2[i]=sc.nextInt();
            Solution ob=new Solution();
            a1 = ob.sortA1ByA2(a1,n,a2,m);
            for(int x:a1)
                System.out.print(x+" ");

            System.out.println();
        }
    }


}


// } Driver Code Ends
