package com.example.helloWorld.GeeksForGeeks.Greedy;
//https://practice.geeksforgeeks.org/problems/choose-and-swap0531/1
import java.io.*;
import java.util.*;

class ChooseAndSwap
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String A = read.readLine().trim();

            String ans = chooseandswap(A);
            System.out.println(ans);
        }
    }
    public static String chooseandswap(String a){
        char start=a.charAt(0), min=a.charAt(0);
        for(int i=1;i<a.length();i++){
            if(!compare(start, a.charAt(i)) && !compare(min, a.charAt(i))){
                min=a.charAt(i);
            }
        }
        if(min==start)
            return a;
        a=a.replaceAll(String.valueOf(min), "A");
        String t=String.valueOf(a.charAt(0));
        a=a.replaceAll(String.valueOf(a.charAt(0)), String.valueOf(min));
        a=a.replaceAll("A", t);
        System.out.println(a+" ");
        return a;
    }

    public static boolean compare(char a, char b){
        if((int)a <= (int)b)
            return true;
        else
            return false;
    }

}
