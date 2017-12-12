题目描述

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int mid = l + ((r - l)>>1);
            if (A[mid] == target){
                return mid;
            }else if (A[mid] > target){
                r--;
            }else{
                l++;
            }
        }
        if (r < 0){
            return 0;
        }
        return l;
    }
}