package com.example.helloWorld.InterviewQuestions.DP;

public class NumberOfWaysToCoverDistance {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToCoverDistance(3));
        System.out.println(numberOfWaysToCoverDistance(4));
        System.out.println(numberOfWaysToCoverDistance(5));
        System.out.println(numberOfWaysToCoverDistance(6));
    }

    private static int numberOfWaysToCoverDistance(int i) {
        if(i<0)
            return 0;
        if(i==0)
            return 1;
        if(i==1)
            return 1;
        if(i==2)
            return 2;
        if(i==3)
            return 4;
        int[] dp = new int[i+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int idx=4;idx<=i;idx++)
            dp[idx]=dp[idx-1]+dp[idx-2]+dp[idx-3];
        return dp[i];
    }
}
