题目描述

Write a function to find the longest common prefix string amongst an array of strings.
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int n = strs.length;
        int minLen = strs[0].length();
        for(int i = 1;i<n;i++){
            minLen = Math.min(minLen,strs[i].length());
        }
        for(int i = 0;i<minLen;i++){
            String s = strs[0].substring(0,i+1);
            for(int j = 1;j<n;j++){
                if (!strs[j].startsWith(s)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,minLen);
    }
}