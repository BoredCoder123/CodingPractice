package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1#

import java.io.*;

public class RecursiveRemovalOfAdjacentDuplicates {

    public static void callRecursiveRemovalOfAdjacentDuplicates () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            String S = br.readLine();
            System.out.println(remove(S));
        }
    }

    private static String remove(String s) {
        if(s.length()<2)
            return s;
        String ans="";
        for(int i=0;i<s.length()-1;i++){
            int j=i+1;
            if(s.charAt(i)==s.charAt(j)){
                while(j<s.length() && s.charAt(i)==s.charAt(j)){
                    j++;
                }
                i=j-1;
            }else{
                ans+=s.charAt(i);
            }
        }
        if(s.charAt(s.length()-1) != s.charAt(s.length()-2)){
            ans+=s.charAt(s.length()-1);
        }
        if(s.equals(ans)){
            return ans;
        }else{
            return remove(ans);
        }
    }
}