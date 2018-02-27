题目描述

Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
import java.util.*;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        if (numbers == null ||numbers.length <= 1){
            return a;
        }
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<numbers.length;i++){
            int t = numbers[i];
            if (!mp.containsKey(target - t)){
                mp.put(t,i+1);
            }else{
                a[0] = mp.get(target - t);
                a[1] = i+1;
                break;
            }
        }
        
        return a;
    }
}