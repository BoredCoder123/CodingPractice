package com.example.helloWorld.GeeksForGeeks.Graph;
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

import java.util.*;
import java.io.*;
import java.lang.*;

import java.util.*;
import java.io.*;
import java.lang.*;

class CycleInDirectedGraph
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(isCyclic(V, list) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
    public static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited= new boolean[v];
        boolean[] recStack= new boolean[v];

        for(int i=0;i<v;i++){
            if(isCyclicUtil(i, visited, recStack, adj))
                return true;
        }
        return false;
    }

    public static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj){
        if(recStack[i])
            return true;
        if(visited[i])
            return false;

        visited[i]=true;

        recStack[i]=true;

        ArrayList<Integer> ch = adj.get(i);
        for(Integer c: ch){
            if(isCyclicUtil(c, visited, recStack, adj))
                return true;
        }

        recStack[i]=false;
        return false;
    }
}
