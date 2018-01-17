题目描述

Implement strStr().
Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
import java.util.*;
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return haystack;
        }
        if (haystack.length() == 0){
            return null;
        }
        int nextval[] = getNextval(needle.toCharArray());
        int i = 0;
        int j = 0;
        while(i < haystack.length() && j < needle.length()){
            if (j < 0 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                j = nextval[j];
            }
        }
        if (j == needle.length()){
            return haystack.substring(i - j);
        }
        return null;
    }
    
    public int[] getNextval(char[] c){
        int n = c.length;
        int i = 0;
        int j = -1;
        int[] nextval = new int[n];
        nextval[0] = -1;
        while(i < n-1){
            if (j == -1 || c[i] == c[j]){
                i++;
                j++;
                if (c[i] != c[j]){
                    nextval[i] = j;
                }else{
                    nextval[i] = nextval[j];
                }
            }else{
                j = nextval[j];
            }
        }
        return nextval;
    }
}