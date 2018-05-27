题目描述

Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
For example,
Given board =
[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word ="ABCCED", -> returnstrue,
word ="SEE", -> returnstrue,
word ="ABCB", -> returnsfalse.
public class Solution {
    boolean flag = false;
    int d[][]= {{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0){
            return true;
        }
        if (board == null || board.length == 0){
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        int len = word.length();
        char c[] = new char[len];
        for(int i = 0;i<len;i++){
            c[i] = word.charAt(i);
        }
        boolean vis[][] = new boolean[row][col];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if (board[i][j] == c[0]){
                    vis[i][j] = true;
                    dfs(i,j,1,len,board,c,vis);
                    if (flag){
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return flag;
    }
    
    public void dfs(int x,int y,int now, int len, char[][] board, char[] c,boolean vis[][]){
        if (now == len){
            flag = true;
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for(int i = 0;i<=3;i++){
            int a = x + d[i][0];
            int b = y + d[i][1];
            if (a>=0 && a<row && b>=0 && b<col && !vis[a][b] && board[a][b] == c[now]){
                vis[a][b] = true;
                dfs(a,b,now+1,len,board,c,vis);
                if (flag){
                    return;
                }
                vis[a][b] = false;
            }
        }
        
    }
}