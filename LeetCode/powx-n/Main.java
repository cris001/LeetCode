题目描述

Implement pow(x, n).
public class Solution {
    public double pow(double x, int n) {
        int sign = 1;
        if (n < 0){
            sign = 0;
            n = -n;
        }
        double ans = 1.0;
        double b = x; 
        while(n>0){
            if ((n & 1) == 1){
                ans *= b;
            }
            b = b*b;
            n>>=1;
        }
        if (sign == 0){
            return 1.0/ans;
        }
        return ans;
    }
}