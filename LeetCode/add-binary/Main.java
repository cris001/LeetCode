题目描述

Given two binary strings, return their sum (also a binary string).
For example,
a ="11"
b ="1"
Return"100".
import java.util.*;
public class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int i = len1 - 1;
        int j = len2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || carry != 0){
            int sum = carry;
            if (i>=0){
                sum+=a.charAt(i) - '0';
                i--;
            }
            if (j>=0){
                sum+=b.charAt(j) - '0';
                j--;
            }
            carry = sum / 2;
            sb.append( (char)(sum % 2 + '0'));
        }
        return sb.reverse().toString();
    }
}