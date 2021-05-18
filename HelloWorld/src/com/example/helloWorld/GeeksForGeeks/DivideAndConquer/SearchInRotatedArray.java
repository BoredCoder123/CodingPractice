package com.example.helloWorld.GeeksForGeeks.DivideAndConquer;
//https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
import java.util.*;

public class SearchInRotatedArray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];

            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();

            System.out.println(search(A, 0, n - 1, key));
        }
    }

    static int search(int arr[], int l, int h, int key)
    {
        if(l>h)
            return -1;

        int mid=(l+h)/2;

        if(arr[mid]==key)
            return mid;

        if(arr[l]<=arr[mid]){
            if(key>=arr[l] && key<arr[mid])
                return search(arr, l, mid-1, key);
            else
                return search(arr, mid+1, h, key);
        }

        if(key>arr[mid] && key<=arr[h])
            return search(arr, mid+1, h, key);
        return search(arr, l, mid-1, key);
    }
}