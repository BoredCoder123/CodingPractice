package com.example.helloWorld.InterviewQuestions.Arrays;

public class PossibleFrom2SortedArrays {
    public static void main(String[] args) {
        generate(new int[]{10, 15, 25}, new int[]{1, 5, 20, 30});
    }

    private static void generateUtil(int[] A, int[] B, int[] C, int i, int j, int m, int n,
                      int len, boolean flag)
    {
        if (flag)
        {
            if (len != 0){
                for(int z=0;z<=len;z++)
                    System.out.print(C[z]+" ");
                System.out.println(" ");
            }

            for (int k = i; k < m; k++)
            {
                if (len == 0)
                {
                    C[len] = A[k];

                    generateUtil(A, B, C, k + 1, j, m, n, len, !flag);
                }

                else if (A[k] > C[len])
                {
                    C[len + 1] = A[k];
                    generateUtil(A, B, C, k + 1, j, m, n, len + 1, !flag);
                }
            }
        }

        else
        {
            for (int l = j; l < n; l++)
            {
                if (B[l] > C[len])
                {
                    C[len + 1] = B[l];
                    generateUtil(A, B, C, i, l + 1, m, n, len + 1, !flag);
                }
            }
        }
    }

    private static void generate(int[] A, int[] B)
    {
        int m=A.length, n=B.length;
        int C[] = new int[m + n];
        generateUtil(A, B, C, 0, 0, m, n, 0, true);
    }

}
