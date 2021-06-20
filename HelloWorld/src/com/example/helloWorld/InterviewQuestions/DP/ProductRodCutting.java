package com.example.helloWorld.InterviewQuestions.DP;

public class ProductRodCutting {
    public static void main(String[] args) {
        System.out.println(productRodCutting(10));
        System.out.println(productRodCutting(5));
    }

    private static int productRodCutting(int n) {
        if(n==2 || n==3)
            return n-1;
        int res=1;
        while(n>4){
            n-=3;
            res*=3;
        }
        return (n*res);
    }
}
