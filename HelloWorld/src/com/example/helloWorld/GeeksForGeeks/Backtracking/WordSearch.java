package com.example.helloWorld.GeeksForGeeks.Backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
        patternSearch(grid, "GEEKS");
        System.out.println();
        patternSearch(grid, "EEEE");
    }

    private static void patternSearch(char[][] grid, String str){
        int r=grid.length, c=grid[0].length;
        boolean flag=true;
        boolean[][] visited= new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int X=0;X<r;X++){
                    for(int Y=0;Y<c;Y++)
                        visited[X][Y]=false;
                }
                if(patternSearchUtil(grid, str, 0, i, j, visited)){
                    System.out.println("String found at "+i+", "+j);
                    flag=false;
                }
            }
        }
        if(flag)
            System.out.println("String not found anywhere in the matrix");
    }

    private static int[] ro={-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] co={-1, 0, 1, -1, 1, -1, 0, 1};

    private static boolean patternSearchUtil(char[][] grid, String str, int idx, int r, int c, boolean[][] visited){
        if(idx==str.length())
            return true;

        if(str.charAt(idx)!=grid[r][c])
            return false;

        visited[r][c]=true;

        for(int i=0;i<8;i++){
            if(isSafe(r+ro[i], c+co[i], grid.length, grid[0].length, visited)){
                if(patternSearchUtil(grid, str, idx+1, r+ro[i], c+co[i], visited))
                    return true;
            }
        }

        visited[r][c]=false;

        return false;
    }

    private static boolean isSafe(int i, int j, int r, int c, boolean[][] visited){
        return (i>=0 && i<r && j>=0 && j<c && !visited[i][j]);
    }
}
