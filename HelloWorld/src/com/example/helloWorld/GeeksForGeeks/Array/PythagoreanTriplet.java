package com.example.helloWorld.GeeksForGeeks.Array;

import java.io.*;
import java.util.Arrays;

public class PythagoreanTriplet {
    public static void callPythagoreanTriplet() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }

    private static boolean checkTriplet(int[] arr, int n) {
        int i, l, r;
        Arrays.sort(arr);
        for(i=0;i<n;i++)
            arr[i]=arr[i]*arr[i];

        for(i=n-1;i>=2;i--){
            l=0;
            r=i-1;
            while(l<r){
                if(arr[i]==arr[l]+arr[r])
                    return true;
                else if(arr[i]>arr[l]+arr[r])
                    l++;
                else
                    r--;
            }
        }
        return false;
    }
}