题目描述

Say you have an array for which the i th element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int m = prices[0];
        int ans = 0;
        for(int i = 1;i<prices.length;i++){
            ans = Math.max(prices[i] - m,ans);
            m = Math.min(m,prices[i]);
        }
        return ans;
    }
}