package com.example.helloWorld.InterviewQuestions.DP;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(palindromePartitioning("geek"));
        System.out.println(palindromePartitioning("abcde"));
        System.out.println(palindromePartitioning("aaaa"));
        System.out.println(palindromePartitioning("abbac"));
        System.out.println(palindromePartitioning("ababbbabbababa"));
    }

    private static int palindromePartitioning(String str) {
        int n=str.length(), i, j, l, k;
        int[][] c = new int[n][n];
        boolean[][] p = new boolean[n][n];
        for(i=0;i<n;i++){
            c[i][i]=0;
            p[i][i]=true;
        }
        for(l=1;l<n;l++){
            for(i=0,j=i+l;j<n;i++,j++){
                p[i][j]=str.charAt(i)==str.charAt(j);
                c[i][j]=(p[i][j]) ? 1 : 0;
                if(l>1){
                    p[i][j]&=p[i+1][j-1];
                }
                if(p[i][j])
                    c[i][j]=0;
                else{
                    c[i][j]=Integer.MAX_VALUE;
                    for(k=i;k<=j-1;k++) {
//                        System.out.println(i+" "+j+" "+k);
                        c[i][j] = Math.min(c[i][j], c[i][k] + c[k + 1][j] + 1);
                    }
                }
            }
        }
//        for(i=0;i<n;i++){
//            for(j=0;j<n;j++){
//                System.out.print(p[i][j]+" ");
//            }
//            System.out.println(" ");
//        }
        return c[0][n-1];
    }
}
