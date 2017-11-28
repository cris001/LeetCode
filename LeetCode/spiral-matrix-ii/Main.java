题目描述

Given an integer n, generate a square matrix filled with elements from 1 to n 2 in spiral order.
For example,
Given n =3,
You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int now = 1;
        while(now<=n*n){
            for(int i = left;i<=right;i++){
                a[top][i] = now++;
            }
            if (now>n*n){
                 break;
            }
            top++;
            for(int i = top;i<=bottom;i++){
                a[i][right] = now++;
            }
            if (now>n*n){
                 break;
            }
            right--;
            for(int i = right;i>=left;i--){
                a[bottom][i] = now++;
            }
            if (now>n*n){
                 break;
            }
            bottom--;
            for(int i = bottom;i>=top;i--){
                a[i][left] = now++;
            }
            if (now>n*n){
                 break;
            }
            left++;
        }
        return a;
    }
}