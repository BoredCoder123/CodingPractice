package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
import java.io.*;
import java.util.*;

public class LongestCommonPrefix {

    public static void callLongestCommonPrefix()throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");
            System.out.println(longestCommonPrefix(arr, n));
        }
    }

    private static String longestCommonPrefix(String arr[], int n){
        String ans="";
        int i, j, min=Integer.MAX_VALUE;
        Boolean flag=true;
        char val='a';
        for(i=0;i<n;i++){
            if(arr[i].length()<min)
                min=arr[i].length();
        }

        for(i=0;i<min;i++){
            val=arr[0].charAt(i);
            for(j=1;j<n;j++){
                if(arr[j].charAt(i)!=val){
                    flag=false;
                    break;
                }
            }
            if(flag)
                ans+=val;
            else
                break;
        }
        if(ans.equals(""))
            return "-1";
        else
            return ans;
    }
}