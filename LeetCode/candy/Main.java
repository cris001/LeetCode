题目描述

There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0){
            return 0;
        }
        if (ratings.length == 1){
            return 1;
        }
        int len = ratings.length;
        int inc = 1;
        int a[] = new int[len];
        for (int i = 1;i<len;i++){
            if (ratings[i] > ratings[i-1]){
                a[i] = Math.max(a[i],inc++);
            }else{
                inc = 1;
            }
        }
        inc = 1;
        for (int i = len - 2;i>=0;i--){
            if (ratings[i] > ratings[i+1]){
                a[i] = Math.max(a[i],inc++);
            }else{
                inc = 1;
            }
        }
        int ans = 0;
        for (int i = 0;i<len;i++){
            ans += a[i] + 1;
        }
        return ans;
    }
}