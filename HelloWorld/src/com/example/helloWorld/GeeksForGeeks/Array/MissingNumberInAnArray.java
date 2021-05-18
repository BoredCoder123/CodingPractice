package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
import java.io.*;
import java.util.*;

public class MissingNumberInAnArray {
    public static void callMissingNumberInAnArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            System.out.println(MissingNumber(array, n));
        }
    }

    private static int MissingNumber(int array[], int n) {
        int i;
        int[] temp = new int[n];
        for(i=0;i<n-1;i++)
            temp[array[i]-1]++;
        for(i=0;i<n;i++){
            if(temp[i]==0)
                return i+1;
        }
        return n;
    }
}