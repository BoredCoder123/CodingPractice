package com.example.helloWorld.InterviewQuestions.Arrays;

public class SmallestArrayMoreThanSum {
    public static void main(String[] args) {
        System.out.println(smallestArrayMoreThanSum(new int[]{1, 4, 45, 6, 0, 19}, 51));
        System.out.println(smallestArrayMoreThanSum(new int[]{1, 10, 5, 2, 7}, 9));
        System.out.println(smallestArrayMoreThanSum(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280));
        System.out.println(smallestArrayMoreThanSum(new int[]{1, 2, 4}, 8));
    }

    private static int smallestArrayMoreThanSum(int[] arr, int sum) {
        int n=arr.length, currSum=0, min=n+1, i=0, j=0;
        while(j<n){
            while(currSum<=sum && j<n) {
                currSum += arr[j];
                j++;
            }

            while(currSum>sum && i<n){
                min=Math.min(min, j-i);
                currSum-=arr[i];
                i++;
            }
        }
        return min;
    }
}
