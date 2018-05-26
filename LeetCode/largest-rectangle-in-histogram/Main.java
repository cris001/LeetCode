题目描述

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height =[2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area =10unit.

For example,
Given height =[2,1,5,6,2,3],
return10.
import java.util.*;
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int n = height.length;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for(int i = 0;i<n;i++){
            while(s.peek() != -1 && height[i] < height[s.peek()]){
                int t = s.pop();
                ans = Math.max(ans, (i-s.peek()-1)*height[t]);
            }
            s.push(i);
        }
        while(s.peek() != -1){
           int t = s.pop();
           ans = Math.max(ans, (n-s.peek()-1)*height[t]);
        }
        return ans;
    }
}