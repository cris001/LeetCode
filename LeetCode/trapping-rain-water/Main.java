题目描述

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given[0,1,0,2,1,0,1,3,2,1,2,1], return6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        int lmax[] = new int[n+1];
        int rmax[] = new int[n+1];
        lmax[0] = A[0];
        for(int i = 1;i<n;i++){
            lmax[i] = Math.max(lmax[i-1], A[i]);
        }
        rmax[n-1] = A[n-1];
        for(int i = n-2;i>=0;i--){
            rmax[i] = Math.max(rmax[i+1], A[i]);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            int k = Math.min(lmax[i], rmax[i]);
            ans += k-A[i];
        }
        return ans;
    }
}