题目描述

Given an array of integers, every element appears threetimes except for one. Find that single one.
public class Solution {

    public int singleNumber(int[] A) {
            int ones = 0;//记录只出现过1次的bits
            int twos = 0;//记录只出现过2次的bits
            int threes;
            for(int i = 0; i < A.length; i++){
                int t = A[i];
                twos |= ones&t;//要在更新ones前面更新twos
                ones ^= t;
                threes = ones&twos;//ones和twos中都为1即出现了3次
                ones &= ~threes;//抹去出现了3次的bits
                twos &= ~threes;
            }
            return ones; 
    }
}