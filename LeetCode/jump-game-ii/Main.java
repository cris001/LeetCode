题目描述

Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example:
Given array A =[2,3,1,1,4]
The minimum number of jumps to reach the last index is2. (Jump1step from index 0 to 1, then3steps to the last index.)
public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        int f[] = new int[n];
        for(int i = 0;i<n;i++){
            f[i] = Integer.MAX_VALUE;
        }
        f[0] = 0;
        for(int i = 0;i<n;i++){
            int m = Math.min(n-1,i+A[i]);
            for(int j = i+1;j<=m && j<n;j++){
                f[j]=Math.min(f[j],f[i] + 1);
            }
        }
        return f[n-1];
    }
}