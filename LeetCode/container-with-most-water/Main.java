题目描述

Given n non-negative integers a1 , a2 , ..., an , where each represents a point at coordinate (i, ai ). n vertical lines are drawn such that the two endpoints of line i is at (i, ai ) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container.
public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while(l<=r){
            int t = (r-l)*Math.min(height[l],height[r]);
            ans = Math.max(ans,t);
            if (height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}