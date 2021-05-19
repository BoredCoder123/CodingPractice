package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/jump-game Q55
public class JumpGame {
    public static void main(String[] args) {
        int[] nums={3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;
        if (nums[0] == 0)
            return false;

        int i, j, max = 0, maxI = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                return false;
            if (i + nums[i] >= nums.length - 1)
                return true;
            for (j = i + 1; j <= i + nums[i]; j++) {
                if (j >= nums.length)
                    return true;
                else {
                    if (j + nums[j] >= max) {
                        max = j + nums[j];
                        maxI = j;
                    }
                }
            }
            i = maxI - 1;
            if (i >= nums.length - 1)
                return true;
        }

        return true;
    }

    public static boolean greedyJumpGame(int[] nums){
        if(nums.length<2)
            return true;
        if(nums[0]==0)
            return false;

        int last=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=last){
                last=i;
            }
        }

        if(last==0)
            return true;
        else
            return false;
    }
}
