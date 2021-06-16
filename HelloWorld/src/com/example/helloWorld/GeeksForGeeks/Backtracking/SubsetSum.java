package com.example.helloWorld.GeeksForGeeks.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,4};
        List<Integer> ans= new ArrayList<>();
        if(subsetSum(arr, 9, ans)) {
            System.out.println("Y");
            System.out.println(ans);
        }
        else
            System.out.println("N");
    }

    private static boolean subsetSum(int[] arr, int sum, List<Integer> ans) {
        int n= arr.length, i, j;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(i=0;i<=n;i++)
            dp[i][0]=true;
        for(i=1;i<=sum;i++)
            dp[0][i]=false;
        for(i=1;i<=n;i++){
            for(j=1;j<=sum;j++){
                if(arr[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
//        for(i=0;i<=n;i++){
//            for(j=0;j<=sum;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println(" ");
//        }

        int tSum=sum;
        i=n;
        if(dp[n][sum]){
            while(tSum>0){
                if(i==1) {
                    ans.add(arr[i - 1]);
                    return true;
                }
                while(dp[i][tSum])
                    i--;
                ans.add(arr[i]);
                tSum-=arr[i];
                i++;
            }
        }

        return dp[n][sum];
    }
}
