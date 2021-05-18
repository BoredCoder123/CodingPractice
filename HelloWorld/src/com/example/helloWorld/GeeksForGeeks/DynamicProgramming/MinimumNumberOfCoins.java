package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class MinimumNumberOfCoins{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());

            List<Integer> numbers= new ArrayList<Integer>();
            numbers = minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    static List<Integer> minPartition(int n)
    {
        List<Integer> l = new ArrayList<>();
        while(n>0){
            if(n>=2000){
                n-=2000;
                l.add(2000);
            }else if(n>=500){
                n-=500;
                l.add(500);
            }else if(n>=200){
                n-=200;
                l.add(200);
            }else if(n>=100){
                n-=100;
                l.add(100);
            }else if(n>=50){
                n-=50;
                l.add(50);
            }else if(n>=20){
                n-=20;
                l.add(20);
            }else if(n>=10){
                n-=10;
                l.add(10);
            }else if(n>=5){
                n-=5;
                l.add(5);
            }else if(n>=2){
                n-=2;
                l.add(2);
            }else if(n>=1){
                n-=1;
                l.add(1);
            }
        }
        return l;
    }
}
