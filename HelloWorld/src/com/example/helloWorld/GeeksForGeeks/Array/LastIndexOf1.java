package com.example.helloWorld.GeeksForGeeks.Array;

import java.io.*;

//https://practice.geeksforgeeks.org/problems/last-index-of-15847/1#
public class LastIndexOf1 {
    public static void callLastIndexOf1() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine();

            System.out.println(lastIndex(s));

        }
    }
    private static int lastIndex( String s) {
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                return i;
            }
        }
        return -1;
    }
}
