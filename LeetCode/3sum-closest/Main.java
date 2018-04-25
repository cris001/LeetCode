题目描述

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
import java.util.*;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length <= 2){
            return target;
        }
        Arrays.sort(num);
        int n = num.length;
        int ans = num[0] + num[1] + num[2];
        for(int i = 0;i<n;i++){
            if (i >= 1 && num[i] == num[i-1]){
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while(l < r){
                int sum = num[l] + num[r] + num[i];
                if (Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                boolean flag = false;
                if (Math.abs(num[l+1] + num[r] + num[i] - target) < Math.abs(num[l] + num[r-1] + num[i] - target)){
                    flag = true;
                }
                if (flag){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }
}