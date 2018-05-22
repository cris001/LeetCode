题目描述

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
For example,
Given:
s1 ="aabcc",
s2 ="dbbca",
When s3 ="aadbbcbcac", return true.
When s3 ="aadbbbaccc", return false.
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()){
            return false;
        }
        boolean f[][] = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for(int i = 1;i<=len1;i++){
            if (s3.charAt(i - 1) == s1.charAt(i - 1)){
                f[i][0] = f[i-1][0];
            }
        }
        for(int i = 1;i<=len2;i++){
            if (s3.charAt(i - 1) == s2.charAt(i - 1)){
                f[0][i] = f[0][i-1];
            }
        }
        for(int i = 1 ;i<=len1;i++){
            for(int j = 1;j<=len2;j++){
                if (s3.charAt(i + j -1) == s1.charAt(i - 1)){
                    f[i][j] = f[i][j] || f[i-1][j];
                }
                if (s3.charAt(i + j -1) == s2.charAt(j - 1)){
                    f[i][j] = f[i][j] || f[i][j-1];
                }
            }
        }
        return f[len1][len2];
    }
}