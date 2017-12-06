题目描述

Implement wildcard pattern matching with support for'?'and'*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null  && p == null){
            return true;
        }
        int n = s.length();
        int m = p.length();
        if (n == 0 && m == 0){
            return true;
        }
        if (m == 0 && n>0){
            return false;
        }
        boolean f[][] = new boolean[n+1][m+1];
        f[0][0] = true;
        for(int i = 1;i<=m;i++){
            if (p.charAt(i-1) == '*'){
                f[0][i] = f[0][i-1];
            }
        }
        
       for(int i = 1;i<=n;i++){
           for(int j = 1;j<=m;j++){
               if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                   f[i][j] = f[i-1][j-1];
               }
               if (p.charAt(j-1) == '*'){
                   f[i][j] = f[i][j-1] || f[i-1][j];
               }
           }
       }
        return f[n][m];
    }
}