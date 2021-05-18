package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
import java.util.*;
import java.io.*;

public class MergeWithoutExtraSpace {

    public static void callMergeWithoutExtraSpace () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            long arr1[] = new long[n];
            long arr2[] = new long[m];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr1[i] = Long.parseLong(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<m; i++){
                arr2[i] = Long.parseLong(inputLine[i]);
            }

            merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr1[i]+" ");
            }
            for(int i=0; i<m; i++){
                str.append(arr2[i]+" ");
            }
            System.out.println(str);
        }
    }

    private static void merge(long arr1[], long arr2[], int n, int m)
    {
        int i=0, j=0, k=n-1;
        long temp;
        while(i<=k && j<m){
            if(arr1[i]<arr2[j])
                i++;
            else{
                temp=arr1[k];
                arr1[k]=arr2[j];
                arr2[j]=temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}