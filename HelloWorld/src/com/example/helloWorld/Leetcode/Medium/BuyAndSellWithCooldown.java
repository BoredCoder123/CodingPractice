package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/ Q309
public class BuyAndSellWithCooldown {
    public int maxProfit(int[] prices) {
        int i, n=prices.length;
        if(n<=1)
            return 0;
        else if(n==2){
            if(prices[1]>prices[0])
                return prices[1]-prices[0];
            else
                return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0]=0;  //[i][0]- This means no stock on day i
        dp[0][1]=-prices[0];   //[i][1] This means stock present on day i
        dp[1][0]=Math.max(dp[0][0], dp[0][1]+prices[1]);
        dp[1][1]=Math.max(dp[0][1], dp[0][0]-prices[1]);

        for(i=2;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }

        return dp[n-1][0];
    }
}
