package com.example.helloWorld.Leetcode.Medium;
//https://leetcode.com/problems/number-of-islands/ Q.200
import java.util.Stack;

public class NumberOfIslands {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public int numIslands(char[][] grid) {
        int n=grid.length, m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int i, j;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++)
                visited[i][j]=false;
        }

        Stack<Pair> s = new Stack<>();
        int cnt=0;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    cnt++;
                    s.push(new Pair(i, j));
                    while(!s.isEmpty()){
                        Pair p=s.pop();
                        int x=p.x, y=p.y;
                        if(x-1>=0){
                            if(grid[x-1][y]=='1' && !visited[x-1][y]){
                                visited[x-1][y]=true;
                                s.push(new Pair(x-1,y));
                            }
                        }
                        if(x+1<n){
                            if(grid[x+1][y]=='1' && !visited[x+1][y]){
                                visited[x+1][y]=true;
                                s.push(new Pair(x+1,y));
                            }
                        }
                        if(y-1>=0){
                            if(grid[x][y-1]=='1' && !visited[x][y-1]){
                                visited[x][y-1]=true;
                                s.push(new Pair(x,y-1));
                            }
                        }
                        if(y+1<m){
                            if(grid[x][y+1]=='1' && !visited[x][y+1]){
                                visited[x][y+1]=true;
                                s.push(new Pair(x,y+1));
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
