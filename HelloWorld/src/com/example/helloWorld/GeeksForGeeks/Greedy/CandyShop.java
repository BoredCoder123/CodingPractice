package com.example.helloWorld.GeeksForGeeks.Greedy;
//https://practice.geeksforgeeks.org/problems/shop-in-candy-store/0
import java.io.*;
import java.util.*;

class CandyShop
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int K = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int candies[]= new int[N];
            for(int i = 0; i < N; i++)
                candies[i] = Integer.parseInt(input_line[i]);

            ArrayList<Integer> cost = candyStore(candies,N,K);
            System.out.println(cost.get(0)+" "+cost.get(1));
        }
    }
    static ArrayList<Integer> candyStore(int candies[],int n,int k){
        Arrays.sort(candies);
        int min=0, max=0, i=0;
        for(i=0;i<(int)(Math.ceil((double)n/(double)(k+1)));i++){
            min+=candies[i];
            max+=candies[n-1-i];
        }
        ArrayList<Integer> l = new ArrayList<>();
        l.add(min);
        l.add(max);
        return l;
    }
}