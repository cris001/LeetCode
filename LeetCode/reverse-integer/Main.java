题目描述
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
public class Solution {
    public int reverse(int x) {
        int sign = 1;
        if (x<0){
            sign = -1;
            x = -x;
        }
        int ans = 0;
        while(x > 0){
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans*sign;
    }
}