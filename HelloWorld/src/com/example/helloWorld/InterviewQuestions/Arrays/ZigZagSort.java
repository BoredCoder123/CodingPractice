package com.example.helloWorld.InterviewQuestions.Arrays;

public class ZigZagSort {
    public static void main(String[] args) {
        zigZagSort(new int[]{4, 3, 7, 8, 6, 2, 1});
        zigZagSort(new int[]{1, 4, 3, 2});
    }

    private static void print(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println(" ");
    }

    private static void zigZagSort(int[] arr) {
        boolean flag=true;
        for(int i=0;i<arr.length-1;i++){
            if(flag){
                if(arr[i]>arr[i+1]){
                    arr[i]+=arr[i+1];
                    arr[i+1]=arr[i]-arr[i+1];
                    arr[i]-=arr[i+1];
                    flag=false;
                }
            }else{
                if(arr[i]<arr[i+1]){
                    arr[i]+=arr[i+1];
                    arr[i+1]=arr[i]-arr[i+1];
                    arr[i]-=arr[i+1];
                    flag=true;
                }
            }
        }
        print(arr);
    }
}
