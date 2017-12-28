题目描述

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length <= 3){
            return ret;
        }
        Arrays.sort(num);
        int n = num.length;
        for(int i = 0;i<n;i++){
            if (i >= 1 && num[i] == num[i-1]){
                continue;
            }
            for(int t = i+1;t<n;t++){
                if (t >= i+2 && num[t] == num[t-1]){
                    continue;
                }
                int l = t + 1;
                int r = n - 1;
                while(l < r){
                    int sum = num[l] + num[r] + num[i] + num[t];
                    if (sum == target){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[t]);
                        list.add(num[l]);
                        list.add(num[r]);
                        ret.add(new ArrayList<>(list));
                        l++;r--;
                        while(l < r && num[l] == num[l-1]){
                            l++;
                        } 
                        while(l < r && num[r] == num[r+1]){
                            r--;
                        }  
                    }else if (sum < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return ret;
    }
}