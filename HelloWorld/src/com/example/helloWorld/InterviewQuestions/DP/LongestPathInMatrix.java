package com.example.helloWorld.InterviewQuestions.DP;

public class LongestPathInMatrix {
    public static void main(String[] args) {
        System.out.println(longestPathInMatrix(new int[][]{{1,2,9}, {5,3,8}, {4,6,7}}));
    }

    private static int longestPathInMatrix(int[][] arr) {
        int result = 1;
        int n=arr.length, m=arr[0].length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    longestPathInMatrixUtil(i, j, arr, dp);
                }

                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }

    private static int longestPathInMatrixUtil(int i, int j, int[][] arr, int[][] dp) {
        int n=arr.length, m=arr[0].length;
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int w=0,x=0,y=0,z=0;
        if (j < m - 1 && ((arr[i][j] + 1) == arr[i][j + 1])) {
            x = dp[i][j] = 1 + longestPathInMatrixUtil(i, j + 1, arr, dp);
        }

        if (j > 0 && (arr[i][j] + 1 == arr[i][j - 1])) {
            y = dp[i][j] = 1 + longestPathInMatrixUtil(i, j - 1, arr, dp);
        }

        if (i > 0 && (arr[i][j] + 1 == arr[i - 1][j])) {
            z = dp[i][j] = 1 + longestPathInMatrixUtil(i - 1, j, arr, dp);
        }

        if (i < n - 1 && (arr[i][j] + 1 == arr[i + 1][j])) {
            w = dp[i][j] = 1 + longestPathInMatrixUtil(i + 1, j, arr, dp);
        }
        dp[i][j] = Math.max(x, Math.max(y, Math.max(z, Math.max(w, 1))));
        return dp[i][j];
    }
}
