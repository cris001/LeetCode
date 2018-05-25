题目描述

Given two sorted integer arrays A and B, merge B into A as one sorted array.
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i>=0 && j>=0){
            if (A[i] > B[j]){
                A[index--] = A[i--];
            }else{
                A[index--] = B[j--];
            }
        }
        while(j>=0){
            A[index--] = B[j--];
        }
    }
}