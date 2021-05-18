package com.example.helloWorld.GeeksForGeeks.DivideAndConquer;

import java.io.*;
import java.util.*;

public class BinarySearch {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }

            int key =sc.nextInt();
            System.out.println(binarySearch(arr,n,key));
            T--;
        }
    }
    static int binarySearch(int arr[], int n, int k){
        int s=0, e=n-1;
        int mid=(s+e)/2;

        while(true){
            mid=(s+e)/2;
            if(arr[mid]==k){
                return mid;
            }else if(mid==s && mid==e)
                return -1;
            if(k>arr[mid]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
    }
}