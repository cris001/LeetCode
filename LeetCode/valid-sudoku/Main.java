题目描述

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character'.'.

A partially filled sudoku which is valid.
import java.util.*;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<9;i++){
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> col = new HashSet<Character>();
            HashSet<Character> box = new HashSet<Character>();
            for(int j = 0;j<9;j++){
                if (board[i][j] != '.' && !row.add(board[i][j])){
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])){
                    return false;
                }
                int a = 3*(i/3)+(j/3);
                int b = 3*(i%3)+(j%3);
                if (board[a][b] != '.' && !box.add(board[a][b])){
                    return false;
                }
            }
        }
        return true;
    }
}