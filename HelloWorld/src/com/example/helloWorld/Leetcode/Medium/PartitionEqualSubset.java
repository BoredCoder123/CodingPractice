package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/partition-equal-subset-sum/ Q416
public class PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int i, j, max=0, n=nums.length;
        for(i=0;i<n;i++){
            max+=nums[i];
        }
        if(max%2==1)
            return false;
        boolean[][] dp = new boolean[n][max+1];
        for(i=0;i<n;i++){
            for(j=0;j<=max;j++){
                dp[i][j]=false;
            }
        }
        for(i=0;i<n;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for(i=1;i<n;i++){
            if(nums[i]<=max)
                dp[i][nums[i]]=true;
            for(j=1;j<=max;j++){
                if(dp[i-1][j]){
                    dp[i][j]=true;
                    if(j+nums[i]<=max){
                        dp[i][j+nums[i]]=true;
                    }
                }
            }
        }
        return dp[n-1][max/2];
    }
}
