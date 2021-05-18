package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1#

import java.io.*;
import java.util.*;

public class RomanNumber {

    public static void callRomanNumber() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            System.out.println(romanToDecimal(roman));
        }
    }

    private static int romanToDecimal(String str) {
        str=str.toUpperCase();
        int ans=0, cur;
        for(int i=0;i<str.length();i++){
            cur=value(str.charAt(i));
            if(i+1<str.length()){
                int r2=value(str.charAt(i+1));

                if(cur>=r2)
                    ans+=cur;
                else{
                    ans+=(r2-cur);
                    i++;
                }
            }else{
                ans+=value(str.charAt(i));
            }
        }
        return ans;
    }

    private static int value(char c){
        if(c=='I')
            return 1;
        else if(c=='V')
            return 5;
        else if(c=='X')
            return 10;
        else if(c=='L')
            return 50;
        else if(c=='C')
            return 100;
        else if(c=='D')
            return 500;
        else if(c=='M')
            return 1000;
        else
            return -1;
    }
}