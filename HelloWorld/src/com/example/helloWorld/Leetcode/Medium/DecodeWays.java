package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/decode-ways/ Q91
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp =new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        if(s.charAt(0)=='0')
            return 0;
        for(int i=1;i<s.length();i++){
            int c=s.charAt(i);
            int p=s.charAt(i-1);

            if(c=='0'&& (p=='0' || p>'2'))
                return 0;
            if(p=='0')
                dp[i+1]=dp[i];
            else if(p=='1'){
                if(c=='0')
                    dp[i+1]=dp[i-1];
                else
                    dp[i+1]=dp[i]+dp[i-1];
            }else if(p=='2'){
                if(c=='0')
                    dp[i+1]=dp[i-1];
                else if(c<='6')
                    dp[i+1]=dp[i]+dp[i-1];
                else
                    dp[i+1]=dp[i];
            }else
                dp[i+1]=dp[i];
        }
        for(int i=0;i<=s.length();i++)
            System.out.print(dp[i]+" ");
        System.out.println(" ");
        return dp[s.length()];
    }
}
