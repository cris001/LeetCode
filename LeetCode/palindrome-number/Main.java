题目描述

Determine whether an integer is a palindrome. Do this without extra space.
click to show spoilers.
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        long a = x;
        long b = 0;
        while(a > 0){
            b = b*10 + a % 10;
            a/=10;
        }
        return x == b;
    }
}