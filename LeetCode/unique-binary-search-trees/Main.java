题目描述

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
public class Solution {
    public int numTrees(int n) {
        if (n == 0){
            return 1;
        }
        int f[] = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 0;j<i;j++){
                f[i]+=f[j]*f[i-1-j];
            }
        }
        return f[n];
    }
}