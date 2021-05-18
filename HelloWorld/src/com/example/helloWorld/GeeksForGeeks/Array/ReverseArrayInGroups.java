package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1
import java.io.*;
import java.util.*;

public class ReverseArrayInGroups {
    public static void callReverseArrayInGroups () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

        //while testcases exist
        while(t-->0){

            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);

            ArrayList<Integer> arr = new ArrayList<>();
            String inputLine2[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(inputLine2[i]));
            }

            reverseInGroups(arr, n, k);

            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
    private static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int[] temp=new int[n];
        int[] rev=new int[n];
        int i, j, z;
        for(i=0;i<n;i++){
            temp[i]=arr.get(i).intValue();
        }
        for(i=k;i<n;i+=k){
            for(j=0;j<k;j++){
                rev[i-k+j]=temp[i-j-1];
            }
        }
        // System.out.println(i+" "+k+" "+n);
        if(i-k==n-1){
            rev[n-1]=temp[n-1];
        }else{
            z=0;
            for(i=i-k;i<n;i++){
                // System.out.println(i+" "+z+" "+(n-1-z));
                rev[n-1-z]=temp[i];
                z++;
            }
        }
        // for(i=0;i<n;i++)
        //     System.out.println(rev[i]);
        arr.clear();
        for(i=0;i<n;i++){
            arr.add(rev[i]);
        }
    }
}

