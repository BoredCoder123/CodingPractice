package com.example.helloWorld.Sorting;

import com.example.helloWorld.Utils.UtilsClass;

public class MergeSort {
    public static void callMergeSort(){
        int[] array={4,6,7,8,4,2,5,1};
        UtilsClass.printArray(array);
        mergeSort(array, 0, array.length-1);
        UtilsClass.printArray(array);
    }

    private static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Copy data to temp arrays L[] and R[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays back into arr[l..r]

        // Initial index of first subarray
        int i = 0;

        // Initial index of second subarray
        int j = 0;

        // Initial index of merged subarray
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of
        // L[], if there are any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of
        // R[], if there are any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // l is for left index and r is
// right index of the sub-array
// of arr to be sorted */
    private static void mergeSort(int arr[],int l,int r){
        if(l>=r){
            return;//returns recursively
        }
        int m =l+ (r-l)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
    }
}
