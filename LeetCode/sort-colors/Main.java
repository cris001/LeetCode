题目描述
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

public class Solution {
    public void sortColors(int[] A) {
        if (A == null || A.length == 0){
            return;
        }
        int l = 0;
        int r = A.length - 1;
        int cur = 0;
        while(cur <= r){
            if (A[cur] == 1){
                cur++;
            }else if (A[cur] == 0){
                int t = A[l];
                A[l] = A[cur];
                A[cur] = t;
                l++;
                cur++;
            }else{
                int t = A[r];
                A[r] = A[cur];
                A[cur] = t;
                r--;
            }
        } 
    }
}