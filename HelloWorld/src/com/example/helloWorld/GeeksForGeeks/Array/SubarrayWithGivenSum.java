package com.example.helloWorld.GeeksForGeeks.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class SubarrayWithGivenSum{
    public static void callSubarrayWithGivenSum() {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}

class Solution{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int start=1, end=0, temp_s=0;
        Boolean isMatch=false;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(isMatch){
                break;
            }
            temp_s+=arr[i];
            if(temp_s==s){
                end=i+1;
                list.add(start);
                list.add(end);
                isMatch=true;
                break;
            }else if(temp_s<s){
                continue;
            }else{
                while(temp_s>s){
                    temp_s-=arr[start-1];
                    start++;
                    if(temp_s==s){
                        end=i+1;
                        list.add(start);
                        list.add(end);
                        isMatch=true;
                        break;
                    }
                }
            }
        }
        if(isMatch)
            return list;
        else{
            list.add(-1);
            return list;
        }
    }
}