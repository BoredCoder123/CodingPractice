package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
import java.util.*;
import java.lang.*;
import java.io.*;

public class ReverseWordsInAString {
    public static void callReverseWordsInAString() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            System.out.println(reverseWords(s));
            t--;
        }
    }

    private static String reverseWords(String S)
    {
        String ans="", temp="";
        int i, start, end=S.length()-1;
        for(i=S.length()-1;i>=0;i--){
            if(S.charAt(i)=='.'){
                start=i+1;
                ans+=S.substring(start,end+1);
                end=i-1;
                ans+=".";
            }
        }
        ans+=S.substring(0,end+1);
        return ans;
    }
}