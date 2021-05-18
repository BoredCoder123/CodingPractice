package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1#
import java.io.*;
import java.util.*;

public class LongestDistinctCharInString {

    public static void callLongestDistinctCharInString()throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();

            System.out.println(longestSubstrDitinctChars(S));
        }
    }

    private static int longestSubstrDitinctChars(String s){
        int i, j, k, curAns=0, maxAns=0;
        for(i=0;i<s.length()-1;i++){
            Boolean[] temp = new Boolean[256];
            for(k=0;k<256;k++)
                temp[k]=false;
            curAns=0;
            for(j=i;j<s.length();j++){
                if(temp[(int)s.charAt(j)]){
                    break;
                }
                else{
                    curAns=j-i+1;
                    temp[(int)s.charAt(j)]=true;
                }
            }
            maxAns=Math.max(curAns, maxAns);
        }
        return maxAns;
    }
}