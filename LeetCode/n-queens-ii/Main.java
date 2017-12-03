题目描述

Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.

import java.util.*;
public class Solution {
    ArrayList<String[]> list = new ArrayList<String[]>();
    public int totalNQueens(int n) {
        if (n<=0){
            return 1;
        }
        char[][] mp = new char[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                mp[i][j] = '.';
            }
        }
        dfs(n,mp,0);
        return list.size();
    }
    
    public void dfs(int n, char[][] mp,int now){
        if (now == n){
            String[] s = new String[n];
            for(int i = 0;i<n;i++){
                s[i]= new String(mp[i]);
            }
            list.add(s);
            return;
        }
        for(int i = 0;i<n;i++){
            if (canPlace(now,i,n,mp)){
                mp[now][i] = 'Q';
                dfs(n,mp,now + 1);
                mp[now][i] = '.';
            }
        }
    }
    
    public boolean canPlace(int x,int y, int n, char[][] mp){
        for(int i = 0;i<x;i++){
            for(int j = 0;j<n;j++){
                if (mp[i][j] == 'Q'){
                    if (j == y || Math.abs(j-y) == (x-i)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}