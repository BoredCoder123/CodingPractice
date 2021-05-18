package com.example.helloWorld.GeeksForGeeks.DivideAndConquer;
//https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1
import java.util.*;

public class OnlyOnce
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }

            System.out.println(findOnce(arr, n));
        }
    }
    static int findOnce(int arr[], int n)
    {
        return findOnceUtil(arr, 0, n-1);
    }

    static int findOnceUtil(int[] arr, int s, int e){
        if(s==e)
            return arr[s];
        else{
            int mid=(s+e)/2;

            if(mid%2==0){
                if(arr[mid]==arr[mid+1]){
                    return findOnceUtil(arr, mid+2, e);
                }else{
                    return findOnceUtil(arr, s, mid);
                }
            }else{
                if(arr[mid]==arr[mid-1])
                    return findOnceUtil(arr, mid+1, e);
                else
                    return findOnceUtil(arr, s, mid-1);
            }
        }
    }
}
