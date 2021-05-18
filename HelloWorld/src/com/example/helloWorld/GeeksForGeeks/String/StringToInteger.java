package com.example.helloWorld.GeeksForGeeks.String;
//https://practice.geeksforgeeks.org/problems/implement-atoi/1
import java.util.Scanner;

public class StringToInteger {

    public static void callStringToInteger()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0)
        {
            String str = sc.nextLine();

            System.out.println(atoi(str));
            t--;
        }
    }

    private static int atoi(String str)
    {
        int i=0, ans=0;
        if(str.charAt(0)=='-')
            i++;
        for(;i<str.length();i++){
            if((int)str.charAt(i)<(int)'0' || (int)str.charAt(i)>(int)'9')
                return -1;
            ans=ans*10+((int)str.charAt(i)-48);
        }
        if(str.charAt(0)=='-')
            ans*=-1;
        return ans;
    }
}