题目描述

Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s ="aab",
Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        boolean p[][] = new boolean[len][len];
        int f[] = new int[len + 2];
        f[len] = -1;
        for(int i = len - 1;i>=0;i--){
            f[i] = Integer.MAX_VALUE;
            for(int j = i;j<=len - 1;j++){
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || p[i+1][j-1])){
                    p[i][j] = true;
                    f[i] = Math.min(f[i],f[j+1] + 1);
                }
            }
        }
        return f[0];
    }
}