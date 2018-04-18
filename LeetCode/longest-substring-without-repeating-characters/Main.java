题目描述

Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int ans = 0;
        int left = 0;
        for(int i = 0;i<s.length();i++){
            char ch = c[i];
            int t = 0;
            if (map.containsKey(ch)){
                t = map.get(ch) + 1;
            }
            left = Math.max(left, t);
            ans = Math.max(ans, i-left+1);
            map.put(ch,i);
        }
        return ans;
    }
}