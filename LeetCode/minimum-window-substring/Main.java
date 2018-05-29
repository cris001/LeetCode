题目描述

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S ="ADOBECODEBANC"
T ="ABC"
Minimum window is"BANC".
Note: 
 If there is no such window in S that covers all characters in T, return the emtpy string"".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
import java.util.*;
public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || T == null){
            return "";
        }
        int n = S.length();
        int m = T.length();
        if (m > n || m == 0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int c[] = new int[256];
        boolean dic[] = new boolean[256];
        for(int i = 0;i<m;i++){
            c[T.charAt(i)]++;
            dic[T.charAt(i)] = true;
        }
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;
        int l = 0;
        for(int i = 0;i<n;i++){
            if (c[S.charAt(i)] > 0){
                c[S.charAt(i)]--;
                count++;
            }else{
                c[S.charAt(i)]--;
            }
            while(count == m){
                char ch = S.charAt(left);
                if (i - left + 1 < ans){
                    ans = i - left + 1;
                    l = left;
                }
                if (dic[ch]){
                    c[ch]++;
                    if (c[ch] > 0){
                        count--;
                    }
                }
                left++;
            }
        }
        if (ans == Integer.MAX_VALUE){
            return "";
        }
        return S.substring(l,l + ans);
    }
}