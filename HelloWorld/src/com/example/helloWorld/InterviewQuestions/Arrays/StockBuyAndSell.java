package com.example.helloWorld.InterviewQuestions.Arrays;

public class StockBuyAndSell {
    public static void main(String[] args) {
        stockBuyAndSell1(new int[]{100, 180, 260, 310, 40, 535, 695});
        stockBuyAndSell2(new int[]{100, 180, 260, 310, 40, 535, 695});
        stockBuyAndSell3(new int[]{100, 180, 260, 310, 40, 535, 695});
        stockBuyAndSell3(new int[]{1,2,3,4,5});
        stockBuyAndSell3(new int[]{5,4,3,2,1});
        stockBuyAndSell4(new int[]{100, 180, 260, 310, 40, 535, 695}, 2);
        stockBuyAndSell4(new int[]{1,2,3,4,5},2);
        stockBuyAndSell4(new int[]{5,4,3,2,1}, 2);
        stockBuyAndSell4(new int[]{100, 180, 260, 310, 40, 535, 695}, 1);
        stockBuyAndSell4(new int[]{1,2,3,4,5},1);
        stockBuyAndSell4(new int[]{5,4,3,2,1}, 1);
        System.out.println(5+" "+stockBuyAndSell5(new int[]{100, 180, 260, 310, 40, 535, 695}));
        System.out.println(5+" "+stockBuyAndSell5(new int[]{1,2,3,4,5}));
        System.out.println(5+" "+stockBuyAndSell5(new int[]{5,4,3,2,1}));
    }

    private static void stockBuyAndSell1(int[] arr) {   //Single buy
        int min=arr[0], i, max=0, n=arr.length;
        for(i=1;i<n;i++){
            min=Math.min(arr[i], min);
            max=Math.max(max, arr[i]-min);
        }
        System.out.println(1+" "+max);
    }

    private static void stockBuyAndSell2(int[] arr){    //Can buy any number of times
        int i, p=0, n=arr.length;
        for(i=1;i<n;i++){
            p+=Math.max(0, arr[i]-arr[i-1]);
        }
        System.out.println(2+" "+p);
    }

    private static void stockBuyAndSell3(int[] arr){    //Can buy and sell only 2 times
        int i, fBuy=Integer.MIN_VALUE, fSell=0, sBuy=Integer.MIN_VALUE, sSell=0, n=arr.length;
        for(i=0;i<n;i++){
            fBuy=Math.max(fBuy, -arr[i]);
            fSell=Math.max(fSell, fBuy+arr[i]);
            sBuy=Math.max(sBuy, fSell-arr[i]);
            sSell=Math.max(sSell, sBuy+arr[i]);
//            System.out.println(fBuy+" "+fSell+" "+sBuy+" "+sSell);
        }
        System.out.println(3+" "+sSell);
    }

    private static void stockBuyAndSell4(int[] arr, int k){    //Can buy and sell k times
        int i, j, n=arr.length;
        if(k>n/2)
            stockBuyAndSell2(arr);
        else{
            int[] buy = new int[k], sell=new int[k];
            for(i=0;i<k;i++){
                buy[i]=Integer.MIN_VALUE;
                sell[i]=0;
            }
            for(i=0;i<n;i++){
                for(j=0;j<k;j++){
                    buy[j]=Math.max(buy[j], j==0?-arr[i]: sell[j-1]-arr[i]);
                    sell[j]=Math.max(sell[j], buy[j]+arr[i]);
                }
            }
            System.out.println(4+" "+sell[k-1]);
        }
    }

    private static int stockBuyAndSell5(int[] arr){
        int i, n=arr.length;
        int[][] dp = new int[n][2];
        for(i=0;i<n;i++){
            dp[i][0]=0;
            dp[i][1]=Integer.MIN_VALUE;
        }
        dp[0][1]=-arr[0];
        dp[1][0]=Math.max(dp[0][0], dp[0][1]+arr[1]);
        dp[1][1]=Math.max(dp[0][1], dp[0][0]-arr[1]);
        for(i=2;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
            dp[i][1]=Math.max(dp[i-1][1], dp[i-2][0]-arr[i]);
        }
        return dp[n-1][0];
    }
}
