package com.example.helloWorld.InterviewQuestions.Arrays;

public class SmallestNotPossibleSum {
    public static void main(String[] args) {
        System.out.println(smallestNotPossible(new int[]{1, 3, 6, 10, 11, 15}));
        System.out.println(smallestNotPossible(new int[]{1, 1, 1, 1}));
        System.out.println(smallestNotPossible(new int[]{1, 1, 3, 4}));
        System.out.println(smallestNotPossible(new int[]{1, 2, 5, 10, 20, 40}));
        System.out.println(smallestNotPossible(new int[]{1, 2, 3, 4, 5, 6}));
    }

    private static int smallestNotPossible(int[] arr) {
        int res=1;
        for(int i=0;i<arr.length && res>=arr[i];i++)
            res+=arr[i];
        return res;
    }
}
