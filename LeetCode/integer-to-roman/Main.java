题目描述

Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
import java.util.*;
public class Solution {
    public String intToRoman(int num) {
        int[] a = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] b = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<a.length;i++){
            while(num >= a[i]){
                num-=a[i];
                sb.append(b[i]);
            }
            
        }
        return sb.toString();
    }
}