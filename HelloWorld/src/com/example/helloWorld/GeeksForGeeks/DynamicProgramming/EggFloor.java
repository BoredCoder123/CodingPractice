package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1
import java.util.*;
import java.lang.*;
import java.io.*;

class EggFloor {

    public static void main (String[] args) throws IOException  {

        //reading input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //reading total testcases
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){

            //reading number of eggs and floors
            String inputLine[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);

            //calling eggDrop() method of class
            //EggDrop
            System.out.println(eggDrop(n, k));
        }
    }
    static int eggDrop(int n, int k)
    {
        int[][] eggFloor = new int[n+1][k+1];
        int i, j, x, res;
        for(i=1;i<n;i++){
            eggFloor[i][1]=1;
            eggFloor[i][0]=0;
        }
        for(i=1;i<=k;i++){
            eggFloor[1][i]=i;
        }
        for(i=2;i<=n;i++){
            for(j=2;j<=k;j++){
                eggFloor[i][j]=Integer.MAX_VALUE;
                for(x=1;x<=j;x++){
                    res=1+Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                    eggFloor[i][j]=Math.max(eggFloor[i][j], res);
                }
            }
        }
        return eggFloor[n][k];
    }
}