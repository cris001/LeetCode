题目描述

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length <= 2){
            return ret;
        }
        Arrays.sort(num);
        int n = num.length;
        for(int i = 0;i<n;i++){
            if (i >= 1 && num[i] == num[i-1]){
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while(l < r){
                int sum = num[l] + num[r] + num[i];
                if (sum == 0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
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
                }else if (sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ret;
    }
}