package com.example.helloWorld.GeeksForGeeks.Recursion;

// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class JosephusProblem {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();//testcases
        while(T-->0)
        {
            Sol obj=new Sol();

            int n,k;
            //taking input n and k
            n=sc.nextInt();
            k=sc.nextInt();

            //calling josephus() function
            System.out.println(obj.josephus(n,k));


        }

    }
}

// } Driver Code Ends



class Sol
{
    public int josephus(int n, int k)
    {
        if (n==1)
            return 1;
        else{
            return (josephus(n-1,k)+k-1)%n+1;
        }
    }
}


