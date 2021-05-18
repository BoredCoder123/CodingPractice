package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1

import java.lang.*;
import java.io.*;


public class ReaarangeArrayAlternatively {

    public static void callReaarangeArrayAlternatively() throws IOException {

// 		Scanner in = new Scanner(System.in);

// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            //size of array
            int n = Integer.parseInt(read.readLine());
            int[] temp = new int[n];

            String str[] = read.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++)
                temp[i] = Integer.parseInt(str[i]);

            // StringBuffer sb = new StringBuffer();

            o1rearrange(temp, n);
            StringBuffer sb = new StringBuffer();

            //appending and printing the elements
            for (int i = 0; i < n; i++)
                sb.append(temp[i] + " ");
            System.out.println(sb);
        }
    }

    private static void rearrange(int arr[], int n) {
        int i = 0;
        int[] temp = new int[n];
        for (i = 1; i < n; i += 2) {
            temp[i] = arr[i / 2];
        }
        for (i = 0; i < n; i += 2) {
            temp[i] = arr[n - 1 - i / 2];
        }
        for (i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    private static void o1rearrange(int arr[], int n){
        int max=n-1, min=0;
        int maxEle=arr[max]+1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                arr[i]+=(arr[max]%maxEle)*maxEle;
                max--;
            }else{
                arr[i]+=(arr[min]%maxEle)*maxEle;
                min++;
            }
        }
        for(int i=0;i<n;i++)
            arr[i]/=maxEle;
    }
}