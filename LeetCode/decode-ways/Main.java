题目描述

A message containing letters fromA-Zis being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
The number of ways decoding"12"is 2.

public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int f[] = new int[len+1];
        f[0] = 1;
        if (s.charAt(0) > '0'){
            f[1] = 1;
        }
        
        for(int i = 2;i<=len;i++){
            if (s.charAt(i-1)>'0'){
                f[i]=f[i-1];
            }
            if (s.charAt(i-2)>'0'){
                int a = Integer.parseInt(s.substring(i-2,i));
                if (a>=10 && a<=26){
                    f[i]+=f[i-2];
                }
            }
        }
        return f[len];
    }
}