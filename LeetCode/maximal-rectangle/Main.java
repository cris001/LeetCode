题目描述

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
import java.util.*;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        int height[] = new int[col + 1];
        for(int k = 0;k<row;k++){
            for(int i = 0;i<col;i++){
                if (matrix[k][i] == '1'){
                    height[i]++;
                }else{
                    height[i] = 0;
                }
            }
            Stack<Integer> s = new Stack<>();
            s.push(-1);
            for(int i = 0;i<col;i++){
                while(s.peek()!=-1 && height[i] < height[s.peek()]){
                    int t = s.pop();
                    ans = Math.max(ans,(i-s.peek()-1)*height[t]);
                }
                s.push(i);
            }
            while(s.peek()!=-1){
               int t = s.pop();
               ans = Math.max(ans,(col-s.peek()-1)*height[t]);
            }
        }
        return ans;
    }
}