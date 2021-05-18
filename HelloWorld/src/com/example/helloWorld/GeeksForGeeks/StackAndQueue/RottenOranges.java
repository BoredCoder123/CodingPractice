package com.example.helloWorld.GeeksForGeeks.StackAndQueue;
//https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1#

import java.util.*;
import java.lang.*;
import java.io.*;

public class RottenOranges {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            int ans = orangesRotting(grid);
            System.out.println(ans);
        }
    }

    public static class Ele
    {
        int x = 0;
        int y = 0;
        Ele(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    private static int orangesRotting(int[][] grid)
    {
        int R=grid.length;
        int C=grid[0].length;
        Queue<Ele> Q=new LinkedList<>();
        Ele temp;
        int ans = 0;
        // Store all the cells having rotten orange in first time frame
        for (int i=0; i < R; i++)
            for (int j=0; j < C; j++)
                if (grid[i][j] == 2)
                    Q.add(new Ele(i,j));

        // Separate these rotten oranges from the oranges which will rotten
        // due the oranges in first time frame using delimiter which is (-1, -1)
        Q.add(new Ele(-1,-1));

        // Process the grid while there are rotten oranges in the Queue
        while(!Q.isEmpty())
        {
            // This flag is used to determine whether even a single fresh
            // orange gets rotten due to rotten oranges in the current time
            // frame so we can increase the count of the required time.
            boolean flag = false;

            // Process all the rotten oranges in current time frame.
            while(!isDelim(Q.peek()))
            {
                temp = Q.peek();

                // Check right adjacent cell that if it can be rotten
                if(isValid(temp.x+1, temp.y, R, C) && grid[temp.x+1][temp.y] == 1)
                {
                    if(!flag)
                    {
                        // if this is the first orange to get rotten, increase
                        // count and set the flag.
                        ans++;
                        flag = true;
                    }
                    // Make the orange rotten
                    grid[temp.x+1][temp.y] = 2;

                    // push the adjacent orange to Queue
                    temp.x++;
                    Q.add(new Ele(temp.x,temp.y));

                    // Move back to current cell
                    temp.x--;
                }

                // Check left adjacent cell that if it can be rotten
                if (isValid(temp.x-1, temp.y, R, C) && grid[temp.x-1][temp.y] == 1)
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    grid[temp.x-1][temp.y] = 2;
                    temp.x--;
                    Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue
                    temp.x++;
                }

                // Check top adjacent cell that if it can be rotten
                if (isValid(temp.x, temp.y+1, R, C) && grid[temp.x][temp.y+1] == 1) {
                    if(!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    grid[temp.x][temp.y+1] = 2;
                    temp.y++;
                    Q.add(new Ele(temp.x,temp.y)); // Push this cell to Queue
                    temp.y--;
                }

                // Check bottom adjacent cell if it can be rotten
                if (isValid(temp.x, temp.y-1, R, C) && grid[temp.x][temp.y-1] == 1)
                {
                    if (!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    grid[temp.x][temp.y-1] = 2;
                    temp.y--;
                    Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue
                }
                Q.remove();

            }
            // Pop the delimiter
            Q.remove();

            // If oranges were rotten in current frame than separate the
            // rotten oranges using delimiter for the next frame for processing.
            if (!Q.isEmpty())
            {
                Q.add(new Ele(-1,-1));
            }

            // If Queue was empty than no rotten oranges left to process so exit
        }

        // Return -1 if all arranges could not rot, otherwise ans
        return (checkAll(grid))? -1: ans;
    }
    private static boolean isValid(int i, int j, int R, int C)
    {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }


    // Function to check whether the cell is delimiter
    // which is (-1, -1)
    private static boolean isDelim(Ele temp)
    {
        return (temp.x == -1 && temp.y == -1);
    }

    private static boolean checkAll(int arr[][])
    {
        int R=arr.length;
        int C=arr[0].length;
        for (int i=0; i<R; i++)
            for (int j=0; j<C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }
}