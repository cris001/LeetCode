题目描述

Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
public class Solution {

public int removeElement(int[] A, int elem) {
        int len = A.length;
        for(int l = 0,h = A.length - 1;l <= h;l++){
            if(A[l] == elem){
                while(l < h && A[h] == elem) h--;
                A[l] = A[h--];
                len = h+1;
            }
        }
        return len;
    }
}