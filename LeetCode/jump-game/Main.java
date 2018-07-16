题目描述
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A =[2,3,1,1,4], returntrue.
A =[3,2,1,0,4], returnfalse.

public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0){
            return true;
        }
        int len = A.length;
        int max = 0;
        for(int i = 0;i<len && max>=i;i++){
            max = Math.max(max,i+A[i]);
        }
        if (max >= len-1){
            return true;
        }
        return false;
    }
}