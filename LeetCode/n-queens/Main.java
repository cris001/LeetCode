题目描述

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where'Q'and'.'both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
import java.util.*;
public class Solution {
    ArrayList<String[]> list = new ArrayList<String[]>();
    public ArrayList<String[]> solveNQueens(int n) {
        if (n<=0){
            return list;
        }
        char[][] mp = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                mp[i][j] = '.';
            }
        }
        dfs(n,mp,0);
        return list;
    }
    
    public void dfs(int n, char[][] mp,int now){
        if (now == n){
            String[] s = new String[n];
            for(int i = 0;i<n;i++){
                s[i]= new String(mp[i]);
            }
            list.add(s);
            return;
        }
        for(int i = 0;i<n;i++){
            if (canPlace(now,i,n,mp)){
                mp[now][i] = 'Q';
                dfs(n,mp,now + 1);
                mp[now][i] = '.';
            }
        }
    }
    
    public boolean canPlace(int x,int y, int n, char[][] mp){
        for(int i = 0;i<x;i++){
            for(int j = 0;j<n;j++){
                if (mp[i][j] == 'Q'){
                    if (j == y || Math.abs(j-y) == (x-i)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}