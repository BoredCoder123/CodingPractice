package com.example.helloWorld.GeeksForGeeks.Backtracking;

public class SudokuSolving {
    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;

        if (solveSudoku(board, N))
        {
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++)
                    System.out.print(board[i][j]+" ");
                System.out.println(" ");
            }
        }
        else {
            System.out.println("No solution");
        }
    }

    private static boolean solveSudoku(int[][] board, int n) {
        int row=-1, col=-1, i, j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    break;
                }
            }
            if(row!=-1)
                break;
        }

        if(row==-1)
            return true;
        for(int num=1;num<=n;num++){
            if(isSafe(board, row, col, num)){
                board[row][col]=num;
                if(solveSudoku(board, n))
                    return true;
                else
                    board[row][col]=0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        int i, j, size=board.length;
        for(i=0;i<size;i++){
            if(board[row][i]==num)
                return false;
            if(board[i][col]==num)
                return false;
        }

        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart=row-row%sqrt;
        int boxColStart=col-col%sqrt;
        for(int r=boxRowStart;r<boxRowStart+sqrt;r++){
            for(int c=boxColStart;c<boxColStart+sqrt;c++){
                if(board[r][c]==num)
                    return false;
            }
        }
        return true;
    }
}
