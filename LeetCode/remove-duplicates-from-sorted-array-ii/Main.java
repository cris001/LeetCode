题目描述

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array A =[1,1,1,2,2,3],
Your function should return length =5, and A is now[1,1,2,2,3].
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int n = A.length;
        if (n <= 2){
            return n;
        }
        int index = 2;
        for(int i = 2;i<n;i++){
            if (A[i] != A[index - 2]){
                A[index++] = A[i];
            }
        }
        return index;
    }
}