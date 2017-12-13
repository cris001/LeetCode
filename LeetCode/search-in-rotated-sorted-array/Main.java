题目描述

Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e.,0 1 2 4 5 6 7might become4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
public class Solution {
    int ans = -1;
    public int search(int[] A, int target) {
        if (A == null || A.length == 0){
            return -1;
        }
        binarySearch(A,0,A.length - 1,target);
        return ans;
    }
    
    public void binarySearch(int[] A,int l,int r,int target){
        if (l>r){
            return;
        }
        if (ans != -1){
            return;
        }
        int mid = l+ ( (r - l)>>1);
        if (A[mid] == target){
            ans = mid;
            return;
        }
        if (A[l] <= A[r]){
            if (A[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
            binarySearch(A,l,r,target);
        }
        
        binarySearch(A,l,mid-1,target);
        binarySearch(A,mid+1,r,target);
    }
}