package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/submissions/ Q673
import java.util.Arrays;

public class LengthOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int n = nums.length;

        int[] dp_l = new int[n];
        Arrays.fill(dp_l, 1);

        int[] dp_c = new int[n];
        Arrays.fill(dp_c, 1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){

                if (nums[i] <= nums[j])
                    continue;

                if (dp_l[j] + 1 > dp_l[i]){
                    dp_l[i] = dp_l[j] + 1;
                    dp_c[i] = dp_c[j];
                }
                else if (dp_l[j] + 1 == dp_l[i])
                    dp_c[i] += dp_c[j];
            }
        }

        int max_length = 0;

        for(int i : dp_l)
            max_length = Math.max(i, max_length);

        int count = 0;

        for(int i = 0; i < n; i++){

            if (dp_l[i] == max_length)
                count += dp_c[i];
        }

        return count;
    }
}
