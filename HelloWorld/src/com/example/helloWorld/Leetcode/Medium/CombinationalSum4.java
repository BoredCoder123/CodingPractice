package com.example.helloWorld.Leetcode.Medium;

import java.util.Arrays;

//https://leetcode.com/problems/combination-sum-iv/ Question 377
public class CombinationalSum4 {
    public int combinationSum4(int[] nums, int target) {
        int i, j;
        int[] dp = new int[target+1];
        Arrays.sort(nums);
        for(i=0;i<=target;i++)
            dp[i]=0;

        dp[0]=1;

        for(i=1;i<=target;i++){
            for(j=0;j<nums.length && nums[j]<=i;j++){
                dp[i]+=dp[i-nums[j]];
                System.out.print(dp[i]+" ");
            }
            System.out.println(" ");
        }
        return dp[target];
    }
}
