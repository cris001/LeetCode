题目描述

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return[1,2,3,6,9,8,7,4,5].
import java.util.*;
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0){
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;
        int now = 0;
        while(now < row * col){
            for(int i = left;i<=right;i++){
                list.add(matrix[top][i]);
                now++;
            }
            top++;
            if (now >= row * col){
                break;
            }
            for(int i = top;i<=bottom;i++){
                list.add(matrix[i][right]);
                now++;
            }
            right--;
            if (now >= row * col){
                break;
            }
            for(int i = right;i>=left;i--){
                list.add(matrix[bottom][i]);
                now++;
            }
            bottom--;
            if (now >= row * col){
                break;
            }
            for(int i = bottom;i>=top;i--){
                list.add(matrix[i][left]);
                now++;
            }
            left++;
            if (now >= row * col){
                break;
            }
        }
        return list;
    }
}