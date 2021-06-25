package com.example.helloWorld.InterviewQuestions.Arrays;

public class LongestContiguousArray {
    public static void main(String[] args) {
        System.out.println(longestContiguousArray(new int[]{10, 12, 11}));
        System.out.println(longestContiguousArray(new int[]{14, 12, 11, 20}));
        System.out.println(longestContiguousArray(new int[]{1, 56, 58, 57, 90, 92, 94, 93, 91, 45}));
    }

    private static int longestContiguousArray(int[] arr) {
        int n=arr.length, max=1, i, j, mx, mn;
        for(i=0;i<n-1;i++){
            mx=arr[i]; mn=arr[i];
            for(j=i+1;j<n;j++){
                mx=Math.max(mx, arr[j]);
                mn=Math.min(mn, arr[j]);
                if(mx-mn==j-i)
                    max=Math.max(max, mx-mn+1);
            }
        }
        return max;
    }
}
