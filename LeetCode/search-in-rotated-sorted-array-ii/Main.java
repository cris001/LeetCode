题目描述

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
public class Solution {
    public boolean search(int[] A, int target) {
        return binarySearch(A,0,A.length - 1,target);
    }
    public boolean binarySearch(int[] A,int l,int r,int target){
        if (l>r){
            return false;
        }
        int mid = l +((r-l)>>1);
        if (A[mid] == target){
            return true;
        }
        if (A[l] <= A[r]){
            if (A[l] == A[r]){
                r--;
            }else if (A[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
            return binarySearch(A,l,r,target);
        }
        return binarySearch(A,l,mid-1,target) || binarySearch(A,mid+1,r,target);
    }
}