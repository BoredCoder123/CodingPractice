package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/unsorted-array4925/1
import java.io.*;
import java.util.*;

public class LeftSideGreaterRightSideSmaller {
    public static void callLeftSideGreaterRightSideSmaller() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(findElement(a, n));

        }
    }

    public static int findElement(int arr[], int n){
        Boolean[] left= new Boolean[n];
        Boolean[] right= new Boolean[n];
        int max=arr[0], i;
        for(i=0;i<n;i++){
            left[i]=false;
            right[i]=false;
        }
        for(i=1;i<n-1;i++){
            if(arr[i]>=max){
                left[i]=true;
                max=arr[i];
            }
        }
        max=arr[i];
        for(i=n-2;i>0;i--){
            if(arr[i]<=max){
                max=arr[i];
                right[i]=true;
            }
        }
        for(i=1;i<n-1;i++){
            if(left[i] && right[i]){
                return arr[i];
            }
        }
        return -1;
    }
}