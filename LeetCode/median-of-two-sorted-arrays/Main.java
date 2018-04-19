题目描述

There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
import java.util.*;
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        int t = m+n;
        if ((t & 1) == 1){
            return findKth(A,n,B,m,(t>>1) + 1)*1.0;
        }else{
            return (findKth(A,n,B,m,(t>>1)) + findKth(A,n,B,m,(t>>1) + 1) ) / 2.0;
        }
    }
    
    public int findKth(int[] A,int n,int[] B, int m,int k){
        if (n>m){
            return findKth(B,m,A,n,k);
        }
        if (n == 0){
            return B[k-1];
        }
        if (k == 1){
            return Math.min(A[0],B[0]);
        }
        int l1 = Math.min(n,k>>1);
        int l2 = k - l1;
        if (A[l1-1] < B[l2-1]){
            return findKth(Arrays.copyOfRange(A,l1,A.length),n-l1,B,m,k-l1);
        }else if (A[l1-1] > B[l2-1]){
            return findKth(A,n,Arrays.copyOfRange(B,l2,B.length),m-l2,k-l2);
        }else{
            return A[l1-1];
        }
        
    }
}