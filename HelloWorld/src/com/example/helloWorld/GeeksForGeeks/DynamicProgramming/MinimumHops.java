package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#
// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class MinimumHops
{
    public static void main (String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(originalMinJumps(arr));
        }
    }

    static int originalMinJumps(int[] arr){
        int i, j, cnt=0, n=arr.length, max=0;
        if(n==0)
            return 0;
        else if(n==1){
            return 1;
        }
        for(i=0;i<n;i++){
            max=i+arr[i];
            for(j=i;j<(arr[i]+i) && j<n;j++){
                // System.out.println("1) "+i+" "+j+" "+max);
                if(j>=(n-1)){
                    i=n;
                    break;
                }else{
                    max=Math.max(max, arr[j]+j);
                }
                // System.out.println("2) "+i+" "+j+" "+max);
            }
            // System.out.println(cnt+" "+i);
            cnt++;
            i=max-1;
        }
        return cnt+1;
    }

    static int optimizedMinJumps(int[] arr){
        if (arr.length <= 1)
            return 0;

        if (arr[0] == 0)
            return -1;


        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                return jump;

            maxReach = Math.max(maxReach, i + arr[i]);

            step--;

            if (step == 0) {
                jump++;

                if (i >= maxReach)
                    return -1;

                step = maxReach - i;
            }
        }

        return -1;
    }
}
