package com.example.helloWorld.GeeksForGeeks.Recursion;
//https://practice.geeksforgeeks.org/problems/number-of-paths0926/1
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class NumberofPaths {

    public static void main (String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int m = Integer.parseInt(inputLine[0]);
            int n = Integer.parseInt(inputLine[1]);
            NumPath ob = new NumPath();
            System.out.println(ob.numberOfPaths(m, n));
        }
    }
}



class NumPath{

    long numberOfPaths(int m, int n) {
        if(n==1 || m==1)
            return 1;

        return numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
    }

}