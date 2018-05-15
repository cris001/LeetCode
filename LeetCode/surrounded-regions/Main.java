题目描述

Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
A region is captured by flipping all'O's into'X's in that surrounded region .
For example,
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
public class Solution {
    int d[][]= {{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        int vis[][]= new int[row][col];
        for(int i = 0;i<col;i++){
            if (board[0][i] == 'O'){
                vis[0][i] = 1;
                //dfs(0,i,board,row,col,vis);
            }
        }
        for(int i = 0;i<col;i++){
            if (board[row - 1][i] == 'O'){
                vis[row - 1][i] = 1;
                //dfs(row - 1,i,board,row,col,vis);
            }
        }
        for(int i = 0;i<row;i++){
            if (board[i][0] == 'O'){
                vis[i][0] = 1;
                //dfs(i,0,board,row,col,vis);
            }
        }
        for(int i = 0;i<row;i++){
            if (board[i][col - 1] == 'O'){
                vis[i][col - 1] = 1;
                //dfs(i,col - 1,board,row,col,vis);
            }
        }
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if (vis[i][j] == 1 && board[i][j] == 'O'){
                    dfs(i,j,board,row,col,vis);
                }
            }
        }
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if (vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
    
    public void dfs(int x,int y, char[][] board,int row,int col,int[][] vis){
        if (x >= row || x < 0 || y >= col || y < 0){
            return;
        }
        for(int i = 0;i<=3;i++){
            int xx = x+d[i][0];
            int yy = y+d[i][1];
            if (!(xx >= row || xx < 0 || yy >= col || yy < 0)){
                if (board[xx][yy] == 'O' && vis[xx][yy] == 0){
                    vis[xx][yy] = 1;
                    dfs(xx,yy,board,row,col,vis);
                }
            }
        }
        
    }
}