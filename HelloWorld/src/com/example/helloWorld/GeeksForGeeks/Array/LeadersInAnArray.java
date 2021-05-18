package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1#
import java.io.*;
import java.util.*;

public class LeadersInAnArray {
    public static void callLeadersInAnArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

        while(t-->0){

            //input size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //inserting elements in the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            StringBuffer str = new StringBuffer();
            ArrayList<Integer> res = new ArrayList<Integer>();

            res = leaders(arr, n);

            //appending result to a String
            for(int i=0; i<res.size(); i++){
                str.append(res.get(i)+" ");
            }

            //printing the String
            System.out.println(str);
        }

    }

    static ArrayList<Integer> leaders(int arr[], int n){
        int i, max=arr[n-1];
        ArrayList<Integer> ans= new ArrayList<Integer>();
        ans.add(arr[n-1]);
        for(i=n-2;i>=0;i--){
            if(arr[i]>=max){
                max=arr[i];
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}