题目描述

Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s ="aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
import java.util.*;
public class Solution {
    ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
    ArrayList<String> list = new ArrayList<String>();
    public ArrayList<ArrayList<String>> partition(String s) {
        if (s == null || s.length()==0){
            return ret;
        }
        dfs(s,0);
        return ret;
    }
    public void dfs(String s,int l){
        if (list.size() > 0 && l>=s.length()){
            ret.add(new ArrayList<>(list));
            return;
        }
        if (l>=s.length()){
            return;
        }
        for(int i = l;i<s.length();i++){
            String str = s.substring(l,i + 1);
            if (isPalindrome(str)){
                list.add(str);
                dfs(s,i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0;i<=len/2;i++){
            if (s.charAt(i) != s.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }
}