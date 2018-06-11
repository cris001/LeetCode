题目描述

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null){
            return 0;
        }
        int n = word1.length();
        int m = word2.length();
        if (n == 0){
            return m;
        }
        if (m == 0){
            return n;
        }
        int f[][] = new int[n+1][m+1];
        f[0][0] = 0;
        for(int i = 1;i<=m;i++){
            f[0][i] = i;
        }
        for(int i = 1;i<=n;i++){
            f[i][0] = i;
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    f[i][j] = f[i-1][j-1];
                }else{
                    f[i][j] = Math.min(f[i-1][j-1],Math.min(f[i-1][j],f[i][j-1]) ) + 1;
                }
            }
        }
        return f[n][m];
    }
}