package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1#
import java.io.*;
import java.util.*;
import java.lang.*;


public class TrappingRainWater {

    public static void callTrappingRainWater () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            //calling trappingWater() function
            System.out.println(trappingWater(arr, n));
        }
    }
    private static int trappingWater(int arr[], int n) {
        int i, j, ans=0;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=arr[0];
        left[n-1]=0;
        right[0]=0;
        right[n-1]=arr[n-1];
        for(i=1;i<n-1;i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }
        for(i=n-2;i>0;i--){
            right[i]=Math.max(right[i+1],arr[i]);
        }
        for(i=1;i<n;i++){
            if(Math.min(left[i],right[i])-arr[i]>0)
                ans+=(Math.min(left[i],right[i])-arr[i]);
        }
        return ans;
    }
}