题目描述

Say you have an array for which the i th element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int lmin = prices[0];
        int rmax = prices[len - 1];
        int f[] = new int[len];
        int g[] = new int[len];
        for(int i = 1;i<len;i++){
            lmin = Math.min(lmin,prices[i]);
            f[i] = Math.max(f[i-1],prices[i]-lmin);
        }
        for(int i= len-2;i>=0;i--){
            rmax = Math.max(rmax,prices[i]);
            g[i] = Math.max(g[i+1],rmax-prices[i]);
        }
        
        int ans =0;
        for(int i = 0;i<len;i++){
            ans = Math.max(ans,f[i] + g[i]);
        }
        return ans;
    }
}