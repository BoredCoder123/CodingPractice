package com.example.helloWorld.GeeksForGeeks.Graph;
//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
import java.util.*;
import java.lang.*;
import java.io.*;
public class BFS
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
                // adj.get(v).add(u);
            }
            S obj = new S();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++)
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

class S
{
    public ArrayList<Integer> bfsOfGraph(int v,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q= new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
        Boolean[] visited = new Boolean[v];
        for(int i=0;i<v;i++)
            visited[i]=false;
        q.add(0);
        while(!q.isEmpty()){
            Integer t=q.poll();
            if(t!=null){
                int ver=t.intValue();
                if(!visited[ver]){
                    visited[ver]=true;
                    ans.add(ver);
                    ArrayList<Integer> tempArr = adj.get(ver);
                    for(int i=0;i<tempArr.size();i++){
                        if(!visited[tempArr.get(i)]){
                            q.add(tempArr.get(i));
                        }
                    }
                }
            }
        }
        return ans;
    }
}
