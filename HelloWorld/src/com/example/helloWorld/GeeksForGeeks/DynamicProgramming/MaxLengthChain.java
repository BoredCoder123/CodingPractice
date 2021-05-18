package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/max-length-chain/1
// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;

    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class MaxLengthChain
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
                arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            System.out.println(maxChainLength(pr, n));
        }
    }
    static int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.y-p2.y;
            }
        });
        int[] max= new int[n];
        max[0]=1;
        for(int i=1;i<n;i++)
            max[i]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i].x > arr[j].y){
                    max[i]=Math.max(max[i], max[j]+1);
                }
            }
        }
        int m=max[0];
        for(int i=0;i<n;i++)
            m=Math.max(m, max[i]);

        return m;
    }
}