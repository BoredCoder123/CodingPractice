package com.example.helloWorld.GeeksForGeeks.StackAndQueue;
//https://practice.geeksforgeeks.org/problems/circular-tour/1#
import java.util.*;

public class CircularTour {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String arr[] = str.split(" ");
            int p[] = new int[n];
            int d[] = new int[n];
            int j=0;
            int k=0;
            for(int i=0; i<2*n; i++)
            {
                if(i%2 == 0)
                {
                    p[j]= Integer.parseInt(arr[i]);
                    j++;
                }
                else
                {
                    d[k] = Integer.parseInt(arr[i]);
                    k++;
                }
            }

            System.out.println(tour(p,d));
            t--;
        }
    }

    private static int tour(int petrol[], int distance[])
    {
        int start=0, end=1, curPetrol=petrol[start]-distance[start];
        while(start!=end || curPetrol<0){
            while(curPetrol < 0 && start!=end){
                curPetrol-=petrol[start]-distance[start];
                start=(start+1)%petrol.length;

                if(start==0)
                    return -1;
            }

            curPetrol+=petrol[end]-distance[end];
            end=(end+1)%petrol.length;
        }
        return start;
    }
}