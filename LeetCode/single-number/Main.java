题目描述

Given an array of integers, every element appears twiceexcept for one. Find that single one.
public class Solution {
    public int singleNumber(int[] A) {
        int a = 0;
        for(int t : A){
            a^=t;
        }
        return a;
    }
}