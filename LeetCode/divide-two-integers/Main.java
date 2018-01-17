题目描述

Divide two integers without using multiplication, division and mod operator.
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0){
            return Integer.MAX_VALUE;
        }
        int sign = -1;
        if (dividend >= 0 && divisor > 0){
            sign = 1;
        }
        if (dividend <= 0 && divisor < 0){
            sign = 1;
        }
        long ans = 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long k = b;
        long count = 1;
        while(a>=b){
            k = b;
            count = 1;
            while(k + k <= a){
                k += k;
                count += count;
            }
            a-=k;
            ans+=count;
        }
        //ans = solve(a,b);
        if (sign == 1){
            return (int)ans;
        }
        return (int)(-ans);
    }
    
    private long solve(long ldividend, long ldivisor) {
        if(ldividend<ldivisor)
            return 0;
        long res = 1;
        long sum = ldivisor;
        //为防止进行多次重复的计算，每一次循环除数*2
        while (sum + sum <= ldividend) {
            sum += sum;
            res += res;
        }
        return res + solve(ldividend - sum, ldivisor);
    }
}