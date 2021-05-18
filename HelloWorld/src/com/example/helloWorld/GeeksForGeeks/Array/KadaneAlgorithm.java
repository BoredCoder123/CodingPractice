package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1#
import java.io.*;

public class KadaneAlgorithm {
    public static void callKadaneAlgorithm () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(maxSubarraySum(arr, n));


        }
    }

    private static int maxSubarraySum(int arr[], int n){
        int max_so_far=arr[0], cur_max=arr[0], i;
        for(i=1;i<n;i++){
            if(cur_max+arr[i] > arr[i]){
                cur_max=arr[i]+cur_max;
            }else{
                cur_max=arr[i];
            }

            if(max_so_far<cur_max){
                max_so_far=cur_max;
            }
        }
        return max_so_far;
    }
}