package com.example.helloWorld.GeeksForGeeks.Array;
//https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
import java.io.*;
import java.util.*;

public class CountTheTriplets {
    public static void callCountTheTriplets() throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter t: ");
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            System.out.print("Enter n: ");
            int n = Integer.parseInt(read.readLine());
            System.out.println("Enter the values: ");
            String input[] = read.readLine().split(" ");
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }

            System.out.println(countTriplet(arr, n));
        }
    }

    private static int countTriplet(int arr[], int n) {
        int max_val = 0;
        for (int i = 0; i < n; i++)
            max_val = Math.max(max_val, arr[i]);
        int[] freq = new int[max_val + 1];
        for (int i = 0; i < n; i++)
            freq[arr[i]]++;

        int ans = 0; // stores the number of ways

        // Case 1: 0, 0, 0
        ans += freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6;

        // Case 2: 0, x, x
        for (int i = 1; i <= max_val; i++)
            ans += freq[0] * freq[i] * (freq[i] - 1) / 2;

        // Case 3: x, x, 2*x
        for (int i = 1; 2 * i <= max_val; i++)
            ans += freq[i] * (freq[i] - 1) / 2 * freq[2 * i];

        // Case 4: x, y, x + y
        // iterate through all pairs (x, y)
        for (int i = 1; i <= max_val; i++) {
            for (int j = i + 1; i + j <= max_val; j++)
                ans += freq[i] * freq[j] * freq[i + j];
        }

        return ans;
    }
}

//0 0 0 0