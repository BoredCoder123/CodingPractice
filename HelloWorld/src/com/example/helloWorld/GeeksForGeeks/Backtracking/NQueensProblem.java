package com.example.helloWorld.GeeksForGeeks.Backtracking;

import java.util.Scanner;

public class NQueensProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        nQueens(x);
    }

    private static void nQueens(int totalQueens) {
        if(totalQueens==1) {
            System.out.println("0, 0");
            return;
        }else if(totalQueens<=0 || totalQueens==2 || totalQueens==3){
            System.out.println("The solution doesn't exists");
            return;
        }
//        nQueensUtil(new boolean[totalQueens][totalQueens], 0, 0, totalQueens, 0, "");
        nQueensUtil(new boolean[totalQueens][totalQueens], 0, totalQueens, 0, "");
    }

    private static void nQueensUtil(boolean[][] board, int row, int col, int totalQueens, int qpsf, String ans) {
        if(totalQueens==qpsf){
            ans=ans.trim();
            System.out.println(ans);
            return;
        }
        if(col==totalQueens){
            col=0;
            row++;
        }
        if(row==totalQueens)
            return;

        if(isSafe(board, row, col)){
            board[row][col]=true;
            nQueensUtil(board, row, col+1, totalQueens, qpsf+1, ans+" ["+row+","+col+"], ");
            board[row][col]=false;
        }
        nQueensUtil(board, row, col+1, totalQueens, qpsf, ans);
    }

    private static void nQueensUtil(boolean[][] board, int row, int totalQueens, int qpsf, String ans) {
        if(totalQueens==qpsf){
            ans=ans.trim();
            System.out.println(ans);
            return;
        }
        for(int col=0;col<totalQueens;col++){
            if(isSafe(board, row, col)){
                board[row][col]=true;
                nQueensUtil(board, row+1, totalQueens, qpsf+1, ans+" ["+row+","+col+"], ");
            }
            board[row][col]=false;
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        int i, j;

        for(i=0;i<col;i++){
            if(board[row][i])
                return false;
        }

        for(i=row-1;i>=0;i--){
            if(board[i][col])
                return false;
        }

        i=row-1;
        j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j])
                return false;
            i--;
            j--;
        }

        i=row-1;
        j=col+1;
        while(i>=0 && j<board.length){
            if(board[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }
}
