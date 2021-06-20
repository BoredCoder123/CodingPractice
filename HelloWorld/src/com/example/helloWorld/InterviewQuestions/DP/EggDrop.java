package com.example.helloWorld.InterviewQuestions.DP;

public class EggDrop {
    public static void main(String[] args) {
        System.out.println(eggDrop(3, 36));
    }

    static int eggDrop(int n, int k)
    {
        int eggFloor[][] = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        for (i = 1; i <= n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;

        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(
                            eggFloor[i - 1][x - 1],
                            eggFloor[i][j - x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
        for(i=0;i<=n;i++){
            for(j=0;j<=k;j++)
                System.out.printf("%2d ",eggFloor[i][j]);
            System.out.println(" ");
        }
        return eggFloor[n][k];
    }
}
