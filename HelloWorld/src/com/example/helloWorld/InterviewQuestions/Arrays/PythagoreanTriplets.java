package com.example.helloWorld.InterviewQuestions.Arrays;

import java.util.Arrays;

public class PythagoreanTriplets {
    public static void main(String[] args) {
        System.out.println(pythagoreanTriplets(new int[]{3, 1, 4, 6, 5}));
        System.out.println(pythagoreanTriplets(new int[]{10, 4, 6, 12, 5}));
        System.out.println(pythagoreanTriplets(new int[]{10, 4, 6, 12, 8}));
    }

    private static boolean pythagoreanTriplets(int[] arr) {
        int n=arr.length, i, j, k;
        Arrays.sort(arr);
        for(i=0;i<n;i++)
            arr[i] *= arr[i];
        for(i=n-1;i>=2;i--){
            j=0; k=i-1;
            while(j<k){
                if(arr[i]==arr[j]+arr[k])
                    return true;
                else if(arr[i]>arr[j]+arr[k])
                    j++;
                else
                    k--;
            }
        }
        return false;
    }
}
