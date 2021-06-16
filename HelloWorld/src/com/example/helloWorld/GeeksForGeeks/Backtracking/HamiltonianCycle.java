package com.example.helloWorld.GeeksForGeeks.Backtracking;

public class HamiltonianCycle {
    public static void main(String[] args) {
        int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        hamCycle(graph1);

        int graph2[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        hamCycle(graph2);
    }

    private static boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
        int size=graph.length;
        if(pos==size){
            if(graph[path[pos-1]][path[0]]==1)
                return true;
            else
                return false;
        }
        for(int i=1;i<size;i++){
            if(isSafe(i, graph, path, pos)){
                path[pos]=i;
                if(hamCycleUtil(graph, path, pos+1))
                    return true;
                path[pos]=-1;
            }
        }
        return false;
    }

    private static boolean isSafe(int i, int[][] graph, int[] path, int pos) {
        if(graph[path[pos-1]][i]==0)
            return false;
        for(int j=0;j<pos;j++){
            if(path[j]==i)
                return false;
        }
        return true;
    }

    private static void hamCycle(int[][] graph) {
        int size=graph.length;
        int[] path= new int[size];
        for(int i=0;i<size;i++)
            path[i]=-1;
        path[0]=0;
        if(hamCycleUtil(graph, path, 1)){
            for(int i=0;i<size;i++)
                System.out.print(path[i]+" ");
            System.out.println(" ");
        }else
            System.out.println("No path exists");
    }

}
