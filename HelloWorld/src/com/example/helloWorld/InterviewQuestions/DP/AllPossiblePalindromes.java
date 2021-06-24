package com.example.helloWorld.InterviewQuestions.DP;

import java.util.*;

public class AllPossiblePalindromes {
    public static void main(String[] args) {
        System.out.println(allPossiblePalindromes("nitin"));
        System.out.println(allPossiblePalindromes("geeks"));
    }

    private static ArrayList<String> allPossiblePalindromes(String str) {
        ArrayList<String> ans = new ArrayList<>();
        int l, i, j, n=str.length();
        boolean[][] p = new boolean[n][n];
        for(i=0;i<n;i++){
            p[i][i]=true;
            ans.add(str.substring(i, i+1));
        }
        for(l=1;l<n;l++){
            for(i=0,j=i+l;j<n;i++,j++){
                p[i][j]=str.charAt(i)==str.charAt(j);
                if(l>1){
                    p[i][j]&=p[i+1][j-1];
                }
                if(p[i][j]){
                    ans.add(str.substring(i, j+1));
                }
            }
        }
        return ans;
    }
}
