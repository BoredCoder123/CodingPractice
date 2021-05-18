package com.example.helloWorld.GeeksForGeeks.Greedy;
//https://practice.geeksforgeeks.org/problems/activity-selection/0
import java.io.*;
import java.util.*;
import java.lang.*;

class MaximumActivities
{
    public static void main (String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //testcases
        int t = Integer.parseInt(br.readLine().trim());

        while(t-- > 0)
        {
            String inputLine[] = br.readLine().trim().split(" ");
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            int start[] = new int[n];
            int end[] = new int[n];

            //adding elements to arrays start and end
            inputLine = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for(int i= 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            //function call
            System.out.println(activitySelection(start, end, n));
        }
    }

    public static int activitySelection(int start[], int end[], int n)
    {
        int[][] arr= new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=start[i];
            arr[i][1]=end[i];
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int count = 1;
        int y = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= arr[y][1] ) {
                count++;
                y = i;
            }
        }
        String s="123";
        s.replaceAll("2", "4");
        return count;
    }
}