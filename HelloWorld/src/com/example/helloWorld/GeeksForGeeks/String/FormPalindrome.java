package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1#
import java.io.*;
import java.util.*;

public class FormPalindrome {

    public static void callFormPalindrome() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0){
            String str = read.readLine();

            System.out.println(countMin(str));
        }
    }

    private static int countMin(String str)
    {
        int n=str.length();
        int table[][] = new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str.charAt(l) == str.charAt(h))?
                        table[l+1][h-1] :
                        (Integer.min(table[l][h-1],
                                table[l+1][h]) + 1);

        for(l=0;l<n;l++){
            for(h=0;h<n;h++){
                System.out.print(table[l][h]+" ");
            }
            System.out.println(" ");
        }

        return table[0][n-1];
    }
}