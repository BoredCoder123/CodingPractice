package com.example.helloWorld.Graph;
//This is an example of undirected graph where if a->b then b->a
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ListGraph {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        int v=0, u;
        for(int i = 0; i < V; i++)
            adj.add(i, new ArrayList<Integer>());
        for(int i = 0; i < E; i++){
            String[] S = br.readLine().trim().split(" ");
            u = Integer.parseInt(S[0]);
            v = Integer.parseInt(S[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        printGraph(V, adj);
        System.out.println(" ");
        BFS(V, adj);
        System.out.println(" ");
        DFS(V, adj);
    }

    public static void printGraph(int v, ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size(); i++){
            for(int j=0; j<adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println(" ");
        }
    }

    public static void BFS(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[v];
        int i, j;
        for(i=0;i<v;i++)
            visited[i]=false;

        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int temp = q.poll().intValue();
            if(!visited[temp]){
                System.out.print(temp+" ");
                visited[temp]=true;
                ArrayList<Integer> tempArr=adj.get(temp);
                for(i=0;i<tempArr.size();i++){
                    if(!visited[tempArr.get(i).intValue()]){
                        q.add(tempArr.get(i).intValue());
                    }
                }
            }
        }
    }

    public static void DFS(int v, ArrayList<ArrayList<Integer>> adj){
        Boolean[] visited = new Boolean[v];
        int i;
        for(i=0;i<v;i++)
            visited[i]=false;

        Stack<Integer> s = new Stack<>();

        s.push(0);

        while(!s.isEmpty()){
            Integer temp=s.pop();
            if(temp!=null){
                int t=temp.intValue();
                if(!visited[t]){
                    System.out.print(t+" ");
                    visited[t]=true;
                    ArrayList<Integer> tempArr = adj.get(t);
                    for(i=tempArr.size()-1;i>=0;i--){
                        if(!visited[tempArr.get(i).intValue()]){
                            s.push(tempArr.get(i).intValue());
                        }
                    }
                }
            }
        }
    }
}