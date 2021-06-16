package com.example.helloWorld.GeeksForGeeks.Backtracking;

import java.util.Scanner;

public class KnightWalk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size=sc.nextInt();
        knightWalk(size);
    }

    private static void knightWalk(int size) {
        int[][] board= new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)
                board[i][j]=-1;
        }
        board[0][0]=0;
        if(knightWalkUtil(board, size, 0, 0, 1))
            display(board);
        else
            System.out.println("The board cannot exist");
    }

    private static void display(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++)
                System.out.printf("%03d ",board[i][j]);
            System.out.println(" ");
        }
    }

    private static int[] posX={ 2, 1, -1, -2, -2, -1, 1, 2 };
    private static int[] posY={ 1, 2, 2, 1, -1, -2, -2, -1 };

    private static boolean knightWalkUtil(int[][] board, int size, int row, int col, int cnt) {
        if(cnt==size*size)
            return true;
        for(int i=0;i<8;i++){
            int nRow=row+posX[i];
            int nCol=col+posY[i];
            if(isSafe(board, nRow, nCol, size)){
                board[nRow][nCol]=cnt;
                if(knightWalkUtil(board, size, nRow, nCol, cnt+1))
                    return true;
                else
                    board[nRow][nCol]=-1;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int size){
        return (row>=0 && col>=0 && row<size && col<size && board[row][col]==-1);
    }
}
