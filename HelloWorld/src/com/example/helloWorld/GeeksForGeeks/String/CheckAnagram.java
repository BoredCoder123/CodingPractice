package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/anagram-1587115620/1

import java.util.*;
import java.lang.*;
import java.io.*;


public class CheckAnagram {
    public static void callCheckAnagram() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            if(isAnagram(s1,s2))
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }



        }
    }


    public static boolean isAnagram(String a,String b)
    {
        a=a.toLowerCase();
        b=b.toLowerCase();
        int[] tempA=new int[26];
        int[] tempB=new int[26];
        int i;
        for(i=0;i<26;i++){
            tempA[i]=0;
            tempB[i]=0;
        }

        if(a.length()!=b.length())
            return false;
        else{
            for(i=0;i<a.length();i++){
                tempA[(int)a.charAt(i)-97]++;
                tempB[(int)b.charAt(i)-97]++;
            }
            for(i=0;i<26;i++){
                if(tempA[i]!=tempB[i]){
                    break;
                }
            }
            if(i==26)
                return true;
        }
        return false;
    }
}