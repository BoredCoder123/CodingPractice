package com.example.helloWorld.GeeksForGeeks.Array;

import java.io.*;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
public class Sort012 {

    public static void callSort012 () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }

    public static void sort012(int a[], int n)
    {
        int[] temp= new int[3];
        int i;
        for(i=0;i<n;i++){
            temp[a[i]]++;
        }
        int j=0;
        for(i=0;i<temp[0];i++){
            a[j]=0;
            j++;
        }
        for(i=0;i<temp[1];i++){
            a[j]=1;
            j++;
        }
        for(i=0;i<temp[2];i++){
            a[j]=2;
            j++;
        }
    }
}