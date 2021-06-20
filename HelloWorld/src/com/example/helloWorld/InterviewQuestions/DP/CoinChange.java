package com.example.helloWorld.InterviewQuestions.DP;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,3}, 6));
        System.out.println(coinChange(new int[]{2, 5, 3, 6}, 10));
    }

    private static int coinChange(int[] arr, int cap) {
        int n=arr.length, i, j;
//        int[][] dp = new int[n+1][cap+1];
//        for(i=0;i<=n;i++)
//            dp[i][0]=1;
//        for(i=1;i<=cap;i++)
//            dp[0][i]=0;
//        for(i=1;i<=n;i++){
//            for(j=1;j<=cap;j++){
//                dp[i][j]=dp[i-1][j];
//                if(i==1){
//                    if(j%arr[i-1]==0)
//                        dp[i][j]=1;
//                    else
//                        dp[i][j]=0;
//                }else{
//                    if(j>=arr[i-1]){
//                        if(j-dp[i][j-arr[i-1]]!=0){
//                            dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];
//                        }
//                    }
//                }
//            }
//        }
//        return dp[n][cap];
        int table[]=new int[cap+1];
        table[0] = 1;
        for(i=0; i<n; i++)
            for(j=arr[i]; j<=cap; j++)
                table[j] += table[j-arr[i]];

        return table[cap];
    }
}
