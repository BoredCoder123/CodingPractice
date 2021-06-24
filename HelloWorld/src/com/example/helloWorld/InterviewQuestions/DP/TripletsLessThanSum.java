package com.example.helloWorld.InterviewQuestions.DP;

import java.util.*;

public class TripletsLessThanSum {
    public static void main(String[] args) {
        System.out.println(tripletsLessThanSum(new int[]{-2, 0, 1, 3}, 2));
        System.out.println(tripletsLessThanSum(new int[]{5, 1, 3, 4, 7}, 12));
    }

    private static int tripletsLessThanSum(int[] arr, int sum) {
        int c=0;
        int i, j, k, t, n=arr.length;
        Arrays.sort(arr);
        for(i=0;i<n-2;i++){
            t=sum-arr[i];
            j=i+1;
            k=n-1;
            while(j<k){
                if(arr[j]+arr[k]<t){
                    c+=k-j;
                    j++;
                }
                else
                    k--;
            }
        }
        return c;
    }
}
