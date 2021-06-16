package com.example.helloWorld.GeeksForGeeks.Backtracking;

public class MazeSolving {
    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                { 0, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int n=maze.length, m=maze[0].length;
        int[][] sol=new int[n][m];
        boolean[][] visited= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                sol[i][j] = 0;
                visited[i][j]=false;
            }
        }
        if(maizeSolving(maze, sol, n, m, visited)){
            display(sol, n, m);
        }else
            System.out.println("Maze is not solvable");
    }

    private static boolean maizeSolving(int[][] maze, int[][] sol, int n, int m, boolean[][] visited) {
        return maizeSolveUtil(maze, sol, n, m, 0, 0, visited);
    }

    private final static int[] posX={0, 1, 0, -1};
    private final static int[] poxY={1, 0, -1, 0};

    private static boolean maizeSolveUtil(int[][] maze, int[][] sol, int n, int m, int x, int y, boolean[][] visited) {
        if(x==0 && y==0 && maze[x][y]==0 && (n>1 || m>1))
            return false;
        visited[0][0]=false;
        sol[0][0]=1;
        if(x==n-1 && y==m-1)
            return true;

        for(int i=0;i<4;i++){
            int newX=x+posX[i];
            int newY=y+poxY[i];

            if(isSafe(newX, newY, n, m, sol, maze, visited)){
                sol[newX][newY]=1;
                visited[newX][newY]=true;
                if(maizeSolveUtil(maze, sol, n, m, newX, newY, visited))
                    return true;
                else
                    sol[newX][newY]=0;
            }
        }

        return false;
    }

    private static boolean isSafe(int x, int y, int n, int m, int[][] sol, int[][] maze, boolean[][] visited){
        return (x>=0 && y>=0 && x<n && y<m && sol[x][y]==0 && maze[x][y]==1 && !visited[x][y]);
    }

    private static void display(int[][] arr, int n, int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println(" ");
        }
    }

}