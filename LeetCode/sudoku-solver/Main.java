题目描述

Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character'.'.
You may assume that there will be only one unique solution.

A sudoku puzzle...


...and its solution numbers marked in red.
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        dfs(board);
    }
    
    public boolean dfs(char[][] board){
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if (board[i][j] == '.'){
                    for(char k = '1';k<='9';k++){
                        if (canPut(board,i,j,k)){
                            board[i][j] = k;
                            if (dfs(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean canPut(char[][] board,int i,int j,char k){
        for(int t = 0;t<board.length;t++){
            if (board[t][j] == k || board[i][t] == k){
                return false;
            }
            if (board[3*(i/3) + t/3][3*(j/3) + t%3] == k){
                return false;
            }
        }
        return true;
    }
        
}