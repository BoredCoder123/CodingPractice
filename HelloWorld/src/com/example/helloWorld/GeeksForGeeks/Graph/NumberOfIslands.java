package com.example.helloWorld.GeeksForGeeks.Graph;
//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#
import java.util.*;
import java.lang.*;
import java.io.*;
class NumberOfIslands
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = S[j].charAt(0);
                }
            }
            int ans = numIslands(grid);
            System.out.println(ans);
        }
    }
    public static int numIslands(char[][] grid)
    {
        int r=grid.length, c=grid[0].length;
        boolean[][] visited= new boolean[r][c];
        int cnt=0, i, j;
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                visited[i][j]=false;
            }
        }

        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    cnt++;
                    DFS(grid, r, c, i, j, visited);
                }
            }
        }
        return cnt;
    }

    public static void DFS(char[][] grid, int r, int c, int x, int y, boolean[][] visited){
        int rowNbr[]= new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[]= new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        visited[x][y]=true;
        for(int k=0;k<8;k++){
            if(isSafe(grid, x+rowNbr[k], y+colNbr[k], r, c, visited))
                DFS(grid, r, c, x+rowNbr[k], y+colNbr[k], visited);
        }
    }

    static boolean isSafe(char[][] grid, int x, int y, int r, int c, boolean[][] visited){
        return (x>=0) && (x<r) && (y>=0) && (y<c) && (!visited[x][y]) && grid[x][y]=='1';
    }
}