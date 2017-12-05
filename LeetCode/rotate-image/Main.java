题目描述

You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up:
Could you do this in-place?
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col-i;j++){
                swap(matrix,i,j,col-1-j,row-1-i);
            }
        }
        
        for(int i = 0;i<row/2;i++){
            for(int j = 0;j<col;j++){
                swap(matrix,i,j,row-1-i,j);
            }
        }
        
    }
    
    public void swap(int[][] matrix,int a,int b,int c,int d){
        int t = matrix[a][b];
        matrix[a][b] = matrix[c][d];
        matrix[c][d] = t;
    }
}