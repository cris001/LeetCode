题目描述

Given an unsorted integer array, find the first missing positive integer.
For example,
Given[1,2,0]return3,
and[3,4,-1,1]return2.
Your algorithm should run in O(n) time and uses constant space.

public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0;i<n;i++){
            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]){
                swap(A,i,A[i] - 1);
            }
        }
        for(int i = 0;i<n;i++){
            if (A[i] != (i+1)){
                return i+1;
            }
        }
        return n+1;
    }
    
    public void swap(int[] A,int i,int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}