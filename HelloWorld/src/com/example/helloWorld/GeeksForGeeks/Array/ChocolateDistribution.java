package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#
import java.io.*;
import java.util.*;
public class ChocolateDistribution
{
    public static void callChocolateDistribution () throws IOException
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();
            ArrayList<Long> arr = new ArrayList<Long>();
            for (int i = 0; i < n; i++) {
                long x = sc.nextInt();
                arr.add(x);
            }
            long m = sc.nextLong();

            System.out.println(findMinDiff(arr, n, m));
        }
    }
    private static long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        long min=Integer.MAX_VALUE, t;
        int N=(int)n;
        long[] temp = new long[N];
        int M=(int)m;
        int i;
        for(i=0;i<N;i++){
            temp[i]=a.get(i).intValue();
        }
        Arrays.sort(temp);
        for(i=0;i<=N-M;i++){
            t=temp[i+M-1]-temp[i];
            min=Math.min(min, t);
        }
        return min;
    }
}