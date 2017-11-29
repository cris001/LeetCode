题目描述

Given a string s consists of upper/lower-case alphabets and empty space characters' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
For example, 
Given s ="Hello World",
return5.
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        String[] t = s.split(" ");
        if (t.length == 0){
            return 0;
        }
        return t[t.length - 1].length();
    }
}