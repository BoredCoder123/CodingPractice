package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0
import java.util.*;
import java.lang.*;
import java.io.*;

public class StringRotatedByTwoPlaces {

    public static void callStringRotatedByTwoPlaces () {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        String s12 = sc.nextLine();
        for(int i=0; i<t; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            boolean flag = isRotated(s1, s2);

            if(flag == true) System.out.println("1");
            else System.out.println("0");

        }
    }

    private static boolean isRotated(String str1, String str2)
    {
        String ans="";
        if(str1.length()>1){
            ans+=str1.substring(2);
            ans+=str1.substring(0,2);
            // System.out.println(ans);
            if(ans.equals(str2))
                return true;
            ans="";
            ans+=str1.substring(str1.length()-2, str1.length());
            ans+=str1.substring(0,str1.length()-2);
            // System.out.println(ans);
            if(ans.equals(str2))
                return true;
        }else{
            if(str1.equals(str2))
                return true;
        }
        return false;
    }
}