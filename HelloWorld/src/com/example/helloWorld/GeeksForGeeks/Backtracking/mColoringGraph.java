package com.example.helloWorld.GeeksForGeeks.Backtracking;

public class mColoringGraph {
    public static void main(String[] args) {
        boolean[][] graph = {
                { false, true, true, true },
                { true, false, true, true },
                { true, true, false, true },
                { true, true, true, false },
        };
        int m = 4; // Number of colors
        int[] ans = new int[graph.length];
        for(int i=0;i<graph.length;i++)
            ans[i]=0;
        if(graphColoring(graph, m, ans)){
            for(int i=0;i<graph.length;i++)
                System.out.print(ans[i]+" ");
        }else
            System.out.println("NO");
    }

    private static boolean graphColoring(boolean[][] graph, int m, int[] ans) {
        return graphColoringUtil(graph, m, graph.length, ans, 0);
    }

    private static boolean graphColoringUtil(boolean[][] graph, int m, int size, int[] ans, int curr) {
        if(curr==size){
            return isSafe(graph, ans);
        }
        for(int i=1;i<=m;i++){
            ans[curr]=i;
            if(graphColoringUtil(graph, m, size, ans, curr+1))
                return true;
            ans[curr]=0;
        }
        return false;
    }

    private static boolean isSafe(boolean[][] graph, int[] color){
        for(int i=0;i<graph.length;i++){
            for(int j=i+1; j<graph.length;j++){
                if(graph[i][j] && color[i]==color[j])
                    return false;
            }
        }
        return true;
    }
}
