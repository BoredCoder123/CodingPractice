package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/implement-strstr/1
import java.util.*;

public class ImplementStrStr {
    public static void callImplementStrStr(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0)
        {
            String line = sc.nextLine();
            String a = line.split(" ")[0];
            String b = line.split(" ")[1];

            System.out.println(strstr(a,b));

            t--;
        }
    }

    private static int strstr(String s, String x)
    {
        for(int i=0;i<=s.length()-x.length();i++){
            if(x.equals(s.substring(i,i+x.length())))
                return i;
        }
        return -1;
    }
}