题目描述
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
click to show follow up.
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i = 0;i<col;i++){
            if (matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }
        for(int i = 0;i<row;i++){
            if (matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow){
            for(int i = 0;i<col;i++){
                matrix[0][i] = 0;
            }
        }
        if (firstCol){
            for(int i = 0;i<row;i++){
                matrix[i][0] = 0;
            }
        }
    }
}