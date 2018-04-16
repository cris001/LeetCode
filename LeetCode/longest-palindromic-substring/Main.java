题目描述

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        int n = s.length();
        boolean f[][] = new boolean[n+1][n+1];
        String t = "";
        int max = 0;
        
        for(int i = n;i>=1;i--){
            f[i][i] = true;
            for(int j = i+1;j<=n;j++){
                f[i][j] = (s.charAt(i-1) == s.charAt(j-1) && (j - i < 2 || f[i+1][j-1]));
                if (f[i][j] && j-i+1 > max){
                    max = j-i+1;
                    t = s.substring(i-1,j);
                }
            } 
        }
        return t;
    }
}	