package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/counting-bits/submissions/ Q.338
public class CountingBits {
    public int[] countBits(int num) {
        int[] dp= new int[num+1];
        if(num==0){
            dp[0]=0;
            return dp;
        }else if(num==1){
            dp[0]=0;
            dp[1]=1;
            return dp;
        }
        dp[0]=0;
        dp[1]=1;
        int pow=1;
        int p=1;
        for(int i=1;i<=num;i++){
            if(i==pow){
                dp[i]=1;
                pow<<=1;
                p=1;
            }else{
                dp[i]=dp[p]+1;
                p++;
            }
        }
        return dp;
    }
}
