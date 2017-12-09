题目描述

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1is read off as"one 1"or11.
11is read off as"two 1s"or21.
21is read off as"one 2, thenone 1"or1211.
Given an integer n, generate the n th sequence.
Note: The sequence of integers will be represented as a string.
import java.util.*;
public class Solution {
    public String countAndSay(int n) {
        if (n <= 0){
            return "";
        }
        String s = "1";
        for(int i = 1;i<n;i++){
            s = countNum(s);
        }
        return s;
    }
    
    public String countNum(String s){
        int n = s.length();
        char c = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int i = 1;
        while(i<n){
            if (c == s.charAt(i)){
                count++;
                i++;
                continue;
            }
            sb.append(String.valueOf(count) + c);
            c = s.charAt(i);
            count = 1;
            i++;
        }
        sb.append(String.valueOf(count) + c);
        return sb.toString();
    }
}