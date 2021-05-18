package com.example.helloWorld.GeeksForGeeks.Graph;
//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
public class DFS
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
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.dfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++)
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends





class Solution
{
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int i;

        Stack<Integer> s = new Stack<>();
        s.push(0);

        boolean[] visited= new boolean[v];

        for(i=0;i<v;i++)
            visited[i]=false;

        while(!s.isEmpty()){
            Integer t = s.peek();
            if(t!=null){
                if(!visited[t.intValue()]){
                    ans.add(t);
                    visited[t.intValue()]=true;
                    ArrayList<Integer> tempAdj = adj.get(t);
                    for(i=0;i<tempAdj.size();i++){
                        int tempVer=tempAdj.get(i).intValue();
                        if(!visited[tempVer]){
                            s.push(tempVer);
                            break;
                        }
                    }
                }else{
                    Boolean tempB= false;
                    ArrayList<Integer> tempAdj = adj.get(t);
                    for(i=0;i<tempAdj.size();i++){
                        int tempVer=tempAdj.get(i).intValue();
                        if(!visited[tempVer]){
                            tempB=true;
                            s.push(tempVer);
                            break;
                        }
                    }
                    if(!tempB)
                        s.pop();
                }
            }
        }
        return ans;
    }
}
