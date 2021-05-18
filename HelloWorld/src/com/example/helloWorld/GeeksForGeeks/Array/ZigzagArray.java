package com.example.helloWorld.GeeksForGeeks.Array;

import java.util.*;
import java.io.*;

public class ZigzagArray {
    public static void callZigzagArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            zigZag(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
    private static void zigZag(int arr[], int n) {
        int i, temp;
        Boolean flag=true;
        for(i=0;i<n-1;i++){
            if(flag){
                if(arr[i]>arr[i+1]){
                    temp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
                flag=false;
            }else{
                if(arr[i]<arr[i+1]){
                    temp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
                flag=true;
            }
        }
    }
}