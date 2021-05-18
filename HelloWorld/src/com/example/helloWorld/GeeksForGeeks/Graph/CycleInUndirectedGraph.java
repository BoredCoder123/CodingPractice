package com.example.helloWorld.GeeksForGeeks.Graph;
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class CycleInUndirectedGraph
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            boolean ans = isCycle(V, adj);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++)
            visited[i]=false;
        for(int i=0;i<v;i++){
            if(!visited[i])
                if(isCyclicUtil(i, visited, -1, adj))
                    return true;
        }
        return false;
    }

    static boolean isCyclicUtil(int v, boolean[] visited, int parent, ArrayList<ArrayList<Integer>> adj){
        visited[v]=true;
        ArrayList<Integer> temp = adj.get(v);
        while(!temp.isEmpty()){
            int i=temp.get(0).intValue();
            temp.remove(0);

            if(!visited[i]){
                if(isCyclicUtil(i,visited, v, adj))
                    return true;
            }
            else if(i!=parent)
                return true;
        }
        return false;
    }
}