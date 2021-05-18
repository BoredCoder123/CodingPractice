package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/minimum-platforms/0
import java.util.*;
import java.io.*;
import java.lang.*;

public class PlatformNeeded
{
    public static void callPlatformNeeded()throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int arr[] = new int[n];
            int dep[] = new int[n];

            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);

            System.out.println(findPlatform(arr, dep, n));
        }
    }
    private static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platNeeded = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                platNeeded++;
                i++;
            }

            else if (arr[i] > dep[j]) {
                platNeeded--;
                j++;
            }

            if (platNeeded > result)
                result = platNeeded;
        }

        return result;
    }
}