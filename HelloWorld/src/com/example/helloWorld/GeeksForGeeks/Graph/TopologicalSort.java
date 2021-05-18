package com.example.helloWorld.GeeksForGeeks.Graph;
//https://practice.geeksforgeeks.org/problems/topological-sort/1#
//DFS only but first visited all the child nodes only then push the main node on stack
// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class TopologicalSort {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> s = new Stack<Integer>();

        boolean visited[] =new boolean[v];
        int[] ans = new int[v];
        for(int i=0;i<v;i++){
            if(visited[i]==false)
                topologicalSortUtil(i, visited, s, adj);

            while(!s.isEmpty())
                ans[i]=s.pop();
        }
        return ans;
    }

    static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> s, ArrayList<ArrayList<Integer>> adj){
        visited[v]=true;
        int i=0;
        ArrayList<Integer> al = adj.get(v);
        while(!al.isEmpty()){
            i=al.get(0).intValue();
            al.remove(0);
            if(!visited[i])
                topologicalSortUtil(i, visited, s, adj);
        }
        s.push(v);
    }
}

