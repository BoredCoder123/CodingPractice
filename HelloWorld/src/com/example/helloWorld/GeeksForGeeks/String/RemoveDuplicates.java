package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1#
import java.io.*;
import java.util.*;

public class RemoveDuplicates {

    public static void callRemoveDuplicates() throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            String result = removeDups(s);

            System.out.println(result);
        }
    }

    private static String removeDups(String s) {
        int[] temp=new int[26];
        int i;
        for(i=0;i<26;i++)
            temp[i]=0;

        String ans="";
        for(i=0;i<s.length();i++){
            if(temp[(int)s.charAt(i)-97]==0){
                temp[(int)s.charAt(i)-97]++;
                ans+=s.charAt(i);
            }
        }
        return ans;
    }
}