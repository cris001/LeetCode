题目描述

Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
Here is an example:
S ="rabbbit", T ="rabbit"
Return3.
public class Solution {
    public int numDistinct(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        int f[][]= new int[len1 + 1][len2+ 1];
        for(int i =0;i<=len1;i++){
            f[i][0] = 1;
        }
        
        for(int i = 1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if (S.charAt(i-1) == T.charAt(j-1)){
                    f[i][j] = f[i-1][j-1] + f[i-1][j];
                }else{
                    f[i][j] = f[i-1][j];
                }
            }
        }
        return f[len1][len2];
    }
}