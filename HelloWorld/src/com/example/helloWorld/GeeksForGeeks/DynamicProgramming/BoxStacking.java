package com.example.helloWorld.GeeksForGeeks.DynamicProgramming;
//https://practice.geeksforgeeks.org/problems/box-stacking/1

import java.util.*;
import java.lang.*;
import java.io.*;

class BoxStacking
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        //sc.next();
        while(t-- > 0)
        {
            int n = sc.nextInt();

            int A[]  =new int[105];
            int B[] = new int[105];
            int C[] = new int[105];

            for(int i = 0; i < n; i++)
            {
                int a =sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                A[i] = a;
                B[i] = b;
                C[i] = c;
            }

            System.out.println(maxHeight(A,B,C,n));
        }
    }
    static class Box implements Comparable<Box>{
        int h, w, d, area;
        Box(int h, int w, int d){
            this.h=h;
            this.w=w;
            this.d=d;
            this.area=w*d;
        }

        @Override
        public int compareTo(Box o){
            return o.area-this.area;
        }
    }
    public static int maxHeight(int h[], int d[], int w[], int n){
        Box[] rot = new Box[n*3];
        int i, j;
        for(i=0;i<n;i++){
            rot[3*i]= new Box(h[i], Math.max(d[i], w[i]), Math.min(d[i], w[i]));
            rot[3*i+1]= new Box(d[i], Math.max(w[i], h[i]), Math.min(w[i], h[i]));
            rot[3*i+2]= new Box(w[i], Math.max(d[i], h[i]), Math.min(d[i], h[i]));
        }

        Arrays.sort(rot);
        n*=3;

        int[] msh = new int[n];
        for(i=0;i<n;i++){
            msh[i]=rot[i].h;
        }

        for(i=0;i<n;i++){
            msh[i]=0;
            Box box=rot[i];
            int val=0;
            for(j=0;j<i;j++){
                Box prevBox=rot[j];
                if(box.w < prevBox.w && box.d < prevBox.d){
                    val=Math.max(val, msh[j]);
                }
            }
            msh[i]=val+box.h;
        }
        int max=-1;
        for(i=0;i<n;i++)
            max=Math.max(max,msh[i]);
        return max;
    }
}