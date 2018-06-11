题目描述

Given a number represented as an array of digits, plus one to the number.
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] a = new int[len + 1];
        int carry = 0;
        digits[len-1]+=1;
        int index = 0;
        for(int i = len - 1;i>=0;i--){
            a[index++] = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
        }
        if (carry > 0){
            a[index++] = carry;
        }
        int ans[] = new int[index];
        for(int i = index - 1;i>=0;i--){
            ans[index - 1 - i] = a[i];
        }
        return ans;
    }
}