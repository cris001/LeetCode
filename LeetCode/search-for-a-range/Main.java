题目描述

Given a sorted array of integers, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order ofO(log n).
If the target is not found in the array, return[-1, -1].
For example,
Given[5, 7, 7, 8, 8, 10]and target value 8,
return[3, 4].
public class Solution {
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0){
            return new int[]{-1,-1};
        }
        int n = A.length;
        int l1 = 0;
        int r1 = n - 1;
        while(l1 <= r1){
            int mid = l1 + ((r1 - l1) >> 1);
            if (A[mid]>=target){
                r1--;
            }else{
                l1++;
            }
        }
        
        int l2 = 0;
        int r2 = n - 1;
        while(l2 <= r2){
            int mid = l2 + ((r2 - l2) >> 1);
            if (A[mid]>target){
                r2--;
            }else{
                l2++;
            }
        }
        if (l1>r2){
            return new int[]{-1,-1};
        }
        return new int[]{l1,r2};
    }
}