package com.example.helloWorld.GeeksForGeeks.Array;

import java.io.*;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
public class EquilibriumPoint {
    public static void callEquilibriumPoint() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            System.out.println(equilibriumPoint(arr, n));
        }
    }

    public static int equilibriumPoint(long arr[], int n) {
        if(n==1){
            return 1;
        }else{
            long lSum=0, rSum=0;
            int i;
            lSum=arr[0];
            for(i=2;i<n;i++){
                rSum+=arr[i];
            }
            for(i=1;i<n-1;i++){
                if(lSum==rSum){
                    return (i+1);
                }else{
                    lSum+=arr[i];
                    rSum-=arr[i+1];
                }
            }
        }
        return -1;
    }
}







