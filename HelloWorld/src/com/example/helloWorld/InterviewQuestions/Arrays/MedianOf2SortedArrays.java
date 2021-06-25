package com.example.helloWorld.InterviewQuestions.Arrays;

import java.util.Arrays;

public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        System.out.println(medianOf2SortedArrays(new int[]{-5, 3, 6, 12, 15}, new int[]{-12, -10, -6, -3, 4, 10}));
    }

    private static float medianOf2SortedArrays(int[] arr1, int[] arr2) {
        int n=arr1.length, m=arr2.length;
        if(m>n)
        return findMedianUtil(arr1, n, arr2, m);
        return findMedianUtil(arr2, m, arr1, n);
    }

    static float findMedianUtil(int[] A, int N, int[] B, int M) {

        if (N == 0)
            return medianSingle(B, M);

        if (N == 1) {

            if (M == 1)
                return MO2(A[0], B[0]);

            if (M % 2 == 1)
                return MO2(B[M / 2], (int) MO3(A[0],
                        B[M / 2 - 1], B[M / 2 + 1]));

            return MO3(B[M / 2], B[M / 2 - 1], A[0]);
        }

        else if (N == 2) {

            if (M == 2)
                return MO4(A[0], A[1], B[0], B[1]);

            if (M % 2 == 1)
                return MO3(B[M / 2], Math.max(A[0], B[M / 2 - 1]),
                        Math.min(A[1], B[M / 2 + 1]));

            return MO4(B[M / 2], B[M / 2 - 1],
                    Math.max(A[0], B[M / 2 - 2]),
                    Math.min(A[1], B[M / 2 + 1]));
        }

        int idxA = (N - 1) / 2;
        int idxB = (M - 1) / 2;

        if (A[idxA] <= B[idxB])
            return findMedianUtil(Arrays.copyOfRange(A, idxA, A.length),
                    N / 2 + 1, B, M - idxA);

        return findMedianUtil(A, N / 2 + 1,
                Arrays.copyOfRange(B, idxB, B.length), M - idxA);
    }

    private static float MO3(int i, int i1, int i2) {
        return (float)(i+i1+i2)-Math.max(i, Math.max(i1, i2))-Math.min(i, Math.min(i1, i2));
    }

    private static float MO4(int a, int b, int c, int d){
        return (float)(((a+b+c+d)-Math.max(a, Math.max(b, Math.max(c,d)))- Math.min(a, Math.min(b, Math.min(c,d))))/2.0);
    }

    private static float MO2(int i, int i1) {
        return (float)((i+i1)/2.0);
    }

    private static float medianSingle(int[] arr, int n) {
        if(n%2==0){
            return (float)((double)(arr[n/2]+arr[n/2-1])/2);
        }
        return (float)(arr[n/2]);
    }
}
